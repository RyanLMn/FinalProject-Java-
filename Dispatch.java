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
		protected int DestinationX;
		protected int DestinationY;
		protected Event event;
		protected boolean atEvent;
			
		public Dispatch(Location l)
		{
			
			size=1;
			active=false; //vehicle is not moving by default
			homelocationX=l.getRow(); //gets the x value 
			homelocationY=l.getColumn(); //gets the y value
			currentlocationX=homelocationX; 
			currentlocationY=homelocationY;
			DestinationX=homelocationX;
			DestinationY=homelocationY;
			ambulance=false;
			rescue=false;
			dropoff=false;
			HLocationX=Map.getHospitalLoc().getRow();
			HLocationY=Map.getHospitalLoc().getColumn();
			homedestination = false;
			atEvent = false;
		}
		
		public void setEvent(Event event) {
			this.event = event;
		}

		public void setElocationX(int x)
		{
		    ELocationX=x; //setter method for Event Location
		    DestinationX=ELocationX;
		   }
		   
		   public void setElocationY(int y)
		   {
		       ELocationY=y;
		    		   DestinationY=ELocationY; //setter method for Event Location
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
			   destination=false;
		   }
		   
		   public void setDropOff( ) {
			   dropoff = true;
		   }
		   
		   public void Respond()
		   {
			    //has not reached destination yet
				if(active==true) 
				{
					if ((atEvent && !event.getEmergency()) || (!atEvent)) {
						atEvent = false;
						if(currentlocationX<DestinationX) //If the destination is to the right of the vehicle
						{
							if(currentlocationX+1!=Map.getBuilding().get(currentlocationY).size() && Map.getBuilding().get(currentlocationY).get(currentlocationX+1) instanceof Roads) //checks for road at it's right
							
							{
								currentlocationX=currentlocationX+1; //moves right
							}
						}
						else if(currentlocationX>DestinationX) //if it's to the left of vehicle
						{
								if(currentlocationX-1 !=-1 && Map.getBuilding().get(currentlocationY).get(currentlocationX-1) instanceof Roads) //checks to see if there is a road at it's left
								{
									currentlocationX=currentlocationX-1; //moves left
								}
						}
						else if(currentlocationX==DestinationX || currentlocationY != DestinationY)
						{
							if(currentlocationX-1 !=-1 && Map.getBuilding().get(currentlocationY).get(currentlocationX-1) instanceof Roads) //checks to see if there is a road at it's left
							{
									currentlocationX=currentlocationX-1; //moves left
							}
								
							else if (currentlocationX+1!=Map.getBuilding().get(currentlocationY).size() && Map.getBuilding().get(currentlocationY).get(currentlocationX +1) instanceof Roads)
							{
								currentlocationX=currentlocationX+1;
							}
						}
						if(currentlocationY<DestinationY) //if the event is above the vehicle
						{
							if(currentlocationX+1!=Map.getBuilding().size() && Map.getBuilding().get(currentlocationY+1).get(currentlocationX)instanceof Roads) //if there is a road above it.
							{
										currentlocationY=currentlocationY+1;
							}
						}
						else if(currentlocationY>DestinationY) 
						{
							if(currentlocationY-1 != -1 && Map.getBuilding().get(currentlocationY-1).get(currentlocationX)instanceof Roads)
							{
									currentlocationY=currentlocationY-1;
							}
						}
						else if(currentlocationY==DestinationY || currentlocationX != DestinationX)
						{
							if(currentlocationY-1 != -1 && Map.getBuilding().get(currentlocationY-1).get(currentlocationX) instanceof Roads) //checks to see if there is a road at it's left
							{
									currentlocationY=currentlocationY-1; //moves left
							}
								
							else if (currentlocationX+1!=Map.getBuilding().size() && Map.getBuilding().get(currentlocationY+1).get(currentlocationX) instanceof Roads)
							{
								currentlocationY=currentlocationY+1;
							}
						}
							if((!(Map.getBuilding().get(DestinationY).get(DestinationX)instanceof Roads) && (currentlocationY==DestinationY || currentlocationY==DestinationY-1 || currentlocationY==DestinationY+1) && (currentlocationX==DestinationX || currentlocationX==DestinationX-1 || currentlocationX==DestinationX+1)) || ((currentlocationY==DestinationY) && (currentlocationX==DestinationX))) //checks to see if it is exactly at the event or near it.
							{
								if(ambulance == true && dropoff == true) //checks to see if it is an ambulance or not, in which case it wll determine whether to go to hospital or home.
								{
										DestinationX=HLocationX;
										DestinationY=HLocationY;
										dropoff = false;
										if (this instanceof ambulance) {
											event.setAA();
											atEvent = true;
										}
								}
								else if (!homedestination)
								{
									DestinationX=homelocationX;
									DestinationY=homelocationY;
									if (this instanceof firetruck) {
										event.setFA();
										atEvent = true;
									} else if (this instanceof PoliceCar) {
										event.setPA();
										atEvent = true;
									}
									homedestination = true;
								} else {
									active = false;
									homedestination = false;
								}
							
							}
					
					}
						
				}
				
		        
		        
				}
	}
