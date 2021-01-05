package com.s4n.delivery;

/**
 * @author DCross
 * Class Location used to manage the coodinates in an XY plane, make use of direction
 */
public class Location {
	private int			posX;
	private int			posY;
	private Direction	direction;
	
	/**
	 * 
	 */
	public Location() {
		this.posX 		= 0;
		this.posY 		= 0;
		this.direction	= Direction.NORTE;
	}
	
	/**
	 * This method change the direction to look, giving one 90° spin to the left
	 */
	public void turnLeft() {
		switch(direction){
		case NORTE :
			this.direction = Direction.OCCIDENTE;
			break;
		case SUR :
			this.direction = Direction.ORIENTE;
			break;
		case ORIENTE :
			this.direction = Direction.NORTE;
			break;
		case OCCIDENTE :
			this.direction = Direction.SUR;
			break;
		}
	}
	
	/**
	 * This method change the direction to look, giving one 90° spin to the right
	 */
	public void turnRight() {
		switch(direction){
		case NORTE :
			this.direction = Direction.ORIENTE;
			break;
		case SUR :
			this.direction = Direction.OCCIDENTE;
			break;
		case ORIENTE :
			this.direction = Direction.SUR;
			break;
		case OCCIDENTE :
			this.direction = Direction.NORTE;
			break;
		}
	}
	
	/**
	 * This method foward one step into the looking direction.
	 * @return distance to origin on the axis that has been moved
	 */
	public int foward() {
		switch(direction){
			case NORTE :
				this.posY++;
				return Math.abs(posY);
			case SUR :
				this.posY--;
				return Math.abs(posY);
			case ORIENTE :
				this.posX++;
				return Math.abs(posX);
			case OCCIDENTE :
				this.posX--;
				return Math.abs(posX);
		}
		return -1;
	}
	
	/**
	 * This method print the actual location and actual looking direction
	 * @return
	 */
	public String printLocation() {
		return "(" + posX + ", " + posY + ") dirección "+direction.getDirection();
	}
	
	/**
	 * This methos reset the location to origin (0, 0) an loking direction to Norte
	 */
	public void resetLocation() {
		posY = 0;
		posX = 0;
		this.direction.setDirection("Norte");
	}

	/**
	 * @return the posX
	 */
	public int getPosX() { return posX; }

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) { this.posX = posX; }

	/**
	 * @return the posY
	 */
	public int getPosY() { return posY; }

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) { this.posY = posY; }

	/**
	 * @return the direction
	 */
	public Direction getDirection() { return direction; }

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) { this.direction = direction; }
	
}
