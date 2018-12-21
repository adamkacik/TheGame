package com.adamkacik.game.graphics;

import java.util.Random;

import com.adamkacik.game.entity.projectile.Projectile;
import com.adamkacik.game.level.tile.Tile;
import com.adamkacik.game.mob.Player;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; // 4096

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -=xOffset;
			yp -=yOffset;
		}
		for (int y=0; y < sprite.getHeight(); y++) {
			int ya=y+yp;
			for (int x=0; x<sprite.getWidth(); x++) {
				int xa = x+xp;
				if(xa<0 || xa>= width || ya <0 || ya>= height) continue;
				pixels[xa+ya*width]=sprite.pixels[x+y*sprite.getWidth()];
			}
		}
	}
	
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}

		}
	}

	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < p.getSpriteSize(); x++) {
				int xa = x + xp;
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if (col != 0xffff00ff) {
					pixels[xa + ya * width] = col;
				}
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) { // flip is change right to left side
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) { // because our hero have 16 pixels
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = 15 - y;
			}
			for (int x = 0; x < 16; x++) {
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) {
					xs = 15 - x;
				}
				if (xa < -16 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[xs + ys * 16];
				if (col != 0xffff00ff) // +2 extra ff at the begining because RGB
					pixels[xa + ya * width] = col;
			}

		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	
}
