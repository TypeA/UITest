Scenario: Min security in creating post in community
Meta: 
@categories create_edit_post privacy post_community min_security personal

Given logged user <name> on Security page for community <community>
When user set min security $security in the community <community>
Then user can set only allowed security <security> when create post in community <community>

Examples:
|name           |community            |security    | 
|testautotest   |test_comm            |Public      |
|testautotest   |test_comm            |Members     |


         
Scenario: Min security in editing post in community
Meta: 
@categories create_edit_post privacy post_community min_security personal

Given logged user <name> with min security <security> on Create Post page in community <community>
When user create new post with privacy <security> in community <community>
Then user see all privacy when edit this post (security <security>)

Examples:
|name           |community   |security    |
|testautotest   |test_comm   |Public      |
|testautotest   |test_comm   |Members     |
