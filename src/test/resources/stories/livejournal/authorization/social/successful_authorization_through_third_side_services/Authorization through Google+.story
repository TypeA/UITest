Scenario: Authorization through Google+ 

Meta: 
@tags execution:auto,component:Autorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Google+ with correct data: login <login>, password <password> 
Then user should be in LJ through Google+

Examples:
|login|password|
|auto-test@gmail.com|Test123|