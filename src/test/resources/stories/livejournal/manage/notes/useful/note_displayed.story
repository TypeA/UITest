Scenario: add user with note to ban list

Meta:
@categories manage note displayed_note useful 

Given logged user <user> on Ban User Page
When add user with note to ban
Then user with asterisk is displayed on Ban User Page

Example:
|user     |
|


Scenario: add ljUser with note to post and comment

Meta:
@categories manage note displayed_note useful 

Given logged <user> on Create Post Page
When add lj-user with note to post
Then lj-user is displayed with asterisk in post
When add lj-user with note to commnet
Then lj-user is displayed with asterisk in comment

Examples:
|user   |
|

Scenario: user with note add comment

Meta:
@categories manage note displayed_note useful

Given logged <user> on Create Post Page
When user with note add comment to post
Then username with asterisk is displayed in comment

Examples:
|user    |
|
