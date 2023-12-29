/**
 * Write a description of class Employee_Pass here.
 *
 * @author Adham Wael
 * @version (a version number or a date)
 */
public class Employee_Pass extends Pass

{
    // instance variables
    private int Id;
    private String nme;
    private int luxuryrating;
    private int journeyscore;
    private int numberofcredits;
    private String jobtype;
    private int employeenumber;
    /**
     * Constructor for objects of class Employee_Pass
     */
    public Employee_Pass(int ID, int empno, String Name, String job)
    {
        // initialise instance variables
        super(ID, Name, 10);
        this.Id = ID;
        this.nme = Name;
        this.journeyscore = 0;
        this.luxuryrating = 10;
        this.numberofcredits = 0;
        this.jobtype = job;
        this.employeenumber = empno;
        
    }

    
    public void ConvertPoints(){
        super.ConvertPoints();
      }


        /**
     * This method is used to use ferry for the employee pass, whereas the number of credits is deducted by 0 and the journey score are added by 1.
     */
     public boolean useFerry(){
       if (numberofcredits >= 0){
           System.out.println("Cannot ride ferry due to insufficient funds");
           return false;
       }else{
           System.out.println("Welcome Aboard the ferry");
           numberofcredits = numberofcredits - 0;
           journeyscore = journeyscore + 1;
       }return true;
    }
   
   
         /**
     * This method is used to return all relevant information on set pass
     */
    public String toString(){
       String s;
       s ="Employee Pass ID: " +  Id  + '\n' + "The Employee number is: " + employeenumber + '\n' + "Pass Holder Name: " +  nme  + '\n' +"Luxury Rating: " + luxuryrating  + '\n' + "Number Of Credits: " + numberofcredits + '\n' +"Journey Score: " + journeyscore + '\n' + "This employee's job is: " + jobtype;
       //System.out.println(s);
       return s;
    }
 }
