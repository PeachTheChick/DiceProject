package opgave01;


//import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {

    public static int addedValue, rollCount, countSame, highestValue = 0; //a way to define multiple field variabels with the same initial value
    public static int[] arr = new int[0];

    public static void main(String[] args) {

        printRules();

        playDice();

//        countInstances(arr, arr.length);

    }

    public static void countInstances(int[] arr, int n) {
        boolean checked[] = new boolean[n];

        Arrays.fill(checked, false);

        for (int index = 0; index < n; index++) {
            if (checked[index] == true)
                continue;

            int count = 1;
            for (int i = index + 1; i < n; i++) {
                if (arr[index] == arr[i]) {
                    checked[i] = true;
                    count++;
                }
            }
            System.out.println(arr[index] + " " + count);
        }
    }

//    public static int[] saveAllRollValues(int currentLength, int[] rolls, int valueToAdd) {
//        int newArray[] = new int[currentLength + 1];
//        for (int index = 0; index < currentLength; index++) {
//            newArray[index] = rolls[index];
//
//            newArray[currentLength] = valueToAdd;
//        }
//        return newArray;
//    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Kast 2 terninger 6 gange");
//        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    public static void playDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kast en terning? ('ja/nej') ");
        String answer = scanner.nextLine();

        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.print("Du har kastet ");
            for (int index = 0; index < faces.length; index++) {
                System.out.print(faces[index] + " ");
            }
            updateStatistics(faces);

            System.out.println();
            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    public static void updateStatistics(int[] roll) {
        int[] dices = roll;

        updateRollcount(); //OK
        sameValue(dices); //OK
        addedValue += addValue(dices); //OK
        setHighestValue(dices); //Ish?
    }

    public static void printStatistics() {
        System.out.println("Du har kastet " + rollCount + " gange.");
        System.out.println("Det samlede antal øjne er " + addedValue + ".");
        System.out.println("Du har kastet ens " + countSame + " gange.");
        System.out.println("Det højeste slag var " + highestValue + ".");
//        countInstances(arr, arr.length);
    }

    //roll 2 dice and return values
    public static int[] rollDice() {
        int[] rollArray = new int[2]; //add new array, allocate 2 spaces for values

        rollArray[0] = (int) (Math.random() * 6 + 1); //add random value to rollArray index 0
        rollArray[1] = (int) (Math.random() * 6 + 1); //add random value to rollArray index 1

        return rollArray;
    }

    public static int addValue(int[] addFaces) {
        int sum = 0;

        for (int index = 0; index < addFaces.length; index++) {
            sum += addFaces[index];
        }
        return sum;
    }

    public static void updateRollcount() {
        rollCount++;
    }

    public static boolean sameValue(int[] sameFaces) {

        if (sameFaces[0] == sameFaces[1]) {
            countSame++;
            return true;
        }
        return false;
    }

    public static void setHighestValue(int[] roll) {
        int currentHighest = highestValue;
        int sumOfRoll = addValue(roll);

        if (sumOfRoll > currentHighest) {
            highestValue = sumOfRoll;
        }
    }

}
