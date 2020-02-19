import java.util.Scanner;
import java.util.Random;

public class CowsAndBullsTest {
    public static void main(String[] args) {
        System.out.println(GeneratesRandomNumber());
    }

    public static int GeneratesRandomNumber() {
        Random rand = new Random();
        int digitOne = rand.nextInt(9) + 1;
        int digitTwo = 0;
        int digitThree = 0;
        int digitFour = 0;

        do {
            digitTwo = rand.nextInt(9) + 1;
        } while (digitTwo == digitOne);

        do {
            digitThree = rand.nextInt(9) + 1;
        } while (digitThree == digitOne || digitThree == digitTwo);

        do {
            digitFour = rand.nextInt(9) + 1;
        } while (digitFour == digitOne || digitFour == digitTwo || digitFour == digitThree);

        String digitOneStr = Integer.toString(digitOne);
        String digitTwoStr = Integer.toString(digitTwo);
        String digitThreeStr = Integer.toString(digitThree);
        String digitFourStr = Integer.toString(digitFour);

        String digitConcat = digitOneStr + digitTwoStr + digitThreeStr + digitFourStr;

        int fourDigitNumber = Integer.parseInt(digitConcat);

        return fourDigitNumber;
    }
}

