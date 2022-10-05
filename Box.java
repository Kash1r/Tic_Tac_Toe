/*
Name: Kashir Khan
CS 2336.003

Analysis:
Box will handle the manipulation of individual squares on boards and a print method.

Design:
1. Box(String mark)
- Constructor for the box
2. boolean setMark(String mark)
- Set the mark for this specific box to the parameter
3. boolean isAvailable()
- Determine if it's legal to set mark on this box
4. String getMark()
- Return mark of this box
5. void print()
- Print out the mark of this box for the board UI

*/
package TTTGame_Ultimate;

class Box
{
    //Each box will have a "mark", X or O
    private String mark;

    //Default constructor of box
    Box(String mark)
    {
        this.mark = mark;
    }

    //Method to set the mark of a Box
    boolean setMark(String mark)
    {
        if(isAvailable())
        {
            this.mark = mark;
            return true;
        }
        return false;
    }

    //Helper method to determine if legal
    boolean isAvailable()
    {
        for(int i = 0; i < 9; i++)
        {
            //The move is only legal if nothing has been marked yet, or the board is already full and there's a "*" now.
            if(this.mark.equals(Integer.toString(i)) || this.mark.equals("*"))
            {
                return true;
            }
        }
        return false;
    }

    //Helper method to get the mark of the box
    String getMark()
    {
        return this.mark;
    }

    //This print method will be used to help print out the board cleanly.
    void print()
    {
        System.out.print(this.mark + " | ");
    }

}
