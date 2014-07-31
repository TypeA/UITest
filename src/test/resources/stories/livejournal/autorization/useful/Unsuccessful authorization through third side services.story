Scenario: Unsuccessful autorization through Facebook 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Facebook with incorrect data: login <login>, password <password> 
Then user is not logged

Examples:
|login|password|
|rnd|rnd|





Scenario: Unsuccessful autorization through Twitter 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Twitter with incorrect data: login <login>, password <password> 
Then user is not logged

Examples:
|login|password|
|rnd|rnd|




Scenario: Unsuccessful autorization through VK 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through VK with incorrect data: login <login>, password <password> 
Then user is not logged

Examples:
|login|password|
|rnd|rnd|




Scenario: Unsuccessful autorization through Google+ 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Google+ with incorrect data: login <login>, password <password> 
Then user is not logged

Examples:
|login|password|
|rnd|rnd|




Scenario: Unsuccessful autorization through Mail.ru 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Mail.ru with incorrect data: login <login>, password <password> 
Then user is not logged

Examples:
|login|password|
|rnd|rnd|




Scenario: Unsuccessful autorization through OpenID 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through OpenID with incorrect data: OpenID_URL <OpenID_URL> 
Then user is not logged and see message <message>

Examples:
|OpenID_URL|message|
|rnd|Введите URL|