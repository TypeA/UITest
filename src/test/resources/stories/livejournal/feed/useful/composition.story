Scenario: Privacy
Meta: 
@categories feed useful composition

Given user <user> which create post with privacy <privacy> (group <group>)
Then user <user1> can see the post on the Friends Feed
Then user <user2> cannot see the post on the Friends Feed

Examples:
|user           |privacy    |group       |user1             |user2          | 
|testautotest   |Public     |            |follower          |not_follower   |
|testautotest   |Friends    |            |friend            |not_friend     |
|testautotest   |Custom     |test_group  |in_group          |not_in_group   |
|testautotest   |Private    |            |nobody            |current_user   |


Scenario: Widgets
Meta: 
@categories feed useful composition
Given user <user> by parametr <parameter> on Friends Feed
When user add all widgets on the Feed
Then composition of widgets is correct

Examples:
|user           |parameter  |
|testautotest   |cyr        |
|test           |noncyr     |


