Scenario: Authorize

Meta: 
@tags execution:manual,component:authorization,attribute:personal

Given unlogged user
When user on page <page> clicks on Login menu item
And when user submit login form with login <login> and password <password>
Then user should be authorized