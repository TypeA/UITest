Scenario: Sticky post
Meta: 
@categories create_edit_post time comfortable 

Given logged user <name> on Create Post page
When user create new sheduied post sticky
Then the Sticky post is scheduled

Examples:
|name         |
|testautotest |


Scenario: Location, mood and music
Meta: 
@categories create_edit_post time comfortable test

Given logged user <name> on Create Post page
When user create new sheduied post with right element <element> (content <content>)
Then the post is scheduled with right element <element> (content <content>)

Examples:
|name         |element  |content |
|testautotest |location |NY      |
|--testautotest |mood     |cold    |
|--testautotest |music    |My music|

 

