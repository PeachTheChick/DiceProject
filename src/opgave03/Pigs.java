package opgave03;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Pigs {
    public static int pointsPlayer1, pointsPlayer2 = 0;

    public static void main(String[] args) {
        playPigs();
    }

    public static void playPigs() {
        int face = rollDie();
        addPoints(face);
    }

    public static void addPoints(int face) {
        Scanner scanner = new Scanner(System.in);

        int currentPoints = face;
        int newPoints = 0;
        String answer = scanner.nextLine();
        while (!answer.equals("No") || !answer.equals("N")) {
            if (face == 1) {
                System.out.println("Ingen point i denne runde :-(");
                newPoints = 0;
            } else {
                newPoints += face;
                System.out.println("Du har " + newPoints + " point :-)");
                System.out.print("Ønsker du at stoppe slå igen? [Yes/No]");
                answer = scanner.nextLine();
            }
        }
        pointsPlayer1 += newPoints;
        scanner.close();
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
}
