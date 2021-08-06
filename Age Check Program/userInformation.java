public class userInformation
{
 private String name;
 public String nickname;
 private int birthDate;
 private int birthMonth;
 private int birthYear;
 public final int driverLicense = 16;
 public final int drinksAllowed=21;
 
 public userInformation()
 {
 name = null;
 birthDate = 0;
 birthMonth = 0;
 birthYear = 0;
 }
 
 public userInformation(String preferredName)
 {
  nickname = preferredName;
 }
 
 public String getNickName()
 {
  return nickname;
 }
 
  public void setName (String newName)
  {
   name = newName;
  }
 public void setBirthDate (Integer newBirthDate)
  {
   birthDate = newBirthDate;
  }
   public void setBirthMonth (Integer newBirthMonth)
  {
   birthMonth = newBirthMonth;
  }
 public void setBirthYear (Integer newBirthYear)
  {
   birthYear = newBirthYear;
  }
 public int getBirthMonth()
 {
  return birthMonth;
 }
 
 public int getBirthYear()
 {
 return birthYear;
 }
 
 public int getBirthDate()
 {
 return birthDate;
 }
  
   public void printUserInfo() 
  {
   System.out.println ("Your legal name is " + name+". You are born on " + birthDate + "/" + birthMonth + "/" + birthYear);
 
  }
  
  public String toString()
  {
   return ("Your nickname is: " + nickname);
  }
  
}
