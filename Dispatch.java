package EMSSystem;

public class Dispatch {
	//location (x, y) positive values are roads on grid

	protected int size;
	protected boolean active;
	protected int homelocationX;
	protected int homelocationY;
	protected boolean destination;
	protected boolean homedestination;
	protected int currentlocationX;
	protected int currentlocationY;
	protected boolean ambulance;
		
	public Dispatch()
	{
		size=1;
		active=false;
		currentlocationX=homelocationX;
		currentlocationY=homelocationY;
		homelocationX=0;
		homelocationY=0;
		ambulance=false;
		
		
		//move to event
			
		if (active=true)
		{
			destination=false;
			while(active=true)
			{
				if(currentlocationX<event.locationX)
				{
					if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Road)
					{
						currentlocationX=currentlocationX+1;
					}
					else if(locationX>event.locationX)
					{
						if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Road)
						{
							currentlocationX=currentlocationX-1;
						}
						if(currentlocationY<event.locationY)
						{
							if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Road)
							{
								currentlocationY=currentlocationY+1;
							}
							else if(currentlocationY>event.locationY) {
								if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Road)
								{
									currentlocationY=currentlocationY-1;
								}
							}
							if((currentlocationY==event.locationY || currentlocationY==event.locationY-1 || currentlocationY==event.locationY+1) && (currentlocationX==event.locationX || currentlocationX==event.locationX-1 || currentlocationX==event.locationX+1))
							{
								destination=true;
							}
							if(destination=true && ambulance != true)
							{
								active=false;
							}
						}
					}
				}
			}
		}	
					
						
		//return home
		if (active false)
		{
			active=false;
		}
		while(active=false)
		{	
			if(currentlocationX<homelocationX)
			{
				if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Road)
				{
					currentlocationX=currentlocationX+1;
				}
				else if(locationX>homelocationX)
				{
					if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Road)
					{	
						currentlocationX=currentlocationX-1;
					}
					if(currentlocationY<homelocationY)
					{
						if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Road)
						{
							currentlocationY=currentlocationY+1;
						}
						else if(currentlocationY>homelocationY) {
							if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Road)
							{
								currentlocationY=currentlocationY-1;
							}
							if((currentlocationY==homelocationY || currentlocationY==event.locationY-1 || currentlocationY==event.locationY+1) && (currentlocationX==event.locationX || currentlocationX==event.locationX-1 || currentlocationX==event.locationX+1))
								homedestination=true;
						}
					}
				}
			}
		}
	}	
}
