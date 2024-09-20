package opgave02;

import com.sun.nio.sctp.SctpMultiChannel;

import java.util.ArrayList;
import java.util.List;

public class Craps {


    public static void main(String[] args) {

        playCraps();

    }

    public static void playCraps() {

        int sumOfRoll = rollDice();

        if (sumOfRoll == 7 || sumOfRoll == 11) {
            System.out.println("Du har kastet: " + sumOfRoll + ", du har derfor vundet!");
        } else if (sumOfRoll == 2 || sumOfRoll == 3 || sumOfRoll == 12) {
            System.out.println("Du har kastet: " + sumOfRoll + ", du har derfor tabt :-(");
        } else {
            rollForPoint(sumOfRoll);
        }
    }

    public static boolean rollForPoint(int sum) {
        int firstRoll = sum;
        int latestRoll = sum;

        do {
            System.out.println("Du har fået " + latestRoll + " point!");
            latestRoll = rollDice();
        }
        while (latestRoll != 7 && latestRoll != firstRoll);

        System.out.println("du har kastet " + latestRoll + ", så du taber :-(");

        return true;
    }

    public static int rollDice() {
        //returns the sum of 2 random numbers between 1-6
        int roll1 = (int) (Math.random() * 6 + 1);
        int roll2 = (int) (Math.random() * 6 + 1);
        int roll = roll1 + roll2;

        return roll;
    }
}
