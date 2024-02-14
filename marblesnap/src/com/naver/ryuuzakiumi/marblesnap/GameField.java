package com.naver.ryuuzakiumi.marblesnap;

import java.util.ArrayList;
import java.util.List;

public class GameField {

	int fieldTopPower[] = { 0, 0, 0 };
	int fieldBotPower[] = { 0, 0, 0 };
	static int fieldp1Power[] = { 0, 0, 0 };
	static int fieldp2Power[] = { 0, 0, 0 };

	static List<Card> field1p1 = new ArrayList<Card>();
	static List<Card> field2p1 = new ArrayList<Card>();
	static List<Card> field3p1 = new ArrayList<Card>();
	List<List<Card>> fieldp1 = new ArrayList<List<Card>>();

	static List<Card> field1p2 = new ArrayList<Card>();
	static List<Card> field2p2 = new ArrayList<Card>();
	static List<Card> field3p2 = new ArrayList<Card>();
	List<List<Card>> fieldp2 = new ArrayList<List<Card>>();

	static List<List<List<Card>>> field = new ArrayList<List<List<Card>>>();

	static List<Card> reflectedField1p1 = new ArrayList<Card>();
	static List<Card> reflectedField2p1 = new ArrayList<Card>();
	static List<Card> reflectedField3p1 = new ArrayList<Card>();
	static List<List<Card>> reflectedFieldp1 = new ArrayList<List<Card>>();

	static List<Card> reflectedField1p2 = new ArrayList<Card>();
	static List<Card> reflectedField2p2 = new ArrayList<Card>();
	static List<Card> reflectedField3p2 = new ArrayList<Card>();
	static List<List<Card>> reflectedFieldp2 = new ArrayList<List<Card>>();

	static List<List<List<Card>>> reflectedField = new ArrayList<List<List<Card>>>();

	int reflectedFieldp1Power[] = { 0, 0, 0 };
	int reflectedFieldp2Power[] = { 0, 0, 0 };

	void fieldReady() {
		fieldp1.add(field1p1);
		fieldp1.add(field2p1);
		fieldp1.add(field3p1);

		fieldp2.add(field1p2);
		fieldp2.add(field2p2);
		fieldp2.add(field3p2);

		field.add(fieldp1);
		field.add(fieldp2);

		reflectedFieldp1.add(reflectedField1p1);
		reflectedFieldp1.add(reflectedField2p1);
		reflectedFieldp1.add(reflectedField3p1);

		reflectedFieldp2.add(reflectedField1p2);
		reflectedFieldp2.add(reflectedField2p2);
		reflectedFieldp2.add(reflectedField3p2);

		reflectedField.add(reflectedFieldp1);
		reflectedField.add(reflectedFieldp2);

		fieldTop.add(field1Top);
		fieldTop.add(field2Top);
		fieldTop.add(field3Top);

		fieldBot.add(field1Bot);
		fieldBot.add(field2Bot);
		fieldBot.add(field3Bot);

	}

	List<Card> field1Top = new ArrayList<Card>();
	List<Card> field2Top = new ArrayList<Card>();
	List<Card> field3Top = new ArrayList<Card>();

	List<List<Card>> fieldTop = new ArrayList<List<Card>>();

	List<Card> field1Bot = new ArrayList<Card>();
	List<Card> field2Bot = new ArrayList<Card>();
	List<Card> field3Bot = new ArrayList<Card>();

	List<List<Card>> fieldBot = new ArrayList<List<Card>>();

	void printField(Location loc1, Location loc2, Location loc3) {
		System.out.print("┏━━━━━━━━");
		System.out.printf("%2d", fieldTopPower[0]);
		System.out.print("━━━━━━━━");
		System.out.print("┳━━━━━━━━");
		System.out.printf("%2d", fieldTopPower[1]);
		System.out.print("━━━━━━━━");
		System.out.print("┳━━━━━━━━");
		System.out.printf("%2d", fieldTopPower[2]);
		System.out.println("━━━━━━━━┓");

		// 6줄 출력
		System.out.print("┃");
		System.out.printf(loc1.txt1);
		System.out.print("┃");
		System.out.printf(loc2.txt1);
		System.out.print("┃");
		System.out.printf(loc3.txt1);
		System.out.println("┃");

		System.out.print("┃");
		System.out.printf(loc1.txt2);
		System.out.print("┃");
		System.out.printf(loc2.txt2);
		System.out.print("┃");
		System.out.printf(loc3.txt2);
		System.out.println("┃");

		System.out.print("┃");
		System.out.printf(loc1.txt3);
		System.out.print("┃");
		System.out.printf(loc2.txt3);
		System.out.print("┃");
		System.out.printf(loc3.txt3);
		System.out.println("┃");

		System.out.print("┃");
		System.out.printf(loc1.txt4);
		System.out.print("┃");
		System.out.printf(loc2.txt4);
		System.out.print("┃");
		System.out.printf(loc3.txt4);
		System.out.println("┃");

		System.out.print("┃");
		System.out.printf(loc1.txt5);
		System.out.print("┃");
		System.out.printf(loc2.txt5);
		System.out.print("┃");
		System.out.printf(loc3.txt5);
		System.out.println("┃");

		System.out.print("┃");
		System.out.printf(loc1.txt6);
		System.out.print("┃");
		System.out.printf(loc2.txt6);
		System.out.print("┃");
		System.out.printf(loc3.txt6);
		System.out.println("┃");

		System.out.print("┗━━━━━━━━");
		System.out.printf("%2d", fieldBotPower[0]);
		System.out.print("━━━━━━━━");
		System.out.print("┻━━━━━━━━");
		System.out.printf("%2d", fieldBotPower[1]);
		System.out.print("━━━━━━━━");
		System.out.print("┻━━━━━━━━");
		System.out.printf("%2d", fieldBotPower[2]);
		System.out.println("━━━━━━━━┛");
	}

