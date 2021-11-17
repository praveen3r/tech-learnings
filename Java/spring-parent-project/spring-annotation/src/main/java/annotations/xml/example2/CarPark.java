package annotations.xml.example2;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    // Getter and setter
}