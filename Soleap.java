// Mystery Number Duel
import java.util.Random;
import java.util.Scanner;
public class Soleap {
    public static void main(String[] args){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int num = random.nextInt(100) + 1;
        int guess;
        System.out.println("Guess the Correct Number Between 1 and 100 !");
        for(int attempts= 0; attempts <=7; attempts ++ ){
            System.out.print(" Enter guess: " + attempts + " out of 7: ");
            guess = input.nextInt();
            if(guess < 1 || guess > 100){
                System.out.println("Invalid number, enter within the range");
                break;
            }
            else if( guess == num){
                System.out.println("Bullsye!, You guessed correctly");
                break;
            }
            else if( guess > num){
                System.out.println("Too high!");
            }
            else{
                System.out.println("Too low!");
            }
        }
        System.out.println("Game over!" + "\n" + "The correct number was:" + num);
    }
}