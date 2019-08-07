package port.view;

import port.model.Pier;
import port.model.Vessel;

public  class ConsoleVew {

    public synchronized void printConnection(Vessel vessel, Pier pier) {
        System.out.println("*CONNECTION MESSAGE:*");

        System.out.println("Vessel " + vessel.getName() + " arrived at pier #"
                + (pier.getPierNum() + 1));

        System.out.println("Vessel " + vessel.getName() +" has "
                + vessel.getCargo() + " tons cargo; pier #" + (pier.getPierNum() + 1)
                + " has " + pier.getCargo() + " tons cargo");

        System.out.println();
    }

    public synchronized void printDeparture(Vessel vessel, Pier pier) {
        System.out.println("*DEPARTURE MESSAGE:*");

        System.out.println("Vessel " + vessel.getName() + " departed from pier #"
                + (pier.getPierNum() + 1));

        System.out.println("Vessel " + vessel.getName() +" has "
                + vessel.getCargo() + " tons cargo; pier #" + (pier.getPierNum() + 1)
                + " has " + pier.getCargo() + " tons cargo after departure.");

        System.out.println();
    }

    public synchronized void printLoading(Vessel vessel, Pier pier, int loadAmount) {
        System.out.println("*VESSEL LOADING MESSAGE:*");

        System.out.println("Vessel " + vessel.getName() + " gets "
                +  loadAmount + " tons of cargo from pier #" + (pier.getPierNum() + 1));

        System.out.println();
    }

    public synchronized void printUnloading(Vessel vessel, Pier pier, int loadAmount) {
        System.out.println("*VESSEL UNLOADING MESSAGE:*");

        System.out.println("Vessel " + vessel.getName() + " drops "
                +  loadAmount + " tons of cargo to pier #" + (pier.getPierNum() + 1));

        System.out.println();
    }

    public synchronized void printInability(Vessel vessel, Pier pier) {
        System.out.println("*LOADING INABILITY MESSAGE:*");

        System.out.println("Unable to implement cargo exchange: Vessel "
                + vessel.getName() + "; Pier #" + pier.getPierNum());

        System.out.println();
    }




}
