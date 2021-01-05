package com.s4n.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

public class DronTest {
	
	private final Dron dron = new Dron("01", 5, 2);

	@Test
	public void moveTest() {
		dron.setDeliveriInstructions("A");
		
		assertEquals("== Reporte de entregas ==\n\n(0, 1) dirección Norte", dron.move());
	}

}
