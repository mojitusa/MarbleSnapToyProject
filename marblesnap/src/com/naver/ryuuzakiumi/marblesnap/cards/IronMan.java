package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class IronMan extends Card {
	
	public IronMan(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	String name = "IRON MAN";
	int energy = 5;
	int power = 0;
	String ability = "onGoing";
	String txt = "지속: 이곳의 내 전체 파워가 두 배로 증가합니다.";

	public static boolean ironManTriger; 
	public static boolean fieldIronManTriger[] = new boolean[3];
	
//	public static void triger(Boolean triger) {
//		ironManTriger = true;
//		System.out.println("아이언맨 지속 트리거 체크 온");
//		
//	}
}
