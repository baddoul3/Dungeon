package RoomPackage;

import java.util.HashSet;

public class ButtonRoom extends Room {

	public ButtonRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("description");
		this.commandList.add("use potion");
		this.commandList.add("precedent");
		this.exitCommand = false;
			
	}
	//The test of the first command and update the buttonRoom set
	@Override
	public void getSpecificInterpretation(String command)
	{
		/*
		 * the only case when the description is not mentioned at the beginning
		 * for the other sub classes this test is not necessary
		 */	
		if(command.equals("description")){
			System.out.println(
					"you have a button to press\n"+
					"set (button) to show the door\n"
					
					);
			
			this.commandList.add("button");
			this.commandList.add("precedent");
			this.commandList.remove("description");
			
					
		}
				
		/*
		 * Update the button class list to contain only exit and precedent choices at last
		 */
		else if(command.equals("button")){
			this.commandList.remove("button");			
			this.commandList.add("exit");
			this.exitCommand=true;
		}
		
		
	}


}
