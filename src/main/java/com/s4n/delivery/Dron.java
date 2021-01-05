/**
 * 
 */
package com.s4n.delivery;

import java.util.concurrent.Callable;

/**
 * @author Danny Cruz
 * Class used to manage main Dron actions
 */
public class Dron implements Callable<String>{
	
	private String		id;
	private int			bound;
	private Location 	location;
	private int 		deliveryLimit;
	private String		deliveriInstructions;
	
	/**
	 * Constructor
	 * @param id			Dron identifier
	 * @param bound			Limit to move in the field
	 * @param deliveryLimit	Limit to delivery
	 */
	public Dron(String id, int bound, int deliveryLimit) {
		this.id						= id;
		this.bound 					= bound;
		this.location 				= new Location();
		this.deliveryLimit			= deliveryLimit;
		this.deliveriInstructions	= "";
	}
	
	/**
	 * This method inspect the delivery instructions (if assigned) and make each on of the delivery
	 * @return An String that contains each one of the deliveries and adtional information if was generated.
	 */
	public String move() {
		
		if(deliveriInstructions != null && !deliveriInstructions.isEmpty()) {
			
			Object[] lines = deliveriInstructions.lines().toArray();
			String	report 			= "== Reporte de entregas ==";
			int 	deliveryNumber	= 0;
			int		stepAux			= 0;
			
			for(Object line : lines) {
				char[]	deliverySteps	= ((String)line).toCharArray();
				
				if(deliveryNumber == deliveryLimit) {
					report += "\n\nSe ha alcanzado el limite de entregas, se retorna al centro de distribución";
					break;
				}
				
				for (char instruction : deliverySteps) {
					switch (instruction) {
					case 'A' :
						stepAux = location.foward();
						if(stepAux > bound) {
		            		report += "\n\nFuera de los limites, se retorna al centro de distribución";
		            		location.resetLocation();
		            		return report;
		            	} else
		            		stepAux = 0;
						break;
						
					case 'I' :
						location.turnLeft();
						break;
						
					case 'D' :
						location.turnRight();
						break;

					default:
						report += "\n\nNo se puede interpretar la indicación (" + instruction + "), se retorna al centro de distribución";
		            	location.resetLocation();;
		        		return report;
					}
					
				}
				report += "\n\n" + location.printLocation();
				location.resetLocation();
				deliveryNumber++;
			}
			
	        return report;
		} else
			return "No se cuenta con una ruta de reparto asignada";
	}
	
	/**
	 * Method used to run a threat for each dron
	 */
	@Override
	public String call() throws Exception {
		String report = "";
		report = move();
		return report;
	}

	/**
	 * @return the id
	 */
	public String getId() { return id; }

	/**
	 * @param id the id to set
	 */
	public void setId(String id) { this.id = id; }

	/**
	 * @return the bound
	 */
	public int getBound() { return bound; }

	/**
	 * @param bound the bound to set
	 */
	public void setBound(int bound) { this.bound = bound; }

	/**
	 * @return the location
	 */
	public Location getLocation() { return location; }

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) { this.location = location; }

	/**
	 * @return the deliveryLimit
	 */
	public int getDeliveryLimit() { return deliveryLimit; }

	/**
	 * @param deliveryLimit the deliveryLimit to set
	 */
	public void setDeliveryLimit(int deliveryLimit) { this.deliveryLimit = deliveryLimit; }

	/**
	 * @return the deliveriInstructions
	 */
	public String getDeliveriInstructions() { return deliveriInstructions; }

	/**
	 * @param deliveriInstructions the deliveriInstructions to set
	 */
	public void setDeliveriInstructions(String deliveriInstructions) { this.deliveriInstructions = deliveriInstructions; }	
}
