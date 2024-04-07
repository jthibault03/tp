# Developer Guide - Voyagers

## Acknowledgements

This project is a team effort by the NUS CS2113 Group W14-4

## Setting Up, Getting Started

Run the JAR File, then follow the prompts through the command-line interface. Refer to this guide for syntax.

## Architecture

{UML Diagram of high-level app architecture}
Given below is a quick overview of main components and how they interact with each other.

Voyagers {...}  
Parser {...}  
Commands {...}  
Storage {...}  
Ui {...}  
Trip {...}  
Bill {...}

How the architecture components interact with each other
{Sequence Diagram}


## Design & implementation

The Voyagers application is designed as a command-line interface 
(CLI) tool for managing travel trips. 
It is implemented in Java and follows a modular architecture to promote scalability and maintainability.

### Normal flow of the application

The application starts by displaying a welcome message. Then the flow is as follows:

1. The user is prompted to enter a command.
2. The application processes the command and displays the appropriate output.
3. Steps 1 and 2 are repeated until the user enters the `exit` command.

The implementation of this flow is made using four main classes: `Parser`, `Commands`, `Storage` and `Ui`.
With these classes we can encapsulate the whole logic of the application in a relative simple loop.

````java
                                    ...
  while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = NewParser.parse(fullCommand);
                c.execute(tripList, ui, null);
                isExit = c.isExit();

            } catch (Exception e) { 
                ui.echo(e.getMessage());
            }
        }
                                ...
````

The following UML sequence diagram shows the flow of the application when the user enters a command.

![Sequence Diagram](diagrams/seq_diagram_flow.png)

### Commands

As shown in the sequence diagram, commands are encapsulated in the `Command` class.
This class is abstract and each command is implemented in a subclass of `Command`.

The `Command` class has the following structure:

````java
public abstract class Command {
    protected boolean isExit = false;
    public abstract void execute(TripList tripList, Ui ui, Storage storage) throws VoyagersException;
    public boolean isExit() {
        return isExit;
    }
}
````

The main logic of each command is implemented in the `execute` method. 

### Parser

To parser the user input into a command we have implemented a `Parser` class. 
This parser is quite generic and easy to extend to include new commands.

The parser works with another class called 'ParserDefinition'. This class is a simple data structure that contains the
expected arguments for each command.

### Simplifying bills: minimizing number of transactions.

Each trip can have multiple bills associated. We have decided to include a functionality to simplify the bills
from a trip. This means that we will try to minimize the number of transactions between the participants of the trip.

The implementation uses a graph algorithm to find the minimum number of transactions between the participants of the trip.
The code has been adapted to the one found in the following [link](https://medium.com/@mithunmk93/algorithm-behind-splitwises-debt-simplification-feature-8ac485e97688).

The next diagram shows the flow of the application after the user enters the `simplifybills` command.

![Sequence Diagram](diagrams/diag_simplify_bills_2.png)


## Bill
Bill implements Payable, an interface to be used a few times in this project to cover 
actions involving payment. It is dependent on the Profile and Trip classes, and Parser
is dependent on the Bill class. We will include this in the UML diagrams to be included soon.
Currently, the supported public methods can add and remove Profiles, pay the bill, change
percentages that different people owe, and set and return various attributes. This is still
not fully fleshed out, as we will add more features and better functionality in subsequent
releases.

## Review
The Review class, instantiated solely by the Trip object. 
It enables users to assign trip ratings (1-10) in Review's 'int score' attribute and input personal reflections and 
encapsulates individual sentiments in Review's 'String reflection attribute, facilitating comprehensive user feedback.
Currently, Reviews are not stored when the app exits, this implementation is planned.

## Product scope
### Target user profile

Individuals who frequently embark on journeys and require a reliable method to document their itinerary, 
capture memories through photos, and track expenses effectively.

### Value proposition

The ultimate travel companion designed for adventurers who crave seamless organisation and unforgettable experiences. 
With our intuitive digital diary, users can effortlessly manage their itinerary, capture precious memories with 
integrated photo features, and track expenses for a worry-free journey. Users can enjoy anytime, anywhere access across 
their local devices. We also have customisation options tailored to users’ unique style.


## User Stories

|Version| As a ... | I want to ...   | So that I can ...                                    |
|--------|----------|-----------------|------------------------------------------------------|
|v1.0|new user| add a new trip  | plan my upcoming travel itinerary                    |
|v2.0|user| review my trips | give scores or simple comments on my completed trips |

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
