package com.naver.ryuuzakiumi.marblesnap;

import java.util.ArrayList;
import java.util.List;

class Location {

	int revealCounter;
	String locationName;
	String txt1 = "                  ";
	String txt2 = "                  ";
	String txt3 = "                  ";
	String txt4 = "                  ";
	String txt5 = "                  ";
	String txt6 = "                  ";

	String caegory;
}

public class LocationList {

	Location loc1 = new Location();
	Location loc2 = new Location();
	Location loc3 = new Location();
	Location unrevealedLoc1 = new Location();
	Location unrevealedLoc2 = new Location();
	Location unrevealedLoc3 = new Location();
	Location locNow = new Location();
	Location locNextTurn = new Location();
	Location locNext2Turn = new Location();
	Location limbo = new Location();
	Location novaRoma = new Location();
	Location olympia = new Location();
	Location projectPegasus = new Location();
	Location theVault = new Location();
	Location crimsonCosmos = new Location();
	Location knowhere = new Location();
	Location tinkerersWorkshop = new Location();
	Location miniaturizedLab = new Location();
	Location hellfireClub = new Location();
	Location theBigHouse = new Location();
	Location tva = new Location();
	
	
	

	List<Location> locationPool = new ArrayList<Location>();

	void locationReady() {

		loc1 = locNow;
		loc2 = locNextTurn;
		loc3 = locNext2Turn;

		locNow.txt5 = "    가장 먼저     ";
		locNow.txt6 = "    공개됩니다.   ";
		locNow.revealCounter = 1;

		locNextTurn.txt5 = "     다음 턴에    ";
		locNextTurn.txt6 = "    공개됩니다.   ";
		locNextTurn.revealCounter = 2;

		locNext2Turn.txt5 = "      2턴 뒤에    ";
		locNext2Turn.txt6 = "    공개됩니다.   ";
		locNext2Turn.revealCounter = 3;

		limbo.locationName = "Limbo";
		limbo.txt1 = "\u001b[1m" + "       림보       " + "\u001b[0m";
		limbo.txt5 = "   이번 게임에는  ";
		limbo.txt6 = "  7턴이 있습니다. ";
		limbo.caegory = "max turn";

		novaRoma.locationName = "Nova Roma";
		novaRoma.txt1 = "\u001b[1m" + "     신 로마      " + "\u001b[0m";
		novaRoma.txt5 = "   카드 한 장을   ";
		novaRoma.txt6 = "     뽑습니다.    ";

		olympia.locationName = "Olympia";
		olympia.txt1 = "\u001b[1m" + "     올림피아     " + "\u001b[0m";
		olympia.txt5 = "    카드 2장을    ";
		olympia.txt6 = "     뽑습니다.    ";

		projectPegasus.locationName = "Project Pegasus";
		projectPegasus.txt1 = "\u001b[1m" + "프로젝트 페가수스 " + "\u001b[0m";
		projectPegasus.txt4 = "   이번 턴에 +5   ";
		projectPegasus.txt5 = "     에너지를     ";
		projectPegasus.txt6 = "    획득합니다.   ";

		theVault.locationName = "The Vault";
		theVault.txt1 = "\u001b[1m" + "    볼트 교도소   " + "\u001b[0m";
		theVault.txt4 = " 6턴에는 이 구역에";
		theVault.txt5 = "   카드를 낼 수   ";
		theVault.txt6 = "     없습니다.    ";

		crimsonCosmos.locationName = "Crimson Cosmos";
		crimsonCosmos.txt1 = "\u001b[1m" + "  크림슨 코스모스 " + "\u001b[0m";
		crimsonCosmos.txt3 = " 이 구역에는 현재 ";
		crimsonCosmos.txt4 = " 비용이 1, 2, 3인 ";
		crimsonCosmos.txt5 = "   카드는 낼 수   ";
		crimsonCosmos.txt6 = "     없습니다.    ";
		
		knowhere.locationName = "Knowhere";
		knowhere.txt1 = "\u001b[1m" + "       노웨어     " + "\u001b[0m";
		knowhere.txt4 = "   이 구역에서는  ";
		knowhere.txt5 = "    출현 효과가   ";
		knowhere.txt6 = "발동하지 않습니다.";
		
		tinkerersWorkshop.locationName = "Tinkerer's Workshop";
		tinkerersWorkshop.txt1 = "\u001b[1m" + "  팅커러의 작업실 " + "\u001b[0m";
		tinkerersWorkshop.txt4 = "   이번 턴에 +1   ";
		tinkerersWorkshop.txt5 = "     에너지를     ";
		tinkerersWorkshop.txt6 = "    획득합니다.   ";

		miniaturizedLab.locationName = "Miniaturized Lab";
		miniaturizedLab.txt1 = "\u001b[1m" + "   축소된 연구소  " + "\u001b[0m";
		miniaturizedLab.txt3 = "   3, 4, 5턴에는  ";
		miniaturizedLab.txt4 = " 이 구역에 카드를 ";
		miniaturizedLab.txt5 = "     추가할 수    ";
		miniaturizedLab.txt6 = "     없습니다.    ";
		
		hellfireClub.locationName = "Hellfire Club";
		hellfireClub.txt1 = "\u001b[1m" + "   헬파이어 클럽  " + "\u001b[0m";
		hellfireClub.txt4 = " 이 구역에는 현재 ";
		hellfireClub.txt5 = " 비용이 1인 카드를";
		hellfireClub.txt6 = "  낼 수 없습니다. ";
		
		theBigHouse.locationName = "The Big House";
		theBigHouse.txt1 = "\u001b[1m" + "     빅 하우스    " + "\u001b[0m";
		theBigHouse.txt3 = " 이 구역에는 현재 ";
		theBigHouse.txt4 = " 비용이 4, 5, 6인 ";
		theBigHouse.txt5 = "   카드는 낼 수   ";
		theBigHouse.txt6 = "     없습니다.    ";
		
		tva.locationName = "TVA";
		tva.txt1 = "\u001b[1m" + "        TVA       " + "\u001b[0m";
		tva.txt5 = " 4턴 이후, 게임을 ";
		tva.txt6 = "     끝냅니다.    ";
		
		locationPool.add(limbo);
		locationPool.add(novaRoma);
		locationPool.add(olympia);
		locationPool.add(projectPegasus);
		locationPool.add(theVault);
		locationPool.add(crimsonCosmos);
		locationPool.add(knowhere);
		locationPool.add(tinkerersWorkshop);
		locationPool.add(miniaturizedLab);
		locationPool.add(hellfireClub);
		locationPool.add(theBigHouse);
		locationPool.add(tva);
		
		
	}

