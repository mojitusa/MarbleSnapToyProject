package com.naver.ryuuzakiumi.marblesnap;

import java.util.List;

import com.naver.ryuuzakiumi.marblesnap.cards.IronMan;
import com.naver.ryuuzakiumi.marblesnap.cards.ThePunisher;

class OnGoing {

	int ironManEffectField = 3;

	void onGoingCheck1(Card card, int fielSelection, int p) {

		if (card.ability == "onGoing") {

			switch (card.name) {
			case "IRON MAN":

				// 아이언맨 있는 곳 찾기

				card.effectTriger = true;
				card.effectedField[fielSelection - 1] = true;

				Card cardReturn = new Card();
				IronMan ironMan = new IronMan("", 0, 0, 0, "", "", 0, 0);

				cardReturn = Search.fieldSearch(p, "IRON MAN");
				ironMan = (IronMan) cardReturn;

				for (int i = 0; i < 3; i++) {
					if (ironMan.effectedField[i]) {
					}
				}

				break;

			case "THE PUNISHER":

				card.effectTriger = true;
				card.effectedField[fielSelection - 1] = true;

				cardReturn = new Card();
				ThePunisher thePunisher = new ThePunisher("", 0, 0, 0, "", "", 0, 0);

				cardReturn = Search.fieldSearch(p, "THE PUNISHER");
				thePunisher = (ThePunisher) cardReturn;

				for (int i = 0; i < 3; i++) {
					if (thePunisher.effectedField[i]) {
					}
				}
				break;

			default:
				break;
			}

		}
	}

	void onGoingCheck2(Card card, int fielSelection, int p) {

		if (card.ability == "onGoing") {

			switch (card.name) {
			case "IRON MAN":

				card.effectTriger = true;
				card.effectedField[fielSelection - 1] = true;

				Card cardReturn = new Card();
				IronMan ironMan = new IronMan("", 0, 0, 0, "", "", 0, 0);

				cardReturn = Search.fieldSearch(p, "IRON MAN");
				ironMan = (IronMan) cardReturn;

				for (int i = 0; i < 3; i++) {
					if (ironMan.effectedField[i]) {
					}
				}

				break;
				
			case "THE PUNISHER":
				
				card.effectTriger = true;
				card.effectedField[fielSelection - 1] = true;

				cardReturn = new Card();
				ThePunisher thePunisher = new ThePunisher("", 0, 0, 0, "", "", 0, 0);

				cardReturn = Search.fieldSearch(p, "THE PUNISHER");
				thePunisher = (ThePunisher) cardReturn;

				for (int i = 0; i < 3; i++) {
					if (thePunisher.effectedField[i]) {
					}
				}
				break;

			default:
				break;
			}

		}
	}

	IronMan fieldIronManAbility(int p, int[] fieldPower) {

		// 아이언맨을 찾아서

		IronMan ironMan = new IronMan("", 0, 0, 0, "", "", 0, 0);

		Card cardReturn = new Card();

		// 현재 아이언맨 필드 위치 탐색
		cardReturn = Search.fieldSearch(p, "IRON MAN");

		// 널이 아니면 즉 있으면 있으면
		if (cardReturn != null) {

			// 찾아서 아이언맨 인스턴스에 넣음
			ironMan = (IronMan) cardReturn;

			if (ironMan.effectTriger) {

				for (int i = 0; i < 3; i++) {

					if (ironMan.effectedField[i]) {

						fieldPower[i] *= 2;
					}
				}
			}
			return ironMan;
		}
		return null;
	}

	void printFieldIronManAbility(int p, int[] fieldPower) {

		IronMan ironMan = fieldIronManAbility(p, fieldPower);

		while (ironMan != null) {
//			System.out.println("아이언맨이 널이 아닙니다.");

			if (ironMan.effectTriger) {
//				System.out.println("아이언맨의 이펙트 트리거가 켜져 있습니다.");
				for (int i = 0; i < 3; i++) {

					if (ironMan.effectedField[i]) {
						System.out.print("IRON MAN 효과 필드 : " + (i + 1));
					}
				}
				System.out.println(" \"나는 아이언 맨이다\"");
				System.out.println("\u001b[1m" + "지속" + "\u001b[0m" + ": 이곳의 내 전체 파워가 두 배로 증가합니다.");
			}
			break;
		}
	}

	ThePunisher fieldThePunisherAbility(int p, List<List<Card>> fieldTopBot) {

		// 퍼니셔를 찾아서

		ThePunisher thePunisher = new ThePunisher("", 0, 0, 0, "", "", 0, 0);

		Card cardReturn = new Card();

		// 현재 퍼니셔 필드 위치 탐색
		cardReturn = Search.fieldSearch(p, "THE PUNISHER");

		// 널이 아니면 즉 있으면 있으면
		if (cardReturn != null) {

			// 찾아서 퍼니셔 인스턴스에 넣음
			thePunisher = (ThePunisher) cardReturn;

			if (thePunisher.effectTriger) {

				for (int i = 0; i < 3; i++) {

					if (thePunisher.effectedField[i]) {

						// 상대 필드 인원수 체크해서 그 수만큼 파워 증가

						thePunisher.addingPower = fieldTopBot.get(i).size();
						thePunisher.currentPower = thePunisher.power + thePunisher.addingPower;
					}
				}
			}
			return thePunisher;
		}
		return null;
	}

	void printFieldThePunisherAbility(int p, List<List<Card>> fieldTopBot) {

		ThePunisher thePunisher = fieldThePunisherAbility(p, fieldTopBot);

		while (thePunisher != null) {

			if (thePunisher.effectTriger) {
				for (int i = 0; i < 3; i++) {

					if (thePunisher.effectedField[i]) {
						System.out.println("THE PUNISHER 효과 필드 : " + (i + 1));
					}
				}
				System.out.println("\u001b[1m" + "지속" + "\u001b[0m" + ": 이곳에 있는 상대 카드 한 장당 +1 파워를 부여합니다.");
			}
			break;
		}
	}

}