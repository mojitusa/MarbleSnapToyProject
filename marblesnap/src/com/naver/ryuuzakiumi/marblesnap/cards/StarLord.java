package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class StarLord extends Card{
	
	public StarLord(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer,
			int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}
	
	//

	public int addingPower = 3;
	public static boolean starLordTriger;

	public static int triger(Boolean triger) {
		starLordTriger = true;

		System.out.println("STAR LORD의 출현 트리거 온");
		System.out.println();
		System.out.println();
		System.out.println();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int result = 0;
		if (triger) {
			result = 3;
		}

		return result;
	}
	
}
