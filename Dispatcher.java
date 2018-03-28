package EMSSystem;

/**
 * 
 * @author William Cirucci
 *
 */
public class Dispatcher {
//location (x, y) positive values are roads on grid
	
	protected int size;
	protected boolean active;
	protected int location;
	protected int homelocation;
	protected boolean destination;
	
	
	public dispatch()
	{
		size=1;
		active=false;
		location=0;
		homelocation=0;

		if (active=true)
		if (location<event.location)
		while (location<event.location)
		location++;
		else
		if(location>event.location)
		while(location>event.location)
		Location--;
		if(location=event.location)
		destination=true;

		if(active=false && location !=homelocation)
		if(location<homelocation)
		location++;
		else if(location>homelocation)
		location--;

	
	}
		public int getLocation()
	{
		return location;
	}
	
	public void setLocation()
	{
		location=0;
	}
	
}
