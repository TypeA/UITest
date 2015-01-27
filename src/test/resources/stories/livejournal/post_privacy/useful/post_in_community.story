Scenario: Create post in community
Meta: 
@categories feed privacy

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
