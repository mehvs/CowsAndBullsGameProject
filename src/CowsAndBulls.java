public class CowsAndBulls {
    public static void main(String[] args) {
        int[] numberToGuess = {3,2,2,6};
        int[] userInput = {3,2,4,5};
        int bullCounter = 0;

        for(int i = 0; i < numberToGuess.length;i++){
            if(numberToGuess[i] == userInput[i]){
                bullCounter++;
            }

        }
        System.out.println("There are " + bullCounter + " bulls");
    }
}
