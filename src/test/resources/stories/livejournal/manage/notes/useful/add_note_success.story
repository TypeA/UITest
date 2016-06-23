Scenario: Add note for user friend 

Meta: 
@categories manage note useful success friend_page

Given logged user <user> on Edit Friend Page
When user <user> add note for friend
Then username friend with asterisk and note is displayed on Friends Page
Then note is displayed on Manage Note Page

Examples:
|user             |
|qwerty0987       |

Scenario: Add note on manage note page

Meta: 
@categories manage add note useful success manage_page

Given logged user <user> on Manage Note
When user <user> add note for user <userStatus>
Then note is displayed on Manage Note Page
Then note is displayed on user profile
Then note is displayed in control strip
!--V-visible, D-deleted, S-suspended

Examples:
|user             |userStatus  |
|qwerty0987       |V           |
|qwerty0987       |D           |
|qwerty0987       |S           |



