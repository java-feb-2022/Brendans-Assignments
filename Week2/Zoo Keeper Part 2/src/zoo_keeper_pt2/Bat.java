package zoo_keeper_pt2;

public class Bat extends Mammal {
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("Woosh!");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("Oh the humanity!");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The town burns and the people scream...");
		this.energyLevel -= 100;
	}
}
