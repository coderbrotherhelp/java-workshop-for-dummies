*By Maciej Gowin & coderbrother.com, under MIT license*

> Code for below exercises can be found under ***workshop-part-1***

## Create "Location Manager" project

* Define the project directory, ie. "location-manager"

* Create file: Main.java with following content defined:
```
public class Main {
    public static void main(String[] args) {
    }
}
```

* Compile created project
```
javac Main.java
```

* Execute the project
```
javac Main
```

## Create startup output

* In the Main class create System.out invocations

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        System.out.println("Started: Location Manager");
        System.out.println("Finished: Location Manager");
    }
}
```

* Replace the inline string with a String variable and utilize a string concatenation

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);
        System.out.println("Finished: " + programName);
    }
}
```

* Recompile and run the project
```
javac Main.java && java Main

```

> Compilation needs to be performed after each code change. Run the comman each time you want to test your changes. Above code needs to be run in each exercise unless different command stated explicitly.

## Introduce an Location class

* Create an Location class 

**File:** *Location.java*
```
public class Location {
    public String name;
}
```

* Create an instance of newly created class in the Main class

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);
        
        Location location1 = new Location();
        System.out.println(location1.name);
        
        System.out.println("Finished: " + programName);
    }
}
```

> If the value of the object is not defined, all class object fields will default to **null**.

* Set the name

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location();
        location1.name = "Katowice";
        System.out.println(location1.name);

        System.out.println("Finished: " + programName);
    }
}
```

* Create a getter and a setter for the name field and make it **private**

**File:** *Location.java*
```
public class Location {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}
```

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location();
        location1.setName("Katowice");
        System.out.println(location1.getName());

        System.out.println("Finished: " + programName);
    }
}
```

> The **name** field of the **Location** is **public** which means that it can be accessed from anywhere.
> Java defines 4 access modifiers: **public**, **package**, **protected** and **private**.

* Create new constructor which takes the name as a parameter

**File:** *Location.java*
```
    (...)

    public Location(String newName) {
        name = newName;
    }
    
    (...)
```

> Constructors define the way a class is instantiated. If a constructor is not defined, default one will be generated automatically.

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        System.out.println(location1.getName());

        System.out.println("Finished: " + programName);
    }
}
```

> Once the custom constructor is defined the default constructor is disabled automatically. If you want to keep the default constructor you have to define it implicitly.

* Override the name with a "setter" method

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        location1.setName("Dublin");
        System.out.println(location1.getName());

        System.out.println("Finished: " + programName);
    }
}
```

* Remove the "setter" method invocation

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        System.out.println(location1.getName());

        System.out.println("Finished: " + programName);
    }
}
```

## Introduce an array

* Create second location

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        System.out.println(location1.getName());

        Location location2 = new Location("Wroclaw");
        System.out.println(location2.getName());

        System.out.println("Finished: " + programName);
    }
}
```

* Define a Java array of locations with predefined size

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        Location location2 = new Location("Wroclaw");

        Location[] locations = new Location[2];
        locations[0] = location1;
        locations[1] = location2;

        System.out.println(locations[0].getName());
        System.out.println(locations[1].getName());

        System.out.println("Finished: " + programName);
    }
}
```

> Size of the array needs to be predefined. If you try to add more elements than the defined size of the array, **ArrayIndexOutOfBoundsException** exception will be thrown.

* Create an array based on objects

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        Location location2 = new Location("Wroclaw");

        Location[] locations = new Location[] { location1, location2 };

        System.out.println(locations[0].getName());
        System.out.println(locations[1].getName());

        System.out.println("Finished: " + programName);
    }
}
```

> Java will define the size of an array based on the objects in the constructor.

## Introduce a "for" loop

* Change the invocation of System.out.println on each object to be invoked in a **for** loop

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        Location location2 = new Location("Wroclaw");

        Location[] locations = new Location[] { location1, location2 };

        for (int index = 0; index < locations.length; index++) {
            System.out.println(locations[index].getName());
        }

        System.out.println("Finished: " + programName);
    }
}
```

## Introduce new primitive types

* Add Location latitude, longitude and engine quantity fields

**File:** *Location.java*
```
public class Location {
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
}
```

* Set new properties on Location instances and override console output

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        location1.setLongitude(19.0237815d);
        location1.setLatitude(50.2648919d);
        location1.setPopulation(294510);
        location1.setArea(164.67d);

        Location location2 = new Location("Wroclaw");
        location2.setLongitude(17.0385376);
        location2.setLatitude(51.1078852d);
        location2.setPopulation(640648);
        location2.setArea(292.92d);

        Location[] locations = new Location[] { location1, location2 };

        for (int index = 0; index < locations.length; index++) {
            System.out.println("Location: " + locations[index].getName() + ": " + locations[index].getLongitude()
                    + ": " + locations[index].getLatitude() + ": " + locations[index].getPriority());
        }

        System.out.println("Finished: " + programName);
    }
}
```

> Java defaults non-initialised primitives to: **0** for int, **0.0** for double. As mentioned before all non-initialized object fields are set to **null**.

> Each primitive has corresponding, built-in Java class defined (ie. Integer for int, Double for double etc.). The conversion between a primitive and a wrapper is done automatically.

* Introduce describe method which returns a string description of the location

**File:** *Location.java*
```
    (...)
    
    public String describe() {
        return "[name: " + name + ", longitude: " + longitude + ", latitude: " + latitude
                + ", population: " + population + ", area: " + area + "]";
    }
    
    (...)
