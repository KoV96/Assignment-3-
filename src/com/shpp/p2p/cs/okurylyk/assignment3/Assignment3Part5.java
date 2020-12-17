package com.shpp.p2p.cs.okurylyk.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part5 extends TextProgram {

    public void run() {
        stPeterburgGame();
    }

    /**
     * This is the main method which consist with loop. While our total is lower then 20 it continue flipping a coin.
     * Also I have a counter n here, which increase with every round of the loop for understanding how many games
     * needs to earn at least 20$.
     */
    private void stPeterburgGame() {
        int total = 0;
        int moneyEarned;
        int n = 0;
        while (total < 20) {
            moneyEarned = startThrowing();
            println("This game, you earned $" + moneyEarned);
            total = total + moneyEarned;
            println("Your total is $" + total);
            n++;
        }
        println("It took " + n + " games to earn $20");
    }

    /**
     * This method starts game. While it`s true (that means "orel") the loop increase n. N this is value of power.
     * I have discovered that our game have sequence: we earn money proportional to 2 in power n.
     *
     * @return a gain we will win.
     */
    private int startThrowing() {
        int gain;
        int n = 0;
        while (flipCoin()) {
            n++;
        }
        return gain = (int) Math.pow(2, n);
    }

    /**
     * This method simulating flipping a coin. I have applied here random generator which generating two values:
     * true or false. As you understand true = orel, false = reshka.
     *
     * @return orel or reshka.
     */
    private boolean flipCoin() {
        RandomGenerator coin = RandomGenerator.getInstance();
        return coin.nextBoolean();
    }
}
