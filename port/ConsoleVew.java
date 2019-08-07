public class ConsoleVew {

    public void printConnection(Vessel vessel, Pier pier) {
        System.out.println("Vessel " + vessel.getName() + " arrived for pier #" + (pier.getPierNum() + 1));
        System.out.println("Vessel has " + vessel.getCargo() + " tons cargo; pier has " + pier.getCargo() + " tons cargo");
    }

    public void printDeparture(Vessel vessel, Pier pier) {
        System.out.println("Vessel " + vessel.getName() + " departed from pier #" + (pier.getPierNum() + 1));
        System.out.println("Vessel has " + vessel.getCargo() + " tons cargo; pier has " + pier.getCargo() + " tons cargo");
    }

    public void printLoading(Vessel vessel, Pier pier, int loadAmount) {
        System.out.println("Vessel " + vessel.getName() + " gets "
                +  loadAmount + " tons of cargo from pier #" + (pier.getPierNum() + 1));
    }

    public void printUnloading(Vessel vessel, Pier pier, int loadAmount) {
        System.out.println("Vessel " + vessel.getName() + " drops "
                +  loadAmount + " tons of cargo to pier #" + (pier.getPierNum() + 1));
    }




}
