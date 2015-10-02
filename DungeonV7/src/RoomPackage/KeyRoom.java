package RoomPackage;

import java.util.HashSet;

public class KeyRoom extends Room {

	
	public KeyRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("open");
		this.commandList.add("precedent");
		this.commandList.add("use potion");
		this.exitCommand=false;

	}

	/*
	 * This method test if the player choose to open the door with a key,
	 * also it update the room set
	 * */
	public void getSpecificInterpretation(String command) {
		if(command.equals("open")) {

			this.commandList.add("exit");
			this.commandList.remove("open");
			this.exitCommand=true;

		}
		
		
			
		
	}

}
