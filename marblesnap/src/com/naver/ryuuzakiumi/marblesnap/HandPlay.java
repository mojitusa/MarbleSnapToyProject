package com.naver.ryuuzakiumi.marblesnap;

import java.util.Scanner;

class HandPlay {

	int currentEnergy;
	Scanner scanner = new Scanner(System.in);

	int cardSelect(int currentEnergy) {
		A: while (true) {
			this.currentEnergy = currentEnergy;
			System.out.println();
			System.out.println("어느 카드를 내시겠습니까? 숫자를 입력하세요. 턴 종료 : 0");
			System.out.println();
			System.out.println("\u001b[1m" + "현재 에너지 : " + this.currentEnergy + "\u001b[0m");
			System.out.println();
			System.out.print("입력 : ");
			

			if (!scanner.hasNextInt()) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				scanner.nextLine();
				continue A;
			}

			int input = scanner.nextInt();
			return input;
		}
	}

	boolean handRangeCheck(int input, int handsize) {

		// 손패 범위 확인
		if (input < 0 || input > handsize) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			return false;
		}
		return true;

	}

	boolean energyRangeCheck(Card card) {

		// 입력 값으로 카드의 에너지 찾기
		int cardEnergy = card.energy;

		// 에너지 범위 확인
		if (cardEnergy > this.currentEnergy) {
			System.out.println("에너지가 부족합니다. 다시 입력하세요.");
			return false;
		}
		return true;
	}

	int selectField() {

		// 필드 선택
		A: while (true) {
			System.out.println();
			System.out.println("어느 필드에 내시겠습니까? (1-3)");
			System.out.print("입력 : ");

			if (!scanner.hasNextInt()) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				scanner.nextLine();
				continue A;
			}
			int input = scanner.nextInt();
			return input;
		}
	}

	boolean fieldRangeCheck(int input) {

		if (input < 1 || input > 3) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			return false;
		}
		return true;
	}

	boolean fieldFullCheck(int fieldSelected, int p) {

		if (p == 1) {

			switch (fieldSelected) {
			case 1:
				if (GameField.reflectedFieldp1.get(0).size() < 4) {
					return true;
				} else {
					return false;
				}
			case 2:
				if (GameField.reflectedFieldp1.get(1).size() < 4) {
					return true;
				} else {
					return false;
				}
			case 3:
				if (GameField.reflectedFieldp1.get(2).size() < 4) {
					return true;
				} else {
					return false;
				}
			default: {
				return false;
			}

			}
		} else if (p == 2) {

			switch (fieldSelected) {
			case 1:
				if (GameField.reflectedFieldp2.get(0).size() < 4) {
					return true;
				} else {
					return false;
				}
			case 2:
				if (GameField.reflectedFieldp2.get(1).size() < 4) {
					return true;
				} else {
					return false;
				}
			case 3:
				if (GameField.reflectedFieldp2.get(2).size() < 4) {
					return true;
				} else {
					return false;
				}
			default: {
				return false;
			}

			}

		}
		return false;
	}
}
