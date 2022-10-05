/*
Name: Kashir Khan
CS 2336.003

Analysis:
This is the general player class HumanPlayer and ComputerPlayer will use
We set the mark, name, etc. for player objects for the Game Driver


Design:
1. Player(String name, String mark)
- Default constructor for Player
2. setMark(String mark)
- Set mark
3. setName(String name)
- Set name
4. getMark()
- get Mark
5. getName()
- get Name
6. public abstract int pickBoardValue(int board)
- An abstract method to select board value, will be implemented in Human/Computer player
7. public abstract int pickSquareValue(int square)
- An abstract method to select square value, will be implemented in Human/Computer player
*/

package TTTGame_Ultimate;
//Player is an abstract class so HumanPlayer and ComputerPlayer can pull from it.
public abstract class Player
{
    private String name;
    private String mark;

    //Default player constructor
    public Player(String name, String mark)
    {
        this.name = name;
        this.mark = mark;
    }
    //Helper method to set mark
    public void setMark(String mark)
    {
        this.mark = mark;
    }
    //Helper method to set name
    public void setName(String name)
    {
        this.name = name;
    }
    //Helper method to get mark
    public String getMark()
    {
        return this.mark;
    }
    //Helper method to get name
    public String getName()
    {
        return this.name;
    }
    //This is an abstract that will be used by HumanPlayer and ComputerPlayer for the player to choose which board they're setting their mark
    public abstract int pickBoardValue(int range);
    ////This is an abstract that will be used by HumanPlayer and ComputerPlayer for the player to choose which square/box they're setting their mark
    public abstract int pickSquareValue(int range);

}
