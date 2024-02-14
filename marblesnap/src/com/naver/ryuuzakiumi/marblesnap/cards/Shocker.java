package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Shocker extends Card {
	
	public Shocker(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "SHOCKER";
	int energy = 2;
	int power = 3;
	boolean hasAbility = false;
	boolean onReveal = false;
	boolean onGoing = false;
	String other = null;
	String txt = "\"너를 날려 버리겠다.\"";

}
