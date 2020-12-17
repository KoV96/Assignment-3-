package com.shpp.p2p.cs.okurylyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {

    public void run() {
        double a = readDouble("Please enter number that need to raise: "); // input a number.
        int b = readInt("Please, enter the power: "); // input a power.
        println(raiseToPower(a, b));
    }

    /**
     * Here I create the main method. I use all condition before return the result. As we know 0 in negative power will
     * be an error. But in our task tells that this method must return a double. So, when this happens I return 0 and
     * write about mistake.
     *
     * @param base     the input number needs to take power;
     * @param exponent the number of power.
     * @return result.
     */
    private double raiseToPower(double base, int exponent) {
        double result;
        if (exponent == 0) {
            return result = 1;
        } else if (exponent < 0) {
            if (base == 0) {
                result = 0;
                println("Error! Division by " + result);
            }
            result = 1 / toPositivePower(base, exponent);
        } else {
            result = toPositivePower(base, exponent);
        }
        return result;
    }

    /**
     * Here is the method, that makes multiplication of number to themself as many times as exponent equal.
     *
     * @param base     the input number needs to take power;
     * @param exponent the number of power.
     * @return number in power.
     */
    private double toPositivePower(double base, int exponent) {
        double powerBase = 1;
        for (int i = 0; i < (exponent < 0 ? -exponent : exponent); i++) {
            powerBase = powerBase * base;
        }
        return powerBase;
    }
}
