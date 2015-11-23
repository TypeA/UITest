Scenario: Public filters
Meta: 
@categories feed comfortable test

Given user <user> on user2 <user2> Friends Feed
Then user see only public filters
Then unlogged user cannot see filters

Examples:
|user               |user2         |
|testautotest       |test          |


Scenario: Default settings
Meta: 
@categories feed comfortable

Given user <user> on custom Friends Feed
Then user see Feed on default settings
Then unlogged see Feed on default settings

Examples:
|user               |
|testautotest       |