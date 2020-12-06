package car;

import java.util.*;
import car.Car;

public class BrandComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return(car1.getBrand().compareTo(car2.getBrand()));
	}
}
