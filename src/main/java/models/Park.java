package models;

public class Park {
    private static int ID_COUNT = 12_543;

    public int id;
    public String name;
    public String location;
    public int area;

    public Park(String name, String location, int area) {
        this.id = ID_COUNT++;
        this.name = name;
        this.location = location;
        this.area = area;
    }
}