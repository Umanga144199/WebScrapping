package edu.lfa.webscrappingapp.grab;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Grabber {

	public static String grab(String path)throws IOException{
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		StringBuilder content = new StringBuilder();
		while((line = reader.readLine()) != null){
			content.append(line + "\r\n");
		}
		return content.toString();
	}
	
	public static void downloadImg(String path, String fileName)throws IOException{
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
	
		InputStream io = conn.getInputStream();
		FileOutputStream os = new FileOutputStream(fileName);
		
		byte[] data = new byte[1024*5];
		
		int i = 0;
		while((i = io.read(data))!= -1){
			os.write(data, 0, i);
		}
	}
}
