package com.s4n.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {
	
	private final Location location = new Location();

	@Test
	public void turnLeftTest() {
		location.turnLeft();
		
		assertEquals(Direction.OCCIDENTE, location.getDirection());
		
		location.resetLocation();
	}
	
	@Test
	public void turnRightTest() {
		location.turnRight();
		
		assertEquals(Direction.ORIENTE, location.getDirection());
		
		location.resetLocation();
	}
	
	@Test
	public void fowardTest() {
		assertEquals(1, location.foward());
		
		location.resetLocation();
	}
	
	@Test
	public void printLocationTest() {
		assertEquals("(0, 0) dirección Norte", location.printLocation());
	}
	
	public void resetLocationTest() {
		location.resetLocation();
		
		assertEquals("(0, 0) dirección Norte", location.printLocation());
	}
}
