package com.s4n.fileRW;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author DCross
 * Class used to file management as read folder and file write and read.
 */
public class FileManager {
	
	/**
	 * Constructor
	 */
	public FileManager() { }
	
	/**
	 * Method used to read all files in a folder
	 * @param folderPath Path of the folder to be read
	 * @return An array with all files contained in the folder
	 */
	public File[] folderReader(String folderPath) {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		return listOfFiles;
	}
	
	/**
	 * Method used to read the information in a file
	 * @param filePath Path of the file to be read
	 * @return An String with all information contained in the file
	 */
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
	
	/**
	 * Method used to write information in a file on an specific location
	 * @param folderPath Path of the folder where the file will be written
	 * @param id Information used to create the file name
	 * @param data The information to be written in the file
	 * @throws IOException
	 */
	public void fileWriter(String folderPath, String id, String data) throws IOException {
	    FileOutputStream outputStream = new FileOutputStream(folderPath + "\\out"+ id + ".txt");
	    byte[] strToBytes = data.getBytes();
	    outputStream.write(strToBytes);

	    outputStream.close();
	}
}
