package cars;

import java.util.*;
import java.io.*;
import comparators.*;

public class Car implements Serializable {
	public String licensePlate;
	public String brand;
	public int yearOfProduction;
	
	public Car(String licensePlate,String brand,int yearOfProduction) {
		this.licensePlate=licensePlate;
		this.brand=brand;
		this.yearOfProduction=yearOfProduction;
	}
	
	public void add(List<Car> l) {
		l.add(this);
		System.out.println("This car has been added to the inventory\r\n");
	}
	
	public void list(List<Car> l, String argument) {
		if(l.size()==0) System.out.println("The inventory is empty.");
		else {
			switch(argument) {
			case "plate":	Collections.sort(l,new PlateComparator());
							break;
			case "brand": 	Collections.sort(l,new BrandComparator());
							break;
			case "year": 	Collections.sort(l,new YearComparator());
							break;
			default: System.out.println("Please type a valid argument\r\n"); 
					 return;
			}
			for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).licensePlate+" "+l.get(i).brand+" "+l.get(i).yearOfProduction);
			}
		}
		System.out.println();
	}
	
	public void save(String filename, List<Car> l) {
		try {
			FileOutputStream f = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(l);
			out.close();
			System.out.println("Saved to the file\r\n");
		}
		catch(IOException e) {
			System.out.println("There was a problem...");
		}
	}
	
	public List<Car> load(String filename, List<Car> l) {
		try { 
			FileInputStream f = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(f);
			l = ((List<Car>)in.readObject());
			in.close();
			System.out.println("The inventory has been loaded. \r\n");
		} 
		catch(IOException ex) { 
			System.out.println("There was a problem...\r\n");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("There was a problem...\r\n");
		}
		return(l);
	}
	
	public void delete(String filename, List<Car> l, String argument) {
		int i=0;
		while(i<l.size()) {
			if(l.get(i).licensePlate.equals(argument)) {
				l.remove(i);
				save(filename,l);
				return;
			}
			i++;
		}
		System.out.println("Please specify a valid license plate to delete a car\r\n");
	}
}
