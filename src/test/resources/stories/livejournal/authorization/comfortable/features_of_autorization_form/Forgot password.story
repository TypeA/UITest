Scenario: Forgot password

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user click link Forgot Password
Then user in Lost Information Page