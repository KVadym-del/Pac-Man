package org.pac_man.game.levels;

import org.pac_man.game.graphics.Sprite;
import org.pac_man.game.graphics.SpriteSheet;
import org.pac_man.game.tiles.Tile;
import org.pac_man.game.rendering.Screen;

import java.util.List;

public class Level {
    public int width, height;
    public List<Tile> tiles;

    public static boolean play = false;

    public Level(String path) {
        loadLevelFromFile(path);
    }

    public void loadLevelFromFile(String path)
    {
        SpriteSheet sheet = new SpriteSheet(path, 16 + 1, 16 + 1);
        width = sheet.getSheetWidth();
        height = sheet.getSheetHeight();
        System.out.println("width: " + width + " height: " + height);
        tiles = new java.util.ArrayList<Tile>();

        int x = 1;
        int y = 1;
        for (Sprite sprite : sheet.getSprites()) {
            tiles.add(new Tile(sprite, x, y, false));
            System.out.println("x: " + x + " y: " + y);
            x = x + (16 + 1);
            if (x >= width) {
                x = 0;
                y = y + (16 + 1);
            }
        }
    }

    public void update()
    {

    }

    public void render(Screen screen)
    {
        for (Tile tile : tiles) {
            screen.graphics.drawImage(tile.sprite.image, tile.x, tile.y, null);
        }
    }

}
