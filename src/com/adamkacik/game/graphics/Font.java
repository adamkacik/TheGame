package com.adamkacik.game.graphics;

public class Font {
	
	private static SpriteSheet font = new SpriteSheet("/fonts/Arial.png",16 );
	
	private static Sprite[] characters = Sprite.split(font);

	public Font() {
		
	}
}
