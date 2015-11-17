Scenario: Default friends filters
Meta: 
@categories feed useful 

Given logged user <user> with friends on Friends Feed
When user set filter <filter>
Then user see friends feed by filter <filter>

Examples:
|user               |filter         |
|testautotest       |all            |
|testautotest       |journals       |
|testautotest       |communities    |


Scenario: Default view
Meta: 
@categories feed useful test

Given logged user <user> with Default view on Friends Feed
Then user see friends feed by group <group>

Examples:
|user           |group          |
|testautotest   |default view   |



Scenario: Edit Filters
Meta: 
@categories feed useful

Given logged user <user> on Friends Feed
When user go to Edit Custom Friends Groups
Then user in correct page <page>

Examples:
|name   |page             |
|test   |ManageGroupsPage |



