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
        startButton.addButtonClickListener(button -> {
            button.setText("Clicked");
            System.out.println("Clicked");
            PacMan.level = new Level("C:\\Users\\vadym\\IdeaProjects\\Pac-Man\\src\\main\\resources\\1mobs.png");
        });
        buttons.add(startButton);
        buttons.add(new CustomButton("Options", 200, 260, 10,  1, Color.BLACK.getRGB()));
        buttons.add(new CustomButton("Exit", 200, 320, 50,  Font.PLAIN, Color.BLACK.getRGB()));

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
}
