import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Guess a number between 1 and 100");
        Random r = new Random();
        int randomNumber = r.nextInt(100) + 1;

        int guessedNumber;
        while(true)
        {
            System.out.print("Guess a number: ");
            guessedNumber = sc.nextInt();

            if(guessedNumber > randomNumber)
            {
                System.out.println("Too High!");
            }
            else if(guessedNumber < randomNumber)
            {
                System.out.println("Too Low!");
            }
            else
            {
                System.out.println("Congrats! You guessed the right number");
                sc.close();
                break;
            }
        }
    }
}

/* Version 0.1

Learnt and Implented:
1. Constructors of classes are activated while creating the object of the class.
    eg: a. Scanner sc = new Scanner(); 
        Here new Scanner is a constructor.
        b. Random r = new Random();
        Here new Random() is a constructor.


Other Learnings:
1. r.nextInt(100) selects a random number from 0 to 99,
    where as r.nextInt(100)+1 selects a random number from 1 to 100.


OOPS concept:
1. new Random() creates a new random number generator. It is a constructor
    nextInt() is used to select any random integer from negative 10 digit to positive 10 digit number
    nextInt(int) is used to select any number from 0 (inclusive) to int (parameter bound) randomly.

*/