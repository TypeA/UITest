Scenario: Create post in community
Meta: 
@categories privacy community useful

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>) in community <community>
Then user <name_1> can read the post in community
Then user <name_2> cannot read the post in community

Examples:
|name           |community   |name_1         |name_2        |privacy     |group     | 
|testautotest   |test_comm   |members        |other_user    |Members     |          |
|testautotest   |test_comm   |maintainers    |members       |Maintainers |          |
|testautotest   |test_comm   |other_user     |              |Public      |          |
|testautotest   |test_comm   |user_in_group  |members       |Custom      |group1    |

Scenario: Edit post in community
Meta:
@categories privacy community useful

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>) in community <community>
When user edit privacy <privacy_1> (group <group_1>) and save post in community
Then user see correct privacy <privacy_1> (group <group_1>) when edit this post in community

Examples:
|name           |community   |privacy     |group     |privacy_1    |group_1    |
|testautotest   |test_comm   |Members     |          |Maintainers  |           |
|testautotest   |test_comm   |Maintainers |          |Public       |           |
|testautotest   |test_comm   |Public      |          |Custom       |group1     |
|testautotest   |test_comm   |Custom      |group1    |Members      |           |


