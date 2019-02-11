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
		//System.out.println("Particle life: " + life);
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life +(random.nextInt(50)-25);
		sprite = Sprite.particle_normal;
		
		this.xa = random.nextGaussian();
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
			xa *= 0.4;
			ya *= 0.4;
		}
		move((xx+xa), (yy+ya)+(zz+za));
	}

	private void move(double d, double e) {
		if (collision((xx+xa), (yy+ya)+(zz+za))){
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
		
	}

	public boolean collision(double x, double y) {	//collision for shooting
		boolean solid=false;
		for (int c=0; c<4 ; c++) {
			double xt=(x - c%2*16)/16;		//size/10+8)/16;
			double yt=(y - c/2*16)/16;		//size/5+8)/16;	
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c%2 == 0) ix = (int) Math.floor(xt);
			if (c/2 == 0) iy = (int) Math.floor(yt);
			
		if (level.getTile(ix,iy).solid()) solid =true;
		}
		return solid;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy - (int)zz -1, sprite, true);
	}

}
