Scenario: Change the position of the group
Meta: 
@categories friends group personal release

Given logged user (name <name>) on Manage Groups Page
When user <name> moves the group <position> and save change
Then the changes displayed correctly on Manage Groups Page
Then the changes displayed correctly on the Friends Feed (name <name>)

Examples:
|name   |position   |
|test   |up         |
|test   |down       |

Scenario: Public group
Meta: 
@categories friends group personal release

Given logged user (name <name>) on Manage Groups Page
When user (name <name>) set the group is public and save the changes
Then unlogged user (name <name>) can see group

Examples:
|name   |
|test   |


Scenario: Create new group
Meta: 
@categories friends group personal release

Given logged user (name <name>) on Manage Groups Page
When user create new group and save the changes
Then the changes displayed correctly on the Friends Feed (name <name>)
Then there are no posts in the new group (name <name>)

Examples:
|name   |
|test   |
|test   |


Scenario: Delete group
Meta: 
@categories friends group personal release

Given logged user (name <name>) on Manage Groups Page
When user (name <name>) delete group and save the changes
Then the changes displayed correctly on the Friends Feed (name <name>)

Examples:
|name   |
|test   |
|test   |



Scenario: Rename group name
Meta: 
@categories friends group useful release

Given logged user (name <name>) on Manage Groups Page
When user (name <name>) rename group name and save the changes
Then the changes displayed correctly on the Friends Feed (name <name>)

Examples:
|name   |
|test   |


Scenario: Add users in group
Meta: 
@categories friends group useful release

Given logged user (name <name>) on Manage Groups Page
When user (name $name) add users in group and save the changes
Then user added to group

Examples:
|name   |
|test   |


Scenario: Delete users in group
Meta: 
@categories friends group useful release

Given logged user (name <name>) on Manage Groups Page
When user (name, <name>) delete users in group and save the changes
Then user deleted from group

Examples:
|name   |
|test   |
|test   |

