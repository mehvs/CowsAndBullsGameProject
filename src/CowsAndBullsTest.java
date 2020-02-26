import java.util.Random;
import java.util.Scanner;

public class CowsAndBullsTest {
    public static void main(String[] args) {
        //createsOnePlayerGame();
        createsTwoPlayerGame();
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

    public static void createsTwoPlayerGame() {
        int computerOne = generatesRandomNumber();
        int computerTwo = generatesRandomNumber();
        int playerOne = 0;
        int playerTwo = 0;

        while(true){
            System.out.println(computerOne + " " + computerTwo);
            System.out.println("Player one turn: ");

            playerOne = getsPlayerInput();
            countsCows(playerOne, computerOne);
            System.out.println("There are " + countsBulls(playerOne, computerOne) + " bulls in your number.");

            if (countsBulls(playerOne, computerOne) == 4) {
                break;
            }

            System.out.println("Player two turn: ");

            playerTwo = getsPlayerInput();
            countsCows(playerTwo, computerTwo);
            System.out.println("There are " + countsBulls(playerTwo, computerTwo) + " bulls in your number.");

            if (countsBulls(playerTwo, computerTwo) == 4) {
                break;
            }
        }
        if(playerOne == computerOne){
            System.out.println("Player one guessed the number!");
        }else if(playerTwo == computerTwo){
            System.out.println("Player two guessed the number!");
        }
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

        for(int i = 1; i <= 4; i++){

            if(takesEachDigit(numberOne, i) == takesEachDigit(numberTwo, i)){
                bulls++;
            }
        }

        return bulls;
    }

    public static void countsCows(int numberOne, int numberTwo) {
        int cows = 0;

        for(int i = 1; i <= 4; i++){

            for(int j = 1; j <= 3; j++){

                if (takesEachDigit(numberOne, i) == takesEachDigit(numberTwo, j)) {

                    if (takesEachDigit(numberOne, j) != takesEachDigit(numberTwo, j)) {
                        cows++;
                    }

                }
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