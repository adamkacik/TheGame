package com.adamkacik.game.level;

import java.util.Random;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.level.tile.Tile;

public class Level {

	//protected Tile[] tiles;
	protected int width, height;
	protected int[] tilesInt;
	//private static Random random = new Random();
	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/sheet/spawn_level.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() { // add this class from RandomLevel.java
		// for (int y=0;y<height;y++) {
		// for (int x=0;x<width;x++) {
		// tiles[x+y*width] = random.nextInt(4); //generate 0-3
		// }
		// }
	}

	protected void loadLevel(String path) {
	
	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x,y).render(x, y, screen);
				
			}
		}

	}
		// Grass = 0xFF00
		// Flower = 0xFFFF00
		// Stone = 0x7F7F00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0|| x >= width || y >= height)
			return Tile.voidTile;
			
			
		if (tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		
		if (tiles[x + y * width] == Tile.col_spawn_water)	return Tile.spawn_water;
		if (tiles[x + y * width] == Tile.col_spawn_wall1)	return Tile.spawn_wall1;
		if (tiles[x + y * width] == Tile.col_spawn_wall2)	return Tile.spawn_wall2;
		if (tiles[x + y * width] == Tile.col_spawn_floor)	return Tile.spawn_floor;
		if (tiles[x + y * width] == Tile.col_spawn_stone)	return Tile.spawn_stone;
		if (tiles[x + y * width] == Tile.col_spawn_hedge)	return Tile.spawn_hedge;
		if (tiles[x + y * width] == Tile.col_spawn_flower)	return Tile.spawn_flower;
		if (tiles[x + y * width] == Tile.col_spawn_rock)	return Tile.spawn_rock;
		
		
		return Tile.voidTile;

	}
}