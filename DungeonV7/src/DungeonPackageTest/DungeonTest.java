package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DungeonPackage.Dungeon;
import DungeonPackage.FirstDungeon;
import RoomPackage.*;
import DungeonPackage.Player;

public class DungeonTest {

	protected Dungeon dungeon1;
	protected Player player;

	@Before
	public void createNewDungeon() {
		player = new Player(1, 1);
		dungeon1 = new FirstDungeon("first", player);

	}

	// This method test if the room returned is one of
	@Test
	public void generateARandomRoomTest() {
		Room room = dungeon1.getRandomRoom();
		assertTrue(room.getName() == "normal" || room.getName() == "key" || room.getName() == "button"
				|| room.getName() == "monster" || room.getName() == "treasure");
	}

	// This method test if the number of keys is decreased
	@Test
	public void dungeonSpecificCommandKeysTest() {

		dungeon1.dungeonSpecificCommand("open");

		assertEquals(player.getKeys(), 0);

	}

	// This method test if the number of weapons is decreased
	@Test
	public void dungeonSpecificCommandWeaponTest() {

		dungeon1.getRandomRoom();
		dungeon1.dungeonSpecificCommand("use weapon");

		assertEquals(player.getWeapons(), 0);

	}
	
	// This method test if the number of treasures is decreased
	public void dungeonSpecificCommandTreasureTest() {

		dungeon1.getRandomRoom();
		dungeon1.dungeonSpecificCommand("treasure");

		assertEquals(player.getTreasure(), 200);

	}
	
	// This method test if the value of transition became true
	public void dungeonSpecificCommandTransitionTest() {

		dungeon1.getRandomRoom();
		dungeon1.dungeonSpecificCommand("use potion");

		assertEquals(dungeon1.dungeonIsChanged(),true);

	}

	
}
