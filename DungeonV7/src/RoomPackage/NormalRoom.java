package RoomPackage;

import java.util.HashSet;

public class NormalRoom extends Room{
	
/*
 * This class uses the common fields of The class Room
 */

	public NormalRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("exit");
		this.commandList.add("precedent");
		this.commandList.add("use potion");
	}

	@Override
	public void getSpecificInterpretation(String command) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
