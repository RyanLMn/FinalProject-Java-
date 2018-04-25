
	package EMSSystem;

	public class Dispatch {
		//location (x, y) positive values are roads on grid

		protected int size; //Size of Car
		protected boolean active; //Determines if Car is moving or not
		protected int homelocationX; //Location of their home station, their return point, on the X
		protected int homelocationY; //Location of their home station, home point on Y
		protected boolean destination; //destination determines whether they've arrived to their event or not.
		protected boolean homedestination; //Like destination only for the returning home method.
		protected int currentlocationX; //Notes current location of vehicle on the X
		protected int currentlocationY; //Notes current location of vehicle on the Y
		protected boolean ambulance; //True only for ambulance subclass, enabling a specific method within Dispatch that drives to the hospital first instead of the homebase.
		protected int ELocationX; //The  X location of the event they are moving to.
		protected int ELocationY; //Y location of event they are moving to
		protected boolean rescue; 
		protected boolean dropoff; //Like destination but for hospital
		protected int HLocationX; //Location of Hospital X
		protected int HLocationY; //Location of Hospital Y
			
		public Dispatch(Location l)
		{
			
			size=1;
			active=false; //vehicle is not moving by default
			homelocationX=l.getRow(); //gets the x value 
			homelocationY=l.getColumn(); //gets the y value
			currentlocationX=homelocationX; 
			currentlocationY=homelocationY;
			ambulance=false;
			rescue=false;
			dropoff=false;
			HLocationX=Map.getHospitalLoc().getColumn();
			HLocationY=Map.getHospitalLoc().getRow();
			
		}
		


		public void setElocationX(int x)
		{
		    ELocationX=x; //setter method for Event Location
		   }
		   
		   public void setElocationY(int y)
		   {
		       ELocationY=y; //setter method for Event Location
		   }
		   
		   public int getElocationX()
		   {
		       return ELocationX; //Get method for Event Location
		   }
		   public boolean getDestination()
	{
		return destination;  //Get method for
	}
		   public int getElocationY()
		   {
	return ELocationY; //Get method for Event Location
		   }
		   public boolean getActive(){
		   return active; //get method for active
		  
		   } 
		   public void setActive(){
			   active=true; //set method for active
		   }
		   
		   public void Respond()
			{
				if (active=true)//I.E. when tasked to move
				{
					destination=false; //has not reached destination yet
					if(active=true) 
					{
						if(currentlocationX<ELocationX) //If the destination is to the right of the vehicle
						{
							if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads) //checks for road at it's right
							
							{
								currentlocationX=currentlocationX+1; //moves right
							}
						}
							else if(currentlocationX>ELocationX) //if it's to the left of vehicle
							{
								if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads) //checks to see if there is a road at it's left
								{
									currentlocationX=currentlocationX-1; //moves left
								}
							}
								if(currentlocationY<ELocationY) //if the event is above the vehicle
								{
									if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads) //if there is a road above it.
									{
										currentlocationY=currentlocationY+1;
									}
								}
									else if(currentlocationY>ELocationY) 
									{
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
						
					
				
				destination=false;
		        
		        
				if(rescue=true)
				{
					dropoff=true;
					active=true;
				}
		        if (dropoff=true)
		        {
		            if(currentlocationX < HLocationX)
		            {
		                if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads)
		                {
		                    currentlocationX=currentlocationX+1;
		                }
		            }
		                else if(currentlocationX>HLocationX)
		                {
              if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads)
              {
              
		            currentlocationX=currentlocationX-1;
		      }
		                }
		                if(currentlocationY<HLocationY)
		                {
		                        if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads)
		                {
		                            currentlocationY=currentlocationY+1;
		                }
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
				
			    
		   
		   public void returnHome()
				   {
				   	if (active==false)
				   		{
				   			active=true;
				   		}
				   		if (active=true)
				   		{	
				   			if(currentlocationX<homelocationX)
				   			{
				   				if(Map.getBuilding().get(currentlocationX+1).get(currentlocationY) instanceof Roads)
				   				{
				   					currentlocationX=currentlocationX+1;
				   				}
				   			}
				   				else if(currentlocationX>homelocationX)
				   				{
				   					if(Map.getBuilding().get(currentlocationX-1).get(currentlocationY) instanceof Roads)
				   					{	
				   						currentlocationX=currentlocationX-1;
				   					}
				   				}
				   					if(currentlocationY<homelocationY)
				   					{
				   						if(Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads)
				   						{
				   							currentlocationY=currentlocationY+1;
				   						}
				   					}
				   						else if(currentlocationY>homelocationY) 
				   						{
				   							if(Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Roads)
				   							{
				   								currentlocationY=currentlocationY-1;
				   							}
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



