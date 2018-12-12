package com.adamkacik.game.level.tile;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
		
	}
	public void render(int x,int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
