Scenario: Forgot password

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user click link Forgot Password
Then user in Lost Information Page



Scenario: Remember me

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user puts a tick Remember me and authorize with correct data: name <name>, password <password>
Then can not authenticate during 60 days


Examples:
|name|password|
|test|test|