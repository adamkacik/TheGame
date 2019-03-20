package com.adamkacik.game.graphics;

public class Font {

	//private static SpriteSheet font = new SpriteSheet("/fonts/Arial3.png", 366/13,218/6);
	private static SpriteSheet font = new SpriteSheet("/fonts/Arial2.png", 16);
	// private static SpriteSheet font = new SpriteSheet("/sheet/spritesheet.png",
	// 80);

	private static Sprite[] characters = Sprite.split(font);

	public Font() {

	}

	public void render(Screen screen) {
		screen.renderSprite(50, 40, characters[0], false);

	}
}
