@categories feed personal

Scenario: Add widget
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) without widgets in sidebar on Friends Feed
When user click Add widget and select widget <widget>
Then widget <widget> added in sidebar

Examples:
|name   |password   |widget             |
|test   |test       |Twitter Feed       |
|test   |test       |Facebook Feed      |
|test   |test       |Instagram Feed     |
|test   |test       |Tumblr Feed        |
|test   |test       |Календарь          |
|test   |test       |Discovery Today    |
|test   |test       |LiveJournal Today  |
|test   |test       |Interesting links  |
|test   |test       |Events             |
|test   |test       |Comments           |
|test   |test       |Guests             |
|test   |test       |Entries            |



Scenario: Delete widget
Meta: 
@categories feed personal test


Given logged user (name <name>, password <password>) with complete set of widgets in sidebar on Friends Feed
When user click Delete widget <widget>
Then widget <widget> deleted in sidebar

Examples:
|name   |password   |widget             |
|test   |test       |Twitter Feed       |
|test   |test       |Facebook Feed      |
|test   |test       |Instagram Feed     |
|test   |test       |Tumblr Feed        |
|test   |test       |Календарь          |
|test   |test       |Discovery Today    |
|test   |test       |LiveJournal Today  |
|test   |test       |Interesting links  |
|test   |test       |Events             |
|test   |test       |Comments           |
|test   |test       |Guests             |
|test   |test       |Entries            |



Scenario: Up Button on widget
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) with complete set of widgets in sidebar on Friends Feed
When user click Up Button many time on lower widget
Then this widget is upper

Examples:
|name   |password   |
|test   |test       |



Scenario: Down Button on widget
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with complete set of widgets in sidebar on Friends Feed
When user click Down Button many time on top widget
Then this widget is lower

Examples:
|name   |password   |
|test   |test       |



Scenario: Up and Down Buttons on widget
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with complete set of widgets in sidebar on Friends Feed
When user move mouse on middle widget
Then Up and Down Buttons are displayed

Examples:
|name   |password   |
|test   |test       |



Scenario: Saving a layout of widgets
Meta: 
@categories feed personal


Given logged user (name <name>, password <password>) with complete set of widgets in sidebar on Friends Feed
When user logged out and logged in again (name <name>, password <password>)
Then user's layout of widgets is applied

Examples:
|name   |password   |
|test   |test       |



