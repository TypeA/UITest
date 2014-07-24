Scenario: Successful autorization through Facebook 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through Facebook with correct data: login <login>, password <password> 
Then user should be in LJ through Facebook

Examples:
|login|password|
|auto-test@rambler.ru|Test123|





Scenario: Successful autorization through Twitter 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through Twitter with correct data: login <login>, password <password> 
Then user should be in LJ through Twitter 

Examples:
|login|password|
|auto-test@rambler.ru|Test123|



Scenario: Successful autorization through VK 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through VK with correct data: login <login>, password <password> 
Then user should be in LJ through VK

Examples:
|login|password|
|auto-test@rambler.ru|Test123|





Scenario: Successful autorization through Google+ 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through Google+ with correct data: login <login>, password <password> 
Then user should be in LJ through Google+

Examples:
|login|password|
|auto-test@gmail.com|Test123|





Scenario: Successful autorization through Mail.ru 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through Mail.ru with correct data: login <login>, password <password> 
Then user should be in LJ through Mail.ru

Examples:
|login|password|
|auto-test@mail.ru|Test123|





Scenario: Successful autorization through OpenID 

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Autorization Form
When user autorizated through OpenID with correct data: OpenID_URL <OpenID_URL> 
Then user should be in LJ through OpenID

Examples:
|OpenID_URL|