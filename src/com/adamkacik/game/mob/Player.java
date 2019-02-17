package com.adamkacik.game.mob;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.adamkacik.game.Game;
import com.adamkacik.game.entity.projectile.Projectile;
import com.adamkacik.game.entity.projectile.WizardProjectile;
import com.adamkacik.game.graphics.AnimatedSprite;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.input.Keyboard;
import com.adamkacik.game.input.Mouse;
import com.adamkacik.game.level.Level;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int fireRate = 0;
	
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
		animSprite = down;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public void update() {
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if(WizardProjectile.FIRE_RATE>0) fireRate--;
		int xa = 0, ya = 0;

		if (anim < 7500)
			anim++; // condition if prevents to big number
		else
			anim = 0; // reset the number anim
		if (input.up) {
			animSprite=up;
			ya--;
		}
		if (input.down) {
			animSprite = down;
			ya++;
		}
		if (input.left) {
			animSprite = left;
			xa--;
		}
		if (input.right) {
			animSprite = right;
			xa++;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
		inventory();
		showMap();
	}
	private void clear() {
		for(int i=0; i<level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	
	private void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <=0) {
			double dx = Mouse.getX() - Game.getWindowWidth() /2; // because player always be in center
			double dy = Mouse.getY() - Game.getWindowHeight() /2;
			double dir = Math.atan2(dy, dx);

			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	private void inventory() { // inventory
		if (input.equip) {
			System.out.println("Show equipment");
		}
	}

	private void showMap() { // show map - spawn_level.png
		if (input.map) {
			System.out.println("Show map");
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (animSprite == left) flip =1;
		else flip = 0;
		
		sprite = animSprite.getSprite();
		screen.renderMob(x, y, sprite, flip);
	}

	
	

}
