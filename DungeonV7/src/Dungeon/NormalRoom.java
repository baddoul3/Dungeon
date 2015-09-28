package Dungeon;

import java.util.ArrayList;

public class NormalRoom extends Room{
	


	public NormalRoom(String name) {
		super(name);
		this.commandList = new ArrayList<>();
		this.commandList.add("cross ");
		this.commandList.add("precedent");
		this.commandList.add("description");
		
	
	}

	
	

}
