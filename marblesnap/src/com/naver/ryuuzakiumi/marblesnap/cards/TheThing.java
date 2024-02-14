package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class TheThing extends Card {
	
	public TheThing(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "THE THING";
	int energy = 4;
	int power = 6;
	String ability = null;
	String txt = "\"때려눕힐 시간이다!\"";

}
