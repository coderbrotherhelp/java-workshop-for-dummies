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
