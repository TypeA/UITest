Scenario: Create post
Meta: 
@categories create_edit_post privacy useful

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>)
Then user <name_1> can read the post
Then user <name_2> cannot read the post

Examples:
|name           |name_1          |name_2        |privacy     |group      |
|testautotest   |not_friend      |              |Public      |           |
|testautotest   |friend          |not_friend    |Friends     |           |
|testautotest   |friend_in_group |friend        |Custom      |test_group |
|testautotest   |current_user    |friend        |Private     |           |

         
Scenario: Privacy in editing 
Meta: 
@categories create_edit_post privacy useful

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>)
Then user see correct privacy <privacy_1> (group <group_1>) when edit this post

Examples:
|name           |privacy     |group             |privacy_1     |group_1                 |
|testautotest   |Public      |                  |Public        |                        |
|testautotest   |Friends     |                  |Friends       |                        |
|testautotest   |Custom      |test_group;Work   |Custom        |test_group;Work         |
|testautotest   |Private     |                  |Private       |                        |



Scenario: Edit post
Meta: 
@categories create_edit_post privacy useful

Given logged user <name> on Create Post page
When user create new post with privacy <privacy> (group <group>)
When user edit privacy <privacy_1> (group <group_1>) and save post
Then user see correct privacy <privacy_1> (group <group_1>) when edit this post

Examples:
|name           |privacy     |group                         |privacy_1      |group_1                       |
|testautotest   |Public      |                              |Private        |                              |
|testautotest   |Friends     |                              |Public         |                              |
|testautotest   |Custom      |test_group;Work;Local Friends |Friends        |                              |
|testautotest   |Private     |                              |Custom         |test_group;Work;Local Friends |                            |



Scenario: Restore privacy from draft
Meta: 
@categories create_edit_post privacy useful

Given logged user <name> on Create Post page
When user write new post with privacy <privacy> (group <group>) 
Then user can restore this post with privacy <privacy> (group <group>) from draft

Examples:
|name           |privacy     |group     | 
|testautotest   |Public      |          |
|testautotest   |Friends     |          |
|testautotest   |Custom      |test_group|
|testautotest   |Private     |          |
