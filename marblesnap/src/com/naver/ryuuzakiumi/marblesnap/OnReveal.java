package com.naver.ryuuzakiumi.marblesnap;

import com.naver.ryuuzakiumi.marblesnap.cards.HawkEye;
import com.naver.ryuuzakiumi.marblesnap.cards.Medusa;
import com.naver.ryuuzakiumi.marblesnap.cards.StarLord;

class OnReveal {
	static int turn;
	int fieldSelection;
	static int hawkEyePower;
	static int medusaPower;

	OnReveal() {

	}

	// 출현 트리거 체크
	void hawkEyeOnRevealCheck(int fielSelection, int p) {
		this.fieldSelection = fielSelection;

		// 전에 켜진 호크아이 트리거 있다면 파워 추가하고
		// 나중에 복제를 생각하면 트리거끼리의 구분도 필여하다
		// 카드에 트리거 번호 변수를 추가하는 것도 좋습니다.
		// 트리거 꺼주기

		// 일단 호크아이 탐색
		HawkEye hawkEye = new HawkEye("", 0, 0, 0, "", "", 0, 0);

		// 현재 호크아이 인스턴스 위치 탐색
		// 핸드 탐색
		Card cardReturn = new Card();

		if (p == 1) {
			cardReturn = Search.handSearch(Play.p1Hand, "HAWK EYE");
		} else if (p == 2) {
			cardReturn = Search.handSearch(Play.p2Hand, "HAWK EYE");
		} else {
			System.out.println("플레이어 입력 오류입니다.");
		}

		if (cardReturn == null) {
			// 필드 탐색
			cardReturn = Search.fieldSearch(p, "HAWK EYE");
		}

		// 널이 아니면 즉 소유하고 있으면
		if (cardReturn != null) {

			// 찾아서 호크아이 인스턴스에 넣음
			hawkEye = (HawkEye) cardReturn;

			// 낸 필드에 호크아이 필드 트리거가 켜져 있고 턴 조건이 맞으면
			if (hawkEye.effectedField[this.fieldSelection - 1] && hawkEye.turn == Play.turn - 1) {
				//int hawkEyeOriginalPower = hawkEye.power;
				hawkEye.currentPower = hawkEye.power + hawkEye.addingPower;
				System.out.println("HAWK EYE의 능력이 발동합니다. HAWK EYE의 파워 + " + hawkEye.addingPower);
				System.out.println();
				System.out.println();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hawkEye.effectedField[this.fieldSelection - 1] = false;
				hawkEye.effectTriger = false;
			}

		}

	}

	// #########필드에 호크아이 트리거 표시########
	void fieldHawkEyeAbility(int p) {

		HawkEye hawkEye = new HawkEye("", 0, 0, 0, "", "", 0, 0);

		// 현재 호크아이 인스턴스 위치 탐색
		// 핸드 탐색
		Card cardReturn = new Card();

		if (p == 1) {
			cardReturn = Search.handSearch(Play.p1Hand, "HAWK EYE");
		} else if (p == 2) {
			cardReturn = Search.handSearch(Play.p2Hand, "HAWK EYE");

		} else {
			System.out.println("플레이어 입력 오류입니다.");
		}

		if (cardReturn == null) {
			// 필드 탐색
			cardReturn = Search.fieldSearch(p, "HAWK EYE");
		}

		// 널이 아니면 즉 소유하고 있으면
		if (cardReturn != null) {

			// 찾아서 호크아이 인스턴스에 넣음
			hawkEye = (HawkEye) cardReturn;

			if (hawkEye.effectTriger) {

				if ((hawkEye.turn == Play.turn || hawkEye.turn + 1 == Play.turn)) {
					for (int i = 0; i < 3; i++) {
						if (hawkEye.effectedField[i]) {
							hawkEye.txtout1 = "필드 " + (i + 1) + " 호크아이 능력 대기중 ";
						}
					}

				} else if (hawkEye.turn + 1 < Play.turn) {

					hawkEye.effectedField[0] = false;
					hawkEye.effectedField[1] = false;
					hawkEye.effectedField[2] = false;
					hawkEye.effectTriger = false;
					hawkEye.txtout1 = null;
				}
			}
		}
	}

