package com.naver.ryuuzakiumi.marblesnap;

import java.util.List;

class Search {

	static Card handSearch(List<Card> hand, String cardName) {

		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).name.equals(cardName)) {
				return hand.get(i);
			}
		}
		return null;
	}

	static Card fieldSearch(int p, String cardName) {

		// 모든 필드를 뒤져서 찾아서 리턴

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < GameField.reflectedField.get(p - 1).get(i).size(); j++) {
				if (GameField.reflectedField.get(p - 1).get(i).get(j).name.equals(cardName)) {
					return GameField.reflectedField.get(p - 1).get(i).get(j);
				}
			}
		}
		return null;
	}

	static Card reflectedfieldSearch(int p, String cardName) {

		// 모든 필드를 뒤져서 찾아서 리턴

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < GameField.field.get(p - 1).get(i).size(); j++) {
				if (GameField.field.get(p - 1).get(i).get(j).name.equals(cardName)) {
					return GameField.field.get(p - 1).get(i).get(j);
				}
			}
		}
		return null;
	}
}