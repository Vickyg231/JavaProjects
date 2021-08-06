/** Created by Vicky Guo
    Sahar Maisha
    Josh Lim
   */
public class Card extends Object
{
 private int pointValue;
 private String rank;
 private String suit;
 
 public Card(String cardRank,String cardSuit,int cardPointValue)
 {
  rank = cardRank;
  suit = cardSuit;
  pointValue = cardPointValue;
 }
 
 public String suit()
 {
  return suit;
 }
 
 public String rank()
 {
  return rank;
 }
 
 public int pointValue()
 {
  return pointValue;
 }
 
 public int getPointValue()
 {
  return pointValue;
 }
 
 public String toString()
 {
  return rank +" of " + suit+" pointValue = "+ pointValue;
 }
 
 public static void main(String[] args)
 {
  Card a = new Card ("Ace","hearts",1);
  System.out.println(a);
  System.out.print(a.getPointValue());
 }
}
