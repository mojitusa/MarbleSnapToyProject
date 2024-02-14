package com.naver.ryuuzakiumi.marblesnap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TurnEnd {
	static void turnEnd() {
		System.out.println();
		System.out.println("턴 종료.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class Play {

	static int currentEenergy1p = 0;
	static int currentEenergy2p = 0;

	static int p1handsize = 0;
	static int p2handsize = 0;

	static int turn = 0;
	static int maxTurn = 6;
	static int turnPriority = 1;

	static List<Card> cardPlayQueue1 = new ArrayList<Card>();
	static List<Card> cardPlayQueue2 = new ArrayList<Card>();
	static List<List<Card>> cardPlayQueue = new ArrayList<List<Card>>();

	static List<Integer> fieldSelectionQueue1 = new ArrayList<Integer>();
	static List<Integer> fieldSelectionQueue2 = new ArrayList<Integer>();
	static List<List<Integer>> fieldSelectionQueue = new ArrayList<>();

	// 손패 인스턴스
	static List<Card> p1Hand = new ArrayList<Card>();
	static List<Card> p2Hand = new ArrayList<Card>();

	static boolean tvaTriger;

	static boolean theVaultTriger[] = new boolean[3];
	static int theVaultLocation;

	static boolean miniaturizedLabTriger[] = new boolean[3];
	static int miniaturizedLabLocation;

	static boolean crimsonCosmosTriger[] = new boolean[3];
	static int crimsonCosmosLocation;

	static boolean hellfireClubTriger[] = new boolean[3];
	static int hellfireClubLocation;

	static boolean theBigHouseTriger[] = new boolean[3];
	static int theBigHouseLocation;

	static boolean knowhereTriger[] = new boolean[3];
	static int knowhereLocation;
	
	static int playedField[][] = new int[2][3];

	static Card draw(List<Card> deck) {

		if (deck.size() == 0) {
			return null;
		} else {

			Card temp = new Card();

			int i = (int) (Math.random() * deck.size());
			temp = deck.get(i);
			deck.remove(i);

			return temp;
		}
	}

	public static void main(String[] args) {

		// 게임 시작
		int p1energy = 0, p2energy = 0;

		// 시작 손패 랜덤 3장
		// 덱 인스턴스 생성
		P1Deck p1Deck = new P1Deck();
		p1Deck.P1Deck2Create();

		P2Deck p2Deck = new P2Deck();
		p2Deck.P2DeckCreate();

		// 카드 플레이 큐 세팅
		cardPlayQueue.add(cardPlayQueue1);
		cardPlayQueue.add(cardPlayQueue2);

		fieldSelectionQueue.add(fieldSelectionQueue1);
		fieldSelectionQueue.add(fieldSelectionQueue2);

		// 퀵 실버 트리거 (첫 핸드에 무조건 손에 들어옴)
		while (p1handsize < 3) {
			for (int i = 0; i < p1Deck.p1Deck.size(); i++) {

				if (p1Deck.p1Deck.get(i).ability == "start") {

					p1Hand.add(p1Deck.p1Deck.get(i));
					p1Deck.p1Deck.remove(i);
					p1handsize++;
				}
			}
			Card card = new Card();
			card = draw(p1Deck.p1Deck);
			if (card != null) {
				p1Hand.add(card);
				p1handsize++;
			}
		}

		while (p2handsize < 3) {
			for (int i = 0; i < p2Deck.p2Deck.size(); i++) {

				if (p2Deck.p2Deck.get(i).ability == "start") {

					p2Hand.add(p2Deck.p2Deck.get(i));
					p2Deck.p2Deck.remove(i);
					p2handsize++;
				}
			}
			Card card = new Card();
			card = draw(p2Deck.p2Deck);
			if (card != null) {
				p2Hand.add(card);
				p2handsize++;
			}
		}

		// ------게임 시작----------

		// 필드 객체 생성
		GameField gField = new GameField();

		// 필드 준비 (연결시키기)
		gField.fieldReady();

		// 출현 객체 생성
		OnReveal onReveal = new OnReveal();

		// 지속 객체 생성
		OnGoing onGoing = new OnGoing();

		// 구역 객체 생성
		// 클래스의 객체 생성
		LocationList location = new LocationList();
		// 각 구역 객체 생성
		location.locationReady();
		// 구역 랜덤하게 배치
		location.locationArrangement();

		while (turn + 1 <= maxTurn) {

			// %%%% 턴 시작 %%%%%%
			turn++;

			// 에너지 +1
			currentEenergy1p = ++p1energy;
			currentEenergy2p = ++p2energy;

			// 구역 세팅
			// 리빌 카운터 하나 줄이기
			// 리빌 카운터가 0이라면 대기중인 구역으로 교체
			Location loc = location.revealLocation();
			// 미공개 구역 출력문 하나씩 당기기
			location.sortLocation();

			// 새로운 구역이 공개되었다면 효과 발동
			if (loc != null) {
				location.activateLocationEffect(loc, p1Deck.p1Deck, p2Deck.p2Deck);
			}

			// 한 장 드로우
			Card card = new Card();
			card = draw(p1Deck.p1Deck);
			if (card != null) {
				p1Hand.add(card);
				p1handsize++;
			}

			card = draw(p2Deck.p2Deck);
			if (card != null) {
				p2Hand.add(card);
				p2handsize++;
			}

			A: while (true) {

				// 필드 에너지 반영
				gField.fieldTop = new ArrayList<List<Card>>();
				gField.fieldBot = new ArrayList<List<Card>>();

				// 필드 파워 초기화
				// 플레이어 1 2 의 구역별 파워 합산
				gField.currentPlayerFieldPower();

				// ========= 화면 출력 ==========
				// 필드 출력

				// 대기중인 내, 상대 지속 능력들 반영
				onGoing.fieldIronManAbility(1, GameField.fieldp1Power);
				onGoing.fieldIronManAbility(2, GameField.fieldp2Power);

				// 전턴 그냥필드를 탑과 바텀에 연결해서 빈 필드 출력 준비
				gField.linkPreviousTurnFieldTBField();

				// 지금 플레이하는 플레이어를 아래 필드로
				// 내 필드는 반영필드 상대 필드는 그냥 필드
				gField.fieldPositionCheck();

//				// 상대 나 필드 구성 보고 증감 효과 반영
//				onGoing.fieldThePunisherAbility(1, gField.fieldp2);
//				onGoing.fieldThePunisherAbility(2, gField.fieldp1);

				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println();

				// 상대 대기중인 능력들 확인
				onReveal.fieldHawkEyeAbility(2);

				// 상대 대기중 능력 출력
				onReveal.printFieldHawkEyEAbility(2);
				onGoing.printFieldIronManAbility(2, gField.reflectedFieldp2Power);
				onGoing.printFieldThePunisherAbility(2, gField.fieldp1);

				// 위 카드들 필드 아래 카드들 출력
				gField.printFieldTopCard();
				gField.printField(location.loc1, location.loc2, location.loc3);
				gField.printFieldBotCard();

				// 대기중인 능력들 확인
				onReveal.fieldHawkEyeAbility(1);

				// 대기중 능력 출력
				onReveal.printFieldHawkEyEAbility(1);

				onGoing.printFieldIronManAbility(1, gField.reflectedFieldp1Power);
				onGoing.printFieldThePunisherAbility(1, gField.fieldp2);

				System.out.println();
				System.out
						.println("\u001b[1m" + "------------------------플레이어 1------------------------" + "\u001b[0m");
				System.out.println();
				System.out.println("\u001b[1m" + "턴 " + turn + "\u001b[0m");

				Hand p1h = new Hand(p1Hand);
				p1h.printhand();

				// 손패 객체 생성
				p1handsize = p1h.hand.size();
				HandPlay handPlay = new HandPlay();

				Card cardSelected;
				int fieldSelected;
				int input;

				while (true) {

					// %% 낼 카드 숫자로 입력 받기
					// 입력 받은 숫자 반환
					input = handPlay.cardSelect(currentEenergy1p);

					// 턴 종료인지 확인
					if (input == 0) {
						break A;
					}

					// 손 패 범위에 맞는지 확인
					if (!handPlay.handRangeCheck(input, p1handsize)) {
						continue;
					}

					// 선택한 카드 불러오기
					cardSelected = p1h.findIndexCard(input);

					// 카드 에너지 범위에 맞는지 확인
					if (!handPlay.energyRangeCheck(cardSelected)) {
						continue;
					}

					break;

				}

				C: while (true) {

					// 필드 입력 받기
					// 입력 받은 숫자 반환
					fieldSelected = handPlay.selectField();

					// 1~3 사이인지 확인
					if (!handPlay.fieldRangeCheck(fieldSelected)) {
						continue;
					}

					// 필드 꽉 차 있는지 확인
					if (!handPlay.fieldFullCheck(fieldSelected, 1)) {
						System.out.println("필드가 꽉 찼습니다.");
						continue;
					}

					// 볼트 교도소 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (turn == 6 && i == fieldSelected - 1 && theVaultTriger[i]) {
							System.out.println("6턴에는 이 구역에 카드를 낼 수 없습니다.");
							continue C;
						}
					}

					// 축소된 연구소 트리거 확인
					for (int i = 0; i < 3; i++) {
						if ((turn == 3 || turn == 4 || turn == 5) && i == fieldSelected - 1
								&& miniaturizedLabTriger[i]) {
							System.out.println("3, 4, 5턴에는 이 구역에 카드를 낼 수 없습니다.");
							continue C;
						}
					}

					// 크림슨 코스모스 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (crimsonCosmosTriger[i] && i == fieldSelected - 1 && cardSelected.energy > 0
								&& cardSelected.energy < 4) {
							System.out.println("현재 비용 1, 2, 3인 카드는 이 구역에 낼 수 없습니다.");
							continue C;
						}
					}

					// 헬파이어 클럽 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (hellfireClubTriger[i] && i == fieldSelected - 1 && cardSelected.energy == 1) {
							System.out.println("현재 비용이 1인 카드는 이 구역에 낼 수 없습니다.");
							continue C;
						}
					}

					// 빅 하우스 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (theBigHouseTriger[i] && i == fieldSelected - 1 && cardSelected.energy > 3
								&& cardSelected.energy < 7) {
							System.out.println("현재 비용 4, 5, 6인 카드는 이 구역에 낼 수 없습니다.");
							continue C;
						}
					}

					break;
				}

				// 카드와 필드선택 입력하고 필드 리스트에 넣고
				gField.addCardp1(cardSelected, fieldSelected);

				// 낸 카드 큐에 넣음
				cardPlayQueue.get(0).add(cardSelected);
				// 필드 선택지도 저장해야 한다.
				// 필드 선택지 큐
				fieldSelectionQueue.get(0).add(fieldSelected);

				// 현재 에너지 줄이기
				currentEenergy1p -= cardSelected.energy;

				// 낸 카드 핸드에서 제거
				p1h.hand.remove(input - 1);

			}

			TurnEnd.turnEnd();
			turnPriority = 2;

			// ----------------------------------//
			// 플레이어 2

			B: while (true) {

				// 필드 에너지 반영
				// 1p 2p 의 전 턴 필드 에너지 합산
				gField.currentPlayerFieldPower();//

				// %% 화면 출력
				// 필드 출력

				// 대기중인 내, 상대 지속 능력들 반영
				onGoing.fieldIronManAbility(1, GameField.fieldp1Power);
				onGoing.fieldIronManAbility(2, GameField.fieldp2Power);

				// 전턴 그냥필드를 탑과 바텀에 연결해서 빈 필드 출력 준비
				gField.linkPreviousTurnFieldTBField();

				// 지금 플레이하는 플레이어를 아래 필드로
				gField.fieldPositionCheck();

//				// 상대 나 필드 구성 보고 증감 효과 반영
//				onGoing.fieldThePunisherAbility(1, gField.fieldp2);
//				onGoing.fieldThePunisherAbility(2, gField.fieldp1);

				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println();

				// 상대 대기중인 능력들 확인
				onReveal.fieldHawkEyeAbility(1);

				// 내 대기중인 능력들 확인
				onReveal.fieldHawkEyeAbility(2);

				// 내 (2p) 대기중 능력 출력
				onReveal.printFieldHawkEyEAbility(2);
				onGoing.printFieldIronManAbility(2, gField.reflectedFieldp2Power);
				onGoing.printFieldThePunisherAbility(2, gField.fieldp1);

				// 위 카드들 필드 아래 카드들 출력
				gField.printFieldTopCard();
				gField.printField(location.loc1, location.loc2, location.loc3);
				gField.printFieldBotCard();

				// 상대(1p) 대기중 능력 출력
				onReveal.printFieldHawkEyEAbility(1);

				onGoing.printFieldIronManAbility(1, gField.reflectedFieldp1Power);
				onGoing.printFieldThePunisherAbility(1, gField.fieldp2);

				System.out.println();
				System.out.println("------------------------플레이어 2------------------------");
				System.out.println();
				System.out.println("턴 " + turn);

				Hand p2h = new Hand(p2Hand);
				p2h.printhand();

				// 손패 객체 생성
				p2handsize = p2h.hand.size();
				HandPlay handPlay = new HandPlay();

				Card cardSelected;
				int fieldSelected;
				int input;

				while (true) {

					// %% 낼 카드 숫자로 입력 받기
					// 입력 받은 숫자 반환
					input = handPlay.cardSelect(currentEenergy2p);

					// 턴 종료인지 확인
					if (input == 0) {
						break B;
					}

					// 손 패 범위에 맞는지 확인
					if (!handPlay.handRangeCheck(input, p2handsize)) {
						continue;
					}

					// 선택한 카드 불러오기
					cardSelected = p2h.findIndexCard(input);

					// 카드 에너지 범위에 맞는지 확인
					if (!handPlay.energyRangeCheck(cardSelected)) {
						continue;
					}

					break;

				}

				D: while (true) {

					// 필드 입력 받기
					// 입력 받은 숫자 반환
					fieldSelected = handPlay.selectField();

					// 1~3 사이인지 확인
					if (!handPlay.fieldRangeCheck(fieldSelected)) {
						continue;
					}

					// 필드 꽉 차 있는지 확인
					if (!handPlay.fieldFullCheck(fieldSelected, 2)) {
						System.out.println("필드가 꽉 찼습니다.");
						continue;
					}

					// 볼트 교도소 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (turn == 6 && i == fieldSelected - 1 && theVaultTriger[i]) {
							System.out.println("6턴에는 이 구역에 카드를 낼 수 없습니다.");
							continue D;
						}
					}

					// 축소된 연구소 트리거 확인
					for (int i = 0; i < 3; i++) {
						if ((turn == 3 || turn == 4 || turn == 5) && i == fieldSelected - 1
								&& miniaturizedLabTriger[i]) {
							System.out.println("3, 4, 5턴에는 이 구역에 카드를 낼 수 없습니다.");
							continue D;
						}
					}

					// 크림슨 코스모스 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (crimsonCosmosTriger[i] && i == fieldSelected - 1 && cardSelected.energy > 0
								&& cardSelected.energy < 4) {
							System.out.println("현재 에너지가 1,2,3인 카드는 이 구역에 낼 수 없습니다.");
							continue D;
						}
					}

					// 헬파이어 클럽 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (hellfireClubTriger[i] && i == fieldSelected - 1 && cardSelected.energy == 1) {
							System.out.println("현재 비용이 1인 카드는 이 구역에 낼 수 없습니다.");
							continue D;
						}
					}

					// 빅 하우스 트리거 확인
					for (int i = 0; i < 3; i++) {
						if (theBigHouseTriger[i] && i == fieldSelected - 1 && cardSelected.energy > 3
								&& cardSelected.energy < 7) {
							System.out.println("현재 비용 4, 5, 6인 카드는 이 구역에 낼 수 없습니다.");
							continue D;
						}
					}

					break;
				}

				// 카드와 필드선택 입력하고 필드 리스트에 넣고
				gField.addCardp2(cardSelected, fieldSelected);

				// 낸 카드 큐에 넣음
				cardPlayQueue.get(1).add(cardSelected);

				// 필드 선택지 큐
				fieldSelectionQueue.get(1).add(fieldSelected);

				// 현재 에너지 줄이기
				currentEenergy2p -= cardSelected.energy;

				// 낸 카드 핸드에서 제거
				p2h.hand.remove(input - 1);

			}

			// ============================================================
			//
			//
			// 1p 2p 낸 다음 공개 파트
			//
			// =============================================================

			// 턴 권한 1p로
			turnPriority = 1;

			// 누가 먼저 공개할지 체크
			// 이기고 있는 필드 체크
			// 턴 시작 시 필드로 체크한다.

			int revealPriority = 3;
			revealPriority = superiority();

			// ===== 큐에서 하나씩 뽑아서 공개 (= 효과 발동)
			// 0. 필드 연결 다시
			// 1. 탑 필드 바텀 필드 전 턴 걸로 즉 field 로 초기화
			// 2. 필드 카드리스트 출력
			// 3. 필드 파워도 재연동 후 출력

			// 0. 탑필드 바텀 필드 뉴해서
			gField.fieldTop = new ArrayList<List<Card>>();
			gField.fieldBot = new ArrayList<List<Card>>();

			// 1. 2p 전 턴 필드를 탑으로 1p 전 턴 필드가 아래로
			// 탑은 필드2 봇은 필드1 복사
			gField.fieldTopBotReorder();

			// 필드 상위 하위 연결
			gField.fieldReady();

			// 필드 파워 초기화

			for (int i = 0; i < gField.fieldTopPower.length; i++) {
				gField.fieldTopPower[i] = 0;
			}

			for (int i = 0; i < gField.fieldBotPower.length; i++) {
				gField.fieldBotPower[i] = 0;

			}

			// 카드 파워 증감 효과 반영
			onGoing.fieldThePunisherAbility(1, gField.fieldp2);
			onGoing.fieldThePunisherAbility(2, gField.fieldp1);

			// 전 턴 필드 상황에서 이번 턴 카드 효과가 없는 상태로 파워 합산, 반영하기
			gField.revealStepFieldPower();

			// 필드 에너지에 영향을 주는 효과 반영
			// 지속 효과 반영
			onGoing.fieldIronManAbility(1, gField.fieldBotPower);
			onGoing.fieldIronManAbility(2, gField.fieldTopPower);

			// 전 턴 화면 출력
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			gField.printFieldTopCard();
			gField.printField(location.loc1, location.loc2, location.loc3);
			gField.printFieldBotCard();

			System.out.println("카드를 공개합니다. (엔터)");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 하나씩 카드를 공개하고 출력에 반영

			// 1p 먼저 공개
			if (revealPriority >= 0) {

				for (int i = 0; i < fieldSelectionQueue1.size(); i++) {

					// 바텀 필드에 넣기
					gField.addCard(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), gField.fieldBot);

					System.out.println();
					System.out.println("플레이어 1 의 카드 " + cardPlayQueue1.get(i).name + "(을)를 "
							+ fieldSelectionQueue1.get(i) + " 번 필드에 냅니다.");
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// ----출현 트리거 체크----
					onReveal.hawkEyeOnRevealCheck(fieldSelectionQueue1.get(i), 1);
					// 전에 켜진 트리거를 발동시키는지 확인

					// 노웨어 트리거가 켜져 있으면 출현 발동 X
					A: while (true) {
						for (int j = 0; j < 3; j++) {
							if (knowhereTriger[j] && j == fieldSelectionQueue1.get(i) - 1) {
								break A;
							}
						}

						onReveal.OnRevealCheck1(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), 1);
						// 내 출현 트리거 확인
						break;

					}

					onGoing.onGoingCheck1(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), 1);
					// 지속 트리거 체크

					// 카드 파워 증감 효과 계산
					// 지속 효과 계산
					onGoing.fieldThePunisherAbility(1, gField.fieldTop);
					onGoing.fieldThePunisherAbility(2, gField.fieldBot);

					// 필드 파워에 합산, 반영하기
					gField.revealStepFieldPower();

					// 필드 파워 증감 계산
					// 아이언맨 효과 계산
					onGoing.fieldIronManAbility(1, gField.fieldBotPower);
					onGoing.fieldIronManAbility(2, gField.fieldTopPower);

					// 필드로 화면 출력
					gField.printFieldTopCard();
					gField.printField(location.loc1, location.loc2, location.loc3);
					gField.printFieldBotCard();

					System.out.println("카드를 공개합니다. (엔터)");
					sc.nextLine();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				for (int i = 0; i < fieldSelectionQueue2.size(); i++) {

					// 이제 2p 차례

					// 탑 필드에 넣기
					gField.addCard(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), gField.fieldTop);

					System.out.println();
					System.out.println("플레이어 2 의 카드 " + cardPlayQueue2.get(i).name + "(을)를 "
							+ fieldSelectionQueue2.get(i) + " 번 필드에 냅니다.");
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// ----출현 트리거 체크----
					onReveal.hawkEyeOnRevealCheck(fieldSelectionQueue2.get(i), 2);
					// 전에 켜진 트리거를 발동시키는지 확인

					// 노웨어 트리거가 켜져 있으면 출현 발동 X
					A: while (true) {
						for (int j = 0; j < 3; j++) {
							if (knowhereTriger[j] && j == fieldSelectionQueue2.get(i) - 1) {
								break A;
							}
						}

						onReveal.OnRevealCheck2(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), 2);
						// 출현 트리거 확인
						break;
					}

					onGoing.onGoingCheck2(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), 2);
					// 지속 트리거 체크

					// 카드 파워 증감 효과 계산
					// 지속 효과 계산
					onGoing.fieldThePunisherAbility(1, gField.fieldTop);
					onGoing.fieldThePunisherAbility(2, gField.fieldBot);

					// 필드 파워에 합산, 반영하기
					gField.revealStepFieldPower();

					// 필드 증감 효과 반영
					// 지속 카드 효과 반영
					onGoing.fieldIronManAbility(1, gField.fieldBotPower);
					onGoing.fieldIronManAbility(2, gField.fieldTopPower);

					// 필드로 화면 출력
					gField.printFieldTopCard();
					gField.printField(location.loc1, location.loc2, location.loc3);
					gField.printFieldBotCard();

					System.out.println("카드를 공개합니다. (엔터)");
					sc.nextLine();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} else if (revealPriority == -1) {

				// 2p 먼저 공개

				for (int i = 0; i < fieldSelectionQueue2.size(); i++) {

					// 탑에 카드 추가
					gField.addCard(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), gField.fieldTop);

					System.out.println();
					System.out.println("플레이어 2 의 카드 " + cardPlayQueue2.get(i).name + "(을)를 "
							+ fieldSelectionQueue2.get(i) + " 번 필드에 냅니다.");
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// ----출현 트리거 체크----
					onReveal.hawkEyeOnRevealCheck(fieldSelectionQueue2.get(i), 2);
					// 전에 켜진 트리거를 발동시키는지 확인

					// 노웨어 트리거가 켜져 있으면 출현 발동 X
					A: while (true) {
						for (int j = 0; j < 3; j++) {
							if (knowhereTriger[j] && j == fieldSelectionQueue2.get(i) - 1) {
								break A;
							}
						}

						onReveal.OnRevealCheck2(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), 2);
						// 내 출현 트리거 확인
						break;

					}
					onGoing.onGoingCheck2(cardPlayQueue2.get(i), fieldSelectionQueue2.get(i), 2);
					// 지속 트리거 체크

					// 카드 파워 증감 효과 계산
					// 지속 효과 계산
					onGoing.fieldThePunisherAbility(1, gField.fieldTop);
					onGoing.fieldThePunisherAbility(2, gField.fieldBot);

					// 필드 파워에 합산, 반영하기
					gField.revealStepFieldPower();

					// 필드 증감 효과 계산
					// 카드 지속 효과 반영
					onGoing.fieldIronManAbility(1, gField.fieldBotPower);
					onGoing.fieldIronManAbility(2, gField.fieldTopPower);

					// 필드로 화면 출력
					gField.printFieldTopCard();
					gField.printField(location.loc1, location.loc2, location.loc3);
					gField.printFieldBotCard();

					System.out.println("카드를 공개합니다. (엔터)");
					sc.nextLine();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				// 이제 1p 차례
				for (int i = 0; i < fieldSelectionQueue1.size(); i++) {

					// 봇에 카드 추가
					gField.addCard(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), gField.fieldBot);

					System.out.println();
					System.out.println("플레이어 1 의 카드 " + cardPlayQueue1.get(i).name + "(을)를 "
							+ fieldSelectionQueue1.get(i) + " 번 필드에 냅니다.");
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// ----출현 트리거 체크----
					onReveal.hawkEyeOnRevealCheck(fieldSelectionQueue1.get(i), 1);
					// 전에 켜진 트리거를 발동시키는지 확인

					// 노웨어 트리거가 켜져 있으면 출현 발동 X
					A: while (true) {
						for (int j = 0; j < 3; j++) {

							if (knowhereTriger[j] && j == fieldSelectionQueue1.get(i) - 1) {
								break A;
							}
						}

						onReveal.OnRevealCheck1(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), 1);
						// 출현 트리거 확인
						break;
					}
					onGoing.onGoingCheck1(cardPlayQueue1.get(i), fieldSelectionQueue1.get(i), 1);
					// 지속 트리거 체크

					// 카드 파워 증감 효과 계산
					// 지속 효과 계산
					onGoing.fieldThePunisherAbility(1, gField.fieldTop);
					onGoing.fieldThePunisherAbility(2, gField.fieldBot);

					// 필드 파워에 합산, 반영하기
					gField.revealStepFieldPower();

					// 필드 증감 효과 반영
					// 카드 지속 효과 반영
					onGoing.fieldIronManAbility(1, gField.fieldBotPower);
					onGoing.fieldIronManAbility(2, gField.fieldTopPower);

					// 필드로 화면 출력
					gField.printFieldTopCard();
					gField.printField(location.loc1, location.loc2, location.loc3);
					gField.printFieldBotCard();

					System.out.println("카드를 공개합니다. (엔터)");
					sc.nextLine();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

			// 큐 비우기
			for (List<Card> queue : cardPlayQueue) {
				queue.clear();
			}
			for (List<Integer> queue : fieldSelectionQueue) {
				queue.clear();
			}

			// 필드 복제해서 동기화
			gField.fieldSynchronize();

			// 턴 종료 시 게임 종료인지 확인
			// TVA 트리거부터 확인
			if (tvaTriger && turn == 4 || turn == maxTurn) {
				System.out.println("게임 종료");

				int winLose = gameResult(gField.fieldBotPower, gField.fieldTopPower);

				if (winLose == 1) {
					System.out.println("플레이어 1 승리!");
				} else if (winLose == -1) {
					System.out.println("플레이어 2 승리!");
				} else {
					System.out.println("무승부!");
				}

				System.out.println("엔터를 입력하면 종료합니다.");
				String in = sc.nextLine();
				System.out.println(in);
				sc.close();

			} else {
				TurnEnd.turnEnd();
				// 턴 출력 위아래 트리거 변경
				// turnPriority = 1;
			}

		}

	}

	private static int superiority() {
		int fieldVictoryCounter[] = new int[3];

		for (int i = 0; i < 3; i++) {

			if (GameField.fieldp1Power[i] > GameField.fieldp2Power[i]) {
				fieldVictoryCounter[i] = 1;
			} else if (GameField.fieldp1Power[i] < GameField.fieldp2Power[i]) {
				fieldVictoryCounter[i] = -1;
			} else {
				fieldVictoryCounter[i] = 0;
			}
		}
		int victorySum = 0;
		for (int i : fieldVictoryCounter) {
			victorySum += i;
		}
		if (victorySum > 0) {
			return 1;
		} else if (victorySum < 0) {
			return -1;
		} else {
			int p1FieldPowerSum = 0;
			int p2FieldPowerSum = 0;

			for (int i : GameField.fieldp1Power) {
				p1FieldPowerSum += i;
			}
			for (int i : GameField.fieldp2Power) {
				p2FieldPowerSum += i;
			}

			if (p1FieldPowerSum > p2FieldPowerSum) {
				return 1;
			} else if (p1FieldPowerSum < p2FieldPowerSum) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	private static int gameResult(int[] fieldBotPower, int[] fieldTopPower) {
		int fieldVictoryCounter[] = new int[3];

		for (int i = 0; i < 3; i++) {

			if (fieldBotPower[i] > fieldTopPower[i]) {
				fieldVictoryCounter[i] = 1;
			} else if (fieldBotPower[i] < fieldTopPower[i]) {
				fieldVictoryCounter[i] = -1;
			} else {
				fieldVictoryCounter[i] = 0;
			}
		}
		int victorySum = 0;
		for (int i : fieldVictoryCounter) {
			victorySum += i;
		}
		if (victorySum > 0) {
			return 1;
		} else if (victorySum < 0) {
			return -1;
		} else {
			int p1FieldPowerSum = 0;
			int p2FieldPowerSum = 0;

			for (int i : fieldBotPower) {
				p1FieldPowerSum += i;
			}
			for (int i : fieldTopPower) {
				p2FieldPowerSum += i;
			}

			if (p1FieldPowerSum > p2FieldPowerSum) {
				return 1;
			} else if (p1FieldPowerSum < p2FieldPowerSum) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