	// 필드에 호크아이 능력 대기중 출력
	void printFieldHawkEyEAbility(int p) {

		Card cardReturn = new Card();

		HawkEye hawkEye = new HawkEye("", 0, 0, 0, "", "", 0, 0);

		// 현재 호크아이 인스턴스 위치 탐색
		// 핸드 탐색
		if (p == 1) {
			cardReturn = Search.handSearch(Play.p1Hand, "HAWK EYE");
		} else if (p == 2) {
			cardReturn = Search.handSearch(Play.p2Hand, "HAWK EYE");
		} else {
			System.out.println("플레이어 입력 오류입니다.");
		}
		// cardReturn = Search.handSearch(Play.p1Hand, "HAWK EYE");
		// 지워도 되는 코드 같다

		if (cardReturn == null) {
			// 필드 탐색
			cardReturn = Search.fieldSearch(p, "HAWK EYE");
		}
		// 널이 아니면 즉 소유하고 있으면
		if (cardReturn != null)

		{

			// 찾아서 호크아이 인스턴스에 넣음
			hawkEye = (HawkEye) cardReturn;

			if (hawkEye.effectTriger) {

				System.out.println(hawkEye.txtout1);
				System.out.println(hawkEye.txtout2);
			}

		}

	}

	void OnRevealCheck1(Card card, int fielSelection, int p) {

		// on reveal 카드별로 트리거 켜기
		if (card.ability == "onReveal") {

//			System.out.println("출현 트리거가 작동합니다.");

			switch (card.name) {
			case "HAWK EYE":

				// 호크아이 트리거 온
				hawkEyePower = card.onRevealTriger(true);
				card.effectTriger = true;
				card.effectedField[fieldSelection - 1] = true;

				// 낸 턴 기록
				card.turn = Play.turn;

				break;

			case "MEDUSA":
				// 2필드면 메두사 트리거 온
				if (fieldSelection == 2) {

					medusaPower = Medusa.triger(true);
					card.effectTriger = true;
					card.effectedField[fielSelection - 1] = true;

					// 모든 필드를 뒤져서 메두사를 찾아서 파워 + 3
					Card cardReturn = new Card();
					Medusa medusa = new Medusa("", 0, 0, 0, "", "", 0, 0);

					cardReturn = Search.fieldSearch(p, "MEDUSA");

					medusa = (Medusa) cardReturn;

					//int medusaOriginalPower = medusa.power;
					medusa.currentPower = medusa.power + medusa.addingPower;
					
					System.out.println("MEDUSA의 능력이 발동합니다. MEDUSA의 파워 + " + medusa.addingPower);
					System.out.println();
					System.out.println();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				break;
				
			case "STAR LORD":
				// 상대가 이번 턴 이 구역에 카드를 냈으면 효과 발현
				
				if (Play.playedField[0][fielSelection - 1] > 0 ) {
					card
					
					
				}

					card.effectTriger = true;
					card.effectedField[fielSelection - 1] = true;

					// 모든 필드를 뒤져서 메두사를 찾아서 파워 + 3
					Card cardReturn = new Card();
					Medusa medusa = new Medusa("", 0, 0, 0, "", "", 0, 0);

					cardReturn = Search.fieldSearch(p, "MEDUSA");

					medusa = (Medusa) cardReturn;

					//int medusaOriginalPower = medusa.power;
					medusa.currentPower = medusa.power + medusa.addingPower;
					
					System.out.println("MEDUSA의 능력이 발동합니다. MEDUSA의 파워 + " + medusa.addingPower);
					System.out.println();
					System.out.println();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				break;

			default:
				break;
			}

		}

	}

	void OnRevealCheck2(Card card, int fielSelection, int p) {

		// on reveal 카드별로 트리거 켜기
		if (card.ability == "onReveal") {

//			System.out.println("출현 트리거가 작동합니다.");

			switch (card.name) {
			case "HAWK EYE":

				// 호크아이 트리거 온
				hawkEyePower = card.onRevealTriger(true);
				card.effectTriger = true;
				card.effectedField[fieldSelection - 1] = true;

				// 낸 턴 기록
				card.turn = Play.turn;

				break;

			case "MEDUSA":
				// 2필드면 메두사 트리거 온
				if (fieldSelection == 2) {

					medusaPower = Medusa.triger(true);
					card.effectTriger = true;
					card.effectedField[fielSelection - 1] = true;

					// 모든 필드를 뒤져서 메두사를 찾아서 파워 + 3
					Card cardReturn = new Card();
					Medusa medusa = new Medusa("", 0, 0, 0, "", "", 0, 0);

					cardReturn = Search.fieldSearch(p, "MEDUSA");
					medusa = (Medusa) cardReturn;

//					int medusaOriginalPower = medusa.power;
					medusa.currentPower = medusa.power + medusa.addingPower;
					System.out.println("MEDUSA의 능력이 발동합니다. MEDUSA의 파워 + " + medusa.addingPower);

					System.out.println();
					System.out.println();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;

			default:
				break;
			}

		}

	}

}