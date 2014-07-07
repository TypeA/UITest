Scenario: Go to Post new entry

Meta: 
@tags execution:manual,component:Entry

Given logined user
When user on main page clicks on Post New Entry menu item
Then user should be on New Entry page

Scenario: Post new entry

Meta: 
@tags execution:manual,component:Entry

Given logined user
When user on main page clicks on Post New Entry menu item
And when user submits Entry fields
And when user clicks Post to journal button
Then user should see the new post page

Scenario: Edit entry

Meta: 
@tags execution:manual,component:Entry

Given logined user
When user on post page clicks on edit button
And when user change Entry fields
And when user clicks Save entry
Then user should see the post page with changes

Scenario: Delete entry

Meta: 
@tags execution:manual,component:Entry

Given logined user
When user on post page clicks on edit button
And when user clicks Delete entry
And when user go to deleted post page
Then user should see page not found