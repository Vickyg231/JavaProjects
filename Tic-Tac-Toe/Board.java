/**
 * A class for representing a generic board
 * Originally used for tic-tac-toe, but hoping to
 * expand to other games
 */
 public class Board 
 {
   /**
   * Keeping track of all the values on the current board.
   */ 
   private String[][] boardAr;
   /**
   * The width of the board.
   */
   private int width;
   /** 
   * The height of the board.
   */
 
   private int height;
   
   /**
   * Alocate all the spaces and dimensions for the game.
   * @param width the width of the game board
   * @param height the height of the game board
   */
   public Board(int width, int height)
   {
     this.width = width;
     this.height = height;
     boardAr = new String[height][width];
   }
   
   /**
   * Construct using 2d String array 
   */
   public Board(String[][] b)
   { 
    boardAr = b;
   }
   
   /**
   * Standard mutator or setter
   * @param row the row value to be set
   * @param col the col value to be set
   * @param val the String that is setting "X","Y" or "-""
   */
   public void set(int row, int col, String val)
   {
     boardAr[row][col] = val;
   }
   
  /**
   * Standard accessor or getter
   * @param row the row starting at index 0
   * @param col the column starting at index 0
   * @return String "X" or "O"
   */
   public String get(int row, int col)
   {
     return boardAr[row][col];
   }
   /**
     * Get the width
     * @return int the width
     */
   public int getWidth()
   { 
     return width;
   }
    
   /**
    * Get the height
    * @return int the height
    */
    public int getHeight()
    { 
      return height;
    }
    
    /**
    * Easy way to look at the data
    * @return String the location of the "X","O" and "-" for the game
    */
    public String toString()
    {
      return ""+boardAr[width][height] ;
    }
  }
