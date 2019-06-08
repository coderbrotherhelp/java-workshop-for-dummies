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
            System.out.printf("Location: %s, Location density: [small: %b, medium: %b, large: %b]\n",
                    locations[index].describe(), locations[index].hasLowDensity(), locations[index].hasMediumDensity(),
                    locations[index].hasHighDensity());
        }

        System.out.println("Finished: " + programName);
    }
}