Scenario: Min security in createing post
Meta: 
@categories feed privacy test

Given logged user <name> on Security page 
When user set min security <security>
Then user can set only allowed security <security>

Examples:
|name           |name_1         |name_2        |privacy     |group     | 
|testautotest   |test           |              |Public      |          |
|testautotest   |test_infriend  |test          |Friends     |          |
|testautotest   |test_fgroup    |test          |Custom      |test_group|
|testautotest   |testautotest   |test_fgroup   |Private     |          |

         

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