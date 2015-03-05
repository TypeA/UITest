Scenario: Change the position of the group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user moves the group up and moves the group down and save the changes
Then the changes displayed correctly on Manage Groups Page
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |
|test   |

Scenario: Public group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user set the group is public and save the changes
Then unlogged user can see group

Examples:
|name   |
|test   |


Scenario: Create new group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user create new group <group> and save the changes
Then the changes displayed correctly on the Friends Feed
Then there are no posts in the new group

Examples:
|name   |group          |
|test   |test_group     |
|test   |НОВАЯ ГРУППА   |
|test   |111            |   


Scenario: Delete group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user delete group and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |
|test   |



Scenario: Rename group name
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user rename group name and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |group      |
|test   |test_group |


Scenario: Add users in group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user add users  in group and save the changes
Then in group displayed correct user

Examples:
|name   |
|test   |


Scenario: Delete users in group
Meta: 
@categories maxa

Given logged user (name <name>) on Manage Groups Page
When user delete users in group and save the changes
Then in group displayed correct user

Examples:
|name   |
|test   |
|test   |

