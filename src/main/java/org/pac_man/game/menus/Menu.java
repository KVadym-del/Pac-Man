package org.pac_man.game.menus;

import org.pac_man.game.PacMan;
import org.pac_man.game.rendering.Screen;

public abstract class Menu {

    protected PacMan game;

    public Menu() {

    }

    public Menu(PacMan game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Screen screen);

    public abstract void dispose();
}
