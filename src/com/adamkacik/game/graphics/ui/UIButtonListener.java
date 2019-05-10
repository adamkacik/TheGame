package com.adamkacik.game.graphics.ui;

public class UIButtonListener {

	public void entered(UIButton button) {
		button.setColor(0xcdcdcd);
	}
	public void exited(UIButton button) {
		button.setColor(0xaaaaaa);
	}
	public void pressed(UIButton button) {
		button.setColor(0xcc2222);
		System.out.println("pressed!");
	}
	public void released(UIButton button) {
		System.out.println("Released!!");
	}
	
}
