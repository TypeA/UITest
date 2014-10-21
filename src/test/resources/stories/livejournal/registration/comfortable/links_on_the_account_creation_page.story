Links on the account creation page

Scenario: TOS link

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user click TOS Link
Then user in correct page <page>

Examples:
|page                 |
|TosRusPageUnlogged   |



Scenario: Privacy link

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user click Privacy Link
Then user in correct page <page>

Examples:
|page                       |
|PrivacyRusPageUnlogged     |
