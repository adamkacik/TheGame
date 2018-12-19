package com.adamkacik.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean up, down, right, left,equip,map;						//equimpent , map

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		equip = keys[KeyEvent.VK_I];								//equipment
		map = keys[KeyEvent.VK_M];									//map
	}

	public void keyPressed(KeyEvent e) { // when the key is pressed
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) { // when I released key
		keys[e.getKeyCode()] = false;

	}

	public void keyTyped(KeyEvent e) {

	}

}
