# Developer Guide - Voyagers

## Acknowledgements

This project is a team effort by the NUS CS2113 Group W14-4

## Design & implementation

The Voyagers application is designed as a command-line interface 
(CLI) tool for managing travel trips. 
It is implemented in Java and follows a modular architecture to promote scalability and maintainability.

The following UML sequence diagram shows the flow of the application when the user enters a command.

![Sequence Diagram](diagrams/seq_diagram_flow.png)

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
                                ...
````

### Settling a bill: minimizing number of transactions.

To be implemented.

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
