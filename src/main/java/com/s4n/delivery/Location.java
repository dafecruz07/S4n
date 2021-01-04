package com.s4n.delivery;

/**
 * 
 * @author DCross
 *
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
	 * 
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
	 * 
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
	 * 
	 * @return
	 */
	public String printLocation() {
		return "(" + posX + ", " + posY + ") dirección "+direction.getDirection();
	}
	
	/**
	 * 
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
