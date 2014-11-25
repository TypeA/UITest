Scenario: Change the position of the group 1
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user moves the group <group_up> up and moves the group <group_down> down
When user save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |password   |group_up       |group_down |
|test   |test       |Online Friends |Family     |


Scenario: Public group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user set the group <group> is public and save the changes
Then unlogged user can see group <group>

Examples:
|name   |password   |group          |
|test   |test       |Online Friends |



Scenario: Create new group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user create new group <group> and save the changes
Then the changes displayed correctly on the Friends Feed
Then there are no posts in the new group

Examples:
|name   |password   |group          |
|test   |test       |test_group     |
|test   |test       |НОВАЯ ГРУППА   |
|test   |test       |111            |   


Scenario: Delete group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user delete group <group> and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |password   |group      |
|test   |test       |test_group |


Scenario: Rename group name
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user rename group <group> name and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |password   |group      |
|test   |test       |test_group |


Scenario: Add users in group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user add users <users> in group <group> and save the changes
Then in group <group> displayed correct posts

Examples:
|name   |password   |group      |users                  |
|test   |test       |test_group |testmaxapryg           |
|test   |test       |test_group |testmaxapryg, test001  |


Scenario: Delete users in group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user delete users <users> in group <group> and save the changes
Then in group <group> displayed correct posts

Examples:
|name   |password   |group      |users                  |
|test   |test       |test_group |testmaxapryg           |
|test   |test       |test_group |testmaxapryg, test001  |



Scenario: Delete users in group
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Manage Groups Page
When user delete users <users> in group <group> and save the changes
Then in group <group> displayed correct posts

Examples:
|name   |password   |group      |users                  |
|test   |test       |test_group |testmaxapryg           |
|test   |test       |test_group |testmaxapryg, test001  |