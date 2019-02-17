package com.adamkacik.game.mob;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;

public class Dummy extends Mob {
	
	public Dummy(int x,int y) {
		System.out.println("Dummy is running");
		this.x = x;
		this.y = y; 
		sprite = Sprite.player_forward;
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		screen.renderMob(x, y, sprite, 0);
	}


	

}
