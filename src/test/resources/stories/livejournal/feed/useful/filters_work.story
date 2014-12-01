Scenario: All friends filter
Meta: 
@categories feed useful

Given user, which exists friends posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed and set All friends filter
When user set All friends filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


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


Scenario: Sendicated feeds filter
Meta: 
@categories feed useful

Given user, which exists Sendicated and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Sendicated feeds filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|



Scenario: Family filter
Meta: 
@categories feed useful

Given user, which exists Family and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Family filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


Scenario: Local friends filter
Meta: 
@categories feed useful

Given user, which exists Local friends and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Local friends filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|



Scenario: Mobile view filter
Meta: 
@categories feed useful

Given user, which exists Mobile view and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Mobile view filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|


Scenario: Online friends filter
Meta: 
@categories feed useful

Given user, which exists Online friends and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Online friends filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|



Scenario: School filter
Meta: 
@categories feed useful

Given user, which exists School and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set School filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|



Scenario: Work filter
Meta: 
@categories feed useful

Given user, which exists Work and other posts on the feed
When logged user (name <name>, password <password>) go to his Friends Feed
When user set Work filter
Then necessary posts displayed on the feed

Examples:
|name|password|
|test|test|
