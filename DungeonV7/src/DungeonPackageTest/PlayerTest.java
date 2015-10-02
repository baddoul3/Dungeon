package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DungeonPackage.Player;

public class PlayerTest {
protected Player player;
	
	@Before
	public void createPlayer(){
		player = new Player (2,2);
	}
	
	//test the number of treasure when we add 100;
	@Test
	public void setTreasureTest() {
		player.setTreasure();
		
		assertEquals(player.getTreasure(),100);
		}
	
	//test if the number of keys is bigger than 0
	
	@Test
	public void haveKeysTest(){
		
		assertEquals(player.haveKeys(), true);
		
	}
	//test if the number of weapons is bigger than 0
	@Test
	public void haveWeapon(){
		
		assertEquals(player.haveWeapons(), true);
		
	}
	
}
