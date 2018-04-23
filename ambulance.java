package EMSSystem;

public class ambulance extends Dispatch{

    private int HLocationX;
    private int HLocationY;

    public ambulance(Location l)
    {
    	super(l);
        size=1;
        rescue=true;
        
        ambulance=true;
        rescue=false;
        HLocationX=0;
        HLocationY=0;
        
        
            
        

        }   
}