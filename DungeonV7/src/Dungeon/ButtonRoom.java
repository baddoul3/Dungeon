package Dungeon;

import java.util.ArrayList;
import java.util.HashSet;

public class ButtonRoom extends Room {

	public ButtonRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("description");
			
	}

	@Override
	public void test(String command)
	{
		if(command.equals("description")){
			System.out.println(
					"you have a button to press\n"+
					"set (button) to show the door\n"
					+ "and exit to go out:\n"
					);
			
			this.commandList.add("button");
			this.commandList.add("precedent");
			this.commandList.remove("description");
			
				
					
		}
		else if(command.equals("button")){
			this.commandList.remove("button");
			this.commandList.remove("description");
			this.commandList.add("exit");
			this.commandList.add("precedent");
		}
		
		
	}


}
