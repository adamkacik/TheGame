package com.adamkacik.game.level.tile.spawn_level;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.level.tile.Tile;

public class SpawnRockTile extends Tile {

	public SpawnRockTile(Sprite sprite) {
		super(sprite);
		
	}
	public void render(int x,int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);
	}
}
