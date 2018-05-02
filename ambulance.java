package EMSSystem;
 
public class ambulance extends Dispatch{ //extension of Dispatch class for ambulances

    private int HLocationX; //outdated
    private int HLocationY; //outdated

    public ambulance(Location l) //sets home to Hospital
    {
    	super(l);
        size=1; //outdated
        
        
        ambulance=true;
        rescue=true;
//boolean statements which are initialized in dispatch class, determines certain variations in the parent code specifically for ambulances.
        
        
            
        

        }   
}
