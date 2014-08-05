Scenario: Authorization through VK 

Meta: 
@tags execution:auto,component:Authorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through VK with correct data: login <login>, password <password> 
Then user should be in LJ through VK

Examples:
|login|password|
|auto-test@rambler.ru|Test123|