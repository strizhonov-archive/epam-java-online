package port;

import port.controller.VesselMotionThread;
import port.model.Port;
import port.model.Vessel;
import port.view.ConsoleVew;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        ConsoleVew cv = new ConsoleVew();

        Port port = new Port(5);

        new VesselMotionThread(new Vessel("Ship1"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship2"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship3"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship4"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship5"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship6"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship7"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship8"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship9"), port, cv).start();
        new VesselMotionThread(new Vessel("Ship10"), port, cv).start();

    }
}
