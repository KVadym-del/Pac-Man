package org.pac_man.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpriteSheet {
    private BufferedImage sheet;
    private List<Sprite> sprites;

    public SpriteSheet(String path, int spriteWidth, int spriteHeight) {
        try {
            sheet = ImageIO.read((new File(path)));
            sprites = new ArrayList<>();
            int rows = sheet.getHeight() / spriteHeight;
            int cols = sheet.getWidth() / spriteWidth;

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    sprites.add(new Sprite(sheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sprite getSprite(int index) {
        return sprites.get(index);
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public int getSheetWidth() {
        return sheet.getWidth();
    }

    public int getSheetHeight() {
        return sheet.getHeight();
    }
}