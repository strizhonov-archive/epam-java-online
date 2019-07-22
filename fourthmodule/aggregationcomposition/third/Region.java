package aggregationcomposition.third;

public class Region {

    private District[] districts;
    private double area;
    private City capital;

    public Region(District[] districts, City capital) {
        this.districts = districts;
        this.capital = capital;

        for (District district : districts) {
            area += district.getArea();
        }
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
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
