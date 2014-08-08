Scenario: Forgot password

Meta: 
@categories authorization comfortable 

Given unlogged user on Login Form
When user click link Forgot Password
Then user in Lost Information Page



Scenario: Remember me

Meta: 
@categories authorization comfortable

Given unlogged user on Login Form
When user puts a tick Remember me and authorize with correct data: name <name>, password <password>
Then can not authenticate during 60 days


Examples:
|name|password|
|test|test|