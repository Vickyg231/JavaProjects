import java.util.Scanner;
/** class HumanPlayer manages the moves for making a move */

public class HumanPlayer
{
  private TicTacToe t;
  public HumanPlayer(TicTacToe t)
  {
    this.t = t;
  }
  /**
   * makeMove reads in two integers using Scanner and places either an 'X'
   * or a 'Y' onto the board.  If the spot is not open, it makes
   * the player try again until he/she enters a correct move
   */
  public void makeMove()
  {
   System.out.println("Enter the location of where you want to put the String \n make sure to put in two values, the first is the row, the second is the column");
   
  }
}
