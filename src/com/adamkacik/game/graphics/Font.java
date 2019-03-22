package com.adamkacik.game.graphics;

public class Font {

	//private static SpriteSheet font = new SpriteSheet("/fonts/Arial3.png", 366/13,218/6);
	private static SpriteSheet font = new SpriteSheet("/fonts/Arial4.png", 16);
	// private static SpriteSheet font = new SpriteSheet("/sheet/spritesheet.png",
	// 80);

	private static Sprite[] characters = Sprite.split(font);

	private static String charIndex = 	"ABCDEFGHIJKLM"+//
										"NOPQRSTUVWXYZ"+//
										"abcdefghijklm"+//
										"nopqrstuvwxyz"+//
										"0123456789.,'"+//
										"'\"\";:!@$%()-+";//
	
	public Font() {

	}

	public void render(String text, Screen screen) {
		for (int i=0; i<text.length(); i++) {
			char currentChar = text.charAt(i);
			int index = charIndex.indexOf(currentChar);
			if (index == -1) continue;
			screen.renderSprite(50 + i*16, 40, characters[index], false);
			
		}
		}
}
