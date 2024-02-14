package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class HawkEye extends Card {

	public HawkEye(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer,
			int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);
	}

	/*
	 * String name = "HAWK EYE"; int energy = 1; int power = 1; String ability =
	 * "onReveal"; String txt = "출현: 다음 턴에 내가 이 구역에 카드를 낼 경우, +3 파워를 부여합니다.";
	 */

	public String txtout1;
	public String txtout2 = "\u001b[1m" + "\"출현: " + "\u001b[0m" + "다음 턴에 내가 이 구역에 카드를 낼 경우, +3 파워를 부여합니다.\"";

	public int addingPower = 3;
	public boolean hawkEyeTriger;
	boolean fieldHawkEyeTriger[] = new boolean[3];

	@Override
	public int onRevealTriger(boolean triger) {
		hawkEyeTriger = true;

		System.out.println("HAWK EYE의 출현 트리거 온");
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
			result = addingPower;
		}

		return result;

	}

}
