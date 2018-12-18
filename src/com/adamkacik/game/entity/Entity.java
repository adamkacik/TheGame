package com.adamkacik.game.entity;

import java.util.Random;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.level.Level;

public abstract class Entity {
		public int x,y;
		public boolean removed = false;
		protected Level level;
		protected final Random random = new Random();
		
		public void update() {
			
		}
		
		public void render(Screen screen) {
			
		}
		
		public void remove() {
			
			removed = true;
		}
		public boolean isRemoved() {
			return removed;
		}
		
		public void init(Level level) {
			this.level=level;
		}
}
