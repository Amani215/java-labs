package car;

import java.util.*;
import car.Car;

public class YearComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return(car2.getYear()-car1.getYear());
	}
}
