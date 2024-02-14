package com.naver.ryuuzakiumi.marblesnap;

public class Test {
	public static void main(String[] args) {
		
		LocationList loc = new LocationList();
		loc.locationReady();
		
		System.out.print("[");
		System.out.printf("%22s", loc.theVault.txt1);
		System.out.println("]");
		System.out.print("[");
		System.out.printf("%30s", loc.projectPegasus.txt1);
		System.out.print("]");
		
	}

}
