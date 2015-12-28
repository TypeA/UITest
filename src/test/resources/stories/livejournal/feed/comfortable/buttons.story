Scenario: Up button
Meta: 
@categories feed comfortable buttons test

Given logged user <user> on Friends Feed
When user scroll Feed down
Then Up button is visible and can return Feed up

Examples:
|user         |
|testautotest |


Scenario: Fulter button
Meta: 
@categories feed comfortable buttons

Given logged user <user> on Friends Feed
When click on Fulter button
Then Filter list is visible and Fulter icone changed on Close icon


Scenario: Settings button
Meta: 
@categories feed comfortable buttons

Given logged user <user> on Friends Feed
When click on Settings button
Then Settings list is visible and Settings icone changed on Close icon

Examples:
|name       |
|test765765 |


Scenario: Replacement blocks

Meta: 
@categories feed comfortable buttons

Given logged user <user> on Friends Feed
When user click on settings and filters icons
Then the blocks is changed

Examples:
|name   |page             |
|test   |ManageGroupsPage |
