
/**
 * A Pass has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author Adham Wael 
 * @version (a version number or a date)
 */
public class Pass 
{
    //fields
   public int passId;
   public String PassHolderName;
   public int LuxuryRating;
   private int NumberOfCredits;
   private int JourneyPoints;
   private int maxCredits;
   
   //constructor with default values for number of credits and journey points
    public Pass (int ID, String Name, int LR){
        
        this.passId = ID;
        this.PassHolderName = Name;
        this.LuxuryRating = LR;
        this.NumberOfCredits = 10;
        this.JourneyPoints = 0;
        this.maxCredits = 150;
        
    }
    
   
   //this method just returns the pass ID
   public int getPassID(){
       return passId;
   }
   
   //This method just returns the pass holder's name
   public String getPassName(){
       return PassHolderName;
   }
   
   //This method just returns the luxury rating of set pass
   public int getLuxuryRating(){
       return LuxuryRating;
   }
   
   //This method just returns the number of credits on set pass
   public int getNoC(){
       return NumberOfCredits;
   }
   
   //This method just returns the maximum amount of credits
   public int getMaxCredits(){
       return maxCredits;
   }
   
   //This method below just checks the luxury rating of the pass and that is in order to check whether a pass is fake or not
   public void CheckPassLR(int LR){
       if (LR != 0 && LR <= 10){
       System.out.println(LuxuryRating);
    }else{
        System.out.println("Pass Luxury Rating is not within appropriate range" + '\n' + "This pass might be fake");
    }
    }
    
    //This method below maxes out the number of credits
    public void TopUpCredit(){
        NumberOfCredits = maxCredits;
    }
    
    //This method below adds credit by a certain number
   public void addCredits(int a){
       NumberOfCredits = NumberOfCredits + a;
   }
    
   //This method below deducts credit by a certain number
   public void DeductCredits(int s){
       NumberOfCredits = NumberOfCredits - s;
   }
   
   //this method is used to deduct journey points
   public void DeductPoints(int f){
       JourneyPoints = JourneyPoints - f;
   }
   
   //This method is used to add journey points
   public void addPoints(int f){
       JourneyPoints = JourneyPoints + f;
   }
   //This method below checks if the pass at hand contains more than 3 credits and if so permits user to board ferry whilst subtracting the number of credits
   //by 3. If user does not have enough credits, the console would tell the user so.
   public boolean useFerry(){
       if (NumberOfCredits < 3){
           //System.out.println("Cannot ride ferry due to insufficient funds");
           return false;
       }else{
           //System.out.println("Welcome Aboard the ferry");
           NumberOfCredits = NumberOfCredits - 3;
           JourneyPoints = JourneyPoints + 1;
       }return true;
   }
   
   //This method below creates two integer variables with an initial value of 0, then checks if the journey points of set pass are above 5, and while they are
   //the number of credits goes up by 1, the journey points are subtracted by 5, and the count variables are either incremented by 1 or by 5, this is done in order
   //to provide the user with a result of how many journey points were converted to how many credits.
   public void ConvertPoints(){
        int Count1 = 0;
        int Count = 0;
        while (JourneyPoints > 5){
            NumberOfCredits = NumberOfCredits + 1;
            Count =+ 1;
            Count1 =+ 5;
            JourneyPoints = JourneyPoints - 5;
        }
        if(Count > 1){
        System.out.println(Count1 + " Journey Points have been converted into " + Count + " Credits with the leftover of " + JourneyPoints + " Journey Points left");
       }else if(Count == 1){
       System.out.println(Count1 + " Journey Points have been converted into " + Count + " Credit with the leftover of " + JourneyPoints + " Journey Points left");
        }else{
            System.out.println(Count1 + " Journey Points have been converted into " + Count + " Credit with the leftover of " + JourneyPoints + " Journey Points left");
        }
   }
   
   //This method below provides and prints a string which contains all information regarding set pass, each record in its own line due to the \n.
   public String toString(){
       String s;
       s ="Pass ID: " +  passId  + '\n' + "Pass Holder Name: " +  PassHolderName  + '\n' +"Luxury Rating: " + LuxuryRating  + '\n' + "Number Of Credits: " + NumberOfCredits + '\n' +"Journey Points: " + JourneyPoints;
       //System.out.println(s);
       return s;
   }
   
   // This method below prints out the number of credits on set pass
      public void CheckCredits(){
       System.out.println(NumberOfCredits);
    }
    }
  




