package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class ThePunisher extends Card {
	
	public ThePunisher(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "THE PUNISHER";
	int energy = 3;
	public int power = 3;
	public final int originalPower = 3;
	String ability = "onGoing";
	String txt = "지속: 이곳에 있는 상대 카드 한 장당 +1 파워를 부여합니다.";
	
	public static boolean thePunisherTriger; 
	public static boolean fieldThePunisherTriger[] = new boolean[3];
	
	public int addingPower;
	

}
