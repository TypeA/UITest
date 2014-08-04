2 сценария про регистрацию с двумя итерациями


Scenario: Displays password

Meta: 
@tags execution:auto,component:Registration,attributes:Comfortable

Given unlogged user on Registration Form
When user enter password <password>
Then the password is hidden
When user clicks Mapping Button
Then the password is displayed

Examples:
|password|
|Test123|

Scenario: Password description

Meta: 
@tags execution:auto,component:Registration,attributes:Comfortable

Given unlogged user on Registration Form
When user enter123 password <password> 
Then user see Password Bubble which contains text <text> and URL <URL>

Examples:
|password|text|URL|
|Test123|Требования к паролю:|http://www.livejournal.com/support/faq/71.html|

