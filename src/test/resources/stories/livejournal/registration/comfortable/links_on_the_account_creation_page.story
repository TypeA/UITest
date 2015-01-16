Scenario: Links on the account creation page

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user click link <link>
Then user in correct page <page>

Examples:
|page                       |link   |
|TosRusPageUnlogged         |TOS    |
|PrivacyRusPageUnlogged     |Privacy|


