package com.adamkacik.game.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.adamkacik.game.entity.Entity;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class Particle extends Entity {

	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;

	private int life;
	private int time = 0;
	protected double xa, ya, za;
	protected double xx, yy, zz;
	
	public Particle(int x, int y, int life) {
		System.out.println("Particle life: " + life);
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;

		this.life = life +(random.nextInt(50)-25);
		sprite = Sprite.particle_normal;
		this.xa = random.nextGaussian()+1.8;
		if(this.xa<0)xa=0.1;
		this.ya = random.nextGaussian();
		this.zz=random.nextFloat()+2.0;

	}

	public Particle(int x, int y, int life, int amount) {
		this(x, y, life);
		for (int i = 0; i < amount - 1; i++) {
			particles.add(new Particle(x, y, life));

		}
		particles.add(this);
	}

	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		za -=0.1;
		
		if(zz < 0) {		//add some "gravity"
			zz=0;
			za *= -0.65;
			xa *=0.4;
			ya *= 0.4;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}

	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy - (int)zz, sprite, true);
	}

}
