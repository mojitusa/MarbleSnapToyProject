package com.naver.ryuuzakiumi.marblesnap.cards;

import com.naver.ryuuzakiumi.marblesnap.Card;

public class Abomination extends Card {

	public Abomination(String name, int energy, int power, int currentPower, String ability, String txt, int ownerPlayer, int duplicationNumber) {
		super(name, energy, power, currentPower, ability, txt, ownerPlayer, duplicationNumber);

		this.name = name;
		this.energy = energy;
		this.power = power;
		this.ability = ability;
		this.txt = txt;
		this.ownerPlayer = ownerPlayer;
	}

	public String name = "ABOMINATION";
	public int energy = 5;
	public int power = 9;
	public String ability = null;
	public String txt = "\"멍청한 놈들! 나한테는 안 되지!\"";

}
