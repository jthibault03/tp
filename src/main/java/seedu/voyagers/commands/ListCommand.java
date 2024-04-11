package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Status;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;

public class ListCommand extends Command{

    public ListCommand(){
        this.args = new String[2];
        this.args[0] = "list";
        this.args[1] = "blank";
    }

    public ListCommand(String[] args){
        super(args);
	}

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        if(args.length == 1){
            args = padArgs();
        }
        switch(args[1]){
            case "upcoming":
                listUpcoming(trips, ui);
                break;
            case "ongoing":
                listOngoing(trips, ui);
                break;
            case "completed":
                listCompleted(trips, ui);
                break;
            case "blank":
                ListAll(trips, ui);
                break;
            default:
                ui.echo("Invalid list type. Please enter a valid list type.");
                break;
        }
    }

    public void ListAll(TripList trips, Ui ui) {
        if (trips.size() == 0){
            ui.echo("You have no trips in your list.");
            return;
        }

        ui.echo("Here are the trips in your list:");
        for (int i = 0; i < trips.size(); i++){
            ui.echo((i + 1) + ". " + trips.get(i));
        }
    }

    public void listUpcoming(TripList trips, Ui ui) {
        int numberTrips = 0;
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.UPCOMING){
                numberTrips ++;
            }
        }
        if (trips.size() == 0){
            ui.echo("You have no trips in your list.");
            return;
        }
        ui.echo("Here are the trips in your list:");
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.UPCOMING){
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    public void listOngoing(TripList trips, Ui ui) {
        int numberTrips = 0;
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.ONGOING){
                numberTrips ++;
            }
        }
        if (trips.size() == 0){
            ui.echo("You have no trips in your list.");
            return;
        }
        ui.echo("Here are the trips in your list:");
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.ONGOING){
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    public void listCompleted(TripList trips, Ui ui) {
        int numberTrips = 0;
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.COMPLETED){
                numberTrips ++;
            }
        }
        if (trips.size() == 0){
            ui.echo("You have no trips in your list.");
            return;
        }
        ui.echo("Here are the trips in your list:");
        for (int i = 0; i < trips.size(); i++){
            if (trips.get(i).getStatus() == Status.COMPLETED){
                ui.echo((i + 1) + ". " + trips.get(i));
            }
        }
    }

    private String[] padArgs() {
        String[] newArgs = new String[2];
        newArgs[0] = "list";
        newArgs[1] = "blank";
        return newArgs;
    }
}
