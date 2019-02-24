package com.adamkacik.game.level.tile;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.level.tile.spawn_level.SpawnFloorTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnFlowerTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnGrassTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnHedgeTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnRockTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnStoneTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnWallTile;
import com.adamkacik.game.level.tile.spawn_level.SpawnWaterTile;

public class Tile {
	
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	//for spawn-level
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	public static Tile spawn_stone = new SpawnStoneTile(Sprite.spawn_stone);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_flower = new SpawnFlowerTile(Sprite.spawn_flower);
	public static Tile spawn_rock = new SpawnRockTile(Sprite.spawn_rock);
			
	public final static int col_spawn_grass = 0xff00ff90; 
	public final static int col_spawn_water = 0xff0026ff; 
	public final static int col_spawn_wall1 = 0xff404040; 
	public final static int col_spawn_wall2 = 0xff527f3f; 
	public final static int col_spawn_floor = 0xffa0a0a0; 
	public final static int col_spawn_stone = 0xff303030; 
	public final static int col_spawn_hedge = 0xff613f3f; 
	public final static int col_spawn_flower = 0xff3f1111;
	public final static int col_spawn_rock = 0xff00137f;
	
	public Tile(Sprite sprite) { // each "Tile" must have sprite
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	public boolean solid() {
		return false;
	}
	
}
