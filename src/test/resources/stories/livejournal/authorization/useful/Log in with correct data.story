Scenario: Successfully autorization

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user enter correct data: name <name>, password <password> and clicks LogIn
Then user logged in


Examples:
|name|password|
|test|test|

