package org.pac_man.game;

import java.awt.*;

import javax.swing.*;

import org.pac_man.game.rendering.Screen;

import org.pac_man.game.menus.Menu;
import org.pac_man.game.menus.MainMenu;

import org.pac_man.game.levels.*;

public class PacMan extends JPanel implements Runnable {
    public final static int WIDTH = 300;
    public final static int HEIGHT = WIDTH / 16 * 10;
    public final static String TITLE = "PacMan";
    public final static int SCALE = 3;

    private final int expectedFps;
    private boolean running = false;
    private Thread gameThread;

    public Screen screen;
    public static Menu menu;
    public static Level level;

    public PacMan(int expectedFps) {
        this.expectedFps = expectedFps;
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        screen = new Screen(WIDTH, HEIGHT);
        menu = new MainMenu(this);
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        final double timePerTick = 1000000000.0 / expectedFps;
        long lastTime = System.nanoTime();
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            while (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void update() {

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        screen.graphics(graphics);
        if (level != null) {
            menu.dispose();
            level.render(screen);
        }
        else
            menu.render(screen);


    }
}
