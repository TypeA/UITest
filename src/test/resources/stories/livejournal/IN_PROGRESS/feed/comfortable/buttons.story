Scenario: Up button
Meta: 
@categories feed comfortable buttons 

Given unlogged user on Friends Feed
When user scrolls down the feed
Then Up button is visible and that button return feed up


Scenario: Fulter button
Meta: 
@categories feed comfortable buttons 

Given unlogged user on Friends Feed
When click on Fulter button
Then Filter list is visible and Fulter icone changed on Close icon


Scenario: Settings button
Meta: 
@categories feed comfortable buttons 

Given login user (name <name>, password <password>) on Friends Feed
When click on Settings button
Then Settings list is visible and Settings icone changed on Close icon

Examples:
|name       |password   |
|test765765 |test       |


Scenario: Replacement blocks

Meta: 
@categories feed comfortable buttons 

Given logged user (name <name>) on Friends Feed
When user click on settings and filters icons
Then the blocks is changed

Examples:
|name   |page             |
|test   |ManageGroupsPage |
