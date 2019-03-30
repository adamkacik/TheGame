package com.adamkacik.game.graphics.ui;

import com.adamkacik.game.graphics.Font;
import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.util.Vector2i;

public class UILabel extends UIComponent {

	public String text;
	private Font font;
	
	public UILabel(Vector2i position, String text) {
		super(position);
		font = new Font();
		this.text = text;
	}

	public void render(Screen screen) {
		font.render(position.x+offset.x, position.y+offset.y,-4,0, text, screen);
	}
	
}
