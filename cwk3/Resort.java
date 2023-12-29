    import java.util.*;
import java.util.Arrays;

/**This class implements the FIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/22
 **/
public class Resort implements FIRE   // do not change this header
{

    private String location;
    private ArrayList<Pass> AllPasses = new ArrayList<Pass>();
    private ArrayList<Island> IslandList = new ArrayList<Island>();
    private ArrayList<Ferry> FerryList = new ArrayList<Ferry>();;
    private String ResortName;
    
    
    // Other fields (including collections)

    /** constructor
     * Some code has been provided 
     */
    public Resort(String RName, String loc) 
    {
        ResortName = RName;
        location = loc;
        loadIslandsAndFerries();
        loadPasses();
        
        
        // Ensure all passes are added to Base Island
        
        
        addPasstoIsland(1000, 0);
        addPasstoIsland(1001, 0);
        addPasstoIsland(1002, 0);
        addPasstoIsland(1003, 0);
        addPasstoIsland(1004, 0);
        addPasstoIsland(1005, 0);
        addPasstoIsland(1006, 0);
        addPasstoIsland(1007, 1);
        addPasstoIsland(1008, 3);
        addPasstoIsland(1, 0);
        addPasstoIsland(2, 0);
        addPasstoIsland(3, 0); 
        // you may do this here or in one of the above method
    }
    
    //This method returns the array list all passes size
    private int getNoOfPasses(){
        return AllPasses.size();
    }
    
    //This method returns the array list all Island's size
    private int getNoOfIslands(){
        return IslandList.size();
    }
    
