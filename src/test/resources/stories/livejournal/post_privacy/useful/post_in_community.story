Scenario: Create post in community
Meta: 
@categories feed privacy

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>) in community
Then user <name_1> can read the post in community
Then user <name_2> cannot read the post in community

Examples:
|name           |name_1         |name_2        |privacy     |group     | 
|testautotest   |members        |other_user    |Members     |          |
|testautotest   |maintainers    |members       |Maintainers |          |
|testautotest   |other_user     |              |Public      |          |
|testautotest   |user_in_group  |members       |Custom      |group1    |

Scenario: Edit post in community
Meta:
@categories feed privacy

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>) in community
When user edit privacy <privacy_1> (group <group_1>) and save post in community
Then user see correct privacy <privacy_1> (group <group_1>) when edit this post in community

Examples:
|name           |privacy     |group     |privacy_1    |group_1    |
|testautotest   |Members     |          |Maintainers  |           |
|testautotest   |Maintainers |          |Public       |           |
|testautotest   |Public      |          |Custom       |group1     |
|testautotest   |Custom      |group1    |Members      |           |


