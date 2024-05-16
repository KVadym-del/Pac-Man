package org.pac_man.game.graphics;

import java.awt.image.BufferedImage;

public class Sprite {
    public final BufferedImage image;

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    public int[] getPixels() {
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        return pixels;
    }
}
