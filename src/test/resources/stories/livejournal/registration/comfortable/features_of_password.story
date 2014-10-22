Features of password

Scenario: Displays password

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user enter password <password>
Then the password is hidden
When user clicks Mapping Button
Then the password is displayed

Examples:
|password   |
|Test123    |




Scenario: Password description

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form 1
When user enter password <password>  1
Then user see Password Bubble which contains text <text> (link <page>) 1

Examples:
|password   |text                   |page                   |
|Test123    |Требования к паролю:   |LearnMorePageUnlogged  |



