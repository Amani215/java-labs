package comparators;

import java.util.*;
import cars.Car;

public class BrandComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return (car1.brand.compareTo(car2.brand));
	}
}
