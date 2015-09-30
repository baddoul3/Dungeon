package RoomPakage;

import java.util.ArrayList;
import java.util.HashSet;

import DungeonPakage.Room;

public class NormalRoom extends Room{
	


	public NormalRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("exit");
		this.commandList.add("precedent");
		this.commandList.add("use potion");
	}
	
	
	@Override
	protected void getSpecificInterpretation(String command) {		
		 if (!commandList.contains(command))
			System.out.println("wrong command, tray again!!");
		
	}
	
	
	

}
