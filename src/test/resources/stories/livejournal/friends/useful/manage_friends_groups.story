Scenario: Change the position of the group
Meta: 
@categories friends group useful 

Given logged user (name <name>) on Manage Groups Page
When user moves the group up and moves the group down and save the changes
Then the changes displayed correctly on Manage Groups Page
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |
|test   |

Scenario: Public group
Meta: 
@categories friends group useful 

Given logged user (name <name>) on Manage Groups Page
When user set the group is public and save the changes
Then unlogged user can see group

Examples:
|name   |
|test   |


Scenario: Create new group
Meta: 
@categories friends group useful sjdfshd

Given logged user (name <name>) on Manage Groups Page
When user create new group and save the changes
Then the changes displayed correctly on the Friends Feed
Then there are no posts in the new group

Examples:
|name   |
|test   |
|test   |


Scenario: Delete group
Meta: 
@categories friends group useful

Given logged user (name <name>) on Manage Groups Page
When user delete group and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |
|test   |
|test   |



Scenario: Rename group name
Meta: 
@categories friends group useful

Given logged user (name <name>) on Manage Groups Page
When user rename group name and save the changes
Then the changes displayed correctly on the Friends Feed

Examples:
|name   |
|test   |


Scenario: Add users in group
Meta: 
@categories friends group useful

Given logged user (name <name>) on Manage Groups Page
When user add users in group and save the changes
Then in group displayed correct user

Examples:
|name   |
|test   |


Scenario: Delete users in group
Meta: 
@categories friends group useful

Given logged user (name <name>) on Manage Groups Page
When user delete users in group and save the changes
Then in group displayed correct user

Examples:
|name   |
|test   |
|test   |

