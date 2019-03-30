package com.adamkacik.game.graphics.ui;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.util.Vector2i;

public class UIComponent {

	

	public int backgroundColor;
	public Vector2i position,offset;
	
	public UIComponent(Vector2i position) {
		this.position = position;
		offset = new Vector2i();
	}
	
	public void update() {
		
	}
	public void render(Screen screen) {
		
	}
	public void setOffset(Vector2i offset) {
		this.offset = offset;
	}
}
