package main;

import car.Car;
//import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		List<Car> list = new LinkedList<Car>();
		String line = new String();
		String command = new String();
		String input1 = new String();
		String input2 = new String();
		int input3;
		
		String inventory = new String("carInventory.txt");
		
		Boolean test=true;
		
		System.out.println("Welcome to your car inventory");
		while(test==true) {
				line = new Scanner(System.in).nextLine();
				command = line.split(" ", 4)[0];
			
				try {input1 = line.split(" ", 4)[1];}
				catch (Exception ex) {input1 = "";}
				
				try {input2 = line.split(" ", 4)[2];}
				catch (Exception ex) {input2 = "";}
				
				try {input3 = Integer.parseInt(line.split(" ", 4)[3]);}
				catch (Exception ex) {input3 = 0;}
				
				switch(command){
					case "add":	new Car(input1,input2,input3).add(list);
								break;
					case "list":new Car(input1,input2,input3).list(list,input1);
								break;
					case "save":new Car(input1,input2,input3).save(list,inventory);
								break;
					case "load": list = new Car(input1,input2,input3).load(list,inventory);
								 break;
					case "delete": 	new Car(input1,input2,input3).delete(list, inventory, input1);
									break;
					default:System.out.println("Invalid input"); test=false; break;
				}
		}
	}
}