```

**File:** *Main.java*
```
public class Main {
    public static void main(String[] args) {
        String programName = "Location Manager";
        System.out.println("Started: " + programName);

        Location location1 = new Location("Katowice");
        location1.setLongitude(19.0237815d);
        location1.setLatitude(50.2648919d);
        location1.setPopulation(294510);
        location1.setArea(164.67d);

        Location location2 = new Location("Wroclaw");
        location2.setLongitude(17.0385376);
        location2.setLatitude(51.1078852d);
        location2.setPopulation(640648);
        location2.setArea(292.92d);

        Location[] locations = new Location[] { location1, location2 };

        for (int index = 0; index < locations.length; index++) {
            System.out.println("Location: " + locations[index].describe());
        }

        System.out.println("Finished: " + programName);
    }
}
```

* Change the describe method body to use a Java StringBuilder

**File:** *Location.java*
```
    (...)
    
    public String describe() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("[")
                .append("name: ").append(name).append(", ")
                .append("longitude: ").append(longitude).append(", ")
                .append("latitude: ").append(latitude).append(", ")
                .append("population: ").append(population).append(", ")
                .append("area: ").append(area)
                .append("]");
        return builder.toString();
    }
    
    (...)
```

> StringBuilder is one of the built-in utility classes. It is defined in the java.lang package which does not have to imported explicitly. More about package and imports in next section.

* Remove a variable assignment

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
                .append("area: ").append(area)
                .append("]")
                .toString();
    }
    
    (...)
```

* Add a check if an location has low density

**File:** *Location.java*
```
    (...)
    
    public boolean hasLowDensity() {
        double density = population / area;
        if (density < 2000.0d) {
            return true;
        } else {
            return false;
        }
    }
    
    (...)
```

> The condition if/else/then is one of the most important block statement in every programming language.

* Add a check if an location has medium density

**File:** *Location.java*
```
    (...)
    
    public boolean hasMediumDensity() {
        double density = population / area;
        if (density >= 2000.0d && density < 5000.0d) {
            return true;
        } else {
            return false;
        }
    }
    
    (...)
```

* Add a check if an location is high density

**File:** *Location.java*
```
    (...)
    
    public boolean hasHighDensity() {
        double density = population / area;
        if (density >= 5000.0d) {
            return true;
        } else {
            return false;
        }
    }
    
    (...)
```

* Create a reusable density calculation method

**File:** *Location.java*
```
    (...)
    
    public double getDensity() {
        return population / area;
    }

    public boolean hasLowDensity() {
        double density = getDensity();
        if (density < 2000.0d) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasMediumDensity() {
        double density = getDensity();
        if (density >= 2000.0d && density < 5000.0d) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasHighDensity() {
        double density = getDensity();
        if (density >= 5000.0d) {
            return true;
        } else {
            return false;
        }
    }
    
    (...)
```

* Extract the area constraints and reuse inline method invocation for density calculations

**File:** *Location.java*
```
    (...)
    
    private static final double LOW_DENSITY_LIMIT = 2000.0d;
    private static final double HIGH_DENSITY_LIMIT = 5000.0d;
    
    (...)

    public double getDensity() {
        return population / area;
    }

    public boolean hasLowDensity() {
        if (getDensity() < LOW_DENSITY_LIMIT) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasMediumDensity() {
        double density = getDensity();
        if (density >= LOW_DENSITY_LIMIT && density < HIGH_DENSITY_LIMIT) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasHighDensity() {
        if (getDensity() >= HIGH_DENSITY_LIMIT) {
            return true;
        } else {
            return false;
        }
    }
    
    (...)
```

> "&&" (AND) is an example of logical operator in Java. Another well know logical operators is "||" (OR).

* Examine the location density

**File:** *Main.java*
```
        (...)
        
        for (int index = 0; index < locations.length; index++) {
            System.out.printf("Location: %s, Location density: [small: %b, medium: %b, large: %b]\n",
                    locations[index].describe(), locations[index].hasLowDensity(), locations[index].hasMediumDensity(),
                    locations[index].hasHighDensity());
        }
        
        (...)
```

* Update the size calculations for code reuse and remove unnecessary if/else statement.

**File:** *Location.java*
```
    (...)
    
    public boolean hasLowDensity() {
        return getDensity() < LOW_DENSITY_LIMIT;
    }

    public boolean hasMediumDensity() {
        return !hasLowDensity() && !hasHighDensity();
    }

    public boolean hasHighDensity() {
        return getDensity() >= HIGH_DENSITY_LIMIT;
    }
    
    (...)
```

> "!" is an unary operator. It works on boolean values by negating the value of the variable. In the other words
> it changes the value from **true** to **false** and **false** to **true**.
