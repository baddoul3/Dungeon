package Dungeon;

import java.util.ArrayList;
import java.util.HashSet;

public class NormalRoom extends Room{
	


	public NormalRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("exit");
		this.commandList.add("precedent");
	}

	@Override
	protected void test(String command) {
		
		
	}
	
	
	

}
