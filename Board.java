/*
Name: Kashir Khan
CS 2336.003

Analysis:
Board will be the overall arching board that will hold boxes
Board needs to be setup for later use by GameDriver
Design:
1. Board(int square, int boardNum)
- Constructor for Board
2. fill()
- Fill the boxes array for this board
3. print(int row)
- Print the board by row
- Printing by row will be useful later when we want to print all 9 boards in GameDriver
4. setWinner(String mark)
- Set the winner of this board, X or O
5. getWinner()
- Return the winner mark of this board, X or O
6. printBoardWinner()
- Print the board winner for the end of the game scoreboard
7. ifBoardWon()
- Check if the board has been won
8. isFull()
- Check if the board is full
9. moveCheck()
- Check if a move is legal
10. getMark()
- Get mark for this box.




 */

package TTTGame_Ultimate;

public class Board
{
    //Board is just a bunch boxes, make an array for it
    private Box[] boxes;
    //Hold size of board
    private int square;
    //Hold which board to look at
    private int boardNum;
    //Holds the winner of this board, X or O
    private String winMark = "";
    //Determine if this board has been won
    private boolean won = false;

    //Board constructor
    Board(int square, int boardNum)
    {
        this.square = square;
        this.boardNum = boardNum;
        fill();
    }

    //Fill the board with boxes
    private void fill()
    {
        boxes = new Box[square];
        for(int i = 0; i < boxes.length; i++)
        {
            //Need to create a new box for each individual spot
            Box box = new Box(Integer.toString(i));
            boxes[i] = box;
        }
    }

    //Print out the board
    //Printing by row is important for when we want to print all 9 boards for the UI
    public void print(int row)
    {
        //Print squares 0, 1, and 2
        if(row == 0)
        {
            for(int i = 0; i < boxes.length-6; i++)
            {
                if(i%3 == 0)
                {
                    System.out.print("\tBOARD#" + boardNum + " | ");
                }
                boxes[i].print();
            }
        }
        //Print squares 3, 4, and 5
        else if(row == 1)
        {
            for(int i = 3; i < boxes.length-3; i++)
            {
                if(i%3 == 0)
                {
                    System.out.print("\tBOARD#" + boardNum + " | ");
                }
                boxes[i].print();
            }
        }
        //Print squares 6, 7, and 8
        else if(row == 2)
        {
            for(int i = 6; i < boxes.length; i++)
            {
                if(i%3 == 0)
                {
                    System.out.print("\tBOARD#" + boardNum + " | ");
                }
                boxes[i].print();
            }
        }
    }

    //Set winner of this board
    public void setWinner(String mark)
    {
        //Need to check if the board has not already been won yet.
        if(!ifBoardWon())
        {
            this.winMark = mark;
            this.won = true;
            //Now the board has been won, we need to set "*" in any unused spots to indicate legal moves
            for(Box b: boxes)
            {
                if(b.isAvailable())
                {
                    b.setMark("*");
                }
            }
        }
    }

    //Helper method to get who has won this board
    public String getWinner()
    {
        return this.winMark;
    }

    //Print the winner of this board
    public void printBoardWinner()
    {
        System.out.println("The winner of BOARD#" + boardNum + " is: " + this.winMark);
    }

    //See if the board is won
    public boolean ifBoardWon()
    {
        return this.won;
    }

    //Check if all the boxes on the board are full
    public boolean isFull()
    {
        for(Box b : boxes)
        {
            if(b.isAvailable())
            {
                return false;
            }
        }
        return true;
    }

    //Check to see if move is legal
    public boolean moveCheck(String mark, int square)
    {
        return boxes[square].setMark(mark);
    }

    //Helper method to get mark in Box
    public String getMark(int square)
    {
        return boxes[square].getMark();
    }
}
