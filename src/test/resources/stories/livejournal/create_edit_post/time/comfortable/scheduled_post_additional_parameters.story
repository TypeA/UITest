Scenario: Create scheduled post with additional parametrs
Meta: 
@categories create_edit_post time comfortable

Given logged user <name> on Create Post page
When user create new post and change parameter <parameter> by value <value>
Then the post with additional parametr <parameter> by value <value> is scheduled

Examples:
|name         |parameter     |value |
|testautotest |mood          |      |
|testautotest |music         |      |
|testautotest |location      |      |
|testautotest |adult content |      |
|testautotest |comments      |      |
|testautotest |screening     |      |
|testautotest |RSS           |      |
|testautotest |ratings       |      |
|testautotest |repost        |      |

 


Scenario: Edit additional parametrs in scheduled post
Meta: 
@categories create_edit_post time comfortable

Given logged user <name> with scheduled post on Scheduled post Page
When user edit parameter <parameter> by value <value> in the scheduled post
Then the post with additional parametr <parameter> by value <value> is scheduled

Examples:
|name         |parameter     |value |
|testautotest |mood          |      |
|testautotest |music         |      |
|testautotest |location      |      |
|testautotest |adult content |      |
|testautotest |comments      |      |
|testautotest |screening     |      |
|testautotest |RSS           |      |
|testautotest |ratings       |      |
|testautotest |repost        |      |