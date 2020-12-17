package com.shpp.p2p.cs.okurylyk.assignment3;


import acm.graphics.GOval;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;


public class Assignment3Part6 extends WindowProgram {
    /* Diameter of the ball */
    private static final double DIAMETER = 100;

    /* The amount of time to pause between frames . */
    private static final double PAUSE_TIME = 1000.0 / 50;

    public void run() {
        long startTime = System.currentTimeMillis(); // start of our timer
        long endTime = 5000; // time, when program must be ended.
        while (timerOn(startTime, endTime)){
            makeSnowing();
        }
        println(System.currentTimeMillis() - startTime); // How many time program worked.
    }

    /**
     * Method, that works as a timer. When present Time more than start Time on 5 seconds, animation will stop.
     * @param startTime time when our program started;
     * @param endTime how many our program must work.
     * @return if delta between present Time and start Time lower than 5.
     */
    private boolean timerOn(long startTime, long endTime) {
        boolean t;
        t = System.currentTimeMillis() - startTime <= endTime;
        return t;
    }


     // Falling snowballs down.
    private void makeSnowing() {
            addRandomCircle();
            pause(PAUSE_TIME); // I don`t know why, but with this it works more accurately
    }

    /**
     * Method that create circles in up of a window and in random x coordinates with random color
     * and moves them till down with some frequency.
     */
    private void addRandomCircle() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        GOval drop = new GOval(rgen.nextDouble(0, getWidth() - DIAMETER),
                1,
                DIAMETER,DIAMETER);
        drop.setFilled(true);
        drop.setColor(rgen.nextColor());
        add(drop);
        while (drop.getY() < getHeight()) {
            drop.move(rgen.nextDouble(-1,1) * 10,  20);
            pause(PAUSE_TIME);
        }
    }
}
