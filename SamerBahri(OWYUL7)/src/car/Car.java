package car;

import java.io.*;
import java.util.*;

public class Car implements Serializable{
	private String licensePlate, brand;
	private int yearOfProduction;
	
	public Car(String lp, String b, int yop) {
		licensePlate=lp;
		brand=b;
		yearOfProduction=yop;
	}
	
	public String getLicense() { return licensePlate;}
	public String getBrand() { return brand;}
	public int getYear() { return yearOfProduction;}
	
	public void add(List<Car> list) {
		list.add(this);
		System.out.println("Added");
	}
	
	public void list(List<Car> list, String arg) {
		if(list.size()!=0)
			switch(arg) {
			case "plate": Collections.sort(list,  new PlateComparator());break;
			case "brand": Collections.sort(list,  new BrandComparator());break;
			case "year": Collections.sort(list,  new YearComparator());break;
			default: System.out.println("Enter plate - brand - year");return;
			}
		
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).licensePlate+" "+list.get(i).brand+" "+list.get(i).yearOfProduction);
			}
	}
	
	public void save(List<Car> list, String inventory) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(inventory));
			out.writeObject(list);
			out.close();
			System.out.println("Saved");
		}catch(IOException ex) {System.out.println("Error");}
	}
	
	public List<Car> load(List<Car> list, String inventory) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(inventory));
			list=(List<Car>)in.readObject();
			in.close();
			System.out.println("Loaded");
		}catch(IOException ex) {} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return(list);
	}

	public void delete(List<Car> list, String inventory, String plate) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).licensePlate.equals(plate)) {
				list.remove(i);
				save(list,inventory);
				System.out.println("deleted");
				return;
			}
		}
		System.out.println("car not found");
	}
}