	void locationArrangement() {

		int i = (int) (Math.random() * locationPool.size());
		unrevealedLoc1 = locationPool.get(i);
		locationPool.remove(i);

		i = (int) (Math.random() * locationPool.size());
		unrevealedLoc2 = locationPool.get(i);
		locationPool.remove(i);

		i = (int) (Math.random() * locationPool.size());
		unrevealedLoc3 = locationPool.get(i);
		locationPool.remove(i);

	}

	Location revealLocation() {
		// 리빌 카운터 하나 줄이기
		loc1.revealCounter -= 1;
		loc2.revealCounter -= 1;
		loc3.revealCounter -= 1;
		// 리빌 카운터가 0이라면 대기중인 구역으로 교체
		if (loc1.revealCounter == 0) {
			loc1 = unrevealedLoc1;
			return loc1;

		} else if (loc2.revealCounter == 0) {
			loc2 = unrevealedLoc2;
			return loc2;

		} else if (loc3.revealCounter == 0) {
			loc3 = unrevealedLoc3;
			return loc3;
		}
		return null;
	}

	void sortLocation() {

		// 미공개 구역 하나씩 당기기
		if (loc3.revealCounter == 1) {
			loc3 = locNextTurn;
			loc3.revealCounter = 1;
		}
	}

	void activateLocationEffect(Location loc, List<Card> p1Deck, List<Card> p2Deck) {
		// 구역이 공개되면 효과 온

		switch (loc.locationName) {
		case "Limbo":
			Play.maxTurn = 7;
			break;
			
		case "TVA":
			Play.tvaTriger = true;
			break;

		case "Nova Roma":
			Card cardN = new Card();
			cardN = Play.draw(p1Deck);

			if (cardN != null) {
				Play.p1Hand.add(cardN);
			}

			cardN = Play.draw(p2Deck);
			if (cardN != null) {
				Play.p2Hand.add(cardN);
			}
			break;

		case "Olympia":
			Card cardO = new Card();

			for (int i = 0; i < 2; i++) {
				cardO = Play.draw(p1Deck);
				if (cardO != null) {
					Play.p1Hand.add(cardO);
				}
			}

			for (int i = 0; i < 2; i++) {
				cardO = Play.draw(p2Deck);
				if (cardO != null) {
					Play.p2Hand.add(cardO);
				}
			}

			break;

		case "Project Pegasus":
			Play.currentEenergy1p += 5;
			Play.currentEenergy2p += 5;

			break;
			
		case "Tinkerer's Workshop":
			Play.currentEenergy1p += 1;
			Play.currentEenergy2p += 1;
			
			break;

		case "The Vault":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.theVaultLocation = 1;
			} else if (loc == loc2) {
				Play.theVaultLocation = 2;
			} else if (loc == loc3) {
				Play.theVaultLocation = 3;
			}
			Play.theVaultTriger[Play.theVaultLocation - 1] = true;

			break;
			
		case "Miniaturized Lab":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.miniaturizedLabLocation = 1;
			} else if (loc == loc2) {
				Play.miniaturizedLabLocation = 2;
			} else if (loc == loc3) {
				Play.miniaturizedLabLocation = 3;
			}
			Play.miniaturizedLabTriger[Play.miniaturizedLabLocation - 1] = true;

			break;

		case "Crimson Cosmos":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.crimsonCosmosLocation = 1;
			} else if (loc == loc2) {
				Play.crimsonCosmosLocation = 2;
			} else if (loc == loc3) {
				Play.crimsonCosmosLocation = 3;
			}
			Play.crimsonCosmosTriger[Play.crimsonCosmosLocation - 1] = true;

			break;
			
		case "Hellfire Club":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.hellfireClubLocation = 1;
			} else if (loc == loc2) {
				Play.hellfireClubLocation = 2;
			} else if (loc == loc3) {
				Play.hellfireClubLocation = 3;
			}
			Play.hellfireClubTriger[Play.hellfireClubLocation - 1] = true;

			break;
			
		case "The Big House":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.theBigHouseLocation = 1;
			} else if (loc == loc2) {
				Play.theBigHouseLocation = 2;
			} else if (loc == loc3) {
				Play.theBigHouseLocation = 3;
			}
			Play.theBigHouseTriger[Play.theBigHouseLocation - 1] = true;
			
			break;
			
		case "Knowhere":
			// 같은 객체인지 체크해서 위치 확인
			if (loc == loc1) {
				Play.knowhereLocation = 1;
			} else if (loc == loc2) {
				Play.knowhereLocation = 2;
			} else if (loc == loc3) {
				Play.knowhereLocation = 3;
			}
			Play.knowhereTriger[Play.knowhereLocation - 1] = true;

			break;
			
		

		default:
			break;
		}

	}

}
