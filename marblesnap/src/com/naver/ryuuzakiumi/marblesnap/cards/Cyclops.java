package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Cyclops extends Card {
	
	public Cyclops(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "CYCLOPS";
	int energy = 3;
	int power = 4;
	String ability = null;
	String txt = "\"가자, 엑스맨.\"";
	
	public void testm(){
		System.out.println("테스트");
		
	}

}
