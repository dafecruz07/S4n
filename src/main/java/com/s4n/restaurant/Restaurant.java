/**
 * 
 */
package com.s4n.restaurant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.s4n.delivery.Dron;
import com.s4n.fileRW.FileManager;

/**
 * @author DCross
 * Class used to manage main restauran options
 */
public class Restaurant {
	private String 		name;
	private List<Dron> 	dronsAvailabe;
	private FileManager	fileManager;
	
	/**
	 * Constructor
	 */
	public Restaurant() {
		this.name 			= "Su corrientazo a domicilio";
		this.dronsAvailabe	= loadDrons(10, 3);
		this.fileManager	= new FileManager();
	}
	
	/**
	 * Constructor
	 * @param deliveryLimit Delivery limit for the drons
	 */
	public Restaurant(int deliveryLimit) {
		this.name 			= "Su corrientazo a domicilio";
		this.dronsAvailabe	= loadDrons(10, deliveryLimit);
		this.fileManager	= new FileManager();
	}

	/**
	 * Constructor
	 * @param bound Bound for the drons to move
	 * @param deliveryLimit Delivery limit for the drons
	 */
	public Restaurant(int bound, int deliveryLimit) {
		this.name 			= "Su corrientazo a domicilio";
		this.dronsAvailabe	= loadDrons(bound, deliveryLimit);
		this.fileManager	= new FileManager();
	}
	
	/**
	 * Method used to assign the available delivery instruction to the drones
	 * @param deliveryInstructions Files that contain the delivery instructions to be assigned
	 */
	public void assignDeliveryRoute(File[] deliveryInstructions) {
		for (File file : deliveryInstructions) {
			String fileName = file.getName();
			if (fileName.contains("in") && fileName.contains(".txt")) {
				int dronId = Integer.parseInt(fileName.substring(2, 4));
				
				String deliveriInstructions = fileManager.fileReader(file.getAbsolutePath());
				dronsAvailabe.get(dronId-1).setDeliveriInstructions(deliveriInstructions);
			}
		}
	}
	
	/**
	 * Methos used to load all 20 available drons
	 * @param bound Bound for the drons to move
	 * @param deliveryLimit Delivery limit for the drons
	 * @return An array that contains all available dons
	 */
	public List<Dron> loadDrons(int bound, int deliveryLimit){
		List<Dron> listDrons = new ArrayList<Dron>();
		for(int i=0; i<20; i++){
			listDrons.add((i < 9) ? (new Dron("0"+ (i+1), bound, deliveryLimit)) : (new Dron(""+ (i+1), bound, deliveryLimit)) );
		}
		return listDrons;
	}

	/**
	 * @return the name
	 */
	public String getName() { return name; }

	/**
	 * @param name the name to set
	 */
	public void setName(String name) { this.name = name; }

	/**
	 * @return the dronsAvailabe
	 */
	public List<Dron> getDronsAvailabe() { return dronsAvailabe; }

	/**
	 * @param dronsAvailabe the dronsAvailabe to set
	 */
	public void setDronsAvailabe(List<Dron> dronsAvailabe) { this.dronsAvailabe = dronsAvailabe; }
	
}
