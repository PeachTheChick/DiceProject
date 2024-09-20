package opgave02;

import java.util.ArrayList;
import java.util.List;

public class Craps {

    public static int sumOfRoll = 0;

    public static void main(String[] args) {

    }

    public static void playCraps() {


        int face = sumOfRoll;
        System.out.println("Du har kastet: " + face);


        sumOfRoll = 0; //end game
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static int rollSum(int face) {
        int newSum = sumOfRoll;
        if (newSum != 0) {
            newSum += face;
        }
        return newSum;
    }
}
