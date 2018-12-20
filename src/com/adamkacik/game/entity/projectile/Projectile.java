package com.adamkacik.game.entity.projectile;

import com.adamkacik.game.entity.Entity;
import com.adamkacik.game.graphics.Sprite;

public class Projectile extends Entity {
	
	protected int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x,y;
	protected double nx,ny;
	protected double distance;
	protected double speed, range, damage;
	
	
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	protected void move() {
		
	}
	public Sprite getSprite() {
		return sprite;
	}
	public int getSpriteSize() {
		return sprite.SIZE;
	}
}
