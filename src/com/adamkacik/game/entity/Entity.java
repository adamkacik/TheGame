package com.adamkacik.game.entity;

import java.util.Random;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.level.Level;

public class Entity {
	
		protected int x,y;
		protected Sprite sprite;
		public boolean removed = false;
		protected Level level;
		protected final Random random = new Random();
		
		public Entity() {
			
		}
		public Entity(int x, int y, Sprite sprite) {
			this.x=x;
			this.y=y;
			this.sprite = sprite;
		}
		public void update() {
			
		}
		
		public void render(Screen screen) {
			if (sprite != null) screen.renderSprite(x, y, sprite, true);
		}
		public int getX() {
			return y;
		}
		public int getY() {
			return y;
		}
		public void remove() {
			
			removed = true;
		}
		public Sprite getSprite() {
			return sprite;
		}
		public boolean isRemoved() {
			return removed;
		}
		
		public void init(Level level) {
			this.level=level;
		}
}
