import java.util.*;
import java.util.Scanner;
/** Created by Vicky Guo
    Sahar Maisha
    Josh Lim
   */
public class Main
{
 private static ArrayList<Card> deck;
 private static int size;
 private static int count = 26;
 private static int count2 = 26;
 private static boolean stop = false;
 
  //this is the ranks of the cards
  private static final String[] ranks = {"ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
  
  //these are all the suits of the cards
  private static final String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
  
  //The values of the card
  private static final int[] pointValue = {1,2,3,4,5,6,7,8,9,10,11,12,13}; 
  
   public DeckP2()
  {
   deck = new ArrayList<>();
   size = 0;
  } 

  public DeckP2(String[] ranks,String[] suits,int[] values)
  {
   deck = new ArrayList<>();
   size = 0;
    for (int i = 0;i<ranks.length;i++)
    {
     for(String suitString:suits)
     {
      deck.add(new Card(ranks[i],suitString,values[i]));
      size++;
     }
    }
    shuffle();
  }
    
   /**It shuffles the cards
      and put them into random order
     */ 
   public void shuffle()
  {
   ArrayList<Card> Shuffled = new ArrayList<Card>();
   for (int i = 0;i<size;i++)
   {
    int j = (int)(Math.random()*deck.size()-1);
    Shuffled.add(deck.remove(j));
   }
   deck = Shuffled;
   size = deck.size();
  }
  /**This would deal the cards out of the deck
  */
  public Card deal()
  { 
   if (size!=0)
   {
    size--;
   return deck.remove(deck.size()-1); 
   }
   else
   {
    return null;
    }
  }
  
   public String toString()
   {
   String rtn = "";
   for (int k = deck.size()-1;k>=0;k--)
   {
    rtn = rtn + deck.get(k);
    if (k!=0)
    {
     rtn = rtn + ", \n";
    }
   }
   return rtn;
  }
  /**This adds the cards into the deck of either the player or the computer
     it just depends on who wins
    */
  public void add(Card card)
  {
   size++;
   deck.add(0,card);
  }
      
  public static void main(String[] args)
  {
   DeckP2 players = new DeckP2();
   DeckP2 computer = new DeckP2();
   DeckP2 D1 = new DeckP2(ranks,suits,pointValue);
   D1.shuffle();
   for(int i = 51;i>=26;i--)
   {
    players.add(D1.deal());
    computer.add(D1.deal());
   } 
 
   //This is where the game begins officially
   Scanner scan = new Scanner(System.in);
   while(stop == false)
   {
   System.out.println("Type in enter to begin a round");
   String answer = scan.nextLine();
   if(answer.equals("Enter")|| answer.equals("enter"))
   {
     if(count<=0)
     {
      stop = true;
      System.out.println("you lose");
     }  
     
     if(count2<=0)
     {
      stop = true;
      System.out.println("you win");
     }
     
    /**The stop is either true or false 
       if it is true, it will stop the program
       or if it is false, it will continuously run
      */
      
    Card one = players.deal();
    Card two = computer.deal();
    System.out.println("You drew a "+ one);
    System.out.println("The computer drew "+ two);
    if(one.getPointValue()>two.getPointValue())
    {
     System.out.println("you get the cards");
     players.add(one);
     players.add(two);
     count = count+2;
     count2 = count2-2;
     players.shuffle();
    }
    if(one.getPointValue()<two.getPointValue())
    {
     System.out.println("computer get the cards");
     computer.add(one);
     computer.add(two);
     count2 = count2+2;
     count = count-2;
     computer.shuffle();
    }
    if(one.getPointValue()==two.getPointValue())
    {
     System.out.println("Game of War");
      if(count<=4)
      {
       stop = true;
       System.out.println("computer wins");
       break;
      }
      if(count2<=4)
      {
       stop = true;
       System.out.println("you win");
       break;
      }
      Card three = players.deal();
      Card four = computer.deal();
      Card five = players.deal();
      Card six = computer.deal();
      Card seven = players.deal();
      Card eight = computer.deal();
      Card war1 = players.deal();
      Card war2 = computer.deal();
      System.out.println(war1);
      System.out.println(war2);
     if(war1.getPointValue()>war2.getPointValue())
     {
      System.out.println("you get all the cards");
      players.add(three);
      players.add(four);
      players.add(five);
      players.add(six);
      players.add(seven);
      players.add(eight);
      players.add(war1);
      players.add(war2);
      count = count+8;
      count2 = count2-8;
      players.shuffle();
     }
     if(war1.getPointValue()<war2.getPointValue())
     {
      System.out.println("computer get all the cards");
      computer.add(three);
      computer.add(four);
      computer.add(five);
      computer.add(six);
      computer.add(seven);
      computer.add(eight);
      computer.add(war1);
      computer.add(war2);
      count2 = count2+8;
      count = count-8;
      computer.shuffle();
     }   
    }
   } 
   } 
  }   
}
 
