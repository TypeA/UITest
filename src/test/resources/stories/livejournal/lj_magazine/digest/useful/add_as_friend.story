Scenario: Logged user can add to friends author of the post

Meta: 
@categories lj_magazine digest useful

Given logged user <user> on the post page
When user <user> click on the Add to friends button
Then user <user> have author of the post in his friends

Examples:
|user                       |
|testautotest               |



Scenario: Unlogged user cant see button Add to friends

Meta: 
@categories lj_magazine digest useful

Given unlogged user on the post page
Then unlogged user cant see button add to friends
