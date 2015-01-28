Scenario: Go to Edit Custom Friends Groups
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user go to Edit Custom Friends Groups
Then user in correct page <page>

Examples:
|name   |page             |
|test   |ManageGroupsPage |


Scenario: Replacement blocks

Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user click on settings and filters icons
Then the blocks is changed

Examples:
|name   |page             |
|test   |ManageGroupsPage |
    



