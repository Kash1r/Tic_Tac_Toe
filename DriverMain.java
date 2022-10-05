/*
Name: Kashir Khan
CS 2336.003

Analysis: This class is just for running the game


Design:
1. Make a new GameDriver
2. Start
3. Ask for user input on what kind of players it wants


*/

package TTTGame_Ultimate;
import java.util.Scanner;

public class DriverMain
{
    public static void main(String[] args)
    {
        GameDriver game = new GameDriver();
        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("For the type of players, please type: ");
        System.out.println("1. Two Human Players");
        System.out.println("2. One Human Player and One Computer Player");
        System.out.println("3. Two Computer Players");

        choice = input.nextInt();

        if(choice == 1)
        {
            game.setPlayers(new HumanPlayer("Player1" , "X"), new HumanPlayer("Player2", "O"));
            game.start();

        }
        else if(choice == 2)
        {
            game.setPlayers(new ComputerPlayer("Player1" , "X"), new HumanPlayer("Player2", "O"));
            game.start();
        }
        else if(choice == 3)
        {
            game.setPlayers(new ComputerPlayer("Player1" , "X"), new ComputerPlayer("Player2", "O"));
            game.start();
        }
        else
        {
            System.out.println("Please restart and choose a valid player state!");
        }

    }
}
