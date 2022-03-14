package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    private final static int MAX_CAPACITY = 5;
    private Semaphore semaphore = new Semaphore(MAX_CAPACITY, true);
    private List<ParkingSpace> parking = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public Parking(List<ParkingSpace> parkingSpaceList) {
        parking.addAll(parkingSpaceList);
    }

    public ParkingSpace getParkingSpace(long maxWaitMillis) throws ResourceException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                lock.lock();
                for (ParkingSpace space : parking) {
                    if (!space.isBusy()) {
                        space.setBusy(true);
                        System.out.println(Thread.currentThread().getName() + " took parking space " + space.getPlaceId());
                        lock.unlock();
                        return space;
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new ResourceException("timed out " + maxWaitMillis + " milliseconds");
    }

    public void leaveParkingSpace(ParkingSpace space) {
        space.setBusy(false);
        System.out.println(Thread.currentThread().getName() + " left the parking space " + space.getPlaceId());
        semaphore.release();
    }
}