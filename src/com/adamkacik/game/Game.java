package com.adamkacik.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.util.Random;

import javax.swing.JFrame;

import com.adamkacik.game.graphics.Screen;
import com.adamkacik.game.graphics.Sprite;
import com.adamkacik.game.graphics.SpriteSheet;
import com.adamkacik.game.input.Keyboard;
import com.adamkacik.game.input.Mouse;
import com.adamkacik.game.level.Level;
import com.adamkacik.game.level.RandomLevel;
import com.adamkacik.game.level.SpawnLevel;
import com.adamkacik.game.level.TileCoordinate;
import com.adamkacik.game.mob.Bird;
import com.adamkacik.game.mob.Player;
import com.adamkacik.game.music.Music;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	public static String title = "The Game";

	private Screen screen;
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	// private Bird bird; //bird animation
	// private Music music; // music
	private boolean running = false;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	int x, y;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(121, 183);
		player = new Player(playerSpawn.x() >>4, playerSpawn.y() >>4, key); // place where player appears
		//player.init(level);
		level.add(player);
		// music = new Music(); //music
		// music.PlaySound(); //music

		frame.addKeyListener(key); // i must add prefix "frame." to work this
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

	}

	public static int getWindowWidth() {
		return width * scale;
	}

	public static int getWindowHeight() {
		return height * scale;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		frame.requestFocus(); // to focus when I press keys
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;

			frame.requestFocus(); // when I press mouse button without this - game crash
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + updates + "ups, " + frames + " fps"); // Show to title,ups,fps
				updates = 0;
				frames = 0;
			}

		}
		stop();
	}

	public void update() {
		key.update();
		//player.update();
		level.update();

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		double xScroll = player.getX() - screen.width / 2; // middle of screen
		double yScroll = player.getY() - screen.height / 2;
		level.render((int)xScroll, (int)yScroll, screen);
		//player.render(screen);
		//screen.renderSheet(40, 40, SpriteSheet.player_down, false);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Veranda", 0, 50));
		g.drawString("X:  " + player.getX() + ", Y: " + player.getY(), 450, 400);//HERE
		if (Mouse.getButton() != -1)
			g.drawString("Button:  " + Mouse.getButton(), 100, 120);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();

	}
}
