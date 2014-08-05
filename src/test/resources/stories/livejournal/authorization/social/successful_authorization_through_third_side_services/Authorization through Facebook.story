Scenario: Authorization through Facebook 

Meta: 
@tags execution:auto,component:Authorization,attributes:Social

When user authorizated through Facebook with correct data: login <login>, password <password> 
Then user should be autorizated in LJ through Facebook

Examples:
|login                  |password   |
|auto-test@rambler.ru   |Test123    |