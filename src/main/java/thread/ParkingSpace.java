package thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkingSpace {
    private volatile boolean busy;
    private volatile int placeId;

    public ParkingSpace(int id){
        this.placeId = id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int id){
        this.placeId = id;
    }

    public boolean isBusy() {
        return busy;
    }
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void takeParkingSpace(){
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ParkingSpace{");
        sb.append("id=").append(placeId);
        sb.append(", busy=").append(isBusy()).append('}');
        return sb.toString();
    }
}
