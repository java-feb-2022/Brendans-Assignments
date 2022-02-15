package com.codingdojo.zookeeper;

public class Mammal {
	public int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("Animal has " + energyLevel + " energy left.");
		return energyLevel;
	}
}
