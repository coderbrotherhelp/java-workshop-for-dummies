public class Location {
    private static final double LOW_DENSITY_LIMIT = 2000.0d;
    private static final double HIGH_DENSITY_LIMIT = 5000.0d;

    private String name;
    private double latitude;
    private double longitude;
    private int population;
    private double area;

    public Location(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double newLatitude) {
        latitude = newLatitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double newLongitude) {
        longitude = newLongitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int newPopulation) {
        population = newPopulation;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double newArea) {
        area = newArea;
    }

    public double getDensity() {
        return population / area;
    }

    public boolean hasLowDensity() {
        return getDensity() < LOW_DENSITY_LIMIT;
    }

    public boolean hasMediumDensity() {
        return !hasLowDensity() && !hasHighDensity();
    }

    public boolean hasHighDensity() {
        return getDensity() >= HIGH_DENSITY_LIMIT;
    }

    public String describe() {
        return new StringBuilder()
                .append("[")
                .append("name: ").append(name).append(", ")
                .append("longitude: ").append(longitude).append(", ")
                .append("latitude: ").append(latitude).append(", ")
                .append("population: ").append(population).append(", ")
                .append("area: ").append(area).append(", ")
                .append("density: ").append(getDensity())
                .append("]")
                .toString();
    }
}