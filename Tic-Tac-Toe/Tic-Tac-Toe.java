import java.util.Scanner;
public class TicTacToe
{
 Scanner scan = new Scanner(System.in);
 private Board board;
 public TicTacToe()
 {
  board = new Board(3,3);
  for (int row = 0;row < board.getHeight();row++)
  {
   for (int column = 0; column < board.getWidth();column++)
   {
    board.set(row,column,"-");
    System.out.print(board.get(row,column));
   }
   System.out.println();
  }
 }
 
 //this will clear the board so that everything is set to "-" 
 public void clearBoard()
 {
  for (int row = 0;row < board.getHeight();row++)
  {
   for (int column = 0; column < board.getWidth();column++)
   {
    board.set(row,column,"-");
   }
  }
 }
 
 //this ensure that the data on the board is printed every round
 public void printBoard()
 {
  for (int row = 0;row < board.getWidth();row++)
  {
   for (int column = 0; column < board.getHeight();column++)
   {
    System.out.print(board.get(row,column));
   }
   System.out.println();
  } 
 }
 
  public void putMark(int row, int column)
  { 
  //checks that the space is not take up yet by the opponent.  
   while (board.get(row,column)!="-")
   {
    System.out.println("You can not put a value there, the opponent already took the spot");
    System.out.println("Enter the row number(0,1,2)");
    row = scan.nextInt();
    System.out.println("Enter the column number(0,1,2)");
    column = scan.nextInt();
   }    
   board.set(row,column,"O");
  } 
  
  public void putMark2(int row, int column)
  { 
  
  //checks that the space is not take up yet by the opponent.  
   while (board.get(row,column)!="-")
   {
    System.out.println("You can not put a value there, the opponent already took the spot");
    System.out.println("Enter the row number(0,1,2)");
    row = scan.nextInt();
    System.out.println("Enter the column number(0,1,2)");
    column = scan.nextInt();
   }    
   board.set(row,column,"X");
  } 
  
  public void putMarkAuto()
  {
   int row = (int)(Math.random()*3);
   int column = (int)(Math.random()*3);
   while(board.get(row,column)!="-")
   {
    row = (int)(Math.random()*3);
    column = (int)(Math.random()*3);
   }
   board.set(row,column,"X");
  }
  
  public void putMarkAuto2()
  {
   int row = (int)(Math.random()*3);
   int column = (int)(Math.random()*3);
   while(board.get(row,column)!="-")
   {
    row = (int)(Math.random()*3);
    column = (int)(Math.random()*3);
   }
   board.set(row,column,"O");
  }

 
  public boolean allFilled()
 {
  int count = 0;
  for (int row = 0;row<board.getHeight();row++)
  {
   for (int column = 0; column<board.getWidth();column++)
   {
    if (!board.get(row,column).equals("-"))
    {
     count++;
    }   
   }
  }
  
  if (count != 9)
  {
   return false;
  } 
  return true;
 }
  
 public char winner()
 {
  int checkX = 0;
  int checkO = 0;
  int count = 3;
  
  //Checks the winner in across rows
  for (int row = 0;row < board.getHeight();row++)
  {
   for (int column = 0;column<board.getWidth();column++)
   {
    if (board.get(row,column).equals("X"))
    {
     checkX++;
    }
    
    else if (board.get(row,column).equals("O"))
    {
     checkO++;
    } 
   }
        
    if (checkX==count)
    {
     return('X');
    }
  
    else if(checkO==count)
    {
     return('O');
    } 
   checkO=0;
   checkX=0; 
  }
 
  
  //Check for the winner for any column
  for (int column = 0;column < board.getWidth();column++)
  {
   for (int row = 0;row<board.getHeight();row++)
   {
    if (board.get(row,column).equals("X"))    
    {
     checkX++;
    }
    
    else if (board.get(row,column).equals("O"))
    {
     checkO++;
    } 
    
    if (checkX==count)
    {
     return('X');
    }
  
    else if(checkO==count)
    {
     return('O');
    } 
   } 
   checkO=0;
   checkX=0; 
  } 
    
  
  //Checks on of the diagonals
  for (int row = 0;row < board.getHeight();row++)
  {
    if (board.get(row,row).equals("X"))
    {
     checkX++;
    }
    
    else if (board.get(row,row).equals("O"))
    {
     checkO++;
    } 
  }
    
    if (checkX==count)
    {
     return('X');
    }
  
    else if(checkO==count)
    {
     return('O');
    }  
   checkO=0;
   checkX=0;  

  
  //Checks the other diagonal 
  int yPosition = 2;
  for (int row = 0;row<board.getHeight();row++)
  {
    if(board.get(row,yPosition).equals("X"))
    {
     checkX++;
    }
    
    else if(board.get(row,yPosition).equals("O"))
    {
     checkO++;
    }
    
    yPosition--;
   }
        
    if(checkX == count)
    {
     return ('X');
    }
    
    if(checkO == count)
    {
     return ('O');
    }  

   checkX = 0;
   checkO = 0;
   return ('T'); 

  }
  public boolean checkWinner ()
   {
      boolean hasWinner = true;
      if (winner() == 'X')
      {
         hasWinner = false;
      }
      else if (winner () == 'O')
      {
         hasWinner = false;
      }
      else if (winner() == 'T' && allFilled())
      {
         hasWinner = false;
      }
      return hasWinner;
   }
   
