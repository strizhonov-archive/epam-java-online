import java.util.Random;

public class Vessel {

    private String name;
    private final int capacity;
    private int cargo;
    private Pier pier;

    public Vessel(String name) {
        Random random = new Random();
        capacity = random.nextBoolean() ? 10 : 20;
        cargo = random.nextBoolean() ? capacity : 0;
        this.name = name;
    }

    public void setPier(Pier pier) {
        this.pier = pier;
    }

    public String getName() {
        return name;
    }

    public int getCargo() {
        return cargo;
    }

    public int load() {
        if (pier != null) {
            int vesselMaxLoad = capacity - cargo;
            int pierCargo = pier.getCargo();
            int loadAmount = Math.min(vesselMaxLoad, pierCargo);
            cargo += loadAmount;
            pier.setCargo(pierCargo - loadAmount);
            return loadAmount;
        }

        return 0;
    }

    public int unload() {
        if (pier != null) {
            int pierMaxLoad = pier.getCapacity() - pier.getCargo();
            int loadAmount = Math.min(cargo, pierMaxLoad);
            cargo -= loadAmount;
            pier.setCargo(pier.getCargo() + loadAmount);
            return loadAmount;
        }

        return 0;
    }

}