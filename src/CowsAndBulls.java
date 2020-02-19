import java.util.Scanner;

public class CowsAndBulls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberToGuess = 5432;
        int userInput = 3421;

        int bullsCount = 0;
        int cowsCount = 0;

        //taking each digit of the guess number
        int tempGuessNumber = numberToGuess;

        int guessDigitOne = tempGuessNumber % 10;
        tempGuessNumber = tempGuessNumber / 10;
        System.out.println(guessDigitOne);

        int guessDigitTwo = tempGuessNumber % 10;
        tempGuessNumber = tempGuessNumber / 10;
        System.out.println(guessDigitTwo);

        int guessDigitThree = tempGuessNumber % 10;
        tempGuessNumber = tempGuessNumber / 10;
        System.out.println(guessDigitThree);

        int guessDigitFour = tempGuessNumber % 10;
        tempGuessNumber = tempGuessNumber / 10;
        System.out.println(guessDigitFour);

        //taking each digit of the user input number
        int tempUserInputNumber = userInput;
        int userInputDigitOne = tempUserInputNumber % 10;
        tempUserInputNumber = tempUserInputNumber / 10;
        System.out.println(userInputDigitOne);

        int userInputDigitTwo = tempUserInputNumber % 10;
        tempUserInputNumber = tempUserInputNumber / 10;
        System.out.println(userInputDigitTwo);

        int userInputDigitThree = tempUserInputNumber % 10;
        tempUserInputNumber = tempUserInputNumber / 10;
        System.out.println(userInputDigitThree);

        int userInputDigitFour = tempUserInputNumber % 10;
        tempUserInputNumber = tempUserInputNumber / 10;
        System.out.println(userInputDigitFour);

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

    }
}