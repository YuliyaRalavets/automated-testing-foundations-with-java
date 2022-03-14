package thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parking store;
        List<ParkingSpace> spaces = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            spaces.add(new ParkingSpace(i));
        }
        store = new Parking(spaces);

        for (int i = 0; i < 20; i++) {
            new Car("Car " + i,store).start();
        }
    }
}
