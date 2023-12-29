
/**
 * Write a description of class Tourist_Pass here.
 *
 * @author Adham Wael
 * @version (a version number or a date)
 */
public class Tourist_Pass extends Pass
{
    // instance variables
    private int Id;
    private String name;
    private int luxuryrating;
    private int NumberOfCredits;
    private String citizenship;
    private int JourneyPoints;

    /**
     * Constructor for objects of class Tourist_Pass
     */
    public Tourist_Pass(int ID, String Name, int LR, int NoC, String cs){
        super(ID, Name, LR);
       // super(ID, Name, LR);
       // super.passId = Id;//(ID, Name, LR);
       //super.PassHolderName = name;
       // super.LuxuryRating = luxuryrating;
        this.Id = ID;
        this.name = Name;
        this.luxuryrating = LR;
        this.NumberOfCredits = NoC;
        this.citizenship = cs;
        this.JourneyPoints = 0;
        
        // initialise instance variables
        
    }

     public void ConvertPoints(){
        super.ConvertPoints();
      }
    
    /**
     * This method is used to use ferry for the tourist pass, whereas the number of credits is deducted by 4 not 3.
     */
     public boolean useFerry(){
       if (NumberOfCredits < 4){
           System.out.println("Cannot ride ferry due to insufficient funds");
           return false;
       }else{
           System.out.println("Welcome Aboard the ferry");
           NumberOfCredits = NumberOfCredits - 4;
           JourneyPoints = JourneyPoints + 1;
       }return true;
   }
   
   
   /**
     * This method is used to use ferry for the tourist pass, whereas it returns a string with all the relevant information of set pass
     */
   public String toString(){
       String s;
       s ="Pass ID: " +  Id  + '\n' + "Pass Holder Name: " +  name  + '\n' +"Luxury Rating: " + luxuryrating  + '\n' + "Number Of Credits: " + NumberOfCredits + '\n' +"Journey Points: " + JourneyPoints + '\n' + "The citizenship of the pass holder is: " + citizenship;
       //System.out.println(s);
       return s;
   }
}
