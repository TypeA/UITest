Scenario: From Main Page
Meta: 
@categories feed comfortable

Given login user (name <name>, password <password>)on Main Page
When user click on the Friend Feed in the Header
Then user in correct page <page> with URL <URL>

Examples:
|name|password||page|URL|
|test|test|Friend Feed|/feed|


Scenario: From Journal
Meta: 
@categories feed comfortable

Given login user (name <name>, password <password>)on Journal
When user click on the Feed Link
Then user in correct page <page> with URL <URL>

Examples:
|name|password||page|URL|
|test|test|Friend Feed|/feed|