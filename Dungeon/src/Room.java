
public class Room {
	protected String name;
	protected Room northRoom;
	protected Room westRoom;

	public Room() {

	}

	
	public Room(String n) {
		name = n;
		
	}
	public String getName() {
		return name;
	}

	public Room getNorthRoom() {
		return northRoom;
	}

	
	public Room getWestRoom() {
		return westRoom;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setNorthRoom(Room northRoom) {
		this.northRoom = northRoom;
	}


	public void setWestRoom(Room westRoom) {
		this.westRoom = westRoom;
	}
	

	
}
