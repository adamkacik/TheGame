package com.adamkacik.game.mob;

import java.util.List;

import com.adamkacik.game.graphics.AnimatedSprite;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.level.Node;
import com.adamkacik.game.mob.Mob.Direction;
import com.adamkacik.game.util.Vector2i;

public class Star extends Mob {
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 16, 16, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 16, 16, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 16, 16, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 16, 16, 3);

	private AnimatedSprite animSprite = down;

	private double xa = 0;
	private double ya = 0;
	private List<Node> path=null;
	private int time = 0;
	private double speed = 0.8;

	public Star(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = Sprite.dummy;
	}

	public void move() {
		xa = 0;
		ya = 0;
		int px = (int) level.getPlayerAt(0).getX();
		int py = (int) level.getPlayerAt(0).getY();
		Vector2i start = new Vector2i((int)getX()/16, (int)getY()/16);
		Vector2i destination = new Vector2i(px>>4, py>>4);
		if (time % 10 ==0 ) path = level.findPath(start, destination);
		if(path != null) {
			if(path.size()>0) {
				Vector2i vec = path.get(path.size() - 1).tile;
				if (x <vec.getX() *16) xa++;
				if (x >vec.getX() *16) xa--;
				if (y <vec.getY() *16) ya++;
				if (y >vec.getY() *16) ya--;
			}
		}
			
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void update() {
		time++;
		move();

		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
		}
		if (ya > 0) {
			animSprite = down;
			dir = Direction.DOWN;
		}
		if (xa > 0) {
			animSprite = left;
			dir = Direction.LEFT;
		}
		if (xa < 0) {
			animSprite = right;
			dir = Direction.RIGHT;
		}

	}

	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int) x, (int) y, this);
	}

	
	
	
}
