package com.adamkacik.game.mob;

import java.util.List;

import com.adamkacik.game.entity.Entity;
import com.adamkacik.game.graphics.AnimatedSprite;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.mob.Mob.Direction;
import com.adamkacik.game.util.Debug;
import com.adamkacik.game.util.Vector2i;

public class Shooter extends Mob{

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	private int time =0;
	private int xa = 0, ya = 0;
	private Entity rand  = null;
	public Shooter(int x, int y) {
		this.x=x;
		this.y=y;
		sprite = Sprite.dummy;
	}
	
	public void update() {
		time++;
		
		if (time % (random.nextInt(50)+30) ==0) {
			xa = random.nextInt(3)-1;
			ya = random.nextInt(3)-1;
			if (random.nextInt(5)==0) {
				xa=0;
				ya=0;
		}
		}
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if (ya<0) {
			animSprite=up;
			dir = Direction.UP;
		}
		if (ya>0) {
			animSprite = down;
			dir = Direction.DOWN;
		}
		if (xa>0) {
			animSprite = left;
			dir = Direction.LEFT;
		}
		if (xa<0) {
			animSprite = right;
			dir = Direction.RIGHT;
		}
		if (xa != 0 || ya != 0) {
			//move(xa, ya);a
			walking = true;
		} else {
			walking = false;
		}
		shootRandom();
	}
	
	private void shootRandom() {
		if(time % (60+ random.nextInt(61)) == 0) {
		
		List<Entity> entities = level.getEntities(this, 500);
		entities.add(level.getClientPlayer());
				
		int index = random.nextInt(entities.size()); // entities.size() = 1 , should be (entities.size()-1) ??
		
		rand=entities.get(index);
					
		}
		if(rand!=null) {
		double dx = rand.getX()-x;
		double dy = rand.getY()-y;
		double dir = Math.atan2(dy, dx);
		shoot(x,y, dir);
		}
	}
		private void shootClosest() {
		List<Entity> entities = level.getEntities(this, 50);
		entities.add(level.getClientPlayer());
		//Player p = ;
		double min=0;
		Entity closest = null;
		for(int i=0;i<entities.size();i++) {
			Entity e=entities.get(i);
			double distance= Vector2i.getDistance(new Vector2i((int)x,(int)y),new Vector2i((int)e.getX(),(int)e.getY()));
			
			if(i==0 || distance<min) {
				min = distance;
				closest = e;
			}
		}
		if(closest!=null) {
		double dx = closest.getX()-x;
		double dy = closest.getY()-y;
		double dir = Math.atan2(dy, dx);
		shoot(x,y, dir);
		}
	}
	
	public void render(Screen screen) {
		 
		sprite = animSprite.getSprite(); 
		//Debug.drawRect(screen, 50,50, 16, 16, false);
		screen.renderMob((int)x,(int)y,this);
	}
}