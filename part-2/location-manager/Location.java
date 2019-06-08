public abstract class Location {
    private static final double LOW_DENSITY_LIMIT = 2000.0d;
    private static final double HIGH_DENSITY_LIMIT = 5000.0d;

    protected String name;
    protected double latitude;
    protected double longitude;
    protected int population;
    protected double area;
    protected Popularity popularity;

    public Location(String name) {
        this.name = name;
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

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(final Popularity popularity) {
        this.popularity = popularity;
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
                .append("popularity: ").append(popularity).append(", ")
                .append("density: ").append(getDensity())
                .append("]")
                .toString();
    }

    @Override
    public String toString() {
        return describe();
    }
}