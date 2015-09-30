package RoomPakage;

import java.util.ArrayList;
import java.util.HashSet;

import DungeonPakage.Room;

public class MonsterRoom extends Room {

	public MonsterRoom(String name) {
		super(name);

		this.commandList = new HashSet<>();		
		this.commandList.add("precedent");
		this.commandList.add("use weapon");
		this.commandList.add("use potion");
		
	}

	@Override
	public void getSpecificInterpretation(String command) {		
		
		
		if (command.equals("use weapon")) {
			this.commandList.remove("use weapon");		
			this.commandList.add("kill");		

		}
		else if (command.equals("kill")) {
			this.commandList.remove("kill");		
			this.commandList.add("exit");
			this.commandList.add("use potion");

		}
				

		

	}

}
