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

    public Building findHighestBuilding() {
        Building highestBuilding = null;
        for (Building building : buildings) {
            if (highestBuilding == null || building.getLevels() > highestBuilding.getLevels()) {
                highestBuilding = building;
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> buildingsInGivenStreet = new ArrayList<>();
        for (Building building : buildings) {
            if (street.equals(building.getAddress().getStreet())) {
                buildingsInGivenStreet.add(building);
            }
        }
        return buildingsInGivenStreet;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
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