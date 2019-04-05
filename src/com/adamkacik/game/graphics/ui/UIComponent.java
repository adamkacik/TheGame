package com.adamkacik.game.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.util.Vector2i;

public class UIComponent {

	

	public int backgroundColor;
	public Vector2i position,offset;
	public Color color;
	
	public UIComponent(Vector2i position) {
		this.position = position;
		offset = new Vector2i();
	}
	
	public UIComponent setColor(int color) {
		this.color = new Color(color);
		return this;
	}
	
	public void update() {
		
	}
	public void render(Graphics g) {
		
	}
	public void setOffset(Vector2i offset) {
		this.offset = offset;
	}
}
