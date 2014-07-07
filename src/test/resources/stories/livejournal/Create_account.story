Scenario: Go to registration form

Meta: 
@tags execution:manual,component:Registration

Given unlogged user
When user on main page clicks on Login menu item
And when user clicks Create New in popup window
Then user should be on registration form

Scenario: Go to registration form

Meta: 
@tags execution:manual,component:Registration

Given unlogged user
When user on main page clicks on Login menu item
And when user clicks Create New in popup window
And when user submit registration form correctly
Then user should see that he have been registered