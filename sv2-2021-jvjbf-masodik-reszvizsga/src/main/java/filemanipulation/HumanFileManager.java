package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    // --- attributes ---------------------------------------------------------

    private List<Human> humans;

    // --- constructors -------------------------------------------------------

    public HumanFileManager() {
        humans = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Human> getHumans() { return humans; }

    // --- public methods -----------------------------------------------------

    public void readHumansFromFile(Path path) {
        List<String> stringHumanList = readStringListFromFile(path);
        String[] stringHumanArray;
        for (String stringHuman : stringHumanList) {
            stringHumanArray = stringHuman.split(";");
            humans.add(new Human(stringHumanArray[0], stringHumanArray[1]));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getMaleHumansStringList());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // --- private methods ----------------------------------------------------

    private List<String> readStringListFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("Can't read file!", exception);
        }
    }

    private List<String> getMaleHumansStringList() {
        List<String> maleHumansStringList = new ArrayList<>();
        for (Human human : humans) {
            if (isMale(human)) {
                maleHumansStringList.add(createHumanString(human));
            }
        }
        return maleHumansStringList;
    }

    private boolean isMale(Human human) {
        return human.getIdentityNumber().charAt(0) == '1' || human.getIdentityNumber().charAt(0) == '3';
    }

    private String createHumanString(Human human) {
        return human.getName() + ";" + human.getIdentityNumber();
    }
}