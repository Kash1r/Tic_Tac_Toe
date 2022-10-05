package TTTGame_Ultimate;
import java.util.Scanner;
/*
Name: Kashir Khan
CS 2336.003

Analysis:
Create a ComputerPlayer object to be used in GameDriver
Read in the board and square value from the user
We don't have to verify input because we can FORCE the computer to do our bidding :)

Design:
1. ComputerPlayer(String name, String mark)
- Default constructor for ComputerPlayer
2. pickBoardValue(int range)
- Use a "do while" loop to get constant input, we still need to simulate input for the UI to keep track of moves
3. pickSquareValue(int range)
- Use a "while" loop to get constant input, we still need to simulate input for the UI to keep track of moves
4. randomNum(int range)
- Generate a random number for the computer to use as a choice for board/square
 */

public class ComputerPlayer extends Player
{
    Scanner input = new Scanner(System.in);

    public ComputerPlayer(String name, String mark)
    {
        //Just super from Player
        super(name, mark);
    }
    //Override the abstract method
    @Override
    //This method is basically the same as HumanPlayer, except we don't have to check for legality or a "real input"
    public int pickBoardValue(int range)
    {
        int board = 0;
        do
        {
            System.out.println("Select a board: \n");
            board = randomNum(range);
        }
        while(!(board >= 0 && board < range));

        System.out.println("Selected board: " + board);

        return board;
    }

    //This method basically does the same thing as the one above.
    @Override
    public int pickSquareValue(int range)
    {
        int square = 0;
        do
        {
            System.out.println("Select a square: \n");
            square = randomNum(range);
        }
        while(!(square >= 0 && square < range));

        System.out.println("Selected square: " + square);

        return square;
    }

    private int randomNum(int range)
    {
        return (int) (Math.random() * range);
    }


}

