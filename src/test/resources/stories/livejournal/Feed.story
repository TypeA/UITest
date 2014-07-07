Scenario: Go to Friend's feed

Meta: 
@tags execution:manual,component:Feed

Given logined user
When user on main page moves cursor on Friend Feed menu item
And when user clicks on Friends Feed in dropdown menu
Then user should be on Friends feed page