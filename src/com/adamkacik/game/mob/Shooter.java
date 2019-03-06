package com.adamkacik.game.mob;

import com.adamkacik.game.graphics.AnimatedSprite;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.mob.Mob.Direction;

public class Shooter extends Mob{

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	private int time =0;
	private int xa = 0, ya = 0;
	
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
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
	
		Player p = level.getClientPlayer();
		double dx = p.getX()-x;
		double dy = p.getY()-y;
		double dir = Math.atan2(dy, dx);
		shoot(x,y, dir);
	}
	
	public void render(Screen screen) {
		screen.renderMob((int)x,(int)y,this);
	}
}