	void fieldPositionCheck() {

//		fieldBot = new ArrayList<List<Card>>();
//		fieldTop = new ArrayList<List<Card>>();

		if (Play.turnPriority == 1) {

			field1Bot = new ArrayList<Card>(reflectedField1p1);
			field2Bot = new ArrayList<Card>(reflectedField2p1);
			field3Bot = new ArrayList<Card>(reflectedField3p1);

			field1Top = new ArrayList<Card>(field1p2);
			field2Top = new ArrayList<Card>(field2p2);
			field3Top = new ArrayList<Card>(field3p2);

		} else if (Play.turnPriority == 2) {

			field1Bot = new ArrayList<Card>(field1p1);
			field2Bot = new ArrayList<Card>(field2p1);
			field3Bot = new ArrayList<Card>(field3p1);

			field1Top = new ArrayList<Card>(reflectedField1p2);
			field2Top = new ArrayList<Card>(reflectedField2p2);
			field3Top = new ArrayList<Card>(reflectedField3p2);
		}

		fieldTop.add(field1Top);
		fieldTop.add(field2Top);
		fieldTop.add(field3Top);

		fieldBot.add(field1Bot);
		fieldBot.add(field2Bot);
		fieldBot.add(field3Bot);

	}

	void fieldTopBotReorder() {
		
		// 그냥 필드 2p는 탑에 1p는 아래에 복사해서 넣기
		field1Top = new ArrayList<Card>(field1p2);
		field2Top = new ArrayList<Card>(field2p2);
		field3Top = new ArrayList<Card>(field3p2);

		field1Bot = new ArrayList<Card>(field1p1);
		field2Bot = new ArrayList<Card>(field2p1);
		field3Bot = new ArrayList<Card>(field3p1);

	}

