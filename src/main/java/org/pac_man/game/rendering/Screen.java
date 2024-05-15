package org.pac_man.game.rendering;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Screen {
    public int width, height;
    public int[] pixels;

    final int TILE_SIZE = 16;
    final Random random = new Random();

    private int[] tiles;
    private int xOffset, yOffset;
    public Graphics graphics;
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void graphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}