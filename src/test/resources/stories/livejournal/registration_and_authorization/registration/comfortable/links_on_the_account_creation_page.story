Scenario: Links on the account creation page

Meta: 
@categories registration_and_authorization comfortable release

Given unlogged user on Registration Form
When user click link <link>
Then user in correct page <page>

Examples:
|page                    |link   |
|TosPageUnlogged         |TOS    |
|PrivacyPageUnlogged     |Privacy|


