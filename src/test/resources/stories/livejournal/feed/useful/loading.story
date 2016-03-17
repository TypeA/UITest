Scenario: User's feed loading
Meta: 
@categories feed useful loading release

Given user <user> with paging type <type> on the Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed by type <type>

Examples:
|user           |type       |
|testautotest   |PAGES      |
|testautotest   |ENDLESS    |



Scenario: Another user feed loading
Meta: 
@categories feed useful loading release

Given user <user> on the user2 <user2> Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed by type <type>

Examples:
|user           |user2  |type       |
|testautotest   |test   |ENDLESS    |



Scenario: Feed loading by unlogged user
Meta: 
@categories feed useful loading release

Given unlogged user on the user <user> Friends Feed
When user scroll Friends Feed down
Then more entries are loading on Friends Feed by type <type>

Examples:
|user           |type       |
|testautotest   |ENDLESS    |

