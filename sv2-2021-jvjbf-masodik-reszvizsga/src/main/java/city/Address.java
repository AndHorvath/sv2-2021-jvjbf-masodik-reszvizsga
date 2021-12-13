package city;

public class Address {

    // --- attributes ---------------------------------------------------------

    private String street;
    private int buildingNumber;

    // --- constructors -------------------------------------------------------

    public Address(String street, int buildingNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    // --- getters and setters ------------------------------------------------

    public String getStreet() { return street; }
    public int getBuildingNumber() { return buildingNumber; }
}