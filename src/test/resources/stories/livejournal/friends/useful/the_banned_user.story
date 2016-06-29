Scenario: Ban User
Meta: 
@categories banned users personal release test

Given logged user (name <name>) on BannedUsersPage
When user ban one user_1 and save change
Then user_1 exist in ban list

Examples:
|name           |
|testautotest   |

Scenario: Unban user
Meta: 
@categories banned users personal release test

Given logged user (name <name>) on BannedUsersPage
When user unban one user_1 and save change
Then user_1 does not exists in ban list

Examples:
|name           |
|testautotest   |

Scenario: Ban several users
Meta: 
@categories banned users personal release test

Given logged user (name <name>) on BannedUsersPage
When user ban several users and save change
Then users exist in ban list

Examples:
|name           |
|testautotest   |

Scenario: Unban several users
Meta: 
@categories banned users personal release test

Given logged user (name <name>) on BannedUsersPage
When user unban several users and save change
Then users does not exist in ban list

Examples:
|name           |
|testautotest   |
