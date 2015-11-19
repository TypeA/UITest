Scenario: Add widget
Meta: 
@categories feed personal sidebar

Given logged user (name <name>) without widgets in sidebar on Friends Feed
When user click Add widget and select widget <widget>
Then widget <widget> added in sidebar

Examples:
|name           |widget             |
|testautotest   |Twitter Feed       |
|testautotest   |Instagram Feed     |
|testautotest   |Tumblr Feed        |
|--testautotest   |Calendar           |
|testautotest   |Discovery Today    |
|testautotest   |LiveJournal Today  |
|testautotest   |Interesting links  |
|testautotest   |Events             |
|testautotest   |Comments           |
|testautotest   |Guests             |
|testautotest   |Entries            |



Scenario: Delete widget
Meta: 
@categories feed personal sidebar


Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Delete widget <widget>
Then widget <widget> deleted in sidebar

Examples:
|name           |widget             |
|testautotest   |Twitter Feed       |
|testautotest   |Instagram Feed     |
|testautotest   |Tumblr Feed        |
|--testautotest   |Calendar           |
|testautotest   |Discovery Today    |
|testautotest   |LiveJournal Today  |
|testautotest   |Interesting links  |
|testautotest   |Events             |
|testautotest   |Comments           |
|testautotest   |Guests             |
|testautotest   |Entries            |



Scenario: Up Button on widget
Meta: 
@categories feed personal sidebar

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Up Button many time on lower widget
Then this widget is upper

Examples:
|name           |
|testautotest   |



Scenario: Down Button on widget
Meta: 
@categories feed personal sidebar

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user click Down Button many time on top widget
Then this widget is lower

Examples:
|name           |
|testautotest   |



Scenario: Up and Down Buttons on widget
Meta: 
@categories feed personal sidebar

Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user move mouse on middle widget
Then Up and Down Buttons are displayed

Examples:
|name           |
|testautotest   |



Scenario: Saving a layout of widgets
Meta: 
@categories feed personal sidebar


Given logged user (name <name>) with complete set of widgets in sidebar on Friends Feed
When user logged out and logged in again (name <name>, password <password>)
Then user's layout of widgets is applied

Examples:
|name           |
|testautotest   |


