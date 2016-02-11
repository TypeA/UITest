Scenario: Add friend
Meta: 
@categories friends personal add_friend

Given logged user (name <name>) on ManageFriendsPage
When user type user <users> and save changes
Then user <users> should be added as a friend

Examples:
|name           |users                   |
|testautotest   |wwwasserman;manyfriends |

Scenario: Delete friend
Meta: 
@categories friends personal add_friend

Given logged user (name <name>) on ManageFriendsPage
When user disable checkbox for user <users> and save changes
Then user <users> should be removed from friends

Examples:
|name           |users                   |
|testautotest   |wwwasserman;manyfriends |