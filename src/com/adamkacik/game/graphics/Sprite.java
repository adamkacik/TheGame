package com.adamkacik.game.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0,0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0);
	
	
	// sprite of player's character direction
	public static Sprite player_forward = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(16,1,1,SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(16,2,1,SpriteSheet.tiles);
	
	// sprites for player's character animation
	public static Sprite player_forward_1 = new Sprite(16,0,2,SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(16,0,3,SpriteSheet.tiles);
	public static Sprite player_back_1 = new Sprite(16,1,2,SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(16,1,3,SpriteSheet.tiles);
	public static Sprite player_side_1 = new Sprite(16,2,2,SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(16,2,3,SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	private void setColor(int color) {
		for(int i=0; i<SIZE*SIZE; i++) {
			pixels[i] = color;
		}
		
	}
	private void load() {
		for (int y=0; y<SIZE; y++){
			for(int x=0;x<SIZE;x++) {
				pixels[x+y*SIZE]=sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
			}
		}
	}
	
}
