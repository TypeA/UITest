Scenario: New user From Main Page
Meta: 
@categories feed comfortable

Given new login user (name <name>, password <password>)on Main Page
When user click on the Friend Feed in the Header
Then user in correct page <page> with URL <URL>

Examples:
|name       |password   |page           |URL    |
|test765765 |Mary1992   |Friend Feed    |/feed  |


Scenario: New user From Journal
Meta: 
@categories feed comfortable

Given new login user (name <name>, password <password>)on Journal
When user click on the Feed Link
Then user in correct page <page> with URL <URL>

Examples:
|name       |password   |page           |URL    |
|test765765 |Mary1992   |Friend Feed    |/feed  |


Scenario: Old user on feed
Meta: 
@categories feed comfortable

Given old login user (name <name>, password <password>)on Main Page
When user click on the Friend Feed in the Header
Then user in correct page <page> with URL <URL>

Examples:
|name       |password   |page           |URL    |
|test765765 |Mary1992   |Friend Feed    |/feed  |


Scenario: Unlogged user on feed
Meta: 
@categories feed comfortable

Given unlogged user on Main Page
When user do to users <friend> Friend Feed in the Header
Then user in friends feed page <page> with URL <URL>

Examples:
|page           |URL    |friend |
|Friend Feed    |/feed  |test   |