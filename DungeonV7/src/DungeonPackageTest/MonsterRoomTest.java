package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RoomPackage.*;


public class MonsterRoomTest {

protected Room monsterRoom;
	
	@Before
	public void createKeysRoom(){
		monsterRoom = new MonsterRoom("monster");
	}
	
	//The test of initialization of the MonsterRoom set
	@Test
	public void creationTest() {
		assertEquals(monsterRoom.getCommandList().contains("precedent"),true);
		assertEquals(monsterRoom.getCommandList().contains("use potion"),true);
		assertEquals(monsterRoom.getCommandList().contains("use weapon"),true);
	}
	
	// The of all changes when the player write "use weapon" in this room set
	@Test
	public void descriptionCommandIn(){
		monsterRoom.getSpecificInterpretation("use weapon");
		assertEquals(monsterRoom.getCommandList().contains("kill"), true);		
		assertEquals(monsterRoom.getCommandList().contains("use weapon"),false);
		
	}
	// The of all changes when the player write "kill" in this room set
	@Test
	public void buttonCommandIn(){
		monsterRoom.getSpecificInterpretation("kill");
		assertEquals(monsterRoom.getCommandList().contains("kill"), false);
		assertEquals(monsterRoom.getCommandList().contains("exit"), true);
		
		
		
	}
	@Test
	public void interpretCommandTest(){
		
		// The test of wrong command
		monsterRoom.interpretCommands("bad command");
		assertEquals(monsterRoom.isBadCommand(),true);
		
		// The of all changes when the player write "use potion" in this room
		monsterRoom.interpretCommands("use potion");
		assertEquals(monsterRoom.isExitDungeon(), true);
		
		// The of all changes when the player write "precedent" in this room set
		monsterRoom.interpretCommands("precedent");
		assertEquals(monsterRoom.isPrecedentCommand(), true);
		
		
	}

}
