*By Maciej Gowin & coderbrother.com, under MIT license*

> Code for below exercises can be found under ***workshop-part-2***

## Introduce different types of locations

* Add a default constructor with no arguments and update existing one

**File:** *Location.java*
```
    (...)
    
    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }
    
    (...)
```

> **this** keyword provides the reference to the current instance.

* Add city and country locations with new specific property for country

**File:** *City.java*
```
public class City extends Location {
}
```

**File:** *Country.java*
```
public class Country extends Location {
    private String callingCode;

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(final String newCallingCode) {
        callingCode = newCallingCode;
    }
}
```

**File:** *Main.java*
```
        (...)
        
        Country country = new Country();
        City city = new City();

        System.out.printf("Location: %s\n", country.describe());
        System.out.printf("Location: %s\n", city.describe());
        
        (...)
```

> Please note that density returned NaN. As we haven't defined the area we tried to divide by 0 and invalid number was returned.

* Change the location variables assignment

**File:** *Main.java*
```
        (...)
        
        Location cargoLocation = new Country();
        Location passengerLocation = new City();

        System.out.printf("Location: %s\n", cargoLocation.describe());
        System.out.printf("Location: %s\n", passengerLocation.describe());
        
        (...)
```

> In Java you can assign subclass instance to the parent object reference variable. Keep in mind that it will restrict
> the available methods to the one defined in the parent class.

* Add Location subclasses constructors which support name numbers

**File:** *City.java*
```
    (...)
    
    public City() {
    }
    
    public City(String name) {
        super(name);
    }

    (...)
}
```

**File:** *Country.java*
```
    (...)

    public Country() {
    }

    public Country(String name) {
        super(name);
    }

    (...)
}
```

**File:** *Main.java*
```
        (...)
        
        Location country = new Country("Poland");
        Location city = new City("Katowice");

        System.out.printf("Location: %s\n", country.describe());
        System.out.printf("Location: %s\n", city.describe());
        
        (...)
```

> By super() we reference to a constructor of the parent class.

* Remove Location default constructors

**File:** *Location.java*
```
    (...)

    private String name;
    private double latitude;
    private double longitude;
    private int population;
    private double area;

    public Location(String name) {
        this.name = name;
    }

    (...)
}
```

**File:** *City.java*
```
public class City extends Location {

    public City(String name) {
        super(name);
    }
}
```

**File:** *Country.java*
```
public class Country extends Location {
    private String callingCode;

    public Country(String name) {
        super(name);
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(final String newCallingCode) {
        callingCode = newCallingCode;
    }
}
```

* Redefine the array of locations

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Country("Poland");
        location1.setPopulation(38433600);
        location1.setArea(312696.0d);

        Location location2 = new City("Katowice");
        location2.setLongitude(19.0237815d);
        location2.setLatitude(50.2648919d);
        location2.setPopulation(294510);
        location2.setArea(164.67d);

        Location location3 = new Country("Ireland");
        location3.setPopulation(4857000);
        location3.setArea(70273.0d);

        Location location4 = new City("Wroclaw");
        location4.setLongitude(17.0385376);
        location4.setLatitude(51.1078852d);
        location4.setPopulation(640648);
        location4.setArea(292.92d);

        Location[] locations = new Location[] { location1, location2, location3, location4 };

        for (int index = 0; index < locations.length; index++) {
            System.out.printf("Location: %s, Location density: [low: %b, medium: %b, high: %b]\n",
                    locations[index].describe(), locations[index].hasLowDensity(), locations[index].hasMediumDensity(),
                    locations[index].hasHighDensity());
        }

        System.out.println("Finished: " + programName);
    }
}
```

* Redefine the describe method for city and country with reused parent class location description

**File:** *City.java*
```
    (...)

    @Override
    public String describe() {
        return "[City]" + super.describe();
    }
    
    (...)
```

**File:** *Country.java*
```
    (...)

    @Override
    public String describe() {
        return "[Country]" + super.describe();
    }
    
    (...)
```

> Annotation @Override tells us that the definition of the function from parent class has been overriden.

* Block the ability to create an instance of Location class

**File:** *Location.java*
```
public abstract class Location {
    (...)
}
```

> An abstract class can't be instantiated.

## Introduce the location popularity

**File:** *Location.java*
```
public abstract class Location {
    private static final double LOW_DENSITY_LIMIT = 2000.0d;
    private static final double HIGH_DENSITY_LIMIT = 5000.0d;

