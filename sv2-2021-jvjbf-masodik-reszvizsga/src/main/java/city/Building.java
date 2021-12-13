package city;

public abstract class Building {

    // --- attributes ---------------------------------------------------------

    private int area;
    private int levels;
    private Address address;

    // --- constructors -------------------------------------------------------

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this(area, 1, address);
    }

    // --- getters and setters ------------------------------------------------

    public int getArea() { return area; }
    public int getLevels() { return levels; }
    public Address getAddress() { return address; }

    // --- public methods -----------------------------------------------------

    public int getFullArea() {
        return area * levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();
}