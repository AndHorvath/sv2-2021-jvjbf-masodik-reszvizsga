package city;

public class Home extends Building {

    // --- attributes ---------------------------------------------------------

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    // --- constructors -------------------------------------------------------

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        validateLevelsParameter(levels);
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    // --- public methods ------------------------------------------------------

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
    }


    // --- private methods -----------------------------------------------------

    private void validateLevelsParameter(int levels) {
        if (levels > 3) {
            throw new IllegalArgumentException("Illegal levels argument.");
        }
    }
}