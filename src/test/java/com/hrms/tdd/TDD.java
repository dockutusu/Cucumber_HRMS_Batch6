package com.hrms.tdd;

import org.testng.annotations.Test;

public class TDD {

	//@Test
	public void knockingDoor() {
		System.out.println("someone is knocking on the door");
	}

	@Test(dependsOnMethods = "knockingDoor")
	public void openingDoor() {

		System.out.println("i will open door but only because sommeone knoked");
	}

	@Test(dependsOnMethods = "openingDoor")
	public void closingDoor() {

		System.out.println("i closed the door after opening the door to whoever knocked");
	}

}
