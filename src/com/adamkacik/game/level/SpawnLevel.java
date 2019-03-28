package com.adamkacik.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.adamkacik.game.level.tile.Tile;
import com.adamkacik.game.mob.Chaser;
import com.adamkacik.game.mob.Dummy;
import com.adamkacik.game.mob.Shooter;
import com.adamkacik.game.mob.Star;

public class SpawnLevel extends Level {

	
	//private int[] tiles;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width =  image.getWidth();
			int h = height = image.getHeight();
			//tiles = new Tile[w * h];
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception!! Could not load level file!!");
		}
		/*for (int i=0; i<2; i++) {
			add(new Dummy(191+i*20,170-i*13));
			
		}
		for (int i=0; i<1;i++) {
			add(new Chaser(230+i*30,170));
		}
		//add (new Star(230, 190));
		//add(new Shooter(260,190));
		//add(new Shooter(230,160));
		
		//add(new Dummy(210,170));*/
	}

	// Grass = 0xFF00
	// Flower = 0xFFFF00
	// Stone = 0x7F7F00
	protected void generateLevel() {
		
	}

	public SpawnLevel(int width, int height) {
		super(width, height);

	}

}			
