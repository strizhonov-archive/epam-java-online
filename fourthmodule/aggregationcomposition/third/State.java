package aggregationcomposition.third;

public class State {

    private City capital;
    private double area;
    private Region[] regions;

    public State(City capital, Region[] regions) {
        this.capital = capital;
        this.regions = regions;

        for (Region region : regions) {
            area += region.getArea();
        }
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public void printCapital() {
        System.out.println(capital);
    }

    public void printNumberOfRegions() {
        System.out.println(regions.length);
    }

    public void printArea() {
        System.out.println(area);
    }

    public void printRegionCapitals() {
        for (Region region : regions) {
            System.out.println(region.getCapital());
        }
    }


}
