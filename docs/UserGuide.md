# Voyagers

Voyagers is a Java application designed to manage trips efficiently through a command-line interface.


## Table of Contents


1. [Introduction](#introduction)
2. [Features](#features)
    - [Add Main Trip](#add-main-trip)
    - [Delete Main Trip](#delete-main-trip)
    - [Set Trip Details](#set-trip-details)
    - [List All Trips](#list-all-trips)
    - [Add Review](#add-review)
    - [Read Review](#read-review)
    - [Update Status](#update-status)
    - [Cancel Trip](#cancel-trip)
    - [Save Data](#save-data)
    - [Exit Application](#exit-application)
3. [Usage](#usage)
    - [Adding a Main Trip](#adding-a-main-trip)
    - [Setting Trip Details](#setting-trip-details)
    - [Change the Name of a Trip](#change-the-name-of-a-trip)
    - [Change the Date of a Trip](#change-the-date-of-a-trip)
    - [Cancel a Trip](#cancel-a-trip)
    - [Uncancel a Trip](#uncancel-a-trip)
    - [Deleting a Main Trip](#deleting-a-main-trip)
    - [Listing All Trips](#listing-all-trips)
    - [Reviewing Trips](#reviewing-trips)
    - [Reading Trip Reviews](#reading-trip-reviews)
    - [Exit Command](#exit-command)
    - [Managing Bills](#managing-bills)
        - [Adding a Bill](#adding-a-bill)
        - [Simplify Bills from a Trip](#simplify-bills-from-a-trip)
    - [Currency](#currency)

## Introduction

Voyagers is a Java application designed to simplify trip management. It provides users with a command-line interface to manage their trips efficiently, including adding main trips, setting trip details, listing all trips, and more.

## Features

- **Add Main Trip**: Add a new main trip with specified details such as name, dates, location, and description.
- **Delete Main Trip**: Remove an existing main trip from the list.
- **Set Trip Details**: Modify trip details such as name, dates, location, and description for existing trips.
- **List All Trips**: View a comprehensive list of all trips along with their details.
- **Add Bill**: Add a bill to a certain trip, along with who paid, people who owe, and what percentage of the bill 
each person owes.
- **Pay Bill** Mark a bill as paid.
- **Add Review**: Review a trip by providing a score and reflection.
- **Read Review**: Read the review of a specific trip.
- **Update Status**: Update the status of a trip to 'Ongoing', 'Upcoming' or 'Completed'.
- **Cancel Trip**: Cancel a trip and remove it from the list.
- **Save Data**: Save the trip data to a file for future reference.
- **Exit Application**: Exit the application.

## Usage

The core of Voyagers is to allow users to manage their trips efficiently. Especially adding a new main trip by typing a
single line.

### Adding a Main Trip

To add a new main trip, use the `addmaintrip` command followed by the trip details.

```bash
addmaintrip /n <Name> /start <yyyy-MM-dd> /end <yyyy-MM-dd> /location <Location> /d <Description>
```

### Setting Trip Details

You can also modify the details of an existing trip using the following commands:

- `setname`: Set the name of a trip.
- `setdates`: Set the dates of a trip.
- `setlocation`: Set the location of a trip.
- `setdescription`: Set the description of a trip.

Example:

### Change the Name of a Trip
```bash
setname Europe Trip /n European Adventure
```

### Change the Date of a Trip

```bash
setdates Europe /start 2024-05-01 /end 2024-07-31
```

### Cancel a Trip

```bash
setstatus Europe /status cancel
```

### Uncancel a Trip

```bash
setstatus Europe /status uncancel
```

### Deleting a Main Trip
To delete an existing main trip, use the `deletemaintrip` command followed by the trip name.

```bash
deletemaintrip /n Europe Trip
```
### Listing All Trips
To view a list of all trips along with their details, use the listall command.

```bash 
listall
```

### Creating a Bill
To add a bill to a trip, use the `addBill` command followed by the following information
```bash
addBill /trip China /n dinner /payer Alice /others Bob Carol /amount 50 /percentages 33.3 33.3 33.3
```

### Paying a Bill
To mark a bill as paid, use the `payBill` command followed by the name of the bill.
```bash
payBill /n dinner
```

### Listing all Bills
To list all bills in Voyagers, use the `listBills` command.
```bash
listBills
```

### Reviewing Trips

To review a trip with a scale of 1-10 'score' and your open-ended 'reflection', use the review command.

```bash
review Trip1 /s 10 /r Trip1 was fantastic, I made 3 new friends.
```

### Reading Trip Reviews

To read previously reviewed trip, use the readreview command with the name of the trip.

```bash
readreview Trip1
```

### Enter "exit" to exit the application.

```bash 
exit
```

### Managing bills

You can add bills to a trip. The bills are payed by a person but it can involve multiple people.

#### Adding a bill

````bash
addbill  <trip name> /description <description> /amount <amount> /currency <currency> /payer <payer> /participants <participants> /percentage <percentage>
````

Example:

````bash
addbill Europe /description "Dinner in Paris" /amount 100 /currency EUR /payer Alice /participants Bob Charlie /percentage 50 50
````

Note:
- The amount must be positive.
  - The currency must be a valid currency code. Consult the list of valid currency codes [here](#currency).
  - The percentage must be between 0 and 100 and the sum of the percentages of all participants must be 100.
  - The payer may not be involved in the bill: i.e the payer may not be in the list of participants.


### Simplify bills from a trip

In order to settle up all the bills. You can simplify all the bills from a trip.
The simplification will reduce the number of transactions needed to settle up all the bills.

````bash
simplifybills <trip name>
````



Note: if the trip is a maintrip, the simplification will be done on all the subtrips of the maintrip.

Note: the simplification will be made using dollars.

#### Currency

The app supports multiple currencies:
- EUR: Euro
- USD: US Dollar
- SGD: Singapore Dollar

