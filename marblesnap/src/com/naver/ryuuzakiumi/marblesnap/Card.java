package com.naver.ryuuzakiumi.marblesnap;

public class Card {
	
	public String name;
	public int energy;
	public int power;
	public int currentPower;
	public boolean fieldExistance;
	public String ability;
	public String txt;
	public int ownerPlayer;
	public int duplicationNumber;
	
	
	public Card(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		
		this.name = name;
		this.energy= energy;
		this.power = power;
		this.currentPower = currentPower;  
		this.ability = ability;
		this.txt = txt;
		this.ownerPlayer = ownerPlayer;
		this.duplicationNumber = duplicationNumber;
	}
	
	public Card() {
		
		this.name = "            ";
		
		
	}
	
	

	public int onRevealTriger(boolean triger) {
		return 0;
	}
	
	public boolean effectedField[] = new boolean[3];
	public int turn;
	public boolean effectTriger;


}
