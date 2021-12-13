package city;

public class Office extends Building {

    // --- attributes ---------------------------------------------------------

    private String company;
    private int numberOfTablesPerLevel;

    // --- constructors -------------------------------------------------------

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;

        validateNumberOfTables(numberOfTablesPerLevel);
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;

        validateNumberOfTables(numberOfTablesPerLevel);
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    // --- getters and setters ------------------------------------------------

    public String getCompany() { return company; }
    public int getNumberOfTablesPerLevel() { return numberOfTablesPerLevel; }

    // --- public methods -----------------------------------------------------

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    // --- private methods ----------------------------------------------------

    private void validateNumberOfTables(int numberOfTablesPerLevel) {
        if (isNumberOverMaximum(numberOfTablesPerLevel) || isNumberUnderMinimum(numberOfTablesPerLevel)) {
            throw new IllegalArgumentException("Invalid number of tables per level.");
        }
    }

    private boolean isNumberOverMaximum (int numberOfTablesPerLevel) {
        return numberOfTablesPerLevel * getLevels() * 2 > getFullArea();
    }

    private boolean isNumberUnderMinimum (int numberOfTablesPerLevel) {
        return numberOfTablesPerLevel * getLevels() * 5 < getFullArea();
    }
}