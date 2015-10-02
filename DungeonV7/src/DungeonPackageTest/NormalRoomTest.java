package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RoomPackage.*;


public class NormalRoomTest {

protected Room normalRoom;
	
	@Before
	public void createKeysRoom(){
		normalRoom = new NormalRoom("key");
	}

	//The test of initialization of the NormalRoom set
	@Test
	public void creationTest() {
		assertEquals(normalRoom.getCommandList().contains("precedent"),true);
		assertEquals(normalRoom.getCommandList().contains("use potion"),true);
		assertEquals(normalRoom.getCommandList().contains("exit"),true);
	}
	
	
	@Test
	public void interpretCommandTest(){
		
		// The test of wrong command
		normalRoom.interpretCommands("bad command");
		assertEquals(normalRoom.isBadCommand(),true);
		
		// The of all changes when the player write "use potion" in this room
		normalRoom.interpretCommands("use potion");
		assertEquals(normalRoom.isExitDungeon(), true);
		
		// The of all changes when the player write "precedent" in this room set
		normalRoom.interpretCommands("precedent");
		assertEquals(normalRoom.isPrecedentCommand(), true);
		
		
	}

}
