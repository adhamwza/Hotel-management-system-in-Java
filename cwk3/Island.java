import java.util.*;
/**
 * An island is part of a FIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can be on the  
 * island at any one time. Each island must maintain a list of all people (passes)
 * currently on the island. These lists are updated whenever passes enter or leave 
 * an island,so that it is always possible to say which passes are on the island 
 * 
 * 
 * All this methods here which exists here have return methods meaning that they do
 * not require a print method however a print method is given to provide better view for tester and 
 * user
 * 
 * @author Adham Wael 
 * @version (a version number or a date)
 */

public class Island 
{
    //fields
    private int IslandID;
    private String IslandName;
    private static int LuxuryRating;
    private int Capacity;
    public String LAP = " ";
    
    public ArrayList<Pass> passList;
    
    //Constructor
    public Island(int ID, String Name, int LR, int C){
        this.IslandID = ID;
        this.IslandName = Name;
        this.LuxuryRating = LR;
        this.Capacity = C;
        this.passList = new ArrayList<Pass>();
    }
    
    //This method just returns the Island ID
    public int getIslandID(){
        return IslandID;
    }
    
    //This method just returns the Island Name
    public String getIslandName(){
        return IslandName;
    }
    
    //This method just returns the luxury rating of set island
    public static int getLR(){
        return LuxuryRating;
    }
    
    //This method returns the maximum capacity of set island
    public int getMax(){
        return Capacity;
    }
    
    
    //This method adds a pass to the pass list array list while providing the user with a message to confirm the addition of pass
    public void enter(Pass p){
        passList.add(p);
        //System.out.println("Pass has been added");
    }
    
    //This method checks if the return value of the findpass method is not null and if so removes the pass from the array list
    //while providing the user with a confirmation of the removal of set pass
    public void leave(Pass p){
        Pass pass = findPass(p.getPassID());
        if (pass != null){
            passList.remove(pass);
        //System.out.println("Pass removed");
        }
    }
    
    //This method checks the array list looking for a certain pass. If found it returns the pass and prints out its information. If not found returns null
    public Pass findPass (int p){
        for(int a = 0; a < passList.size(); a++){
            Pass ps = passList.get(a);

            if (ps.getPassID() == p){
               //System.out.println("This pass ID: " + ps.getPassID() +  '\n' +"This pass's holder's name: " + ps.getPassName() +  '\n' +"This pass's Luxury Rating: " + ps.getLuxuryRating() +  '\n' +"The number of credits on this pass is: " + ps.getNoC());
                return ps;
            }
        }
            //System.out.println("This pass: " + p + " does not exist on this island");
            return null;
        }
    
    //This method uses the empty string created above (or alternatively can be created here) and increments with the pass list and adds each pass with
    //its information to set empty string until done
    public String ListAllPasses(){
       // String LAP = "";
        for(int i = 0; i < passList.size(); i++){
            Pass p = passList.get(i);
            LAP = LAP + p.toString();
            
    }return LAP;
    //System.out.println(LAP);
 }
 
     //This method checks whether the island is full or not while providing the user with a message to inform whether an island is full or not
    public boolean Maxedout(){
        if (passList.size() >= Capacity){
            //System.out.println ("Island full");
        return true;
    }
    else{
        //System.out.println("Island not full");
        return false;
    }
    }
    
    //This method checks whether a pass exists on the island or not using the finspass method. If found it returns and prints the information of the pass while declaring
    //first that the pass exists on set island. If not found it only declares that the pass does not exist on set island
    public boolean IsOnIsland(int l){
        
        for (int x = 0; x < passList.size(); x++){
            Pass p = passList.get(x);
            if (p.getPassID() == l){
                
                //System.out.println("This pass: " +p.getPassID() + " exists on this island: " + getIslandName());
                return true;
                
            }
            
        }return false;
       
        }
    

    //This method just returns and prints all information regarding set island
    public String toString(){
        String string;
        string = ( '\n' +" This Island's ID: " + IslandID + '\n' + "This Island's name: " + IslandName + '\n' + "This Island's luxury rating: " + LuxuryRating + '\n' + "This Island's capacity" + Capacity
        + '\n' + " This island contains all these passes: " + '\n' + LAP);
        //System.out.println(string);
     return string;
    }
    
     }
     
    




    
