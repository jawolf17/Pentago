package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import controller.Controller;

public class Pentago {

	public static void main(String[] args) {
		String size="medium";
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/settings.ptg"));
			if(bf.ready()){
				size=bf.readLine();
			}
			Controller c = new Controller(size);
			c.launchMenu();
		} catch (FileNotFoundException e) {
			try {
				PrintWriter write = new PrintWriter("src/settings.ptg","UTF-8");
				write.println("medium");
				write.close();
				Controller c = new Controller("medium");
				c.launchMenu();
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				Controller c = new Controller("medium");
				c.launchMenu();
			}
			
		} catch (IOException e) {
			Controller c = new Controller(size);
			c.launchMenu();
		}
	}

}
