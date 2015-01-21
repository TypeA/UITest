Scenario: Create post
Meta: 
@categories feed privacy test

Given logged user <name> on Create Post page
When user create new post with privacy <privacy>
Then user <name_1> can read the post
Then user <name_2> cannot read the post

Examples:
|name           |name_1         |name_2        |post           |privacy     | 
|testautotest   |test           |              |PostsGenerate  |Public      | 
|testautotest   |test_infriend  |test          |PostsGenerate  |Friends     |
|testautotest   |testautotest   |test_fgroup   |PostsGenerate  |Private     |

         




Scenario: Privacy in editing
Meta: 
@categories feed privacy

Given logged user (name <name>, password <password>) on Create Post page
When user create new public post <post> with privacy <privacy>
Then user see privacy <privacy> when edit what post

Examples:
|name           |password   |post           |privacy            |
|testautotest   |test       |PostsGenerate  |public             |
|testautotest   |test       |PostsGenerate  |friends            |
|testautotest   |test       |PostsGenerate  |custom PostPrivacy |
|testautotest   |test       |PostsGenerate  |private            |



Scenario: Edit post
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


