
/**
 * Write a description of class Business_Pass here.
 *
 * @author Adham Wael
 * @version (a version number or a date)
 */
public class Business_Pass extends Pass
{
    // instance variables
    private int Id;
    private String nme;
    private int luxuryrating;
    private int loyaltypoints;
    private int numberofcredits;
    

    /**
     * Constructor for objects of class Business_Pass
     */
    public Business_Pass(int ID, String Name, int LR)
    {
        // initialise instance variables
        super(ID, Name, LR);
        this.Id = ID;
        this.nme = Name;
        this.loyaltypoints = 20;
        this.numberofcredits = 30;
    }

    
    /**
     * This method is used to use ferry for the business pass, whereas the number of credits is deducted by 3 and the loyalty points are added by 2.
     */
    public boolean useFerry(){
       if (numberofcredits < 3){
            System.out.println("Cannot ride ferry due to insufficient funds");
           return false;
       }else{
           System.out.println("Welcome Aboard the ferry");
           numberofcredits = numberofcredits - 3;
           loyaltypoints = loyaltypoints + 2;
       }return true;
   }
   
   /**
     * This method is used to convert loyalty points to credits, for every 3 loyalty points a credit is added and 3 loyalty points deducted
     */
    public void ConvertPoints(){
        int Count1 = 0;
        int Count = 0;
        while (loyaltypoints > 3){
            numberofcredits = numberofcredits + 1;
            Count =+ 1;
            Count1 =+ 3;
            loyaltypoints = loyaltypoints - 3;
       }
        if(Count > 1){
        System.out.println(Count1 + " Loyalty Points have been converted into " + Count + " Credits with the leftover of " + loyaltypoints + " loyalty points left");
       }else if(Count == 1){
       System.out.println(Count1 + " Loyalty Points have been converted into " + Count + " Credit with the leftover of " + loyaltypoints + " loyalty points left");
        }
   }
   
   
      /**
     * This method is used to return all relevant information on set pass
     */
   public String toString(){
       String s;
       s ="Pass ID: " +  Id  + '\n' + "Pass Holder Name: " +  nme  + '\n' +"Luxury Rating: " + luxuryrating  + '\n' + "Number Of Credits: " + numberofcredits + '\n' + "The number of loyalty points on the pass is :" + loyaltypoints;
       //System.out.println(s);
       return s;
   }
}
