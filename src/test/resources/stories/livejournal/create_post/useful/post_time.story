Scenario: Scheduled post
Meta: 
@categories feed useful test

Given logged user <name> on Create Post page
When user create new post and change parameter <parameter> by value <value>
Then the post is scheduled

Examples:
|name         |parameter |value |
|testautotest |hour      |3     |
|testautotest |day       |3     |
|testautotest |month     |3     |
|testautotest |year      |3     |