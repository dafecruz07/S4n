package com.s4n.fileRW;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author DCross
 *
 */
public class FileManager {
	
	
	public FileManager() { }
	
	public File[] folderReader(String folderPath) {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		return listOfFiles;
	}
	
	public String fileReader(String filePath) {
		String content = "";
		 
        try {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
 
        return content;
	}
	
	public void fileWriter(String folderPath, String id, String data) throws IOException {
	    FileOutputStream outputStream = new FileOutputStream(folderPath + "\\out"+ id + ".txt");
	    byte[] strToBytes = data.getBytes();
	    outputStream.write(strToBytes);

	    outputStream.close();
	}
	
	public static void main(String[] args) throws IOException {
		
//		FileManager fileManagement = new FileManager();
//		String folderPathIn		= "C:\\Users\\DCross\\Desktop\\S4N\\In";
//		String folderPathOut	= "C:\\Users\\DCross\\Desktop\\S4N\\Out";
//		String filePath 		= "C:\\Users\\DCross\\Desktop\\S4N\\In\\in01.txt";
//		String fileData			= "== Reporte de entregas ==\r\n"
//								+ "(-2, 4) dirección Norte\r\n"
//								+ "(-3, 3) dirección Sur\r\n"
//								+ "(-4, 2) dirección Oriente"
//								+ "Se ha alcanzado el limite de entregas del Dron, se retorna al centro de distribución";
//		
//		fileManagement.folderReader(filePath);
//		fileManagement.fileReader(filePath);
//		fileManagement.fileWriter(folderPathOut, "01", fileData);
	}
	

}
