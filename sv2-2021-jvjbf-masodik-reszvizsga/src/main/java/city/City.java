package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    // --- attributes ---------------------------------------------------------

    private String name;
    private long fullArea;
    private List<Building> buildings;

    // --- constructors -------------------------------------------------------

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
        this.buildings = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public long getFullArea() { return fullArea; }
    public List<Building> getBuildings() { return buildings; }

    // --- public methods -----------------------------------------------------

    public void addBuilding(Building building) {
        if (getTakenArea() + building.getArea() > fullArea) {
            throw new IllegalArgumentException(getOverAreaExceptionText());
        }
        buildings.add(building);
    }

    // --- private methods ----------------------------------------------------

    private long getTakenArea() {
        long takenArea = 0L;
        for (Building building : buildings) {
            takenArea += building.getArea();
        }
        return takenArea;
    }

    private String getOverAreaExceptionText() {
        return "City can't be larger than " + fullArea;
    }
}