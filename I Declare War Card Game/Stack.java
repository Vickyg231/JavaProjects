import java.util.*;

public class Stack
{
  public static Integer[] ar1nums = {5,7,5};
  public static Integer[] ar2nums = {2,8,8};
  public static Integer[] ar3nums = {3,9,5};
  public static Integer[] ar4nums = {9,8,2};
 
 public static void main(String[] args)  
 {
    /*int[] ar1nums = {5};
   ar1.add(0,5);
   ar2.add(0,3);
   ar3.add(0,7);
   ar4.add(0,4);
   ar1.add(1,8);
   ar2.add(1,4);
   ar3.add(1,5);
   ar4.add(1,7);
   */
  }


 
 //Determine if there are cards in a deck
 public static boolean emptySet(ArrayList array)
 {
   if (array.size()==0)
   {
   return true;
   }
  return false;
 }
 
 //Push the card to the top of the pile
 public static void push(ArrayList array,int number)
 {
  array.add(0,number);
 }
 
 //Looks at the first card in the pile but does not remove it or draw it 
 public static void peek(ArrayList array)
 {
  
  System.out.println(array.get(0));
 }
 
 //Takes out the card that is on the very top of the deck
 public static void pop(ArrayList array)
 {
  System.out.println(array.get(0));
  array.remove(0);
 }
  
}
