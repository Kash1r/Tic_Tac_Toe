/*
Name: Kashir Khan
CS 2336.003

Analysis:
GameDriver will the "manager" of the game pulling every other class within the project

Design:
1. public GameDriver()
- Default constructor of a game, create a board too
2. private void createBoard()
- Fill the board array with boards
3. setPlayers()
- Set the players for the players[]
4. printBoards()
- Print out the overall board of boards (board of boards heeeheee)
5. printBoardWinner()
- Print out who out the board for clarity in the UI
6. switchPlayers()
- Switch which player is playing/marking
7.
 */
package TTTGame_Ultimate;

public class GameDriver
{
    //Keep a list of the players for reference
    private Player[] players = new Player[2];
    //Board is referring to the overall board.
    private Board[] board = new Board[9];
    //Size of the individual TTT games within each board
    private int squareSize = 9;
    //This is to help keep track which square was selected by the previous opponent
    private int squareVal = -1;
    //Keep track which player is playing
    private int currentPlayer = -1;
    //Keep track of which board
    private int currentBoard = -1;

    //Default constructor for GameDriver
    public GameDriver()
    {
        createBoard();
    }

    //Populate all 9 boards.
    private void createBoard()
    {
        for(int i = 0; i < squareSize; i++)
        {
            //Create a board
            Board b = new Board(squareSize, i);
            //Put one for each of the 9 slots
            board[i] = b;
        }
    }

    //Set the players, taking in any kind of player: Human or Computer.
    public void setPlayers(Player player1, Player player2)
    {
        players[0] = player1;
        players[1] = player2;
    }

    //Print out the board for the UI
    public void printBoards()
    {
        //Print top 3 boards.
        for(int i = 0; i < 3; i++)
        {
            for(int x = 0; x < 3; x++)
            {
                board[x].print(i);
            }
            System.out.println();
        }
        System.out.println();
        //Print middle 3 boards.
        for(int i = 0; i < 3; i++)
        {
            for(int x = 3; x < 6; x++)
            {
                board[x].print(i);
            }
            System.out.println();
        }
        System.out.println();
        //Print bottom 3 boards.
        for(int i = 0; i < 3; i++)
        {
            for(int x = 6; x < 9; x++)
            {
                board[x].print(i);
            }
            System.out.println();
        }
        System.out.println();
    }

