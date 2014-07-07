Scenario: Authorize

Meta: 
@tags execution:manual,component:Authorization

Given unlogged user
When user login page  submit login form with login <login> and password <password>
And when user click Log in
Then user should be authorized

