package seedu.voyagers.utils;
import seedu.voyagers.classes.Profile;
import seedu.voyagers.classes.ProfileList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileStorage {
    public static void readProfileFile(ProfileList profileList, String currentDir, String fileName) {
        try {
            File f = new File(currentDir + "/" + fileName);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String[] inputs = s.nextLine().split("\\|", 2);
                assert inputs.length == 2 : "Invalid input format";
                Profile profile = new Profile(inputs[0], Currency.valueOf(inputs[1]));
                ProfileList.add(profile);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Profile file not found.\nCreating new profile file...\nProfile file created.");
        }
    }

    public static void writeProfileFile(ArrayList<Profile> profiles, int size, String currentDir, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(currentDir + "/" + fileName);
            for (int i = 0; i < size; i++) {
                fileWriter.write(profiles.get(i).toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
