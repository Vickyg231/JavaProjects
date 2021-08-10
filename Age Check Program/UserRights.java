//Project Runner 
import java.util.Scanner;
public class UserRights 
{
 public static double sum(double wine, double car)
 {
 double wineTotal = wine;
 double carTotal = car;
 double total = wineTotal+carTotal;
 return total;
 } 
 public static void main(String[] args)
 {
  Boolean drinkAnswer = false;
  Boolean driveAnswer = false;
 
 //get name
  Scanner scan = new Scanner(System.in);
  System.out.println("Welcome,please enter your name");
  String name = scan.nextLine();
  userInformation p1 = new userInformation(name);
  p1.setName("" + name);
  
  //greeting about their nickname preference
  System.out.println("Hi " + name + ", do you like to be called by a nickname? \n Please enter true for yes and false for no");
  String answer = scan.nextLine();
  Boolean answers = Boolean.parseBoolean(answer);
  Boolean yes = true;
  
  Boolean no = false;
   if (yes.equals(answers))
   {
    System.out.println("What is your preferred nickname?");
    p1.nickname = scan.nextLine();
    System.out.println(p1.toString());
   }
   
  // get date to verify age
  System.out.println("Please enter today's day in the format date(2 digits), month(2 digits), year(all four digits)\n no spaces either please");
  System.out.println (" You do not have to put dividers between the number \n Make sure to not go over this number: " + Integer.MAX_VALUE);
  int todayDate = scan.nextInt();
  int todayDay = todayDate/1000000;
  int todayMonth = (todayDate%1000000)/10000;
  int todayYear = todayDate%10000;

  // get birthday to comfirm age   
  System.out.println("Please enter your birth day(2 digits), month(2 digits) and year(all four digits), \n you don't have to worry about putting slashes inbetween them.\n no spaces either please");
  Integer birthDay = scan.nextInt(); 
  p1.setBirthDate(birthDay/1000000);
  p1.setBirthMonth((birthDay%1000000)/10000);
  p1.setBirthYear(birthDay%10000);
  p1.printUserInfo(); 
  
  //Calculating if they can learn how to drive 
  if (p1.getBirthMonth()==todayMonth)
  {
   if (p1.getBirthDate()<=todayDate)
   {
    if(Math.abs(p1.getBirthYear()-todayYear)>=p1.driverLicense)
    {
     driveAnswer = true;
    }
   }
  }
   else if (p1.getBirthMonth()<todayMonth)
   {
    if (Math.abs(p1.getBirthYear()-todayYear)>=p1.driverLicense)
    {
     driveAnswer = true;
    }
   }
    else if (p1.getBirthMonth()>todayMonth)
    {
     if (Math.abs(p1.getBirthYear()-todayYear)>=17)
      {
       driveAnswer = true;
      }
     }
 else 
    { 
     driveAnswer = false;
    }
    
  //calculating if they can have alcohol    
  if (p1.getBirthMonth()==todayMonth)
  {
   if (p1.getBirthDate()<=todayDate)
   {
    if ((Math.abs(p1.getBirthYear()-todayYear))>=p1.drinksAllowed)
     {
      drinkAnswer = true;
     }
   }
  }
   else if (p1.getBirthMonth()<todayMonth)
   {
    if (Math.abs(p1.getBirthYear()-todayYear)>=p1.drinksAllowed)
    {
     drinkAnswer = true;
    }
   }
   else if (p1.getBirthMonth()>todayMonth)
    {
     if (Math.abs(p1.getBirthYear()-todayYear)>=22)
      {
       drinkAnswer = true;
      }
     }
    else 
    {
     drinkAnswer = false ;
    }  
   
   //Some questionaries if they are of age to drink 
  if ((drinkAnswer == true)&&(driveAnswer = true))
   {
   System.out.println("Hey, I see that you are allow to drink, fair reminder drinking is not the best though.");
   System.out.println("What do you think the price of a bottle of wine would be?");
   Double wineTotal = scan.nextDouble();
   System.out.println("How much do you think buying a car cost?");
   Double carTotal = scan.nextDouble();
   Double total = sum(wineTotal,carTotal);
   double totalPrice = (int)(total+0.5);
   String costQuality = ("The price of wine and a car is ");
   System.out.println(costQuality + totalPrice+". \n See since you have to pay for cars,it is bad to drink and drive. \n Save that money for car insurance instead.");
   } 
   
   // questionarie if they are only old enough to drive   
  else if (driveAnswer == true)
  {
   System.out.println("Since you are 16 or above, you are allow to learn how to drive. Congrats!");
   System.out.println("How much do you think buying a car cost?");
   Double carTotal = scan.nextDouble();
   Double total = sum(0,carTotal);
   double totalPrice = (int)(total+0.5);
   String carCost = ("The price of a car is ");
   System.out.println(carCost + totalPrice+". \n See since you have to pay for cars in the future,remember to save your money!");
   } 
   
   //activity since they can't do either yet  
  else 
  {
   System.out.println("Sorry you aren't old enough to drive or drink but here's a fun activity for you.");
   System.out.println("I don't know if you are interested in some math computer tricks but here you go.");
   System.out.println("Enter a number");
   Double number = scan.nextDouble();
   System.out.println("Enter a power for the number to be raised to");
   Double power = scan.nextDouble();
   System.out.print("Your number is: " +number+" and the power it is raise to is: " + power);
   Integer solution = (int)Math.pow(number,power);
   System.out.println(" Your answer is: " + solution);
   System.out.println("Enter the biggest number you can think of and I will pick a random number from 0-your number");
   Double random = scan.nextDouble();
   Integer randomS = (int)(Math.random()*random);
   System.out.println("The chosen random number is: " + randomS);
   System.out.println("Enter a number and I will find the square root of that number for you as the last activity");
   Double square = scan.nextDouble();
   Integer done = (int)(Math.sqrt(square));
   System.out.println("The approximate square root of the number is:" + done);
   System.out.println("I hoped you had fun!");
  }
 }
}
 
