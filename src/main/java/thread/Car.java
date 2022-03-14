package thread;

public class Car extends Thread {
    private Parking parking;

    public Car(String name, Parking parking) {
        super(name);
        this.parking = parking;
    }

    @Override
    public void run() {
        ParkingSpace parkingSpace = null;
        try {
            parkingSpace = parking.getParkingSpace(100);
            parkingSpace.takeParkingSpace();
        } catch (ResourceException e) {
            System.out.println(Thread.currentThread().getName() + " left the parking - "+ e.getMessage());
        } finally {
            if (parkingSpace != null) {
                parking.leaveParkingSpace(parkingSpace);
            }
        }
    }
}
