package comparators;

import java.util.*;
import cars.Car;

public class YearComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return (car1.yearOfProduction-car2.yearOfProduction);
	}
}
