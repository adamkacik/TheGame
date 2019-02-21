package com.adamkacik.game.mob;

import com.adamkacik.game.graphics.AnimatedSprite;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.mob.Mob.Direction;

public class Chaser extends Mob{
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int xa=0;
	private int ya=0;
	
	public Chaser(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = Sprite.dummy;
	}
	public void move() {
		xa =0;
		ya =0;
		Player player = level.getClientPlayer();
		if(x < player.getX()) xa++;
		if(x > player.getX()) xa--;
		if(y < player.getY()) ya++;
		if(y > player.getY()) ya--;
		
		
			
			
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}
	public void update() {
		move();
		
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
		
		
	}
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob(x, y, this);
	}
}
