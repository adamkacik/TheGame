package com.adamkacik.game.level.tile;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
		
	}
	public void render(int x,int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);
	}

}
