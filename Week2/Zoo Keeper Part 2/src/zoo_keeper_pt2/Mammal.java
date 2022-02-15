package zoo_keeper_pt2;

public class Mammal {
	public int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("Animal has " + energyLevel + " energy left.");
		return energyLevel;
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
