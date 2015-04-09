Scenario: Create scheduled post
Meta: 
@categories create_edit_post post_time useful

Given logged user <name> on Create Post page
When user create new post and change parameter <parameter> by value <value>
Then the post is scheduled

Examples:
|name         |parameter |value |
|testautotest |hour      |3     |
|testautotest |day       |3     |
|testautotest |month     |3     |
|testautotest |year      |3     |
