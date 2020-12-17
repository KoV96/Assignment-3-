package com.shpp.p2p.cs.okurylyk.assignment3;

import acm.graphics.GFillable;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part4 extends WindowProgram {
    // Height and width of one brick.
    private final static int BRICK_HEIGHT = 5;
    private final static int BRICK_WIDTH = 20;
    // Number of bricks in base.
    private final static int BRICK_IN_BASE = 10;
    // Color of a brick.
    private static final Color FIRE_BRICK = new Color(178, 34, 34);

    public void run() {
        windowSizeSettings();
        buildPyramid(BRICK_WIDTH, BRICK_HEIGHT, BRICK_IN_BASE);
    }

    /**
     * The main method, that builds pyramid row by row.
     *
     * @param brickWidth  width of one brick;
     * @param brickHeight height of one brick;
     * @param brickInBase number of bricks in base.
     */
    private void buildPyramid(int brickWidth, int brickHeight, int brickInBase) {
        for (int i = 0; i < brickInBase; i++) {
            buildOneRow(Assignment3Part4.BRICK_WIDTH, brickHeight, brickInBase, i);
        }
    }

    /**
     * This method builds only one row. In each next row there are n -1 bricks then in previous row.
     *
     * @param brickWidth  width of one brick;
     * @param brickHeight height of one brick;
     * @param brickInBase number of bricks in base;
     * @param level       level of pyramid. It starts from base which is zero level.
     */
    private void buildOneRow(int brickWidth, int brickHeight, int brickInBase, int level) {
        int rowLength = brickWidth * (brickInBase - level);
        for (int i = 0; i < brickInBase - level; i++) {
            GRect brick = new GRect((getWidth() / 2.0 - (rowLength) / 2.0) + (brickWidth * i),
                    (getHeight() - brickHeight) - brickHeight * level,
                    brickWidth, brickHeight);
            fillObj(brick, FIRE_BRICK, true);
            add(brick);
        }
    }

    // This method makes our window flexible.
    private void windowSizeSettings() {
        int widthSpace = 200;
        int heightSpace = 100;
        int applicationWidth = (BRICK_WIDTH * BRICK_IN_BASE) + widthSpace;
        int applicationHeight = (BRICK_HEIGHT * BRICK_IN_BASE) + heightSpace;
        setSize(applicationWidth, applicationHeight);
    }

    // Give color to each object.
    private void fillObj(GFillable obj, Color fillColor, boolean isFilled) {
        obj.setFilled(isFilled);
        obj.setFillColor(fillColor);
    }
}
