package com.s4n.delivery;

/**
 * 
 * @author DCross
 *
 */
public enum Direction {
	NORTE("Norte"),
	SUR("Sur"),
	ORIENTE("Oriente"),
	OCCIDENTE("Occidente");
	
	private String direction;
	
	private Direction() { this.direction = "Norte"; }

	/**
	 * @param direction
	 */
	private Direction(String direction) { this.direction = direction; }

	/**
	 * @return the direction
	 */
	public String getDirection() { return direction; }

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) { this.direction = direction; }
}
