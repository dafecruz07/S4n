package com.s4n.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.s4n.delivery.Dron;
import com.s4n.fileRW.FileManager;

/**
 * @author DCross
 * Class used to run the restaurant application
 */
public class App {
	private BufferedReader	br;
	private ExecutorService	service;
	private Restaurant		restaurant;
	private FileManager		fileManager;
	
	public App() throws IOException, InterruptedException, ExecutionException{
		this.service		= Executors.newFixedThreadPool(1);
		this.fileManager	= new FileManager();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bienvenido al gestor de entregas de Su corrientazo a domicilio.");
		System.out.print("Si desea modificar capacidad actual de entrega de los drones (3) ingrese 'Y' de lo contrario ingrese 'N': ");
		
		String aux = br.readLine();
		
		if (aux.equalsIgnoreCase("y")) {
			System.out.print("Por favor ingrese la nueva capacidad de dentrega de los drones: ");
			
			int deliveryLimit = Integer.parseInt(br.readLine()); 
			restaurant = new Restaurant(deliveryLimit);
		} else {
			restaurant = new Restaurant();
		}
		
		System.out.print("Por favor ingrese la ruta de la carpeta donde se encuentran las instrucciones de entrega (C:/xxx/xxx/folder/): ");
		
		String path = br.readLine();
		
		restaurant.assignDeliveryRoute(fileManager.folderReader(path));
		
		System.out.println("Se procede con el reparto.");
		
		List<Dron> 	dronsAvailabe = restaurant.getDronsAvailabe();
		
		for (Dron dron : dronsAvailabe) {
			if (dron.getDeliveriInstructions()!= null && !dron.getDeliveriInstructions().isEmpty()) {
				Future<String> resultado= service.submit(dron);
				fileManager.fileWriter(path, dron.getId(), resultado.get());
			}
		}
		
		System.out.println("Entregas finalizadas, los reportes de entregas se encuentran en la misma ruta de instrucciones de entrega '" + path + "'");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		App app = new App();
	}

}
