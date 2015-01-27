Scenario: Min security in creating post
Meta: 
@categories feed privacy test

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
@categories feed privacy

Given logged user (name <name>, password <password>) with post <post> with privacy <privacy>
When user edit privacy <privacy_1> in post
Then user see privacy <privacy_1> in post <post>

Examples:
|name           |password   |post           |privacy            |privacy_1          |
|testautotest   |test       |PostsGenerate  |public             |friends            |
|testautotest   |test       |PostsGenerate  |friends            |custom PostPrivacy |
|testautotest   |test       |PostsGenerate  |custom PostPrivacy |private            |
|testautotest   |test       |PostsGenerate  |private            |public             |