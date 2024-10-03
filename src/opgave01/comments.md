Slet udkommenteret kode. Udkommenteret kode gør ingen gavn, det forringer overblikket over resten af koden.

---

I updateStatistisks metoden er der igen grund til at lave en lokal variable

    int[] dices = roll;

bare brug parametervariablen roll.

---

sameValue metoden returnerer en boolean, som I ikke bruger. Lad den returnerer void og fjern jeres to return statements.

---

I bruger en for-løkke til at lægge terningeslagene sammen, 

        for (int index = 0; index < addFaces.length; index++) {
            sum += addFaces[index];
        }

Når I ved at der kun er to terninger er det ok at bruge

        sum = addFaces[0] + addFaces[1];

---

I setHighestValue metoden behøver I ikke den lokale variabel currentHighest. 

    public static void setHighestValue(int[] roll) {
        int sumOfRoll = addValue(roll);
        if (sumOfRoll > highestValue) {
            highestValue = sumOfRoll;
        }
    }

---



