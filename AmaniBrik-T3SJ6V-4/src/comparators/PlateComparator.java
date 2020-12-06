package comparators;

import java.util.*;
import cars.Car;

public class PlateComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return (car1.licensePlate.compareTo(car2.licensePlate));
	}
}
