import java.util.Random;

public class VesselMotionThread implements Runnable {

    private Vessel vessel;
    private Port port;

    public VesselMotionThread(Vessel vessel, Port port) {
        this.vessel = vessel;
        this.port = port;
    }

    @Override
    public void run() {
        ConsoleVew cv = new ConsoleVew();

        Random random = new Random();

        Pier pier = null;
        while (pier == null) {
            pier = port.getFreePier();
        }

        vessel.setPier(pier);
        pier.setHasVessel(true);
        cv.printConnection(vessel, pier);

        if (random.nextBoolean()) {
            int loadAmount = vessel.load();
            cv.printLoading(vessel, pier, loadAmount);
        } else {
            int loadAmount = vessel.unload();
            cv.printUnloading(vessel, pier, loadAmount);
        }

        cv.printDeparture(vessel, pier);

    }
}
