package com.adamkacik.game.level.tile;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class Tile {
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) { // each "Tile" must have sprite
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	public boolean solid() {
		return false;
	}
	
}
