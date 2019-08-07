package port.model;

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
        for (Pier pier : piers) {
            if (!pier.hasVessel()) {
                return pier;
            }
        }
        return null;
    }
}