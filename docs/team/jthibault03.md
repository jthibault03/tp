# jthibault03's Project Portfolio Page

## Overview

We created Voyagers, a CLI-based Java application for managing trips and involved expenses. 
The main features include adding and modifying trips, subtrips, reviews, bills, and people.

## Summary of Contributions

### Code Contributed:
- [tP Code Dashboard link](#https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=jthibault03&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23)

Most of my code was for these classes:
 - `Bill` class
 - `Profile` class
 - `ProfileList` class
 - `Bill` class
 - `BillList` class
 - `Currency` enum  

Commands implemented:
 - `AddBillCommand`
 - `ListBillCommand`
 - `PayBillCommand`
 - `SetBillCurrencyCommand`

### Features Implemented:
- Created several internal features and methods for `Profile` and `Bill` to be used in `ProfileList` and `BillList`, 
static classes that manage information across all Trips.
- Added ability to add bills to trips, which includes different profiles, currencies, and debt percentages.
- Added ability to list bills.
- Added ability to set the currency of a bill.
- Added ability to mark bills as paid.
- Created Payable interface for Bill class.

### Contributions to the UG
For the UG, I focused on developing documentation and instructions mainly for the classes/commands I developed.
### Contributions to the DG
I created an outline/overall structure of the DG for teammates to add to. I also mainly
focused on the classes I created.
### Community
- Reviewed PR's for other teams
- Packaged most of my updates as PRs from my repo into the group repo, for ease
of team management.