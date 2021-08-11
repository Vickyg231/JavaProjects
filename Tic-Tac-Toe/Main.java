import java.util.Scanner;
public class Main 
{ 
  public static void main(String[] args)
  {
   Scanner scan = new Scanner(System.in);
   TicTacToe board = new TicTacToe();
   playType play = new playType();  
   System.out.println("Which type of Tic Tac Toe would you like you like to play?");
   System.out.println("Put '1' for HumanVsHuman, put '2' for HumanVsRandomPlayer, put '3' for RandomVsRandom, and put '4' for HumanVsAI");
   int number = scan.nextInt();
   if (number == 1)
   {
    System.out.println("Welcome to HumanVsHuman Tic Tac Toe, grab a friend and let's get started");
    play.humanVsHuman(board);
    System.out.println();
   }
   
     
   if (number == 2)
   {
    System.out.println("Welcome to HumanVsRandomPlayer,are you smarter than a easy level computer");
    play.humanVsRandom(board);
    System.out.println();
   }
      
   if (number == 3)
   {
    System.out.println("Watch the battle between two random players happen");
    play.RandomVsRandom(board);
    System.out.println();
   }
   
   //It works to some degree,not fully developed
   if(number == 4)
   {
    System.out.println("Play against the AI medium mode!");
    play.humanVsAI(board);
    System.out.println();
   }


   if(board.winner()=='X')
   {
    System.out.println("Player X wins");
   }
   
   else if(board.winner()=='O')
   {
    System.out.println("Player O wins");
   }
   
   else if(board.allFilled())
   {
    System.out.println("It's a tie");
   }
  }
}
