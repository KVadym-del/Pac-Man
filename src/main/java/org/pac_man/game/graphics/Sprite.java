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

    public static Sprite imageScale(BufferedImage image, int scale) {
        int width = image.getWidth() * scale;
        int height = image.getHeight() * scale;
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                scaledImage.setRGB(x, y, image.getRGB(x / scale, y / scale));
            }
        }
        return new Sprite(scaledImage);
    }
}
