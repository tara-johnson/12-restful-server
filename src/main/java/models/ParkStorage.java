package models;

import java.util.HashMap;
import java.util.Map;

public class ParkStorage {
    public static Map<Integer, Park> parks;
    static {
        parks = new HashMap<>();
        Park arches = new Park("Arches", "Utah", 76_679);
        Park badlands = new Park("Badlands", "South Dakota", 242_756);

        parks.put(arches.id, arches);
        parks.put(badlands.id, badlands);
    }
}