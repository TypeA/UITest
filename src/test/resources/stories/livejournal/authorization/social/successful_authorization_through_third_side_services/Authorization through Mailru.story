Scenario: Authorization through Mail.ru 

Meta: 
@tags execution:auto,component:Authorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through Mail.ru with correct data: login <login>, password <password> 
Then user should be in LJ through Mail.ru

Examples:
|login|password|
|auto-test@mail.ru|Test123|