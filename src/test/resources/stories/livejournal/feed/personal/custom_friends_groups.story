Scenario: Go to Edit Custom Friends Groups
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user go to Edit Custom Friends Groups
Then user in correct page <page> with URL <URL>

Examples:
|name|password|page|URL|
|test|test|Edit Custom Friends Groups|/friends/editgroups.bml|



Scenario: Change the position of the group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user moves the group <group_up> up and moves the group <group_down> down
When user save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name|password|group_up|group_down|
|test|test|Online Friends|Family|



Scenario: Create new group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user create new group <group> and save the changes
Then the changes displayed correctly on the Friends Feed
Then there are no posts in the new group

Examples:
|name|password|group|
|test|test|test_group|
|test|test|НОВАЯ ГРУППА|
|test|test|111|


Scenario: Delete group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user delete group <group> and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name|password|group|
|test|test|test_group|


Scenario: Rename group name
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user rename group <group> name and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name|password|group|
|test|test|test_group|


Scenario: Add users in group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user add users <users> in group <group> and save the changes
Then in group <group> displayed correct posts

Examples:
|name|password|group|users|
|test|test|test_group|testmaxapryg|
|test|test|test_group|testmaxapryg, test001|


Scenario: Delete users in group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Edit Custom Friends Groups
When user delete users <users> in group <group> and save the changes
Then in group <group> displayed users <users> posts

Examples:
|name|password|group|users|
|test|test|test_group|testmaxapryg|
|test|test|test_group|testmaxapryg, test001|
