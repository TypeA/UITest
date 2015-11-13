Scenario: User's feed loading
Meta: 
@categories feed useful

Given user <user> with paging type <type> on the Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed by type <type>

Examples:
|name           |type       |
|testautotest   |PAGES      |
|testautotest   |ENDLESS    |


Scenario: Another user feed loading
Meta: 
@categories feed useful

Given user <user> on the user2 <user2> Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed

Examples:
|user           |user2  |
|testautotest   |test   |



Scenario: Feed loading by unlogged user
Meta: 
@categories feed useful

Given unlogged user on the user <user> Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed

Examples:
|user           |
|testautotest   |

