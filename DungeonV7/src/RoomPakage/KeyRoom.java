package RoomPakage;

import java.util.ArrayList;
import java.util.HashSet;

import DungeonPakage.Room;

public class KeyRoom extends Room {
	
	public KeyRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("open");
		this.commandList.add("precedent");
		this.commandList.add("use potion");

	}

	public void getSpecificInterpretation(String command) {
		
		if (command.equals("open")) {

			this.commandList.add("exit");
			this.commandList.remove("open");
			
			
		}
	}
	
	

}
