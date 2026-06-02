import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class NumberGuesser
{
    public int getValidInt(Scanner sc)
    {
        int input=0;
        while(true)
        {
            System.out.print("Guess a number: ");
            try
            {
            input = sc.nextInt();
            if(input<1 || input>100)
            {
                throw new IllegalArgumentException("Number must be between 1 and 100!");
            }
            break;
            }
            catch(InputMismatchException e)
            {
            System.out.println("Please enter a valid number: "+e);
            sc.nextLine();
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
        return input;
    }

    public void performanceMeasure(int attempts)
    {
        switch(attempts)
        {
        case 1,2,3 : System.out.println("Excellent!!");
            break;
        case 4,5,6,7 : System.out.println("Good!");
            break;
        default: System.out.println("Keep Practicing..");
        }
    }

}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        NumberGuesser ng = new NumberGuesser();

        int randomNumber = r.nextInt(100) + 1;

        System.out.println("Guess a number between 1 and 100"); 
        int attempts = 0;
        int guessedNumber;
        while(true)
        {
            guessedNumber = ng.getValidInt(sc);
            attempts++;

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
                System.out.println("Attempts: "+attempts);
                ng.performanceMeasure(attempts);
                sc.close();
                break;
            }
        }
    }
}

/* Version 0.3

Learnt and Implented:
1. Constructors of classes are activated while creating the object of the class.
    eg: a. Scanner sc = new Scanner(); 
        Here new Scanner is a constructor.
        b. Random r = new Random();
        Here new Random() is a constructor.
2. IllegalArgumentException is an exception used for runtime Exception,
    which indicates that the method has been passed an illeagal argument,
    according to the rules of the class/method.


Other Learnings:
1. r.nextInt(100) selects a random number from 0 to 99,
    where as r.nextInt(100)+1 selects a random number from 1 to 100.
2. no need to attempts++ in every condition. If I take any guess I can write attempts++ once.
3. Note that the attempts wont increment until the user enters a valid input.
    So for every bad input the program will not increment the attempt counter,
    hence resulting in robustness of the program.
4. PerformanceMeasure method is an example of a behavior based on state.

OOPS concept:
1. new Random() creates a new random number generator. It is a constructor
    Since java int is 32 bit, nextInt() is used to select a number from -2,147,483,648 to 2,147,483,647
    nextInt(int) is used to select any number from 0 (inclusive) to int (parameter bound) randomly.

*/