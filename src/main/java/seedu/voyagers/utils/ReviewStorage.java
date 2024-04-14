package seedu.voyagers.utils;

import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.classes.Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewStorage {
    private static final Logger LOGGER = Logger.getLogger("Storage");


    /**
     * Reads the trip file and adds the trips to the list of trips.
     *
     * @param tripList   The class which contains a list of trips.
     * @param currentDir The current directory of the file.
     * @param fileName   The name of the file to read from.
     */
    public static void readReviewFile(TripList tripList, String currentDir, String fileName) {

        Logger logger = Logger.getLogger("Storage");
        //local path of data file
        File f = new File(currentDir + "/" + fileName);

        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String[] inputs = s.nextLine().split("\\|", 3);
                assert inputs.length == 3 : "Invalid input format";
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Trip trip = null;
                trip = tripList.getTrip(inputs[0]);
                if (trip == null) {
                    throw new NullPointerException("Trip not found");
                }
                Review review = trip.getReview();
                review.setScore(inputs[1]);
                review.setReflection(inputs[2]);
            }
            s.close();
        } catch (FileNotFoundException e) {

            System.out.println("Review file not found.\nCreating new review file...\nReview file created.");
            try {
                assert f.createNewFile() : "Review File creation failed";
                f.createNewFile();
                logger.log(Level.INFO, "Review file created.");
            } catch (java.io.IOException ex) {
                System.out.println("An error occurred.");
                logger.log(Level.SEVERE, "An error occurred when creating the review file.");
            }
        } catch (NullPointerException e) {
            System.out.println("Trip from local-reviews.txt not found.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Writes the trips to the trip file.
     *
     * @param tripList   The class which containts a list of trips.
     * @param tripsCount The number of trips in the list.
     * @param currentDir The current directory of the file.
     */
    public static void writeReviewFileMain(TripList tripList, int tripsCount, String currentDir, String fileName) {
        //local path of data file
        File f = new File(currentDir + "/" + fileName);

        try (java.io.FileWriter writer = new java.io.FileWriter(f)) {
            for (int i = 0; i < tripsCount; i++) {
                Trip trip = tripList.get(i);
                if (trip.getTripType()=="main") {
                    parseToFile(writer, trip);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void parseToFile(FileWriter writer, Trip trip) throws IOException {
        Review review = trip.getReview();
        writer.write(trip.getName() + "|" + review.getScore() + "|" + review.getReflection() +
                "\n");
    }
}
