import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {
    public static void main(String[] args) {
        createsOnePlayerGame();
    }

    public static void createsOnePlayerGame() {
        boolean isGameOn = true;
        int computerNumber = generatesRandomNumber();

        while (isGameOn) {
            System.out.println(computerNumber);
            int player = getsPlayerInput();

            countsCows(player, computerNumber);
            System.out.println("There are " + countsBulls(player, computerNumber) + " bulls in your number.");

            if (countsBulls(player, computerNumber) == 4) {
                isGameOn = false;
            }
        }
        System.out.println("Congratulations you guessed the number!");
    }

    //method that generates four digit number with no repetitive digits
    public static int generatesRandomNumber() {
        Random rand = new Random();
        int digitOne = rand.nextInt(9) + 1;
        int digitTwo = 0;
        int digitThree = 0;
        int digitFour = 0;

        do {
            digitTwo = rand.nextInt(10);
        } while (digitTwo == digitOne);

        do {
            digitThree = rand.nextInt(10);
        } while (digitThree == digitOne || digitThree == digitTwo);

        do {
            digitFour = rand.nextInt(10);
        } while (digitFour == digitOne || digitFour == digitTwo || digitFour == digitThree);

        String digitOneStr = Integer.toString(digitOne);
        String digitTwoStr = Integer.toString(digitTwo);
        String digitThreeStr = Integer.toString(digitThree);
        String digitFourStr = Integer.toString(digitFour);

        String digitConcat = digitOneStr + digitTwoStr + digitThreeStr + digitFourStr;

        int fourDigitNumber = Integer.parseInt(digitConcat);

        return fourDigitNumber;
    }

    public static int takesEachDigit(int number, int digit) {
        int numberToReturn = 0;

        int tempNumber = number;

        int digitOne = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitTwo = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitThree = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitFour = tempNumber % 10;
        tempNumber = tempNumber / 10;

        if (digit == 4) {
            numberToReturn = digitOne;
        } else if (digit == 3) {
            numberToReturn = digitTwo;
        } else if (digit == 2) {
            numberToReturn = digitThree;
        } else if (digit == 1) {
            numberToReturn = digitFour;
        }

        return numberToReturn;
    }

    public static int countsBulls(int numberOne, int numberTwo) {
        int bulls = 0;
        if ((takesEachDigit(numberOne, 1)) == (takesEachDigit(numberTwo, 1))) {
            bulls++;
        }

        if ((takesEachDigit(numberOne, 2)) == (takesEachDigit(numberTwo, 2))) {
            bulls++;
        }

        if ((takesEachDigit(numberOne, 3)) == (takesEachDigit(numberTwo, 3))) {
            bulls++;
        }

        if ((takesEachDigit(numberOne, 4)) == (takesEachDigit(numberTwo, 4))) {
            bulls++;
        }

        return bulls;
    }

    public static void countsCows(int numberOne, int numberTwo) {
        int cows = 0;
        if (takesEachDigit(numberOne, 4) == takesEachDigit(numberTwo, 3)) {
            if (takesEachDigit(numberOne, 3) != takesEachDigit(numberTwo, 3)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 4) == takesEachDigit(numberTwo, 2)) {
            if (takesEachDigit(numberOne, 2) != takesEachDigit(numberTwo, 2)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 4) == takesEachDigit(numberTwo, 1)) {
            if (takesEachDigit(numberOne, 1) != takesEachDigit(numberTwo, 1)) {
                cows++;
            }
        }
        //checking if the 3th digit is matching with any of the rest and adds to cows' counter
        if (takesEachDigit(numberOne, 3) == takesEachDigit(numberTwo, 4)) {
            if (takesEachDigit(numberOne, 4) != takesEachDigit(numberTwo, 4)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 3) == takesEachDigit(numberTwo, 2)) {
            if (takesEachDigit(numberOne, 2) != takesEachDigit(numberTwo, 2)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 3) == takesEachDigit(numberTwo, 1)) {
            if (takesEachDigit(numberOne, 1) != takesEachDigit(numberTwo, 1)) {
                cows++;
            }
        }
        //checking if the 2nd digit is matching with any of the rest and adds to cows' counter
        if (takesEachDigit(numberOne, 2) == takesEachDigit(numberTwo, 4)) {
            if (takesEachDigit(numberOne, 4) != takesEachDigit(numberTwo, 4)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 2) == takesEachDigit(numberTwo, 3)) {
            if (takesEachDigit(numberOne, 3) != takesEachDigit(numberTwo, 3)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 2) == takesEachDigit(numberTwo, 1)) {
            if (takesEachDigit(numberOne, 1) != takesEachDigit(numberTwo, 1)) {
                cows++;
            }
        }
        //checking if the 1st digit is matching with any of the rest and adds to cows' counter
        if (takesEachDigit(numberOne, 1) == takesEachDigit(numberTwo, 4)) {
            if (takesEachDigit(numberOne, 4) != takesEachDigit(numberTwo, 4)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 1) == takesEachDigit(numberTwo, 3)) {
            if (takesEachDigit(numberOne, 3) != takesEachDigit(numberTwo, 3)) {
                cows++;
            }
        }

        if (takesEachDigit(numberOne, 1) == takesEachDigit(numberTwo, 2)) {
            if (takesEachDigit(numberOne, 2) != takesEachDigit(numberTwo, 2)) {
                cows++;
            }
        }
        System.out.println("There are " + cows + " cows in your number.");

    }

    public static int getsPlayerInput() {
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        return userInput;
    }


}