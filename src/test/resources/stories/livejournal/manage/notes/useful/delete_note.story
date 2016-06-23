Scenario: delete user with note on manage 

Meta:
@categories manage note delete_note useful

Given logged user <user> on Manage Note
When delete user with note
Then note is not displayed on Manage Note Page
Then note is not displayed on user profile
Then note is not displayed in control strip