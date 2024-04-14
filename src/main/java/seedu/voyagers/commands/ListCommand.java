package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Status;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;

public class ListCommand extends Command {

    public ListCommand() {
        this.args = new String[2];
        this.args[0] = "list";
        this.args[1] = "all";
    }

    public ListCommand(String[] args) {
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage) {
        if (args.length == 1) {
            args = padArgs();
        }
        switch (args[1]) {
        case "upcoming":
            listUpcoming(trips, ui);
            break;
        case "ongoing":
            listOngoing(trips, ui);
            break;
        case "completed":
            listCompleted(trips, ui);
            break;
        case "cancelled":
            listCancelled(trips, ui);
            break;
        case "all":
            listAll(trips, ui);
            break;
        default:
            ui.echo("Invalid list type. Please enter a valid list type.");
            break;
        }
    }

    public void listAll(TripList trips, Ui ui) {
        if (trips.size() == 0) {
            ui.echo("You have no trips in your list.");
            return;
        }

        ui.echo("Here are the trips in your list:");
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getTripType() == "main") {
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    public void listUpcoming(TripList trips, Ui ui) {
        boolean hasTrip = false;
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.UPCOMING) {
                hasTrip = true;
                break;
            }
        }
        if (!hasTrip) {
            ui.echo("You have no upcoming trips in your list.");
            return;
        }
        ui.echo("Here are the upcoming trips in your list:");
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.UPCOMING && trips.get(i).getTripType() == "main") {
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    public void listOngoing(TripList trips, Ui ui) {
        boolean hasTrip = false;
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.ONGOING) {
                hasTrip = true;
                break;
            }
        }
        if (!hasTrip) {
            ui.echo("You have no ongoing trips in your list.");
            return;
        }
        ui.echo("Here are the ongoing trips in your list:");
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.ONGOING && trips.get(i).getTripType() == "main") {
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    public void listCompleted(TripList trips, Ui ui) {
        boolean hasTrip = false;
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.COMPLETED) {
                hasTrip = true;
                break;
            }
        }
        if (!hasTrip) {
            ui.echo("You have no completed trips in your list.");
            return;
        }
        ui.echo("Here are the completed trips in your list:");
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.COMPLETED && trips.get(i).getTripType() == "main") {
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    private void listCancelled(TripList trips, Ui ui) {
        boolean hasTrip = false;
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.CANCELLED) {
                hasTrip = true;
                break;
            }
        }
        if (!hasTrip) {
            ui.echo("You have no cancelled trips in your list.");
            return;
        }
        ui.echo("Here are the cancelled trips in your list:");
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getStatus() == Status.CANCELLED && trips.get(i).getTripType() == "main") {
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    private String[] padArgs() {
        String[] newArgs = new String[2];
        newArgs[0] = "list";
        newArgs[1] = "all";
        return newArgs;
    }
}
