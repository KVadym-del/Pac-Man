package org.pac_man.game.levels;

import org.pac_man.game.graphics.Sprite;
import org.pac_man.game.graphics.SpriteSheet;
import org.pac_man.game.tiles.Tile;
import org.pac_man.game.rendering.Screen;

import java.util.List;

public class Level {
    public int width, height;
    public List<Tile> tiles;

    public static int SCALE;

    public static boolean play = false;

    public Level(String path, int scale) {
        SCALE = scale;
        loadLevelFromFile(path);
    }

    public void loadLevelFromFile(String path)
    {
        SpriteSheet wallSheet = new SpriteSheet(path, 8 + 1, 8 + 1);
        width = wallSheet.getSheetWidth();
        height = wallSheet.getSheetHeight();
        System.out.println("width: " + width + " height: " + height);
        tiles = new java.util.ArrayList<>();

        int x = 0;
        int y = 0;
        for (Sprite sprite : wallSheet.getSprites()) {
            tiles.add(new Tile(Sprite.imageScale(sprite.image, SCALE), x, y, false));
            System.out.println("x: " + x + " y: " + y);
            x = x + ((8 + 1) * SCALE);
            if (x >= width * SCALE) {
                x = 0;
                y = y + ((8 + 1) * SCALE);
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
