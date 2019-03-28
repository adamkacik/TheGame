package com.adamkacik.game.entity.projectile;

import com.adamkacik.game.entity.particle.Particle;
import com.adamkacik.game.entity.spawner.ParticleSpawner;
import com.adamkacik.game.entity.spawner.Spawner;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 15;
	
	
	public WizardProjectile(double x, double y, double dir) {
		super(x, y, dir);
		range = 200;
		speed =3;
		damage = 20;
		
		sprite = Sprite.projectile_arrow;
		nx = speed*Math.cos(angle);
		ny = speed*Math.sin(angle);
	} 
	public void update() {
		if(level.tileCollision((int)(x+nx), (int)(y+ny),  5, 6, 6)) { //5 is height/weight particles
			//Particle p = new Particle((int)x,(int)y,50,500);
			//level.add(p);
			level.add(new ParticleSpawner((int)x, (int)y, 44, 50, level)); //relocated level line 41
			remove();
		}
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
		screen.renderProjectile((int)x,(int)y,this, angle);
	}
}
