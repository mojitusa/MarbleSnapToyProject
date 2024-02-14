package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Hulk extends Card {
	
	public Hulk(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "HULK";
	int energy = 6;
	int power = 12;
	String ability = null;
	String txt = "\"헐크 스매시!\"";


}
