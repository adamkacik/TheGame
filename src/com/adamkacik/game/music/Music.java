package com.adamkacik.game.music;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	
	
	public Music() {
		
	}
	public void PlaySound() {
		System.out.println("PlayMusic");
		try {
			AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(this.getClass().getResource("/6pEy.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
		}
		catch(Exception e) {
			System.out.println("Problem z plikiem dzwiekowym!!");
		}
	}
}
