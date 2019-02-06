package com.adamkacik.game.entity.spawner;

import java.util.ArrayList;
import java.util.List;

import com.adamkacik.game.entity.Entity;
import com.adamkacik.game.entity.particle.Particle;
import com.adamkacik.game.level.Level;

public class Spawner extends Entity{

	
	public enum Type {
		MOB, PARTICLE;
	}
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);	
		this.x=x;
			this.y=y;
			this.type = type;
			for (int i =0;i<amount;i++) {
				if (type == Type.PARTICLE) {
					level.add(new Particle(x,y, 50));
				}
			}
		}
}
