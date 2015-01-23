Scenario: Create post
Meta: 
@categories feed privacy test

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>)
Then user <name_1> can read the post
Then user <name_2> cannot read the post

Examples:
|name           |name_1         |name_2        |privacy     |group     | 
|testautotest   |test           |              |Public      |          |
|testautotest   |test_infriend  |test          |Friends     |          |
|testautotest   |test_fgroup    |test          |Custom      |test_group|
|testautotest   |testautotest   |test_fgroup   |Private     |          |

         
Scenario: Privacy in editing
Meta: 
@categories feed privacy

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>)
Then user see correct privacy <privacy> when edit this post

Examples:
|name           |privacy     |group     |
|testautotest   |Public      |          |
|testautotest   |Friends     |          |
|testautotest   |Custom      |test_group|
|testautotest   |Private     |          |



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


