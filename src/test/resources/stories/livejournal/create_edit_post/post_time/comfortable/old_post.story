Scenario: Create old post
Meta: 
@categories post_time useful test

Given logged user <name> on Create Post page
When user create new post and change parameter <parameter> by value <value>
Then the post is in journal

Examples:
|name         |parameter |value  |
|testautotest |hour      |-5     |
|testautotest |day       |-4     |
|testautotest |month     |-3     |
|testautotest |year      |-1     |