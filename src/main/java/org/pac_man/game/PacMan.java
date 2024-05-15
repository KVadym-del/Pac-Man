package org.pac_man.game;

import java.awt.*;

import javax.swing.*;

import org.pac_man.game.rendering.CustomButton;
import org.pac_man.game.rendering.Screen;

import org.pac_man.game.menus.Menu;
import org.pac_man.game.menus.MainMenu;

public class PacMan extends JPanel {
    public final static int WIDTH = 300;
    public final static int HEIGHT = WIDTH / 16 * 10;
    public final static String TITLE = "PacMan";
    public final static int SCALE = 3;

    private boolean running = false;
    private Timer timer;

    public Screen screen;
    public static Menu menu;

    public PacMan(int expectedFps) {
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
        timer = new Timer(16, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        timer.stop();
    }

    public void update() {

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        screen.graphics(graphics);
        menu.render(screen);
    }
}
