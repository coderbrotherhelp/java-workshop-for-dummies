import java.util.Objects;

public class City extends Location {

    public City(String name) {
        super(name);
    }

    @Override
    public String describe() {
        return "[City]" + super.describe();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        City other = (City) otherObject;
        return Objects.equals(name, other.name)
                && Objects.equals(latitude, other.latitude)
                && Objects.equals(longitude, other.longitude)
                && Objects.equals(population, other.population)
                && Objects.equals(area, other.area)
                && Objects.equals(popularity, other.popularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
