import java.util.ArrayList;

/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * 
 * All this methods here which exists here have return methods meaning that they do
 * not require a print method however a print method is given to provide better view for tester and 
 * user
 * 
 * @author Adham Wael 
 * @version (a version number or a date)
 */
public class Ferry
{
    //fields
    public String ferryCode;
    public Island destination;
    public Island source;
    private ArrayList<Pass> FerrypassList;
    
    
    //constructor
    public Ferry(String Fcode, Island Source, Island Destination ){
        this.ferryCode = Fcode;
        this.destination = Destination;
        this.source = Source;
        
        FerrypassList = new ArrayList<Pass>();
    }
    
    //This method returns the ferry code
    public String getFCode(){
        return ferryCode;
    }
    
    //This method returns the source island
    public Island getSource(){
        return source;
    }
    
    //This method returns the destination island
    public Island getDestination(){
        return destination;
    }
    
    
    //This method intakes a pass and returns and outputs whether a pass is valid
    //to use a ferry or not
    public boolean isValid(Pass p){
        if(p.useFerry() == true ){
            //System.out.println("Pass has enough credits");
            return true;
        }
        //System.out.println("Pass has insufficient credits");
        return false;
    }
    
    //This method checks the return of the isValid method and accordingly determines
    //whether a pass's travel is completed or not, and if completed removes pass from
    //source island, adds pass to destination island, deducts credit, adds journey points
    //and adds list into the list of passes on set ferry
    public String travel(Pass p, Island s, Island d){
        String f = " ";
        if (isValid(p) == true){
            s.leave(p);
            d.enter(p);
            p.DeductCredits(3);
            p.addPoints(1);
            FerrypassList.add(p);
            f = "Travel completed, credit deducted, and journey point(s) added";
            //System.out.println(f);
        }else{
            f = "Travel incomplete";
            //System.out.println(f);
        }return f;
    }
    
    //This method returns and prints all the details of set ferry and the passes
    //aboard set ferry.
    public String toString(){
        String d = " ";
        d = "This ferry code is: " + ferryCode + '\n' + "This ferry leaves from: " + source + '\n' + "This ferry arrives at: " + destination +
         "This ferry contains these passes: " + FerrypassList;
         //System.out.println(d);
        return d;
        }
}