    //This method returns the array list all Ferries size
    private int getNoOfFerries(){
        return FerryList.size();
    }
     
    
    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString()
    {
        String s = "The location of the resort is: " + location + '\n' + "The name of the resort is: " + ResortName + '\n' + "The islands on this resort are: " +
        ListAllIslands() + '\n' + "The Islands and their passes are: " + getAllPassesOnAllIslands();
        
        return s;
    }

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands()
    {
        String ss = "";
        for (Island I : IslandList){
            if(I.passList.size() != 0){
        for(int x = 0; x <= IslandList.size()-1 ; x++){
              
            
        }     ss = ss +"The passes on the " + I.getIslandName() +" Island are: " + '\n' + getAllPassesOnIsland(I.getIslandName()) + '\n' + '\n';//+I.ListAllPasses() + '\n' + '\n';
    }  
}
        
        return ss;
}
    
    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd -the id of the pass
     * @return the name of the Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd)
    {
        Pass p = getPass(cd);
        
        if (p != null){
            
        
        for (Island I : IslandList){
            
            if(I.IsOnIsland(cd)){
            
            
                    System.out.println("This pass exists on the " + I.getIslandName() + " Island");
                    return "Pass found";
                   
                }
            }
         
    }
        return "Not found";
    }
    
    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd)
    {
        for (Pass p : AllPasses){
            
            if (p.getPassID() == cd){
                
                return p.toString();
            }
            
        }
       
        return "Not found";
    }
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        for (Island I : IslandList){
            if (I.getIslandName() == isl){
                
                return I.getIslandID();
            }
        }

        return -1;
    }
                
    /**Returns a String representation of all passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl)
    {
        
        String s = "The passes on the island are:  " + '\n';
        Island i = getIsland(isl);
        for (Island I : IslandList){
            
            if(i != null && I.getIslandName() == i.getIslandName()){
                System.out.println("Hi");
                 for(int x = 0; x < I.passList.size(); x++){
                    Pass p = I.passList.get(x);
                    s = s + p.toString();
                    if(I.passList.size() == 0){
                s = "Island is empty";
            }
                }
                
            }
            
        }return s;
    

   }
 
     /**Returns true if a Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the pass >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island 
     * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {   
        Pass p =getPass(cdId);
        
        Ferry f = getFerry(ferCode);
        
        for(Pass pp : AllPasses){
            
            if(p != null && pp.getPassID() == p.getPassID() ){
                
            p = pp;
            
            for(Ferry ff : FerryList){
                
                if(f.getFCode() != null && ff.getFCode() == f.getFCode()){
                    
                    f = ff;
                    Island s = f.getSource();
                    Island d = f.getDestination();
  
                if(p.getLuxuryRating() >= d.getLR() && p.useFerry() == true && s.IsOnIsland(p.getPassID()) == true && d.Maxedout() != true){
                    System.out.println("Can Travel");
                    return true;
                }
                
            }
                }
        }
            }
            System.out.println("Cant travel");
        return false;

    }     

    /**Returns the result of a pass requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the pass  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. Pass 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPassId, String ferCode)
    {   //other checks optional
        
        String string = "";
        Pass p = getPass(pPassId);
        Ferry f = getFerry(ferCode);
        
        string = "Travel incomplete, nothing has changed";
        for(Pass pp : AllPasses){   
            //System.out.println(pp);
            if(p != null && pp.getPassID() == p.getPassID() ){
                p = pp;
                for(Ferry ff : FerryList){
                    
                    if(f.getFCode() != null && ff.getFCode() == f.getFCode()){
                        f = ff;
                        Island s = f.getSource();
                        Island d = f.getDestination();   
                        if(p.getLuxuryRating() >= d.getLR()  && p.useFerry() == true && s.IsOnIsland(p.getPassID()) == true  && d.Maxedout() != true){
                        s.leave(p);
                        d.enter(p);
                        p.DeductCredits(3);
                        p.addPoints(1);
                        string = "Travel completed. Credits and journey points updated.";
                        
                    }
                    }
                }
        }
    }
    //System.out.println(string);
    return string;
}

         
    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds)
    {
        for (Pass p : AllPasses){
            if (p.getPassID() == id && creds <= p.getMaxCredits()){
                p.addCredits(creds);
                System.out.println("Credits added");
            }
        }
        
    }
    
    /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id)  
    {
        for( Pass p : AllPasses){
            if(p.getPassID() == id){
                p.ConvertPoints();
            }//else{
             //   System.out.println("Recheck the pass id that has been entered");
            //}
        }
        
    } 

    //***************private methods**************
    private void loadPasses()
    {
        Pass a = new Pass(1000, "Lynn", 5);
        
        Pass b = new Pass (1001, "May", 3);
        b.addCredits(20);
        Pass c = new Pass (1002, "Nils", 10);
        c.DeductCredits(10);
        Pass d = new Pass (1003, "Olek", 1);
        d.addCredits(2);
        Pass e = new Pass (1004, "Pan", 3);
        e.DeductCredits(7);
        Pass f = new Pass (1005, "Quin", 1);
        f.addCredits(20);
        Pass g = new Pass (1006, "Raj", 4);
        g.DeductCredits(5);
        Pass h = new Pass (1007, "Sol", 7);
        h.addCredits(10);
        Pass i = new Pass (1008, "Tel", 6);
        i.addCredits(20);
        
        Tourist_Pass j = new Tourist_Pass(1, "Adham", 5, 10, "Egyptian");
        Business_Pass k = new Business_Pass(2, "Adham2", 7);
        Employee_Pass l = new Employee_Pass(3, 0001, "Adham3", "Guy");
        
        AllPasses.add(a);
        AllPasses.add(b);
        AllPasses.add(c);
        AllPasses.add(d);
        AllPasses.add(e);
        AllPasses.add(f);
        AllPasses.add(g);
        AllPasses.add(h);
        AllPasses.add(i);
        AllPasses.add(j);
        AllPasses.add(k);
        AllPasses.add(l);
    }
    
    private void loadIslandsAndFerries()
    {
        
        Island aa = new Island(0, "Base", 0, 100);
        Island bb = new Island(1, "Yorkie", 1, 100);
        Island cc = new Island(2, "Bounty", 3, 10);
        Island dd = new Island(3, "Twirl", 5, 2);
        Island ee = new Island(4, "Aero", 1, 1);
        IslandList.add(aa);
        IslandList.add(bb);
        IslandList.add(cc);
        IslandList.add(dd);
        IslandList.add(ee);
        
        
        Ferry aaa = new Ferry("ABC1", aa, bb);
        Ferry bbb = new Ferry("BCD2", bb, aa);
        Ferry ccc = new Ferry("CDE3", bb, cc);
        Ferry ddd = new Ferry("DEF4", cc, bb);
        Ferry eee = new Ferry("JKL8", cc, dd);
        Ferry fff = new Ferry("EFG5", dd, bb);
        Ferry ggg = new Ferry("GHJ6", bb, ee);
        Ferry hhh = new Ferry("HJK7", ee, bb);
        FerryList.add(aaa);
        FerryList.add(bbb);
        FerryList.add(ccc);
        FerryList.add(ddd);
        FerryList.add(eee);
        FerryList.add(fff);
        FerryList.add(ggg);
        FerryList.add(hhh);
        
    }
    
  
    /** Returns the pass with the pass id specified by the parameter
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id)
    {
        for (Pass p : AllPasses){
            if(p.getPassID() == id){
                return p;
            }
        }
  
        return null;
    }
    
    private Island getisland(int INo){
        for (Island I : IslandList){
            if (I.getIslandID() == INo){
                return I;
            }
        }
        return null;
    }
    
    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
               for (Island I : IslandList){
            
            String II = I.getIslandName();
            
            if(II.equalsIgnoreCase(islandName)){
                
                return I;
            }
        } 
        return null;
    }
    
    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    public Ferry getFerry(String fer)
    {

        for (Ferry f : FerryList){
            
            String ff = f.getFCode();
            
            if(ff.equalsIgnoreCase(fer)){
                
                return f;
            }
        } 
        return null;
    }
    
    private String ListAllIslands(){
         String LAP = "";
        for(int i = 0; i < IslandList.size(); i++){
            Island I = IslandList.get(i);
            LAP = LAP + I.toString();
    }return LAP;
 }

 
 private void addPasstoIsland(int pNo, int INo){
     Pass p = getPass(pNo);
     Island I = getisland(INo);
     
     if ( p == null || I == null){
     }else{
         I.enter(p);
     }
    }
    
}