    private String name;
    private double latitude;
    private double longitude;
    private int population;
    private double area;
    private String popularity;

    (...)

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(final String popularity) {
        this.popularity = popularity;
    }
    
    (...)
    
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
}
```

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Country("Poland");
        location1.setPopulation(38433600);
        location1.setArea(312696.0d);
        location1.setPopularity("medium");

        Location location2 = new City("Katowice");
        location2.setLongitude(19.0237815d);
        location2.setLatitude(50.2648919d);
        location2.setPopulation(294510);
        location2.setArea(164.67d);
        location2.setPopularity("low");

        Location location3 = new Country("Ireland");
        location3.setPopulation(4857000);
        location3.setArea(70273.0d);
        location3.setPopularity("high");

        Location location4 = new City("Wroclaw");
        location4.setLongitude(17.0385376);
        location4.setLatitude(51.1078852d);
        location4.setPopulation(640648);
        location4.setArea(292.92d);
        location4.setPopularity("medium");

        Location[] locations = new Location[] { location1, location2, location3, location4 };

        for (int index = 0; index < locations.length; index++) {
            System.out.printf("Location: %s, Location density: [low: %b, medium: %b, high: %b]\n",
                    locations[index].describe(), locations[index].hasLowDensity(), locations[index].hasMediumDensity(),
                    locations[index].hasHighDensity());
        }

        System.out.println("Finished: " + programName);
    }
}
```

* Introduce an enumeration for the popularity

**File:** *Popularity.java*
```
public enum Popularity {
    LOW, MEDIUM, HIGH;
}
```

**File:** *Location.java*
```
public abstract class Location {
public abstract class Location {
    private static final double LOW_DENSITY_LIMIT = 2000.0d;
    private static final double HIGH_DENSITY_LIMIT = 5000.0d;

    private String name;
    private double latitude;
    private double longitude;
    private int population;
    private double area;
    private Popularity popularity;

    (...)
    
    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(final Popularity popularity) {
        this.popularity = popularity;
    }

    (...)

    public String describe() {
        return new StringBuilder()
                .append("[")
                .append("name: ").append(name).append(", ")
                .append("longitude: ").append(longitude).append(", ")
                .append("latitude: ").append(latitude).append(", ")
                .append("engine: ").append(priority).append(" x ").append(engineType)
                .append("]")
                .toString();
    }
}
```

**File:** *Main.java*
```
        (...)
        
        Location location1 = new Country("Poland");
        location1.setPopulation(38433600);
        location1.setArea(312696.0d);
        location1.setPopularity(Popularity.MEDIUM);

        Location location2 = new City("Katowice");
        location2.setLongitude(19.0237815d);
        location2.setLatitude(50.2648919d);
        location2.setPopulation(294510);
        location2.setArea(164.67d);
        location2.setPopularity(Popularity.LOW);

        Location location3 = new Country("Ireland");
        location3.setPopulation(4857000);
        location3.setArea(70273.0d);
        location3.setPopularity(Popularity.HIGH);

        Location location4 = new City("Wroclaw");
        location4.setLongitude(17.0385376);
        location4.setLatitude(51.1078852d);
        location4.setPopulation(640648);
        location4.setArea(292.92d);
        location4.setPopularity(Popularity.MEDIUM);
        
        (...)
```

* Add a popularity description

**File:** *EngineType.java*
```
public enum Popularity {
    LOW("Low"), MEDIUM("Medium"), HIGH("High");

    private String description;

    Popularity(String description) {
        this.description = description;
    }

    public String describe() {
        return description;
    }
}
```

**File:** *Location.java*
```
    (...)
    
    public String describe() {
        return new StringBuilder()
                .append("[")
                .append("name: ").append(name).append(", ")
                .append("longitude: ").append(longitude).append(", ")
                .append("latitude: ").append(latitude).append(", ")
                .append("population: ").append(population).append(", ")
                .append("area: ").append(area).append(", ")
                .append("popularity: ").append(popularity.describe()).append(", ")
                .append("density: ").append(getDensity())
                .append("]")
                .toString();
    }
    
    (...)
```

