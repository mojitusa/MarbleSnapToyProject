package com.naver.ryuuzakiumi.marblesnap;

import java.util.ArrayList;
import java.util.List;

class Hand {

	List<Card> hand = new ArrayList<Card>();

	public Hand(List<Card> hand) {
		this.hand = hand;
	}

	void printhand() {

		System.out.println("");
		for (int i = 0; i < hand.size(); i++) {

			System.out.print(i + 1 + ". ");
			System.out.printf("%15s", hand.get(i).name + " | ");
			System.out.print("에너지 : " + hand.get(i).energy + " | ");
			System.out.print("파워 : ");
			System.out.printf("%5s", hand.get(i).power + " | ");
			System.out.println(hand.get(i).txt);

		}

	}

	Card findIndexCard(int index) {
		return hand.get(index - 1);
	}
}