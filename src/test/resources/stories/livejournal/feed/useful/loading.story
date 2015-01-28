Scenario: Feed loading for users with underscope in name on his feed
Meta: 
@categories feed useful

Given user (name <name>) with underscope in name on the Friends Feed
When user scroll down his Friends Feed
Then more entries are loading on Friends Feed

Examples:
|name     |
|long_name|




Scenario: Feed loading for users with underscope in name on oter user feed
Meta: 
@categories feed useful

Given user (name <name>) with underscope in name on the Friends Feed
When user scroll down oter user Friends Feed
Then more entries are loading on Friends Feed

Examples:
|name     |
|long_name|



Scenario: Feed with filter loading for users with underscope in name 
Meta: 
@categories feed useful

Given user (name <name>) with underscope in name on the Friends Feed
When user scroll down his Friends Feed with filter
Then more entries are loading on Friends Feed

Examples:
|name     |
|long_name|