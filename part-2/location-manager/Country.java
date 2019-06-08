import java.util.ArrayList;

public class Country extends Location {
    private String callingCode;
    private ArrayList<City> cities;

    public Country(String name) {
        super(name);
        this.cities = new ArrayList<City>();
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(final String newCallingCode) {
        callingCode = newCallingCode;
    }

    public void addCity(final City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    @Override
    public String describe() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("[Country]")
                .append(super.describe())
                .append("[Cities]");

        for (City city : cities) {
            stringBuilder.append("\n- ").append(city);
        }
        return stringBuilder.toString();
    }
}
