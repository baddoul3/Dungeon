package DungeonPakage;


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

	public int getWeapons() {
		return weapons;
	}

	public int getPotion() {
		return potion;
	}

	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

	public void setWeapons(int weapons) {
		this.weapons = weapons;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}
	 
	
	 
	
	
	
}
