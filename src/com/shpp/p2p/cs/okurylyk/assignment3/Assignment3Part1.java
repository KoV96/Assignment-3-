package com.shpp.p2p.cs.okurylyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {

    public void run() {
        makeUserPoll();
    }

    /**
     * Here I create method, that will be asking user how much minutes per day he or she have an aerobic. I have
     * realized this by the loop. Also in this loop I have created array which will be fulling step by step with
     * param t (time) that user input. I use [i-1] cause number of first array element is 0.
     */
    private void makeUserPoll() {
        int[] timeArray = new int[7];
        for (int i = 1; i <= 7; i++) {
            int t = readInt("How many minutes did you do on day " + i + "?");
            t = inputControl(i, t);
            timeArray[i - 1] = t;
        }
        checkHealth(timeArray);
    }

    /**
     * Here I make a control of user input. If user input a wrong value, I will ask him input a correct one.
     * @param dayOfWeek present number of week day;
     * @param time value of user input;
     * @return correct value.
     */
    private int inputControl(int dayOfWeek, int time) {
        if (time < 0) {
            while (time < 0){
                println("Sorry, but you input wrong value");
                time = readInt("How many minutes did you do on day " + dayOfWeek + "?");
            }
        }
        return time;
    }

    /**
     * When I created an array, I make checking of user health which standing on user data. According to our conditions
     * I create a loop and check both params if it is okay. When it is okay my params will be increased by 1.
     *
     * @param timeArray array which consist user data of training time.
     */
    private void checkHealth(int[] timeArray) {
        int cardioHealth = 0;
        int bloodPressure = 0;
        for (int i = 0; i < timeArray.length; i++) {
            if (timeArray[i] >= 30 && timeArray[i] < 40) {
                cardioHealth++;
            } else if (timeArray[i] >= 40) {
                cardioHealth++;
                bloodPressure++;
            }
        }
        writeConclusion(cardioHealth, bloodPressure);
    }

    /**
     * And the last method makes conclusion. I have realized it by two println(s) with conditions inside.
     * @param chTraining this is a number of user trainings which were at least 30 min.
     * @param bpTraining this is a number of user trainings which were more then 40 min.
     */
    private void writeConclusion(int chTraining, int bpTraining) {
        println (chTraining >= 5 ?
                "Cardiovacular health:\n Great job! You've done enough exercise for cardiovacular health." :
                "Cardiovacular health:\n You needed to train hard for at least " + (5 - chTraining) +
                        " more day(s) a week!");
        println (bpTraining >= 3 ?
                "Blood pressure:\n Great job! You've done enough exercise to keep a low blood pressure." :
                "Blood pressure:\n You needed to train hard for at least " + (3 - bpTraining) +
                        " more day(s) a week!");
    }
}
