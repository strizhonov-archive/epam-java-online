package aggregationcomposition.second;

public class Engine {

    private boolean isEngineOn;

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public void setEngineOn(boolean engineOn) {
        isEngineOn = engineOn;
    }

    public void start() {
        isEngineOn = true;
        System.out.println("Engine started.");
    }

}
