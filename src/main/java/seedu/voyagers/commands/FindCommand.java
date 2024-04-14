package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

public class FindCommand extends Command{
    public FindCommand(String[] args) {
        super(args);
    }

    public void execute(TripList tasks, Ui ui, TripStorage tripStorage){
        TripList toPrintTrips = new TripList(tasks.size());
        findWithKeyword(args[0], tasks, toPrintTrips);
        if(toPrintTrips.size() == 0){
            ui.echo("No trips found.");
            return;
        }
        for(int i = 0; i < toPrintTrips.size(); i++){
            ui.echo(toPrintTrips.get(i).toString());
        }
    }


    private void findWithKeyword(String keyword, TripList tasks, TripList foundList){
        int i = 0;
        while(i < tasks.size()){
            String tripName;
            tripName = tasks.get(i).getName();
            if(tripName.contains(keyword)){
                foundList.add(tasks.get(i));
            }
            i++;
        }
    }
}