* Examine the default location and engine string conversion

**File:** *Main.java*
```
        (...)
        
        for (int index = 0; index < locations.length; index++) {
            System.out.printf("Location: %s\n", locations[index]);
        }
        
        (...)
```

*  Override the default location and popularity conversion

**File:** *Location.java*
```
    (...)

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
    
    (...)
```

**File:** *EngineType.java*
```
    (...)
    
    @Override
    public String toString() {
        return describe();
    }
    
    (...)
```

> In Java each class is a subclass of Object. The Object class defines few generic functions and "toString()" is the prime example. By default Object.toString returns the id of the object.

## Introduce an country registry

* Create an list of cities per country with option to add new city

**File:** *Country.java*
```
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
        cities.add(city);
    }

    @Override
    public String describe() {
        return "[Country]" + super.describe();
    }
}
```

> List is a new data type. It differs from arrays in the size which does not have to be predefined and is unlimited.
> We have to import ArrayList as this class is part of external package provided by Java.

* Redefined registered countries and cities and use proper assignments

**File:** *Main.java*
```
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        City katowice = new City("Katowice");
        katowice.setLongitude(19.0237815d);
        katowice.setLatitude(50.2648919d);
        katowice.setPopulation(294510);
        katowice.setArea(164.67d);
        katowice.setPopularity(Popularity.LOW);

        City wroclaw = new City("Wroclaw");
        wroclaw.setLongitude(17.0385376);
        wroclaw.setLatitude(51.1078852d);
        wroclaw.setPopulation(640648);
        wroclaw.setArea(292.92d);
        wroclaw.setPopularity(Popularity.MEDIUM);

        Country poland = new Country("Poland");
        poland.setPopulation(38433600);
        poland.setArea(312696.0d);
        poland.setPopularity(Popularity.MEDIUM);
        poland.addCity(katowice);
        poland.addCity(wroclaw);

        Country ireland = new Country("Ireland");
        ireland.setPopulation(4857000);
        ireland.setArea(70273.0d);
        ireland.setPopularity(Popularity.HIGH);

        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(poland);
        countries.add(ireland);

        for (int index = 0; index < countries.size(); index++) {
            System.out.printf("%s\n", countries.get(index));
        }

        System.out.println("Finished: " + programName);
    }
}
```

* Redefined Country's describe function to expose information about assigned cities

**File:** *Country.java*
```
    (...)
    
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
    
    (...)
```

> We used foreach to iterate over the ArrayList.

* Make sure that airline's location list does not contain duplicates

**File:** *Country.java*
```
    (...)
    
    public void addCity(final City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }
    
    (...)
```

**File:** *Main.java*
```
        (...)
    
        poland.addCity(katowice);
        poland.addCity(wroclaw);
        poland.addCity(wroclaw);
    
        (...)
```

* Create duplicate city and add it to a country

**File:** *Main.java*
```
        (...)
    
        City wroclawDuplicate = new City("Wroclaw");
        wroclawDuplicate.setLongitude(17.0385376);
        wroclawDuplicate.setLatitude(51.1078852d);
        wroclawDuplicate.setPopulation(640648);
        wroclawDuplicate.setArea(292.92d);
        wroclawDuplicate.setPopularity(Popularity.MEDIUM);

        Country poland = new Country("Poland");
        poland.setPopulation(38433600);
        poland.setArea(312696.0d);
        poland.setPopularity(Popularity.MEDIUM);
        poland.addCity(katowice);
        poland.addCity(wroclaw);
        poland.addCity(wroclaw);
        poland.addCity(wroclawDuplicate);
    
        (...)
```

> The Object.equals function is used for comparison. By default it compare only reference (using == comparison) of the object and not it's internal value.

* Redefine default comparison together with hashCode generation

**File:** *Location.java*
```
    (...)
    
    protected String name;
    protected double latitude;
    protected double longitude;
    protected int population;
    protected double area;
    protected Popularity popularity;
    
    (...)
```

> We had to change access of fields to protected so all subclasses can access the fields.

**File:** *City.java*
```
(...)
import java.util.Objects;

(...)

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

(...)
```

> The general contract of hashCode is: ... If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result. More details under: https://www.baeldung.com/java-equals-hashcode-contracts
