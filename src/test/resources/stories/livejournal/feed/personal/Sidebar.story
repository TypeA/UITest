Scenario: Add widget
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) without widgets in sidebar on Friends Feed
When click Add widget and select widget <widget>
Then widget <widget> added in sidebar

Examples:
|name|password|widget|
|test|test|Twitter Feed|
|test|test|Facebook Feed|
|test|test|Instagram Feed|
|test|test|Calendar|
|test|test|LivaJournal Today|
|test|test|Interesting links|
|test|test|Events|
|test|test|Comments|
|test|test|Guests|
|test|test|Entries|


Scenario: Delete widget
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with a complete set of widgets in sidebar on Friends Feed
When click Delete widget <widget>
Then widget <widget> deleted in sidebar

Examples:
|name|password|widget|
|test|test|Twitter Feed|
|test|test|Facebook Feed|
|test|test|Instagram Feed|
|test|test|Calendar|
|test|test|LivaJournal Today|
|test|test|Interesting links|
|test|test|Events|
|test|test|Comments|
|test|test|Guests|
|test|test|Entries|


Scenario: Up Button
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with widgets in sidebar on Friends Feed
When click Up Button on lower widget
Then lower widget move up


Scenario: Down Button
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with widgets in sidebar on Friends Feed
When click Down Button on top widget
Then top widget move down


Scenario: Up and Down Buttons
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with widgets in sidebar on Friends Feed
When move mouse on middle widget
Then Up and Down Buttons are displayed
