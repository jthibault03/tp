package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;

public class HelpCommand extends Command{

    @Override
    public void execute(TripList tasks, Ui ui, TripStorage tripStorage) {
        ui.echo("Here are the commands you can use:", true, false);
        ui.echo("1. addmaintrip - add a main trip with name, start, end, location and description",
                false, false);
        ui.echo("   addmaintrip /n <name> /start yyyy-MM-dd /end yyyy-MM-dd /location <location /d <description"
                , false, false);
        ui.echo("2. How to modify main trips:",
                false, false);
        ui.echo("   setname <current_name> /n <new_name> - You can change name of main trips only",
                false, false);
        ui.echo("   setdates <current_name> /start <yyyy-MM-dd> /end <yyyy-MM-dd>",
                false, false);
        ui.echo("   setlocation <current_name> /location <location>",
                false, false);
        ui.echo("   setdescription <current_name> /d <description>",
                false, false);
        ui.echo("   setstatus - cancel or uncancel a trip without deleting it from the database",
                false, false);
        ui.echo("   setstatus <current_name> /status <cancel OR uncancel>",
                false, false);
        ui.echo("3. list - Lists all trips", false, false);
        ui.echo("   list <status> - list by status (upcoming, ongoing, completed, cancelled)",
                false, false);
        ui.echo("4. add - Adds a trip", false, false);
        ui.echo("5. deletemaintrip /n <main_trip_name> - Deletes a main trip", false, false);
        ui.echo("6. deletesubtrip /n <main_trip_name> /i <index - Deletes a sub trip", false, false);
        ui.echo("7. addbill /trip <trip_name> /n <bill_name> /payer <payer_name> /others <debtor_names> /amount <bill_total> /percentages <percentages>", false, false);

        ui.echo("8. paybill /trip <trip_name> /n <bill_name>", false, false);
        ui.echo("9. listbills - lists all bills", false, false);
        ui.echo("10. find - Finds a trip", false, false);
        ui.echo("   find <keyword> - show trips whose names contain the keyword", false, false);
        ui.echo("11. help - Shows the help message", false, false);
        ui.echo("12. review <main_trip_name> /s <1-10> /r <reflection> - Give your thoughts on a main trip",
                false, false);
        ui.echo("13. readreview <main_trip_name> - Read your review", false, false);
        ui.echo("14. exit - Exits the program",false, true);
    }
}
