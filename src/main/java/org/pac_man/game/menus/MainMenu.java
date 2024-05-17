package org.pac_man.game.menus;

import org.pac_man.game.PacMan;
import org.pac_man.game.rendering.Screen;
import org.pac_man.game.rendering.CustomButton;
import org.pac_man.game.levels.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    private final List<CustomButton> buttons;

    public MainMenu(PacMan game) {
        super(game);
        buttons = new ArrayList<>();

        CustomButton startButton = new CustomButton("Start", 200, 200, 50, Font.PLAIN, Color.BLACK.getRGB());
        startButton.addButtonClickListener(this::startButtonClicked);
        CustomButton optionsButton = new CustomButton("Options", 200, 260, 50,  1, Color.BLACK.getRGB());
        optionsButton.addButtonClickListener(this::optionsButtonClicked);
        CustomButton exitButton = new CustomButton("Exit", 200, 320, 50,  Font.PLAIN, Color.BLACK.getRGB());
        exitButton.addButtonClickListener(this::exitButtonClicked);

        buttons.add(startButton);
        buttons.add(optionsButton);
        buttons.add(exitButton);

        for (CustomButton button : buttons) {
            game.add(button);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Screen screen) {
        for (CustomButton button : buttons) {
            button.render(screen.graphics);
        }
    }

    @Override
    public void dispose() {
        for (CustomButton button : buttons) {
            game.remove(button);
        }
    }

    public void startButtonClicked(CustomButton button) {
        System.out.println("Start clicked");
        PacMan.level = new Level("C:\\Users\\vadym\\IdeaProjects\\Pac-Man\\src\\main\\resources\\1walls.png", PacMan.SCALE);
    }

    public void optionsButtonClicked(CustomButton button) {
        System.out.println("Options clicked");
    }

    public void exitButtonClicked(CustomButton button) {
        System.out.println("Exit clicked");
        System.exit(0);
    }
}
