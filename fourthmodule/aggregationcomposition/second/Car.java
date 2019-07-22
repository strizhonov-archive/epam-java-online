package aggregationcomposition.second;

public class Car {

    private Engine engine;
    private Wheel[] wheels;
    private int fuelVolume;
    private String brand;

    public Car(Engine engine, Wheel[] wheels, int fuelVolume, String brand) {
        this.engine = engine;
        this.wheels = wheels;
        this.fuelVolume = fuelVolume;
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void move() {
        engine.start();

        while (fuelVolume > 0 && engine.isEngineOn()) {
            fuelVolume--;
            try {
                wait(60_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void refuel(int fuelVolume) {
        this.fuelVolume += fuelVolume;
    }

    public void replaceWheel(int wheelNumber, Wheel newWheel) {
        if (wheelNumber < 0 || wheelNumber > 3) {
            System.out.println("Illegal wheel number. Wheel was not changed.");
        } else {
            wheels[wheelNumber] = newWheel;
        }
    }

    public void printBrand() {
        System.out.println(brand);
    }
}
