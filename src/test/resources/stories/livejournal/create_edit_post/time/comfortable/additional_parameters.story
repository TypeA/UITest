Scenario: Sticky post
Meta: 
@categories create_edit_post time comfortable test

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
When user create new sheduied post with right element <element>
Then the post is scheduled with right element <element>

Examples:
|name         |element  |
|testautotest |location |
|testautotest |mood     |
|testautotest |music    |

 

