import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
public class Main extends JFrame
{
 //Figure out how to report win and lose
 //ideas loops all the way
 //Figure out if they only have nine cards or less left and can win
 private static final String[] RANKS =
 {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

 /**
	* The suits of the cards for this game to be sent to the deck.
	*/
 private static final String[] SUITS =
 {"♠", "♥", "♦", "♣"};

 /**
	* The values of the cards for this game to be sent to the deck.
	*/
 private static final int[] POINT_VALUES =
	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      
 /**
   *The game will repeat with a stop values
   */
 private static boolean stop = true;
 private static boolean stop2 = true;

 public static void main(String[] args)
  {
    /**beginningDeck is the Deck we start with.  
      *When we deal, it gets split into two 
      *Decks for each player 
      */
      
    Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
    beginningDeck.shuffle();
    //Cards created to compare the card that we got to the actual values 
    Card J = new Card("J","heart",11);
    Card Q = new Card("Q","heart",12);
    Card K = new Card("K","heart",13);

    //There are nine cards on the table using an arraylist         
    ArrayList<Card> cards = new ArrayList <Card>();
    for (int i = 0; i < 9; i++)
    {
     cards.add(beginningDeck.deal());
    }
     //The cards that are dealt out
     System.out.print(" ");
     for (int i = 0; i < 9; i++)
     System.out.print(i+"    ");
     System.out.println();
     //The cards that are dealt in a line
     for (int i = 0; i < 9; i++)
     {
      System.out.print(cards.get(i)+((i!=8)?", ":"\n"));
     }

     //check that the 9 cards are playable. 
     for(int i = 0;i<cards.size();i++)
     {
       int s = -1;
       int t = -1;
       int u = -1;
       if (cards.get(i).matched(J))
       {
        s = i;
       }
       
       if (cards.get(i).matched(Q))
       {
        t = i;
       }
       
       if (cards.get(i).matched(K))
       {
        u = i;
       }
        
       //This makes sure there is a J, Q and K in the array
       if (s!=-1&&t!=-1&&u!=-1)
       {
        stop2 = false;
       }
     }
     
     for(int i = 0;i<cards.size();i++)
     {
      for(int l = i+1;l<cards.size()-1;l++)
       {
        if(cards.get(i).pointValue()+cards.get(l).pointValue()!=11)
        {
         stop = true;
        }
        else 
        {
         stop = false;
         i = 9;
         l = 8;
        }
       }
      }

     
    if((stop2==true)&&(stop==true))
    {
     System.out.println("Sorry you lose.");
    }
    
    while((stop2==false)||(stop==false))
    {
     Scanner scan = new Scanner(System.in); 
     System.out.println("Enter 'begin' to begin the round");
     String answer2 = scan.nextLine();
     if (answer2.equals("begin"))
     {
      System.out.println("First, do you have J, Q, and K?");
      String answer = scan.nextLine();
       if (answer.equals("yes"))
       {
        System.out.println("Enter the indices of J,Q and K");
        int j= scan.nextInt();
        int q= scan.nextInt();
        int k= scan.nextInt();

        //Check that they are actually j,q,and k
        boolean check = false;
        
        if((cards.get(j)!=cards.get(q)&&cards.get(q)!=cards.get(k)&&cards.get(k)!=cards.get(j))&&(cards.get(j).pointValue()+cards.get(q).pointValue()+cards.get(k).pointValue()==36))
        {
         check = true;
        }
         if (check == true)
         {
          System.out.println("On to the next round..."); 
          cards.set(j,beginningDeck.deal());
          cards.set(q,beginningDeck.deal());
          cards.set(k,beginningDeck.deal());
          System.out.print(" ");
          for (int i = 0; i < 9; i++)
          System.out.print(i+"    ");
          System.out.println();
          
          //The cards that are dealt in a line
          for (int i = 0; i < 9; i++)
          {
           System.out.print(cards.get(i)+((i!=8)?", ":"\n"));
          }
          
          //checking if the game is playable 
          for(int i = 0;i<cards.size();i++)
          {
           int s = -1;
           int t = -1;
           int u = -1;
           if (cards.get(i).matched(J))
           {
            s = i;
           }
       
           if (cards.get(i).matched(Q))
           {
            t = i;
           }
       
           if (cards.get(i).matched(K))
           {
            u = i;
           }
        
           //This makes sure there is a J, Q and K in the array
           if (s!=-1&&t!=-1&&u!=-1)
           {
            stop2 = false;
           }
          }
     
     for(int i = 0;i<cards.size();i++)
     {
      for(int l = i+1;l<cards.size()-1;l++)
       {
        if(cards.get(i).pointValue()+cards.get(l).pointValue()!=11)
        {
         stop = true;
        }
        else 
        {
         stop = false;
         i = 9;
         l = 8;
        }
       }
      }

     
    if ((stop2==true)&&(stop==true))
    {
     System.out.println("Sorry you lose.");
    }

        }
               
       //Redeal cards if the indicies aren't J,Q,K
       else if (check==false)
       {
        System.out.println("Nope those aren't J,Q,K.");
        System.out.print(" ");
        for (int i = 0; i < 9; i++)
        System.out.print(i+"    ");
        System.out.println();
        //The cards that are dealt in a line
        for (int i = 0; i < 9; i++)
        {
         System.out.print(cards.get(i)+((i!=8)?", ":"\n"));
        }
       }
      }
      
      //Checks if the cards can add up to 11
      else if(answer.equals("no"))
      {
       System.out.print("Enter the two indices of your numbers: ");
       int a = scan.nextInt();
       int b = scan.nextInt();
       if (cards.get(a).pointValue() + cards.get(b).pointValue() == 11){
       System.out.println("Next round!");
       cards.set(a,beginningDeck.deal());
       cards.set(b,beginningDeck.deal());
       for (int i = 0; i < 9; i++)
       System.out.print(i+"    ");
       System.out.println();
       
       //The cards that are dealt in a line
       for (int i = 0; i < 9; i++)
       {
        System.out.print(cards.get(i)+((i!=8)?", ":"\n"));
       }
       
      for(int i = 0;i<cards.size();i++)
      {
       int s = -1;
       int t = -1;
       int u = -1;
       if (cards.get(i).matched(J))
       {
        s = i;
       }
       
       if (cards.get(i).matched(Q))
       {
        t = i;
       }
       
       if (cards.get(i).matched(K))
       {
        u = i;
       }
        
       //This makes sure there is a J, Q and K in the array
       if (s!=-1&&t!=-1&&u!=-1)
       {
        stop2 = false;
       }
     }
     
     for(int i = 0;i<cards.size();i++)
     {
      for(int l = i+1;l<cards.size()-1;l++)
       {
        if(cards.get(i).pointValue()+cards.get(l).pointValue()!=11)
        {
         stop = true;
        }
        else 
        {
         stop = false;
         i = 9;
         l = 8;
        }
       }
      }

     
    if ((stop2==true)&&(stop==true))
    {
     System.out.println("Sorry you lose.");
    }

      }
      
     //When the cards don't equal 11
     else if (cards.get(a).pointValue() + cards.get(b).pointValue() != 11)
     {
      System.out.println("No,try again. Those numbers don't add up to 11");
      System.out.print(" ");
      for (int i = 0; i < 9; i++)
      System.out.print(i+"    ");
      System.out.println();
      //The cards that are dealt in a line
      for (int i = 0; i < 9; i++)
      {
       System.out.print(cards.get(i)+((i!=8)?", ":"\n"));
      }
     }
    }
   }
  }
  //If there are only nine 
  if(beginningDeck.size()<=9)
  {
   ArrayList<Card> remain = new ArrayList<Card>();
   for (int i = 0;i<beginningDeck.size();i++)
   {
     remain.add(beginningDeck.deal());
   }
   System.out.print(" ");
      for (int i = 0; i < 9; i++)
      System.out.print(i+"    ");
      System.out.println();
      //The cards that are dealt in a line
      for (int i = 0; i < 9; i++)
      {
       System.out.print(remain.get(i)+((i!=8)?", ":"\n"));
      }
  while(!remain.isEmpty())
  {
     Scanner scan = new Scanner(System.in); 
     System.out.println("Enter 'begin' to begin the round");
     String answer2 = scan.nextLine();
     if (answer2.equals("begin"))
     {
      System.out.println("First, do you have J, Q, and K?");
      String answer = scan.nextLine();
       if (answer.equals("yes"))
       {
        System.out.println("Enter the indices of J,Q and K");
        int j= scan.nextInt();
        int q= scan.nextInt();
        int k= scan.nextInt();

        //Check that they are actually j,q,and k
        boolean check = false;
        
        if((remain.get(j)!=remain.get(q)&&remain.get(q)!=remain.get(k)&&remain.get(k)!=remain.get(j))&&(remain.get(j).pointValue()+remain.get(q).pointValue()+remain.get(k).pointValue()==36))
        {
         check = true;
        }
         if (check == true)
         {
          System.out.println("On to the next round..."); 
          remain.remove(j);
          remain.remove(q);
          remain.remove(k);
          System.out.print(" ");
          for (int i = 0; i < remain.size(); i++)
          System.out.print(i+"    ");
          System.out.println();
          
          //The cards that are dealt in a line
          for (int i = 0; i < remain.size(); i++)
          {
           System.out.print(remain.get(i)+((i!=remain.size()-1)?", ":"\n"));
          }
          
          //checking if the game is playable 
          for(int i = 0;i<remain.size();i++)
          {
           int s = -1;
           int t = -1;
           int u = -1;
           if (remain.get(i).matched(J))
           {
            s = i;
           }
       
           if (remain.get(i).matched(Q))
           {
            t = i;
           }
       
           if (remain.get(i).matched(K))
           {
            u = i;
           }
        
           //This makes sure there is a J, Q and K in the array
           if (s!=-1&&t!=-1&&u!=-1)
           {
            stop2 = false;
           }
          }
     
     for(int i = 0;i<remain.size();i++)
     {
      for(int l = i+1;l<remain.size()-1;l++)
       {
        if(remain.get(i).pointValue()+remain.get(l).pointValue()!=11)
        {
         stop = true;
        }
        else 
        {
         stop = false;
         i = remain.size();
         l = remain.size()-1;
        }
       }
      }

     
    if ((stop2==true)&&(stop==true))
    {
     System.out.println("Sorry you lose.");
    }

        }
               
       //Redeal cards if the indicies aren't J,Q,K
       else if (check==false)
       {
        System.out.println("Nope those aren't J,Q,K.");
        System.out.print(" ");
        for (int i = 0; i < 9; i++)
        System.out.print(i+"    ");
        System.out.println();
        //The cards that are dealt in a line
        for (int i = 0; i < remain.size(); i++)
        {
         System.out.print(remain.get(i)+((i!=remain.size()-1)?", ":"\n"));
        }
       }
      }
      
      //Checks if the cards can add up to 11
      else if(answer.equals("no"))
      {
       System.out.print("Enter the two indices of your numbers: ");
       int a = scan.nextInt();
       int b = scan.nextInt();
       if (remain.get(a).pointValue() + remain.get(b).pointValue() == 11){
       System.out.println("Next round!");
       remain.remove(a);
       remain.remove(b);       
       for (int i = 0; i < remain.size(); i++)
       System.out.print(i+"    ");
       System.out.println();
       
       //The cards that are dealt in a line
       for (int i = 0; i < remain.size(); i++)
       {
        System.out.print(remain.get(i)+((i!=remain.size()-1)?", ":"\n"));
       }
       
      for(int i = 0;i<remain.size();i++)
      {
       int s = -1;
       int t = -1;
       int u = -1;
       if (remain.get(i).matched(J))
       {
        s = i;
       }
       
       if (remain.get(i).matched(Q))
       {
        t = i;
       }
       
       if (remain.get(i).matched(K))
       {
        u = i;
       }
        
       //This makes sure there is a J, Q and K in the array
       if (s!=-1&&t!=-1&&u!=-1)
       {
        stop2 = false;
       }
     }
     
     for(int i = 0;i<remain.size();i++)
     {
      for(int l = i+1;l<remain.size()-1;l++)
       {
        if(remain.get(i).pointValue()+remain.get(l).pointValue()!=11)
        {
         stop = true;
        }
        else 
        {
         stop = false;
         i = remain.size();
         l = remain.size()-1;
        }
       }
      }

     
    if ((stop2==true)&&(stop==true))
    {
     System.out.println("Sorry you lose.");
    }

      }
      
     //When the cards don't equal 11
     else if (remain.get(a).pointValue() + remain.get(b).pointValue() != 11)
     {
      System.out.println("No,try again. Those numbers don't add up to 11");
      System.out.print(" ");
      for (int i = 0; i < remain.size(); i++)
      System.out.print(i+"    ");
      System.out.println();
      //The cards that are dealt in a line
      for (int i = 0; i < remain.size(); i++)
      {
       System.out.print(remain.get(i)+((i!=remain.size()-1)?", ":"\n"));
      }
     }
    }
   }    
  }
  if(remain.isEmpty())
  {
   System.out.println("Congrats you won!");
  }
 }
}
}
