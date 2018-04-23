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
	protected int ELocationX;
	protected int ELocationY;
	protected boolean rescue;
	protected boolean dropoff;
	protected int HLocationX;
	protected int HLocationY;
		
	public Dispatch(Location l)
	{
		
		size=1;
		active=false;
		homelocationX=l.getRow();
		homelocationY=l.getColumn();
		currentlocationX=homelocationX;
		currentlocationY=homelocationY;
		ambulance=false;
		rescue=false;
		dropoff=false;
		HLocationX=Map.getHospitalLoc().getColumn();
		HLocationY=Map.getHospitalLoc().getRow()
		
	}
	


	public void setElocationX(int x)
	{
	    ELocationX=x;
	   }
	   
	   public void setElocationY(int y)
	   {
	       ELocationY=y;
	   }
	   
	   public int getElocationX()
	   {
	       return ELocationX;
	   }
	   public boolean getDestination()
{
	return destination;
}
	   public int getElocationY()
	   {
return ELocationY;
	   }
	   public boolean getActive(){
	   return active;
	  
	   } 
	   public void setActive(){
		   active=true;
	   }
	   
	   public void Respond()
		{
			if (active=true)
			{
				destination=false;
				while(active=true)
				{
					if(currentlocationX<ELocationX)
					{
						if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads)
						{
							currentlocationX=currentlocationX+1;
						}
						else if(currentlocationX>ELocationX)
						{
							if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads)
							{
								currentlocationX=currentlocationX-1;
							}
							if(currentlocationY<ELocationY)
							{
								if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads)
								{
									currentlocationY=currentlocationY+1;
								}
								else if(currentlocationY>ELocationY) {
									if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Roads)
									{
										currentlocationY=currentlocationY-1;
									}
								}
								if((currentlocationY==ELocationY || currentlocationY==ELocationY-1 || currentlocationY==ELocationY+1) && (currentlocationX==ELocationX || currentlocationX==ELocationX-1 || currentlocationX==ELocationX+1))
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
			destination=false;
	        
	        
			if(rescue=true)
			{
				dropoff=true;
				active=true;
			}
	        while (dropoff=true)
	        
	            if(currentlocationX < HLocationX)
	                {
	                if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads)
	                {
	                    currentlocationX=currentlocationX+1;
	                }
	                else if(currentlocationX>HLocationX)
	                {
	                    if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads)
	                    {
	                    
	                        currentlocationX=currentlocationX-1;
	                        }
	                if(currentlocationY<HLocationY)
	                {
	                        if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads)
	                {
	                            currentlocationY=currentlocationY+1;
	                }
	                
	                        else if(currentlocationY>HLocationY)
	                            if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Roads)
	                    {
	                                currentlocationY=currentlocationY-1;
	                    }
	                
	        
	                if((currentlocationY==HLocationY || currentlocationY==HLocationY-1 || currentlocationY==HLocationY+1) && (currentlocationX==HLocationX|| currentlocationX==HLocationX-1 || currentlocationX==HLocationX+1))
	            {
	            destination=true;
	            }
	            if(destination=true)
	            {
	                dropoff=false;
	            }
	
			
			}
			}
		    }
	   }
	   public void returnHome()
			   {
			   	if (active==false)
			   		{
			   			active=true;
			   		}
			   		while(active=true)
			   		{	
			   			if(currentlocationX<homelocationX)
			   			{
			   				if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads)
			   				{
			   					currentlocationX=currentlocationX+1;
			   				}
			   				else if(currentlocationX>homelocationX)
			   				{
			   					if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads)
			   					{	
			   						currentlocationX=currentlocationX-1;
			   					}
			   					if(currentlocationY<homelocationY)
			   					{
			   						if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads)
			   						{
			   							currentlocationY=currentlocationY+1;
			   						}
			   						else if(currentlocationY>homelocationY) {
			   							if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Roads)
			   							{
			   								currentlocationY=currentlocationY-1;
			   							}
			   							if((currentlocationY==homelocationY || currentlocationY==homelocationY-1 || currentlocationY==homelocationY+1) && (currentlocationX==homelocationX || currentlocationX==homelocationX-1 || currentlocationX==homelocationX+1))
			   								homedestination=true;
										active=false;
			   						}
			   					}
			   				}
			   			}
			   		}
			   }}

