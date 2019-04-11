package com.adamkacik.game.graphics.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.util.Vector2i;

public class UILabel extends UIComponent {

	public String text;
	private Font font;
	public boolean dropShadow = false;
	public int dropShadowOffset = 2;
	
	
	public UILabel(Vector2i position, String text) {
		super(position);
		font = new Font("Helvetica", Font.PLAIN, 32);
		this.text = text;
		color = new Color(0xff00ff);
	}
	
	public UILabel setFont(Font font) {
		this.font = font;
		return this;
	}
	

	public void render(Graphics g) {
		if(dropShadow) {
		g.setFont(font);
		g.setColor(Color.BLACK);			//add shadow to name
		g.drawString(text, position.x+offset.x+dropShadowOffset, position.y +offset.y +dropShadowOffset);
		}
		
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, position.x + offset.x, position.y+offset.y);
		
	}
	
}
