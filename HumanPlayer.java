/*
Name: Kashir Khan
CS 2336.003

Analysis:
Create a HumanPlayer object to be used in GameDriver
Read in the board and square value from the user
Verify values as well

Design:
1. HumanPlayer(String name, String mark)
- Default constructor for HumanPlayer
2. pickBoardValue(int range)
- Use a "do while" loop to get constant input
- Check for legality of the move/mark
3. pickSquareValue(int range)
- Use a "while" loop to get constant input
- Check for legality of the move/mark
 */
package TTTGame_Ultimate;
import java.util.Scanner;


public class HumanPlayer extends Player
{
    Scanner input = new Scanner(System.in);

    //HumanPlayer default constructor
    public HumanPlayer(String name, String mark)
    {
        //Just super from Player
        super(name, mark);
    }
    //Override the abstract method
    @Override
    public int pickBoardValue(int range)
    {
        //We will need to check user input
        boolean legalInput = false;
        //The reason why "choice" is a string and not int is to check for legal input easier.
        String choice = "";
        int board = 0;
        //A "do while" structure is used here like in the previous TTT game phases. It makes for an easy use of getting an input.
        do
        {
            System.out.print("Select a board: ");
            choice = input.nextLine();
            //Check for legal input
            if(isLegal(choice))
            {
                //Use parseInt to get an int value return
                board = Integer.parseInt(choice);
                //Now we need to check if we can place it legally on the board
                if (board >= 0 && board < range)
                {
                    legalInput = true;
                }
            }
        }
        while (!legalInput);

        System.out.println("Selected board: " + board);

        return board;
    }

    //This method basically does the same thing as the one above.
    @Override
    public int pickSquareValue(int range)
    {
        boolean legalInput = false;
        String choice = "";
        int square = 0;
        do
        {
            System.out.print("Select a square: ");
            choice = input.nextLine();
            if(isLegal(choice))
            {
                square = Integer.parseInt(choice);
                if (square >= 0 && square < range)
                {
                    legalInput = true;
                }
            }
        }
        while (!legalInput);

        System.out.println("Selected square: " + square);

        return square;
    }

    //Check for legal input
    public static boolean isLegal(String value)
    {
        try
        {
            //See if input is an integer
            Integer.parseInt(value);
            return true;
        }
        catch (Exception e)
        {
            //If not, return false;
            return false;
        }
    }

}
