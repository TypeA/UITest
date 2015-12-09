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
@categories create_edit_post time comfortable

Given logged user <name> on Create Post page
When user create new sheduied post with right element <element> (content <content>)
Then the post is scheduled with right element <element> (content <content>)

Examples:
|name         |element  |content |
|testautotest |location |NY      |
|testautotest |mood     |cold    |
|testautotest |music    |My music|


Scenario: Three posts
Meta: 
@categories create_edit_post time comfortable

Given logged user <name> on Create Post page
When user create new sheduied post with Three posts
Then the post is scheduled with Three posts

Examples:
|name         |
|testautotest |


Scenario: Drop-down menu
Meta: 
@categories create_edit_post time comfortable

Given logged user <name> on Create Post page
When user create new sheduied post with drop-down menu content <content>
Then the post is scheduled with drop-down menu content <content>

Examples:
|name         |content       |
|testautotest |ADULT CONTENT |
|testautotest |COMMENTS      |
|testautotest |SCREENING     |



Scenario: Check-boxes
Meta: 
@categories create_edit_post time comfortable

Given logged user <name> on Create Post page
When user create new sheduied post with check-boxes <checkbox>
Then the post is scheduled with check-boxes <checkbox>

Examples:
|name         |checkbox     |
|testautotest |feed and rss |
|testautotest |ratings      |



 

