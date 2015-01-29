Scenario: Add friend
Meta: 
@categories friends useful

Given logged user (name <name>, password <password>) on ManageFriendsPage
When user type user <users> and save changes
Then user <users> should be added as a friend

Examples:
|name           |users                   |
|testautotest   |wwwasserman;manyfriends |