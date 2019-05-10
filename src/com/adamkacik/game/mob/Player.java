package com.adamkacik.game.mob;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;

import com.adamkacik.game.Game;
import com.adamkacik.game.entity.Entity;
import com.adamkacik.game.entity.projectile.Projectile;
import com.adamkacik.game.entity.projectile.WizardProjectile;
import com.adamkacik.game.graphics.AnimatedSprite;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.graphics.ui.UIActionListener;
import com.adamkacik.game.graphics.ui.UIButton;
import com.adamkacik.game.graphics.ui.UILabel;
import com.adamkacik.game.graphics.ui.UIManager;
import com.adamkacik.game.graphics.ui.UIPanel;
import com.adamkacik.game.graphics.ui.UIProgressBar;
import com.adamkacik.game.input.Keyboard;
import com.adamkacik.game.input.Mouse;
import com.adamkacik.game.level.Level;
import com.adamkacik.game.util.Vector2i;

public class Player extends Mob {

	
	private String name;
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 16,16,3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 16,16,3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 16,16,3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 16,16,3);
	
	private AnimatedSprite animSprite = down;
	
	private int fireRate = 0;
	
	private UIManager ui;
	private UIProgressBar uiHealthBar;
	private UIButton button;
	
	public Player(String name,Keyboard input) {
		this.name = name;
		this.input = input;
		sprite = Sprite.player_forward;
		
		
	}

	public Player(String name, int x, int y, Keyboard input) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
		
		ui = Game.getUiManager();
		UIPanel panel = (UIPanel) new UIPanel(new Vector2i((300-80)*3,0), new Vector2i(80*3,168*3)).setColor(0x4f4f4f4f);
		ui.addPanel(panel);
		UILabel nameLabel = new UILabel(new Vector2i(50,200),name);
		nameLabel.setColor(0xbbbbbb);
		nameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		nameLabel.dropShadow = true;
		panel.addComponent(nameLabel);
		uiHealthBar = new UIProgressBar(new Vector2i(50,210),new Vector2i(150,20));
		uiHealthBar.setColor(0x6a6a6a);
		uiHealthBar.setForegroundColor(Color.RED);
		panel.addComponent(uiHealthBar);
		UILabel hpLabel = new UILabel(new Vector2i(uiHealthBar.position).add(new Vector2i(2,16)),"HP");
		hpLabel.setColor(0xffffff);
		hpLabel.setFont(new Font("Veranda",Font.PLAIN,18));
		panel.addComponent(hpLabel);
		//Player default attributes
		health = 100;
		
		button = new UIButton(new Vector2i(150,10),new Vector2i(80,30), new UIActionListener() {
			public void perform() {
				System.out.println("Button Pressed!");
				System.exit(0);
			}
		});
		button.setText("EXIT");
		panel.addComponent(button);
	}

	public String getName() {
		return name;
	}
	
	public void update() {
		
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if(WizardProjectile.FIRE_RATE>0) fireRate--;
		double xa = 0, ya = 0;
		double speed = 1;
		if (anim < 7500)
			anim++; // condition if prevents to big number
		else
			anim = 0; // reset the number anim
		if (input.up) {
			animSprite=up;
			ya-=speed;
		}
		if (input.down) {
			animSprite = down;
			ya+=speed;
		}
		if (input.left) {
			animSprite = left;
			xa-=speed;
		}
		if (input.right) {
			animSprite = right;
			xa+=speed;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
		uiHealthBar.setProgress(health/100);
		inventory();
		showMap();
	}
	private void clear() {
		for(int i=0; i<level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	
	private void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <=0) {
			double dx = Mouse.getX() - Game.getWindowWidth() /2; // because player always be in center
			double dy = Mouse.getY() - Game.getWindowHeight() /2;
			double dir = Math.atan2(dy, dx);

			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
		
	}

	private void inventory() { // inventory
		if (input.equip) {
			System.out.println("Show equipment");
		}
	}

	private void showMap() { // show map - spawn_level.png
		if (input.map) {
			System.out.println("Show map");
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (animSprite == left) flip =1;
		else flip = 0;
		
		sprite = animSprite.getSprite();
		screen.renderMob((int)x, (int)y, sprite, flip);
	}

	
	

}
