package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Medusa extends Card {

	public Medusa(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer,
			int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}

	/*
	 * public String name = "MEDUSA"; int energy = 2; int power = 2; String ability
	 * = "onReveal"; String txt = "출현: 이 카드가 중앙 구역에 있을 경우, +3 파워를 부여합니다.";
	 */
	public int addingPower = 3;
	public static boolean medusaTriger;

	public static int triger(Boolean triger) {
		medusaTriger = true;

		System.out.println("MEDUSA의 출현 트리거 온");
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
