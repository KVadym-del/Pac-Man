package org.pac_man.game.entities;

import org.pac_man.game.graphics.Sprite;

public class Entity {
    public int x, y;
    public Sprite sprite;

    public Entity(Sprite sprite, int x, int y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }
}
