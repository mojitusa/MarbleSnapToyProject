package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class MistyKnight extends Card {
	
	public MistyKnight(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "Misty Knight";
	int energy = 1;
	int power = 2;
	String ability = null;
	String txt = "\"이 도시를 구해야 해요.\"";

}
