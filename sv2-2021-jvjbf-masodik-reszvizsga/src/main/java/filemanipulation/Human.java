package filemanipulation;

public class Human {

    // --- attributes ---------------------------------------------------------

    private String name;
    private String identityNumber;

    // --- constructors -------------------------------------------------------

    public Human(String name, String identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public String getIdentityNumber() { return identityNumber; }
}