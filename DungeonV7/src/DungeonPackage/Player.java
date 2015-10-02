package DungeonPackage;


public class Player {

	int keys;
	int weapons;
	int potion;
	int treasure;
	
	public Player(int keys, int weapons)
	{
		this.keys = keys;
		this.weapons = weapons;
		
	}
	
	public int getKeys() {
		return keys;
	}
	public int decreaseKeys() {
		return keys--;
	}

	public int getWeapons() {
		return weapons;
	}
	public int decreaseWeapons() {
		return weapons--;
	}

	public int getPotion() {
		return potion;
	}

	public int getTreasure() {
		return treasure;
	}

	//this method add 100 at treasure  count of player
	public void setTreasure() {
		this.treasure +=100;
	}

	// this method test if the player have one or more keys to open next doors, 	
	public boolean haveKeys() {
		return this.keys >= 0;
	}
	
	// this method test if the player have one or more weapons to kill the next monster
	public boolean haveWeapons() {
		return this.weapons >= 0;
	}
	
	 
	
	
	
}
