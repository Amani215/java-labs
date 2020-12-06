package Prog;

import java.util.*;
import java.io.*;
import cars.*;

public class Main {
	public static void main(String args[]) {
		List<Car> l =new ArrayList<Car>();
		String filename = new String("inventory.txt");
		String input = new String();
		String command = new String();
		String argument1 = new String();
		String argument2 =new String();
		int argument3;
		
		do {
			InputStreamReader  isr = new InputStreamReader(System.in);	
			BufferedReader br = new BufferedReader(isr);
		      try {
		         System.out.println("Enter a command (To exit the app type stop): ");
		         input = br.readLine();
		      } catch (IOException ioe) {
		         System.out.println(ioe);
		      }
		      
		      command= input.split(" ",4)[0];
			    try{
			    	argument1 = input.split(" ",4)[1];
			    }catch(Exception e) {
			    	argument1 = "";
			    }
			    
			    try {
			    	argument2 = input.split(" ",4)[2];
				}catch(Exception e) {
					argument2 = "";
			    }
			    
			    try {
			    	argument3=Integer.parseInt(input.split(" ",4)[3]);
				}catch(Exception e) {
					argument3 = 0;
			    }
			    
			    Car newCar = new Car(argument1,argument2,argument3);
			    
			switch(command) {
			case "add":	newCar.add(l);
						break;
			case "list": newCar.list(l,argument1);
						 break;
			case "save": newCar.save(filename,l);
			 			 break;
			case "load": l = newCar.load(filename,l);
			 			 break;
			case "delete": 	newCar.delete(filename,l,argument1);
							break;
			default: break;
			}
		}while(command.equals("stop")==false);
		
		System.out.println("You just exited the app.");
	}
}
