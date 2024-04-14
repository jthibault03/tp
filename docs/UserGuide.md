# Voyagers

Voyagers is a Java application designed to manage trips efficiently through a command-line interface.

<!---
@@author azamanis
-->

## Table of Contents


1. [Introduction](#introduction)
2. [Features](#features)
    - [Add Main Trip](#adding-a-main-trip)
    - [Delete Main Trip](#deleting-a-main-trip)
    - [Set Trip Details](#setting-trip-details)
    - [Add Sub Trip](#adding-a-sub-trip)
    - [Delete Sub Trip](#deleting-a-sub-trip)
    - [List All Trips](#listing-all-trips)
    - [Listing Trips by Status](#listing-trips-by-status)
    - [Add Review](#reviewing-trips)
    - [Read Review](#reading-trip-reviews)
    - [Update Status](#update-status)
    - [Cancel Trip](#canceling-a-trip)
    - [Save Data](#save-data)
    - [Exit Application](#exit-application)
3. [Usage](#usage)
    - [Adding a Main Trip](#adding-a-main-trip)
    - [Setting Trip Details](#setting-trip-details)
    - [Change the Name of a Trip](#change-the-name-of-a-trip)
    - [Change the Date of a Trip](#change-the-date-of-a-trip)
    - [Change the Location of a Trip](#Change-the-Location-of-a-Trip)
    - [Change the Description of a Trip](#Change-the-Description-of-a-Trip)
    - [Cancel a Trip](#cancel-a-trip)
    - [Uncancel a Trip](#uncancel-a-trip)
    - [Deleting a Main Trip](#deleting-a-main-trip)
    - [Add Sub Trip](#adding-a-sub-trip)
    - [Delete Sub Trip](#deleting-a-sub-trip)
    - [Listing All Trips](#listing-all-trips)
    - [Listing Trips by Status](#listing-trips-by-status)
    - [Reviewing Trips](#reviewing-trips)
    - [Reading Trip Reviews](#reading-trip-reviews)
    - [Exit Command](#exit-command)
    - [Managing Bills](#managing-bills)
        - [Adding a Bill](#adding-a-bill)
        - [Simplify Bills from a Trip](#simplify-bills-from-a-trip)
    - [Currency](#currency)

<!---
@@author azamanis
-->

## Introduction

Voyagers is a Java application designed to simplify trip management. It provides users with a command-line interface to 
manage their trips efficiently, including adding main trips, setting trip details, listing all trips, and more.

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
Example:
```bash
addmaintrip /n EuropeTrip /start 2024-05-01 /end 2024-07-01 /location Europe /d Travelling western europe with the family
```
Example output:
```bash
		____________________________________________________________
		Got it. I've added this trip:
	Trip Name: EuropeTrip		Start Date: 2024-05-01		End Date: 2024-07-01		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
Now you have 3 trips in the list.
        ____________________________________________________________
```


### Setting Trip Details

You can also modify the details of an existing trip using the following commands:

- `setname`: Set the name of a trip.
- `setdates`: Set the dates of a trip.
- `setlocation`: Set the location of a trip.
- `setdescription`: Set the description of a trip.

### Change the Name of a Trip (only for main trips)
```bash
setname <current_name> /n <new_name>
```


Example:

```bash
setname EuropeTrip /n EuropeanAdventure
```

Example output:

```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-01		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Change the Date of a Trip

```bash
setdates <current_trip_name> /start <yyyy-MM-dd> /end <yyyy-MM-dde>
```

Example:
```bash
setdates EuropeanAdventure /start 2024-05-01 /end 2024-07-31
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Change the Location of a Trip

```bash
setdates <current_trip_name> /location <new_location>
```

Example:
```bash
setdates DateWithSO /location Fancy Restaurant
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: DateWithSO		Start Date: 2024-08-27		End Date: 2024-08-27		Location: Fancy Restaurant		Description: Having Italian with beloved		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Change the Description of a Trip

```bash
setdates <current_trip_name> /d <new_description>
```

Example:
```bash
setdates DateWithSO /d Double dating with other friends at Italian place
```

Example output:
```bash
        ____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: DateWithSO		Start Date: 2024-08-27		End Date: 2024-08-27		Location: Fancy Restaurant		Description: Double dating with other friends at Italian place		Status: UPCOMING
	Sub-trips:
        ____________________________________________________________
```

### Canceling a Trip

```bash
setstatus <current_name> /status cancel
```

Example:
```bash
setstatus EuropeanAdventure /status cancel
```

Example output:
```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: CANCELLED
	Sub-trips:
		____________________________________________________________
```

### Uncancel a Trip
```bash
setstatus <trip_name> /status uncancel
```

Example:
```bash
setstatus EuropeanAdventure /status uncancel
```

Example output:
```bash
		____________________________________________________________
		Noted. I've modified this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Deleting a Main Trip
To delete an existing main trip, use the `deletemaintrip` command followed by the trip name.

```bash
deletemaintrip /n <main_trip_name>
```

Example:
```bash
deletemaintrip /n EuropeanAdventure
```

Example output:
```
		____________________________________________________________
		Noted. I've removed this trip:
	Trip Name: EuropeanAdventure		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Europe		Description: Travelling western europe with the family		Status: UPCOMING
	Sub-trips:
Now you have 2 trips in the list.
		____________________________________________________________
```

### Adding a Sub Trip
To add sub trips under a main trip, use the addsubtrip command.

```bash
addsubtrip /n <existing_main_trip_name> /start <yyyy-MM-dd> /end <yyyy-MM-dd> /location <location> /d <description>
```

Example:
```bash
addsubtrip /n Korea /start 2024-05-10 /end 2024-05-24 /location Gwanggyo Lake Park /d have a picnic
```

Example output:
```bash
		____________________________________________________________
		Got it. I've added this trip as a subtrip of :Korea
	Korea-1		Start Date: 2024-05-10		End Date: 2024-05-24		Location: Gwanggyo Lake Park		Description: have a picnic		Status: UPCOMING
Now you have 1 subtrips.
		____________________________________________________________
```


### Deleting a Sub Trip
To delete a sub trip, use the deletesubtrip command.

```bash
deletesubtrip /n <Main trip name> /i <index of subtrip>
```

Example:
```bash
deletesubtrip /n Korea /i 1
```

Example output:
```bash
		____________________________________________________________
		Noted. I've removed this subtrip:
	Korea-1		Start Date: 2024-05-10		End Date: 2024-05-24		Location: Gwanggyo Lake Park		Description: have a picnic		Status: UPCOMING
		____________________________________________________________
```

### Listing All Trips
To view a list of all trips along with their details, use the list command.

```bash 
list
```

Example output:
```bash
____________________________________________________________
		Here are the trips in your list:
		____________________________________________________________
		____________________________________________________________
		1. 	Trip Name: Korea		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Suwon		Description: dating		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

### Listing Trips by Status
To view a list of trips of only a specific status, add the status after the list command

```bash
list <status>
```

Example 1:
```bash
list upcoming
```

Example output 1:
```bash
		____________________________________________________________
		Here are the upcoming trips in your list:
		____________________________________________________________
		____________________________________________________________
		1. 	Trip Name: Korea		Start Date: 2024-05-01		End Date: 2024-07-31		Location: Suwon		Description: dating		Status: UPCOMING
	Sub-trips:
		____________________________________________________________
```

Example 2:
```bash
list cancelled
```

Example output 2:
```bash
		____________________________________________________________
		You have no cancelled trips in your list.
		____________________________________________________________
```

### Creating a Bill
To add a bill to a trip, use the `addBill` command followed by the following flags:
 
 `/trip`: name of the trip this bill belongs to  
`/n`: name of this bill  
`/payer`: name of the person who paid the bill  
`/others`: other people involved in the bill, owing the payer for this expense  
`/amount`: how much this bill costed. Default currency will be the currency of the trip.
`/percentages`: the percentage of the total amount that each person is responsible for
in the bill. Must have the same number of arguments as the number of people in `/payer` and `/others`. 
 Must add up to 100 (+-0.5).
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

To review a main trip with a scale of 1-10 'score' and your open-ended 'reflection', use the review command.

```bash
review <main_trip_name> /s <1-10> /r <open-ended thoughts>
```

Example:
```bash
review Korea /s 7 /r Great food, great weather, expensive though
```

Example output:
```bash
		____________________________________________________________
		Noted. you reviewed this trip: Korea with a score of 7
		noting: Great food, great weather, expensive though
		____________________________________________________________

```

### Reading Trip Reviews

To read previously reviewed main trip, use the readreview command with the name of the trip.
```bash
readreview <main_trip_name>
```

Example:
```bash
readreview Korea
```

Example output:
```bash
		____________________________________________________________
		Here's what you wrote about Korea
		Score: 7
		Reflection:
		Great food, great weather, expensive though
		____________________________________________________________
```

### Save data
Remember to properly exit to save trip data.

### Enter "exit" to exit the application.

```bash 
exit
```

Output:
```bash
		____________________________________________________________
		Bye. Hope to see you again soon!
		____________________________________________________________
```

<!---
@@author azamanis
-->

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


### Simplify bills

In order to settle up all the bills. You can simplify all the bills.
The simplification will reduce the number of transactions needed to settle up all the bills.

````bash
simplifybills
````



Note: if the trip is a maintrip, the simplification will be done on all the subtrips of the maintrip.

Note: the simplification will be made using dollars.

#### Currency

The app supports multiple currencies:
- EUR: Euro
- USD: US Dollar
- SGD: Singapore Dollar                                                                                                                                                                                                                                                                                                                       
- JPY: Japanese Yen
- CNY: Chinese Yuan
- KRW: South Korean Won
- GBP: British Pound
- AUD: Australian Dollar
- CAD: Canadian Dollar

<!---
@@author azamanis
-->
