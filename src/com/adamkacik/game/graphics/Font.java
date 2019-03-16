package com.adamkacik.game.graphics;

public class Font {
	
	private static SpriteSheet font = new SpriteSheet("/fonts/Arial.png", 16);
	//private static SpriteSheet font = new SpriteSheet("/sheet/spritesheet.png", 80);
	
	private static Sprite[] characters = Sprite.split(font);

	public Font() {
		
	}
	public void render(Screen screen) {
		screen.renderSprite(50, 50, characters[0],  false);
		
	}
}