  public void AiControls()
  {
   int oCount = 0;
   int oCount2 = 0;
   int oCount3 = 0;
   int num = 0;
   int num2 = 1;
   int num3 = 2;
   int blockCount = 2;
   //check if the row has two of the O 
   for(int row = 0;row<board.getHeight();row++)
   {
    for(int column = 0;column<board.getWidth();column++)
    {
     if(board.get(num,column).equals("O"))
     { 
      oCount++;
     }
     if(board.get(num2,column).equals("O"))
     {
      oCount2++;
     }
     if(board.get(num2,column).equals("O"))
     {
      oCount3++;
     }
    }
     //Check Row1
     if(oCount == blockCount)
     {
      int test = (int)(Math.random()*3);
      //System.out.println("true");
      while(!board.get(num,test).equals("-"))
      {
       test = (int)(Math.random()*3);
       if (!board.get(num,test).equals("-"))
       {
        num = (int)(Math.random()*3);
       }
      }
      board.set(num,test,"X");
      break;
     }
     //Checks Row2
     else if (oCount2 == blockCount)
     {
      int test = (int)(Math.random()*3);
      //System.out.println("true");
      while(!board.get(num2,test).equals("-"))
      {
       test = (int)(Math.random()*3);
      }
      if(!board.get(num2,test).equals("-"))
      {
       num2 = (int)(Math.random()*3);
      }
      board.set(num2,test,"X");
      break;
     }
     //Check Row3
     else if (oCount3 == blockCount)
     {
      int test = (int)(Math.random()*3);
      //System.out.println("true");
      while(!board.get(num3,test).equals("-"))
      {
       test = (int)(Math.random()*3);
      }
      if(!board.get(num3,test).equals("-"))
      {
       num3 = (int)(Math.random()*3);
      }
      board.set(num3,test,"X");
      break;
     }
   } 
   
   //Check the columns
  for (int column = 0;column < board.getWidth();column++)
  {
   int colCount = 0;
   int colCount2 = 0;
   int colCount3 = 0;
   for (int row = 0;row<board.getHeight();row++)
   {
    if (board.get(num,column).equals("O"))    
    {
     colCount++;
    } 
    else if (board.get(num2,column).equals("O"))
    {
     colCount2++;
    } 
    else if(board.get(num3,column).equals("O"))
    {
     colCount3++;
    }
   }
   //Check the first Column
    if (colCount==blockCount)
    {
     int test = (int)(Math.random()*3);
     System.out.println("true");
     while(!board.get(test,num).equals("-"))
     {
      test = (int)(Math.random()*3);
     }
      if(!board.get(test,num).equals("-"))
      {
       test = (int)(Math.random()*3);
      }
     board.set(test,num,"X");
     break;
    }
    
    //Check the second column
    if (colCount2==blockCount)
    {
     int test = (int)(Math.random()*3);
     //System.out.println("true");
     while(!board.get(test,num2).equals("-"))
     {
      test = (int)(Math.random()*3);
     }
      if(!board.get(test,num2).equals("-"))
      {
       test = (int)(Math.random()*3);
      }
     board.set(test,num2,"X");
     break;
    }
    
    //check the third column
    if (colCount2==blockCount)
    {
     int test = (int)(Math.random()*3);
     //System.out.println("true");
     while(!board.get(test,num3).equals("-"))
     {
      test = (int)(Math.random()*3);
     }
      if(!board.get(test,num3).equals("-"))
      {
       test = (int)(Math.random()*3);
      }
     board.set(test,num3,"X");
     break;
    }
   } 
  }
 }
