package Dungeon;

public class Gamer {

	int keys;
	int blows;
	int potion;
	
	public Gamer(int k, int b, int p)
	{
		keys = k;
		blows = b;
		potion = p;
	}
	
	public int getKeys() {
		return keys;
	}

	public int getBlows() {
		return blows;
	}

	public int getPotion() {
		return potion;
	}

	public void setKeys(int keys) {
		this.keys = keys;
	}

	public void setBlows(int blows) {
		this.blows = blows;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}

	public Gamer()
	{
		
	}
	
	
	
}
