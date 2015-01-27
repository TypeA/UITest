Scenario: Min security in creating post
Meta: 
@categories feed privacy

Given logged user <name> on Security page 
When user set min security <security>
Then user can set only allowed security <security> when create post

Examples:
|name           |security    | 
|testautotest   |Public      |
|testautotest   |Friends     |
|testautotest   |Private     |

         

Scenario: Min security in editing post
Meta: 
@categories feed privacy test

Given logged user <name> with min security <security> on Create Post page
When user create new post with privacy <security>
Then user see all privacy when edit this post

Examples:
|name           |security    |
|testautotest   |Public      |
|testautotest   |Friends     |
|testautotest   |Private     |