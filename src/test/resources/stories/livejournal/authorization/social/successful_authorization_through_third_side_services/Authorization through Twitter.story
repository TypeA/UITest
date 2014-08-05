Scenario: Authorization through Twitter 

Meta: 
@tags execution:auto,component:Authorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Twitter with correct data: login <login>, password <password> 
Then user should be in LJ through Twitter 

Examples:
|login|password|
|auto-test@rambler.ru|Test123|