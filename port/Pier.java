import java.util.Random;

public class Pier {

    private static int COUNTER = 0;
    private final int pierNum;
    private boolean hasVessel;
    private Vessel vessel;
    private final int capacity;
    private int cargo;

    public Pier() {
        pierNum = COUNTER;
        COUNTER++;
        Random random = new Random();
        capacity = random.nextBoolean() ? 100 : 200;
        cargo = random.nextBoolean() ? capacity : 0;
    }

    public boolean hasVessel() {
        return hasVessel;
    }

    public void setHasVessel(boolean hasVessel) {
        this.hasVessel = hasVessel;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public int getPierNum() {
        return pierNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