	void printFieldBotCard() {

		int field1BotSize = field1Bot.size();
		int field2BotSize = field2Bot.size();
		int field3BotSize = field3Bot.size();

		Card row1[] = new Card[3];
		Card row2[] = new Card[3];
		Card row3[] = new Card[3];
		Card row4[] = new Card[3];

		Card nullCard = new Card();

		// 널카드로 초기화
		for (int i = 0; i < 3; i++) {
			row1[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row2[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row3[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row4[i] = nullCard;
		}

		switch (field1BotSize) {
		case 4:
			row4[0] = field1Bot.get(3);
		case 3:
			row3[0] = field1Bot.get(2);
		case 2:
			row2[0] = field1Bot.get(1);
		case 1:
			row1[0] = field1Bot.get(0);
		default:
			break;
		}

		switch (field2BotSize) {
		case 4:
			row4[1] = field2Bot.get(3);
		case 3:
			row3[1] = field2Bot.get(2);
		case 2:
			row2[1] = field2Bot.get(1);
		case 1:
			row1[1] = field2Bot.get(0);
		default:
			break;
		}

		switch (field3BotSize) {
		case 4:
			row4[2] = field3Bot.get(3);
		case 3:
			row3[2] = field3Bot.get(2);
		case 2:
			row2[2] = field3Bot.get(1);
		case 1:
			row1[2] = field3Bot.get(0);
		default:
			break;
		}
		
		//바텀 카드 출력부
		
		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row1[i].name);
			if (row1[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row1[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row2[i].name);
			if (row2[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row2[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row3[i].name);
			if (row3[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row3[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row4[i].name);
			if (row4[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row4[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
	}

	void printFieldTopCard() {

		int field1TopSize = field1Top.size();
		int field2TopSize = field2Top.size();
		int field3TopSize = field3Top.size();

		Card row1[] = new Card[3];
		Card row2[] = new Card[3];
		Card row3[] = new Card[3];
		Card row4[] = new Card[3];

		Card nullCard = new Card();

		// 널카드로 초기화
		for (int i = 0; i < 3; i++) {
			row1[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row2[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row3[i] = nullCard;
		}
		for (int i = 0; i < 3; i++) {
			row4[i] = nullCard;
		}

		switch (field1TopSize) {
		case 4:
			row4[0] = field1Top.get(3);
		case 3:
			row3[0] = field1Top.get(2);
		case 2:
			row2[0] = field1Top.get(1);
		case 1:
			row1[0] = field1Top.get(0);
		default:
			break;
		}

		switch (field2TopSize) {
		case 4:
			row4[1] = field2Top.get(3);
		case 3:
			row3[1] = field2Top.get(2);
		case 2:
			row2[1] = field2Top.get(1);
		case 1:
			row1[1] = field2Top.get(0);
		default:
			break;
		}

		switch (field3TopSize) {
		case 4:
			row4[2] = field3Top.get(3);
		case 3:
			row3[2] = field3Top.get(2);
		case 2:
			row2[2] = field3Top.get(1);
		case 1:
			row1[2] = field3Top.get(0);
		default:
			break;
		}
		
		//탑 카드 출력부
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row4[i].name);
			if (row4[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row4[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row3[i].name);
			if (row3[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row3[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row2[i].name);
			if (row2[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row2[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println(" ");

		for (int i = 0; i < 3; i++) {
			System.out.print("[");
			System.out.printf("%14s", row1[i].name);
			if (row1[i].fieldExistance == false) {
				System.out.print("   ");
			} else {
				System.out.printf("%3d", row1[i].currentPower);
			}
			System.out.print("]");
		}
		System.out.println();
	}

	void currentPlayerFieldPower() {

		// 0으로 초기화
		for (int i = 0; i < fieldp1Power.length; i++) {
			fieldp1Power[i] = 0;
		}
		for (int i = 0; i < fieldp2Power.length; i++) {
			fieldp2Power[i] = 0;
		}

		// 구역별 파워 합산

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < fieldp1.get(i).size(); j++) {
				fieldp1Power[i] += fieldp1.get(i).get(j).currentPower;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < fieldp2.get(i).size(); j++) {
				fieldp2Power[i] += fieldp2.get(i).get(j).currentPower;
			}
		}
	}

	void linkPreviousTurnFieldTBField() {

		fieldBotPower = fieldp1Power.clone();
		fieldTopPower = fieldp2Power.clone();

	}

	void revealStepFieldPower() {
		// 0으로 초기화
		for (int i = 0; i < fieldTopPower.length; i++) {
			fieldTopPower[i] = 0;
		}

		// 구역별 파워 합산
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < fieldTop.get(i).size(); j++) {
				fieldTopPower[i] += fieldTop.get(i).get(j).currentPower;
//				System.out.println("탑 필드 합산 : " + fieldTop.get(i).get(j));
			}
		}

		// 0으로 초기화
		for (int i = 0; i < fieldBotPower.length; i++) {
			fieldBotPower[i] = 0;
		}

		// 구역별 파워 합산
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < fieldBot.get(i).size(); j++) {
				fieldBotPower[i] += fieldBot.get(i).get(j).currentPower;
			}

		}

	}

	void addCardp1(Card card, int fieldIndex) {

		// 낸 카드 필드 리스트에 추가
		if (fieldIndex == 1) {
			reflectedField1p1.add(card);
		} else if (fieldIndex == 2) {
			reflectedField2p1.add(card);
		} else {
			reflectedField3p1.add(card);
		}
		// 필드 존재 트리거 켜기
		card.fieldExistance = true;

	}

	void addCard(Card card, int fieldIndex, List<List<Card>> field) {

		// 낸 카드 필드 리스트에 추가
		if (fieldIndex == 1) {
			field.get(0).add(card);
		} else if (fieldIndex == 2) {
			field.get(1).add(card);
		} else {
			field.get(2).add(card);
		}
		// 필드 존재 트리거 켜기
		card.fieldExistance = true;

	}

	void addCardp2(Card card, int fieldIndex) {

		// 낸 카드 필드 리스트에 추가
		if (fieldIndex == 1) {
			reflectedField1p2.add(card);
		} else if (fieldIndex == 2) {
			reflectedField2p2.add(card);
		} else {
			reflectedField3p2.add(card);
		}
		// 필드 존재 트리거 켜기
		card.fieldExistance = true;

	}

	public void fieldSynchronize() {

		// 리스트 복사

		// 깊은 복사
		field1p1 = new ArrayList<Card>();
		field2p1 = new ArrayList<Card>();
		field3p1 = new ArrayList<Card>();

		field1p2 = new ArrayList<Card>();
		field2p2 = new ArrayList<Card>();
		field3p2 = new ArrayList<Card>();

		for (Card card : reflectedField1p1) {
			field1p1.add(card);
		}
		for (Card card : reflectedField2p1) {
			field2p1.add(card);
		}
		for (Card card : reflectedField3p1) {
			field3p1.add(card);
		}

		for (Card card : reflectedField1p2) {
			field1p2.add(card);
		}
		for (Card card : reflectedField2p2) {
			field2p2.add(card);
		}
		for (Card card : reflectedField3p2) {
			field3p2.add(card);
		}

		field = new ArrayList<List<List<Card>>>();

		fieldp1 = new ArrayList<List<Card>>();
		fieldp2 = new ArrayList<List<Card>>();

		fieldp1.add(field1p1);
		fieldp1.add(field2p1);
		fieldp1.add(field3p1);

		fieldp2.add(field1p2);
		fieldp2.add(field2p2);
		fieldp2.add(field3p2);

		field.add(fieldp1);
		field.add(fieldp2);

	}

}
