package org.pac_man.game.tiles;

import org.pac_man.game.graphics.Sprite;

public class Tile {
    public int x, y;
    public boolean solid;
    public Sprite sprite;

    public Tile(Sprite sprite, int x, int y, boolean solid) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.solid = solid;
    }

    public boolean isSolid() {
        return solid;
    }
}
