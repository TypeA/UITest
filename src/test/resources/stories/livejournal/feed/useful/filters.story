Scenario: Default friends filters 
Meta: 
@categories feed useful filters

Given logged user <user> with friends on Friends Feed
When user set filter <filter>
Then user see Friends Feed by filter <filter>

Examples:
|user               |filter         |
|testautotest       |all            |
|testautotest       |journals       |
|testautotest       |communities    |


Scenario: Default View
Meta: 
@categories feed useful filters

Given logged user <user> with group <filter> on Friends Feed
Then user see Friends Feed by group <filter>

Examples:
|user           |filter         |
|testautotest   |Default View   |



Scenario: Friends group
Meta: 
@categories feed useful filters

Given logged user <user> with group <filter> on Friends Feed
When user set filter <filter>
Then user see Friends Feed by group <filter>

Examples:
|user           |filter         |
|testautotest   |test_group     |



Scenario: Edit Filters
Meta: 
@categories feed useful filters

Given logged user <user> on Friends Feed
When user go to Edit Custom Friends Groups
Then user in correct page <page>

Examples:
|user           |page             |
|testautotest   |ManageGroupsPage |



