Scenario: Default friends filters
Meta: 
@categories feed useful test

Given logged user <user> with friends on Friends Feed
When user set filter <filter>
Then user see feeds feed by filter <filter>

Examples:
|user               |filter         |
|test  |all            |
|--test_with_friends  |journals       |
|--test_with_friends  |communities    |
|--test_with_friends  |sendicated     |


Scenario: Default view
Meta: 
@categories feed useful

Given user, which exists Sendicated and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Sendicated feeds filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


Scenario: Edit Filters
Meta: 
@categories feed useful

Given logged user <user> on Friends Feed
When user go to Edit Custom Friends Groups
Then user in correct page <page>

Examples:
|name   |page             |
|test   |ManageGroupsPage |









Scenario: Journals only filter
Meta: 
@categories feed useful

Given user, which exists Journals and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Journals only filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


Scenario: Communities only filter
Meta: 
@categories feed useful

Given user, which exists Communities and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Communities only filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


Scenario: Sendicated filter
Meta: 
@categories feed useful

Given user, which exists Sendicated and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Sendicated feeds filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|