    //Print who has won in each board.
    private void printBoardWinner()
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[i].ifBoardWon())
            {
                board[i].printBoardWinner();
            }
        }
    }

    //Switch the current playing player
    private void switchPlayers()
    {
        //No need to randomize the starting player
        if(this.currentPlayer == 0)
        {
            this.currentPlayer = 1;
        }
        else
        {
            this.currentPlayer = 0;
        }
    }

    //Select the board
    private boolean selectBoard()
    {
        if(currentBoard == -1 || board[currentBoard].isFull())
        {
            //Check if board value is legal
            do
            {
                currentBoard = players[this.currentPlayer].pickBoardValue(9);
            }
            while(board[currentBoard].isFull());
            return true;
        }
        else
        {
            System.out.println("Selected board: " + currentBoard);
        }
        return false;
    }

    //Check for tie on the boards all the boards already have a win mark and no win condition has been met
    private boolean isTieMark()
    {
        if(board[0].ifBoardWon() && board[1].ifBoardWon() && board[2].ifBoardWon() && board[3].ifBoardWon() && board[4].ifBoardWon() &&
                board[5].ifBoardWon() && board[6].ifBoardWon() && board[7].ifBoardWon() && board[8].ifBoardWon())
        {
            return true;
        }
        return false;
    }

    //Check for a tie on the boards if just all the boards are filled with marks and no win condition has been met
    private boolean isTieFull()
    {
        if(board[0].isFull() && board[1].isFull() && board[2].isFull() && board[3].isFull() && board[4].isFull() &&
                board[5].isFull() && board[6].isFull() && board[7].isFull() && board[8].isFull())
        {
            return true;
        }
        return false;
    }

    //Check if the game is over based on win condition or ties
    private boolean gameOver()
    {
        //Check if any win condition has been met
        if(isWinner())
        {
            printBoards();
            System.out.println("The game winner is: " + players[this.currentPlayer].getMark() + "!");
            return true;
        }
        //Check for a tie with multiple won boards
        if(isTieMark())
        {
            printBoards();
            System.out.println("The game has ended in a tie!");
            return true;
        }
        //Check for at tie with just filled boards
        if(isTieFull())
        {
            printBoards();
            System.out.println("The game has ended in a tie!");
            return true;
        }
        return false;
    }

    //Check the rows of the boards for win condition
    private boolean boardCheckRow()
    {
        //Increment to check for win
        int count = 0;
        for(int i = 0; i < squareSize; i++)
        {
            //Check the board to see if it matches the winner
            if(board[i].getWinner() == players[this.currentPlayer].getMark())
            {
                count++;
            }
            //If at the end of the row the count equals 3 (the row satisfies the win condition)
            if(count == 3)
            {
                return true;
            }
            //Reset after checking each row
            if(i==2 || i==5)
            {
                count = 0;
            }
        }
        return false;
    }

    //Check the cols of the boards for the win condition
    private boolean boardCheckCol()
    {
        //Check left side and see if the board mark winners match
        if(board[0].getWinner() == players[this.currentPlayer].getMark() &&
                board[3].getWinner() == players[this.currentPlayer].getMark() &&
                board[6].getWinner() == players[this.currentPlayer].getMark())
        {
            return true;
        }
        //Check middle and see if the board mark winners match
        else if(board[1].getWinner() == players[this.currentPlayer].getMark() &&
                board[4].getWinner() == players[this.currentPlayer].getMark() &&
                board[7].getWinner() == players[this.currentPlayer].getMark())
        {
            return true;
        }
        //Check right side and see if the board mark winners match
        else if(board[2].getWinner() == players[this.currentPlayer].getMark() &&
                board[5].getWinner() == players[this.currentPlayer].getMark() &&
                board[8].getWinner() == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check from top left to bottom right of the boards
    private boolean boardCheckDiag1()
    {
        //Check each individual board and see if they match the board mark winner
        if(board[0].getWinner() == players[this.currentPlayer].getMark() &&
                board[4].getWinner() == players[this.currentPlayer].getMark() &&
                board[8].getWinner() == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check from top right to bottom left of the boards
    private boolean boardCheckDiag2()
    {
        //Check each individual board and see if they match the board mark winner
        if(board[2].getWinner() == players[this.currentPlayer].getMark() &&
                board[4].getWinner() == players[this.currentPlayer].getMark() &&
                board[6].getWinner() == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check for the overall 3 TTT boards won in a row
    private boolean isWinner()
    {
        if(boardCheckRow() || boardCheckCol() || boardCheckDiag1() || boardCheckDiag2())
        {
            return true;
        }
        return false;
    }

    //Check individual board row win condition
    private boolean checkSquareRow()
    {
        //Basically works the same as the boardCheckRow
        int count = 0;
        for(int i = 0; i < 9; i++) {
            if(board[currentBoard].getMark(i) == players[this.currentPlayer].getMark())
            {
                count++;
            }
            if(count == 3)
            {
                return true;
            }
            if(i==2 || i==5)
            {
                count = 0;
            }
        }
        return false;
    }

    //Check individual board col win condition
    private boolean checkSquareCol() {
        //Basically works the same as the boardCheckRow
        if(board[currentBoard].getMark(0) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(3) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(6) == players[this.currentPlayer].getMark())
        {
            return true;
        }
        else if(board[currentBoard].getMark(1) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(4) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(7) == players[this.currentPlayer].getMark())
        {
            return true;
        }
        else if(board[currentBoard].getMark(2) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(5) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(8) == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check from top left to bottom right
    private boolean checkSquareDiag1()
    {
        if(board[currentBoard].getMark(0) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(4) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(8) == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check from top right to bottom left
    private boolean checkSquareDiag2()
    {
        if(board[currentBoard].getMark(2) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(4) == players[this.currentPlayer].getMark() &&
                board[currentBoard].getMark(6) == players[this.currentPlayer].getMark())
        {
            return true;
        }
        return false;
    }

    //Check the individual board for winner
    private void boardWinner()
    {
        if(checkSquareRow() || checkSquareCol() || checkSquareDiag1() || checkSquareDiag2())
        {
            //Set the individual board as won.
            board[currentBoard].setWinner(players[this.currentPlayer].getMark());
        }
    }

    //Start the game basically
    public void start()
    {
        do
        {
            //Constantly print the board for UI
            printBoards();
            //Print who has won each board for the players to keep track easily
            printBoardWinner();
            //Switch players because turns.
            switchPlayers();
            //Clarify for UI
            System.out.println("The current player is: " + players[this.currentPlayer].getMark());
            //Make sure to check the player move is valid and select board
            selectBoard();
            while(!board[currentBoard].moveCheck(players[this.currentPlayer].getMark(), squareVal = players[this.currentPlayer].pickSquareValue(squareSize)));
            //Check for board winner
            boardWinner();
            //Current board placement is based on previous opponent
            currentBoard = squareVal;
        }
        while(!gameOver());
    }




}
