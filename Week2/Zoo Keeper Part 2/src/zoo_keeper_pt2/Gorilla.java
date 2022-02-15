package zoo_keeper_pt2;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super(100);
	}
	
	public void throwSomething() {
		System.out.println("The Gorilla has thrown something...");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The Gorilla enjoys the banana!");
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The Gorilla has climbed the tree, watch out!");
		energyLevel -= 10;
	}
}
