Scenario: not paid account does not see Manage Note Page

Meta:
@categories manage note not_paid useful

Given logged not paid user <user> on Manage Note
When 
Then user can not access to Manage Note Page


Scenario: account changed from paid to free

Meta:
@categories manage note not_paid useful

Given logged paid user <user> on Manage Page
When paid user changed to no-paid user
Then user can not access to Manage Note Page
Then user can not see note on profile
Then user can not see note in control strip