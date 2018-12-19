package com.adamkacik.game.entity.projectile;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 100;
		speed =3;
		damage = 20;
		rateOfFire = 15;
		sprite = Sprite.projectile_wizard;
		nx = speed*Math.cos(angle);
		ny = speed*Math.sin(angle);
	}
	public void update() {
		move();
	}
	
	protected void move() {
		x += nx;
		y += ny;
		if (distance()>range) {
			remove();
		}
	}
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin-x)*(xOrigin-x) + (yOrigin - y)*(yOrigin - y)));
		
		
		return dist;
		
		
	}
	public void render(Screen screen) {
		screen.renderProjectile((int)x,(int)y,this);
	}
}
