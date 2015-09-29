package Dungeon;

import java.util.ArrayList;
import java.util.HashSet;

public class KeyRoom extends Room{
	
	
	public KeyRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("open");		
		this.commandList.add("precedent");
		
	}

	
	public void test(String command) {
				

		
		if(command.equals("open")){
			
			this.commandList.add("exit");
			this.commandList.remove("open");
			
			
		}
		
		}
}
