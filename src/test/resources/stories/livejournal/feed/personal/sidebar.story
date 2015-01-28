@categories feed personal

Scenario: Add widget
Meta: 
@categories feed personal

Given logged user (name <name>) without widgets in sidebar on Friends Feed
When user click Add widget and select widget <widget>
Then widget <widget> added in sidebar

Examples:
|name   |widget             |
|test   |Twitter Feed       |
|test   |Facebook Feed      |
|test   |Instagram Feed     |
|test   |Tumblr Feed        |
|test   |Календарь          |
|test   |Discovery Today    |
|test   |LiveJournal Today  |
|test   |Interesting links  |
|test   |Events             |
|test   |Comments           |
|test   |Guests             |
|test   |Entries            |



Scenario: Delete widget
Meta: 
@categories feed personal


Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Delete widget <widget>
Then widget <widget> deleted in sidebar

Examples:
|name   |widget             |
|test   |Twitter Feed       |
|test   |Facebook Feed      |
|test   |Instagram Feed     |
|test   |Tumblr Feed        |
|test   |Календарь          |
|test   |Discovery Today    |
|test   |LiveJournal Today  |
|test   |Interesting links  |
|test   |Events             |
|test   |Comments           |
|test   |Guests             |
|test   |Entries            |



Scenario: Up Button on widget
Meta: 
@categories feed personal

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Up Button many time on lower widget
Then this widget is upper

Examples:
|name   |
|test   |



Scenario: Down Button on widget
Meta: 
@categories feed personal

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Down Button many time on top widget
Then this widget is lower

Examples:
|name   |
|test   |



Scenario: Up and Down Buttons on widget
Meta: 
@categories feed personal

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user move mouse on middle widget
Then Up and Down Buttons are displayed

Examples:
|name   |
|test   |



Scenario: Saving a layout of widgets
Meta: 
@categories feed personal


Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user logged out and logged in again (name <name>, password <password>)
Then user's layout of widgets is applied

Examples:
|name   |
|test   |


