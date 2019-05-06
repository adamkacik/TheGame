package com.adamkacik.game.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

import com.adamkacik.game.util.Vector2i;

public class UIButton extends UIComponent {
	
	public UILabel label;
	private UIButtonListener buttonListener;
	
	
	
	public UIButton(Vector2i position, Vector2i size) {
		super(position, size);
		Vector2i lp = new Vector2i(position);
		lp.x +=4;
		lp.y +=size.y-2;
		label = new UILabel(lp, " ");
		label.setColor(0x666666);
		label.active = false;
		
		setColor(0xAAAAAA);
		
	}
	void init(UIPanel panel) {
		super.init(panel);
		panel.addComponent(label);
		
	}
	
	public void setText(String text) {
		if(text == " ") {
			label.active = false;
		}else
			label.text = text;
	}
	
	public void update() {
		
	}
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(position.x + offset.x,  position.y+offset.y,  size.x,  size.y);
		
		if(label !=null)
			label.render(g);
		}
	
}
