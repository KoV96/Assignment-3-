package com.shpp.p2p.cs.okurylyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {

    public void run() {
        int n = readInt("Enter a number: ");
        if (n <= 0) {
            outputMistake(n);
        } else {
            startNumberHail(n);
        }
    }

    private void outputMistake(int n) {
        while (n <= 0) {
            println("Error! You should enter positive number");
            n = readInt("Enter a number: ");
        }
        startNumberHail(n);
    }

    private void startNumberHail(int number) {
        while (number != 1) {
            if (isNumberOdd(number)) {
                println(number + " is odd so I make 3n + 1: " + ((3 * number) + 1));
                number = (3 * number) + 1;
            } else {
                println(number + " is even so I take half: " + (number / 2));
                number /= 2;
            }
        }
        println("The END!");
    }

    private boolean isNumberOdd(int number) {
        return number % 2 != 0;
    }
}
