package aggregationcomposition.third;

public class District {

    private City[] cities;
    private double area;
    private City capital;

    public District(City[] cities, double area, City capital) {
        this.cities = cities;
        this.area = area;
        this.capital = capital;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }
}
