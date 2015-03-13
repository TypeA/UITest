Scenario: Logged user create new post
Meta: 
@categories create_edit_post create_post useful test

Given logged user <name> on Create Post page
When user create new post
Then the post is in journal

Examples:
|name         |
|testautotest |


Scenario: Unlogged user create new post
Meta: 
@categories create_edit_post create_post useful test

Given unlogged user on Create Post page
When user create new post
Then the post is in journal

Examples:
|name         |
|testautotest |