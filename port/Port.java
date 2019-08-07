import java.util.ArrayList;

public class Port {

    private ArrayList<Pier> piers;

    public Port(int size) {
        piers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            piers.add(new Pier());
        }
    }

    public Pier getFreePier() {
        for (int i = 0; i < piers.size(); i++) {
            if (!piers.get(i).hasVessel()) {
                return piers.get(i);
            }
        }
        return null;
    }
}