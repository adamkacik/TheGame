package com.adamkacik.game.graphics;

public class Sprite {
	public int SIZE;
	private int x, y;
	public int[] pixels;
	private int width, height;
	protected SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0,0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16,1,0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2,0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16,0x1B87E0);
	// sprite for spawn_level
	public static Sprite spawn_grass = new Sprite(16, 0,0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1,0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 2,0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 3,0, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 3,2, SpriteSheet.spawn_level);
	public static Sprite spawn_stone = new Sprite(16, 3,3, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 3,1, SpriteSheet.spawn_level);
	public static Sprite spawn_flower = new Sprite(16, 3,4, SpriteSheet.spawn_level);
	public static Sprite spawn_rock = new Sprite(16,2,4, SpriteSheet.spawn_level);
	
	
	
	
	
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
	public static Sprite dummy = new Sprite(16,0,0,SpriteSheet.dummy_down); 
	
	//particles
	public static Sprite particle_normal = new Sprite(3,0xaaaaaa);
	
	// projectiles sprite here
	
	public static Sprite projectile_wizard = new Sprite(16,0,0,SpriteSheet.projectile_wizard);
	
	// bird animation
	public static Sprite bird_1 = new Sprite(16,4,0,SpriteSheet.tiles);
	public static Sprite bird_2 = new Sprite(16,4,1,SpriteSheet.tiles);
	public static Sprite bird_3 = new Sprite(16,4,2,SpriteSheet.tiles);
	
	protected Sprite(SpriteSheet sheet, int width, int height) {
		if(width ==height) SIZE = width;
		else SIZE = -1;
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	public Sprite(int width, int height, int colour) {
		SIZE=-1;
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		setColor(colour);
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	public static Sprite[] split(SpriteSheet sheet) {
		int amount = ((sheet.getWidth() * sheet.getHeight())/ (sheet.SPRITE_WIDTH*sheet.SPRITE_WIDTH) )
		
		Sprite[] sprites = new Sprite[amount];
		int current = 0;
		int[] pixels = new int[sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT];
		
		for (int yp = 0 ; yp<sheet.getHeight()/sheet.SPRITE_HEIGHT; yp++) {
			for (int xp = 0 ; xp<sheet.getWidth()/sheet.SPRITE_WIDTH; xp++) {
			
				for (int y =0; y<sheet.SPRITE_HEIGHT; y++) {
					for (int x=0; x<sheet.SPRITE_WIDTH; x++) {
						int xo = x+xp*sheet.SPRITE_WIDTH;
						int yo = y+yp*sheet.SPRITE_HEIGHT;
						
						pixels[x+y*sheet.SPRITE_WIDTH]=  sheet.getPixels()[xo+yo*sheet.getWidth()];
					}
				}
			sprites[current] = new Sprite(pixels, sheet.SPRITE_WIDTH, sheet.SPRITE_HEIGHT);
			current++;
			}
		}
		return sprites;
	}
	
	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = height;
		this.height = height;
		this.pixels = pixels;
	}
	private void setColor(int color) {
		for(int i=0; i<width*height; i++) {
			pixels[i] = color;
		}
		
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	
	private void load() {
		for (int y=0; y<height; y++){
			for(int x=0;x<width;x++) {
				pixels[x+y*width]=sheet.pixels[(x+this.x)+(y+this.y)*sheet.SPRITE_WIDTH]; //here
			}
		}
	}
	
}
