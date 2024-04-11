package seedu.voyagers.commands;

import seedu.voyagers.classes.ProfileList;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.ProfileStorage;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

/*
public class ListProfileCommand extends Command{
    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        if (trips.size() == 0){
            ui.echo("You have no profiles in your list.");
            return;
        }

        ui.echo("Here are the profiles in your list:");
        int counter = 0;
        for (int i = 0; i < trips.size(); i++){
            ProfileList profileList = trips.get(i).getProfiles();
            for (int j = 0; j < profileList.size(); j++) {
                ui.echo((counter + 1) + ". " + profileList.get(j));
                counter++;
            }
        }

        if (counter == 0) {
            ui.echo("You have no bills in your list.");
            return;
        }
    }
}
*/