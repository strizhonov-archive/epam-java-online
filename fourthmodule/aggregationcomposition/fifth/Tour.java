package aggregationcomposition.fifth;

public class Tour {

    private TourType type;
    private Transport transport;
    private int durationDays;
    private boolean areMealsIncluded;

    public Tour(TourType type, Transport transport, int durationDays, boolean areMealsIncluded) {
        this.type = type;
        this.transport = transport;
        this.durationDays = durationDays;
        this.areMealsIncluded = areMealsIncluded;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public boolean areMealsIncluded() {
        return areMealsIncluded;
    }

    public void setAreMealsIncluded(boolean areMealsIncluded) {
        this.areMealsIncluded = areMealsIncluded;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "type=" + type +
                ", transport=" + transport +
                ", durationDays=" + durationDays +
                ", areMealsIncluded=" + areMealsIncluded +
                '}' + "\n";
    }
}
