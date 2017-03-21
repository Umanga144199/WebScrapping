package edu.lfa.webscrappingapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.lfa.webscrappingapp.grab.Grabber;

public class Scrapper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Instagram Scrapper !!");
		System.out.println("Download instagram pics !!");
		String basePath = "https://www.instagram.com/";
		
		System.out.println("Enter the username");
		String link = input.next();
		try{
		
		String content = Grabber.grab(basePath + link);
		
		String regEx = "https://(.*?).jpg";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(content); 
		
		while(matcher.find()){
			String imgPath = matcher.group(0);
			
			String path = (imgPath);
			
			String[]tokens = path.split("/");
			
			File file1 = new File("F:/Javascrap/InstagramPics");
			if(!file1.isDirectory()){
				file1.mkdir();
			}
			
			File file2 = new File("F:/Javascrap/InstagramPics/" + link);
			if(!file2.isDirectory()){
				file2.mkdir();
			}
			System.out.println("Downloading the Pics......" + link);
			
			Grabber.downloadImg(imgPath, "F:/Javascrap/InstagramPics/" + link + "/" + tokens[tokens.length-1]);
			
		}
		
		System.out.println("Your pics are downloaded in F drive!!");
		
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		
	}

}
