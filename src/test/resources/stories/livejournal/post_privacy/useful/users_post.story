Scenario: Create post
Meta: 
@categories feed privacy test

Given logged user (name <name>, password <password>) on Create Post page
When user create new post with privacy <privacy>
Then user (name <name_1>, password <password_1>) can read the post
Then user (name <name_2>, password <password_2>) cannot read the post

Examples:
|name           |password   |name_1         |password_1   |name_2        |password_2   |post           |privacy            | 
|testautotest   |test       |test           |test         |              |             |PostsGenerate  |Public             | 
|testautotest   |test       |test_infriend  |Test123      |test          |test         |PostsGenerate  |Friends            |
|testautotest   |test       |testautotest   |test         |test_infgroup |Mary1992     |PostsGenerate  |Private            |

         




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


