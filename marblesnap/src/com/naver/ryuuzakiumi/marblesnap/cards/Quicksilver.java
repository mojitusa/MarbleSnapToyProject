package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Quicksilver extends Card {

	public Quicksilver(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "QUICKSILVER";
	int energy = 1;
	int power = 2;
	String  ability = "start";
	String txt = "첫 턴에 무조건 손에 들어옵니다.";

}
