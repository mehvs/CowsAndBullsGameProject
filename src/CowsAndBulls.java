import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberToGuess = generatesRandomNumber();


        int bullsCount = 0;
        int cowsCount = 0;

        boolean isGameRunning = true;

        while (isGameRunning) {
            System.out.print(numberToGuess + " Enter 4 digit number with different digits: ");
            int userInput = input.nextInt();


            //taking each digit of the guess number
            int tempGuessNumber = numberToGuess;

            int guessDigitOne = tempGuessNumber % 10;
            tempGuessNumber = tempGuessNumber / 10;

            int guessDigitTwo = tempGuessNumber % 10;
            tempGuessNumber = tempGuessNumber / 10;

            int guessDigitThree = tempGuessNumber % 10;
            tempGuessNumber = tempGuessNumber / 10;

            int guessDigitFour = tempGuessNumber % 10;
            tempGuessNumber = tempGuessNumber / 10;


            //taking each digit of the user input number
            int tempUserInputNumber = userInput;

            int userInputDigitOne = tempUserInputNumber % 10;
            tempUserInputNumber = tempUserInputNumber / 10;

            int userInputDigitTwo = tempUserInputNumber % 10;
            tempUserInputNumber = tempUserInputNumber / 10;

            int userInputDigitThree = tempUserInputNumber % 10;
            tempUserInputNumber = tempUserInputNumber / 10;

            int userInputDigitFour = tempUserInputNumber % 10;
            tempUserInputNumber = tempUserInputNumber / 10;


            //adding to bull counter
            if (userInputDigitFour == guessDigitFour) {
                bullsCount++;
            }

            if (userInputDigitThree == guessDigitThree) {
                bullsCount++;
            }

            if (userInputDigitTwo == guessDigitTwo) {
                bullsCount++;
            }

            if (userInputDigitOne == guessDigitOne) {
                bullsCount++;
            }

            System.out.println("There are " + bullsCount + " bulls in your number");
            //adding to cow counter

            //checking if the 4th digit is matching with any of the rest and adds to cows' counter
            if (userInputDigitFour == guessDigitThree) {
                cowsCount++;
            }

            if (userInputDigitFour == guessDigitTwo) {
                cowsCount++;
            }

            if (userInputDigitFour == guessDigitOne) {
                cowsCount++;
            }
            //checking if the 3th digit is matching with any of the rest and adds to cows' counter
            if (userInputDigitThree == guessDigitFour) {
                cowsCount++;
            }

            if (userInputDigitThree == guessDigitTwo) {
                cowsCount++;
            }

            if (userInputDigitThree == guessDigitOne) {
                cowsCount++;
            }
            //checking if the 2nd digit is matching with any of the rest and adds to cows' counter
            if (userInputDigitTwo == guessDigitFour) {
                cowsCount++;
            }

            if (userInputDigitTwo == guessDigitThree) {
                cowsCount++;
            }

            if (userInputDigitTwo == guessDigitOne) {
                cowsCount++;
            }
            //checking if the 1st digit is matching with any of the rest and adds to cows' counter
            if (userInputDigitOne == guessDigitFour) {
                cowsCount++;
            }

            if (userInputDigitOne == guessDigitThree) {
                cowsCount++;
            }

            if (userInputDigitOne == guessDigitTwo) {
                cowsCount++;
            }

            System.out.println("There are " + cowsCount + " cows");
            cowsCount = 0;
            bullsCount = 0;

            if(userInput == numberToGuess){
                isGameRunning = false;
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
}