import java.util.Scanner;
public class playType
{
 private TicTacToe t;
 private boolean go = true;
 Scanner scan = new Scanner(System.in);
 public void humanVsHuman(TicTacToe t)
 {
  int count = 1;
  while(t.checkWinner())
  { 
   if (count == 1)
   {
    System.out.println("Player O's turn");
    System.out.println("Enter a row[0,1,2]");
    int row = scan.nextInt();
    System.out.println("Enter a column[0,1,2]");
    int column = scan.nextInt();
    t.putMark(row,column);
   }
   if (count == -1)
   {
    System.out.println("Player X's turn");
    System.out.println("Enter a row[0,1,2]");
    int row = scan.nextInt();
    System.out.println("Enter a column[0,1,2]");
    int column = scan.nextInt();
    t.putMark2(row,column);
   }
   count= count*-1; 
   t.printBoard(); 
   System.out.println();
  } 
 }
 
 public void humanVsRandom(TicTacToe t)
 {
  int count = 1;
  while(t.checkWinner())
  { 
   if (count == 1)
   {
    System.out.println("Player O's turn");
    System.out.println("Enter a row[0,1,2]");
    int row = scan.nextInt();
    System.out.println("Enter a column[0,1,2]");
    int column = scan.nextInt();
    t.putMark(row,column);
    System.out.println();
   }
   if (count == -1)
   {
    System.out.println("Computer Player X's turn");
    t.putMarkAuto();
    System.out.println();

   }
   count= count*-1; 
   t.printBoard(); 
   System.out.println();
  }
 }
 
 //Two random players 
  public void RandomVsRandom(TicTacToe t)
  {
   int count = 1;
   while(t.checkWinner())
   { 
    if (count == 1)
    {
     System.out.println("Player O's turn");
     t.putMarkAuto2();
     System.out.println();
    }
    
    if (count == -1)
    {
     System.out.println("Computer Player X's turn");
     t.putMarkAuto();
     System.out.println();
    }
   count= count*-1; 
   t.printBoard(); 
   System.out.println();
  }
 }
  
 
 public void humanVsAI(TicTacToe t)
 {
  int count = 1;
  while(t.checkWinner())
  { 
   if (count == 1)
   {
    System.out.println("Player O's turn");
    System.out.println("Enter a row[0,1,2]");
    int row = scan.nextInt();
    System.out.println("Enter a column[0,1,2]");
    int column = scan.nextInt();
    t.putMark(row,column);
    System.out.println();
   }
   if (count == -1)
   {
    System.out.println("Computer Player X's turn");
    t.AiControls();
    System.out.println();

   }
   count= count*-1; 
   t.printBoard(); 
   System.out.println();
  }
 }
}

