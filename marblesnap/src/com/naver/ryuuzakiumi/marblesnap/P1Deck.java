package com.naver.ryuuzakiumi.marblesnap;

import java.util.ArrayList;
import java.util.List;

import com.naver.ryuuzakiumi.marblesnap.cards.Abomination;
import com.naver.ryuuzakiumi.marblesnap.cards.Cyclops;
import com.naver.ryuuzakiumi.marblesnap.cards.HawkEye;
import com.naver.ryuuzakiumi.marblesnap.cards.Hulk;
import com.naver.ryuuzakiumi.marblesnap.cards.IronMan;
import com.naver.ryuuzakiumi.marblesnap.cards.Medusa;
import com.naver.ryuuzakiumi.marblesnap.cards.MistyKnight;
import com.naver.ryuuzakiumi.marblesnap.cards.Quicksilver;
import com.naver.ryuuzakiumi.marblesnap.cards.Shocker;
import com.naver.ryuuzakiumi.marblesnap.cards.StarLord;
import com.naver.ryuuzakiumi.marblesnap.cards.ThePunisher;
import com.naver.ryuuzakiumi.marblesnap.cards.TheThing;

public class P1Deck {

	public List<Card> p1Deck = new ArrayList<>();
	
	Abomination abomination = new Abomination("ABOMINATION", 5, 9, 9, null, "\"멍청한 놈들! 나한테는 안 되지!\"", 1, 0);
	Cyclops	cyclops = new Cyclops("CYCLOPS", 3, 4, 4, null, "\"가자, 엑스맨.\"", 1, 0);
	HawkEye hawkEye = new HawkEye("HAWK EYE", 1, 1, 1, "onReveal", "\u001b[1m" + "출현" + "\u001b[0m" + ": 다음 턴에 내가 이 구역에 카드를 낼 경우, +3 파워를 부여합니다.", 1, 0);
	Hulk hulk = new Hulk("HULK", 6, 12, 12, null, "\"헐크 스매시!\"", 1, 0);
	IronMan ironMan = new IronMan("IRON MAN", 5, 0, 0, "onGoing",  "\u001b[1m" + "지속" + "\u001b[0m" + ": 이곳의 내 전체 파워가 두 배로 증가합니다.", 1, 0);
	Medusa medusa = new Medusa("MEDUSA", 2, 2, 2, "onReveal", "\u001b[1m" + "출현" + "\u001b[0m" + ": 이 카드가 중앙 구역에 있을 경우, +3 파워를 부여합니다.", 1, 0);
	MistyKnight mistyKnight = new MistyKnight("Misty Knight", 1, 2, 2, null, "\"이 도시를 구해야 해요.\"", 1, 0);
	Quicksilver quicksilver = new Quicksilver("QUICKSILVER", 1, 2, 2, "start", "첫 턴에 무조건 손에 들어옵니다.", 1, 0);
	Shocker shocker = new Shocker("SHOCKER", 2, 3, 3, null, "\"너를 날려 버리겠다.\"", 1, 0);
	TheThing theThing = new TheThing("THE THING", 4, 6, 6, null, "\"때려눕힐 시간이다!\"", 1, 0);
	ThePunisher thePunisher = new ThePunisher("THE PUNISHER", 3, 3, 3, "onGoing",  "\u001b[1m" + "지속" + "\u001b[0m" + ": 이곳에 있는 상대 카드 한 장당 +1 파워를 부여합니다.", 1, 0);
	StarLord starLord = new StarLord("STAR LORD", 2, 2, 2, "onReveal", "\u001b[1m" + "출현" + "\u001b[0m" + ": 이번 턴에 상대가 이곳에 카드를 냈을 경우, 이 카드에 +3 파워를 부여합니다.", 1, 0);
	
	
	void P1Deck2Create() {

		p1Deck.add(abomination);
		p1Deck.add(cyclops);
		p1Deck.add(hawkEye);
		p1Deck.add(hulk);
		p1Deck.add(ironMan);
		p1Deck.add(medusa);
		p1Deck.add(mistyKnight);
		p1Deck.add(quicksilver);
		p1Deck.add(shocker);
		p1Deck.add(theThing);
		p1Deck.add(thePunisher);
		p1Deck.add(starLord);
		

	}

}
