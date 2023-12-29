import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author Adham 
 * @version (a version number or a date)
 */
public class ResortUI
{  
//These fields create a scanner object names reader and a FIRE object names fortunate
    private Scanner reader = new Scanner(System.in);
    private FIRE fortunate = new Resort("Fortunate Islands", "Egypt");
    
    //This method provides a method for every choice
    private void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllResort();}
            else if (choice == 2){listAllPasses();}
            else if (choice == 3){listOneIsland();}
            else if (choice == 4){findLocationOfPass();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){viewPass();}
            else if (choice == 8){updateCredits();}                        
            else if (choice == 9){convertPts();}
            else if (choice == 0){System.exit(0);}
            // output menu & get choice
            
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    //This method provides a user with some options and lets him/her choose an option and according to that chooses the appropriate method to call
    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all passes on all islands");
        System.out.println("3. List all passes on one island");
        System.out.println("4. Find location of pass");
        System.out.println("5. Say if pass can move by ferry");
        System.out.println("6. Move a pass by ferry");
        System.out.println("7. View pass");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");

        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }
    
    //This method returns all relevant information about a resort
     private void listAllResort()
    {
     
        System.out.println(fortunate.toString());
    }
    
    //This method prints out all passes on all islands
    private void listAllPasses()
    {
    
        System.out.println(fortunate.getAllPassesOnAllIslands());
    }
   
    //This method intakes the name of an island and invokes a method in the resort and lists all the passes on set island
      private void listOneIsland()
    {
        System.out.println("Please enter the name of the Island");
        String s = reader.nextLine();
        //System.out.println(s);
        //if(s != null){
        System.out.println(fortunate.getAllPassesOnIsland(s));
    //}else{
        //System.out.println("Please try again");
    //}
 }
       
    //This method intakes a pass ID and calls a method in resort that returns the location of the pass and if the pass does not exist it prints out no such pass
    private void findLocationOfPass()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
    
        String ww = fortunate.findPassLocation(trav);
        if(ww != null)
        {
            System.out.println(ww);
        }
        else
        {
            System.out.println("No such pass");
        }
    }
    
    //This method intakes a pass's ID and ferry code and uses the can travel method from resort to determine whether a pass can travel or not
    private void tryTravel()
    {
         System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter ferry code");
        reader.nextLine();
        String ferry = reader.nextLine();
        System.out.println(fortunate.canTravel(trav,ferry));
    }
    
    //This method intakes pass id and ferry code and if the pass passes certain conditions it invokes the travel method and changes the pass
    //location and updates credits and so on
    private void travelNow()
    {
        System.out.println("Please enter pass ID");
         int pid = reader.nextInt();
        System.out.println(pid);
        //reader.nextInt();
        System.out.println("Please enter ferry code");
        reader.nextLine();
        String fcode = reader.nextLine();
        System.out.println(fortunate.travel(pid,fcode));
    }
    
    //This method intakes a pass's ID and calls the view pass method from resort and prints out the details of set pass
    private void viewPass()
    {
         System.out.println("Enter pass ID number");
        int cId = reader.nextInt();
        System.out.println(fortunate.viewAPass(cId));
    }
     
    //This method intakes the pass id and the number of credits a person wants added and adds that number to the number of credits a pass has
    private void updateCredits()
    {
         System.out.println("Enter the pass id to be updated");
        int ccc = reader.nextInt();
        //reader.nextInt();
        System.out.println("How many credits would you like to add?");
        int cc = reader.nextInt();
        //reader.nextInt();
        fortunate.topUpCredits(ccc, cc);
    }

    // This one calls the point conversion method from resort, it intakes a pass ID number and converts the points of set pass to credits
    private void convertPts()
    {
        System.out.println("Enter pass ID number");
         int cId = reader.nextInt();
        fortunate.convertPoints(cId);
    }   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
    
}
