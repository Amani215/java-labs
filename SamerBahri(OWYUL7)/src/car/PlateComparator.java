package car;

import java.util.*;
import car.Car;

public class PlateComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return(car1.getLicense().compareTo(car2.getLicense()));
	}
}
