public class Main {

    public static void main(String[] args) {

        Port port = new Port(5);

        new VesselMotionThread(new Vessel("Ship1"), port).run();
        new VesselMotionThread(new Vessel("Ship2"), port).run();
        new VesselMotionThread(new Vessel("Ship3"), port).run();
//        new VesselMotionThread(new Vessel("Ship4"), port).run();
//        new VesselMotionThread(new Vessel("Ship5"), port).run();
//        new VesselMotionThread(new Vessel("Ship6"), port).run();
//        new VesselMotionThread(new Vessel("Ship7"), port).run();
//        new VesselMotionThread(new Vessel("Ship8"), port).run();
//        new VesselMotionThread(new Vessel("Ship9"), port).run();
//        new VesselMotionThread(new Vessel("Ship10"), port).run();


    }
}
