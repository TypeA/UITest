Scenario: Create scheduled post
Meta: 
@categories create_edit_post time useful

Given logged user <name> on Create Post page
When user create new post and change parameter <parameter> by value <value>
Then the post is scheduled

Examples:
|name         |parameter |value |
|testautotest |hour      |3     |
|testautotest |day       |3     |
|testautotest |month     |3     |
|testautotest |year      |3     |


Scenario: Create scheduled post with several privacy
Meta: 
@categories create_edit_post time useful

Given logged user <name> on Create Post page
When user create new scheduled post with privacy <privacy> (group <group>)
Then the post is scheduled with privacy <privacy>

Examples:
|name           |privacy     |group      |
|testautotest   |Public      |           |
|testautotest   |Friends     |           |
|testautotest   |Custom      |test_group |
|testautotest   |Private     |           |


Scenario: Edit scheduled post
Meta: 
@categories create_edit_post time useful test

Given logged user <name> with scheduled post on Scheduled post Page
When user edit element <element> by change <changes> in the scheduled post
Then the scheduled post is editing

Examples:
|name         |element      |changes           |
|testautotest |subject      |rnd               |
|testautotest |text         |rnd               |
|testautotest |tags         |rnd               |


Scenario: Edit privacy in scheduled post
Meta: 
@categories create_edit_post time useful

Given logged user <name> with scheduled post on Scheduled post Page
When user edit element <element> by change <changes> in the scheduled post
Then privacy <changes> in the scheduled post is editing

Examples:
|name         |element      |changes           |
|testautotest |privacy      |Friends           |
|testautotest |privacy      |Custom/test_group |
|testautotest |privacy      |Private           |



Scenario: Delete scheduled post
Meta: 
@categories create_edit_post time useful

Given logged user <name> with scheduled post on Scheduled post Page
When user delete the scheduled post
Then the scheduled post is deleted

Examples:
|name         |
|testautotest |
