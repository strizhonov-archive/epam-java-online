package port.controller;

import port.model.Pier;
import port.model.Port;
import port.model.Vessel;
import port.view.ConsoleVew;

public class VesselMotionThread extends Thread {

    private Vessel vessel;
    private Port port;
    private ConsoleVew cv;

    public VesselMotionThread(Vessel vessel, Port port, ConsoleVew cv) {
        this.vessel = vessel;
        this.port = port;
        this.cv = cv;
    }

    @Override
    public void run() {

        Pier pier = null;
        while (pier == null) {
            pier = port.getFreePier();
        }

        vessel.setPier(pier);
        pier.setHasVessel(true);
        cv.printConnection(vessel, pier);


        if (vessel.getCargo() > 0 && pier.getCapacity() - pier.getCargo() > 0) {
            int loadAmount = vessel.unload();
            cv.printUnloading(vessel, pier, loadAmount);
        } else if (vessel.getCargo() == 0 && pier.getCargo() > 0) {
            int loadAmount = vessel.load();
            cv.printLoading(vessel, pier, loadAmount);
        } else {
            cv.printInability(vessel, pier);
        }

        pier.setHasVessel(false);
        vessel.setPier(null);
        cv.printDeparture(vessel, pier);
    }


}
