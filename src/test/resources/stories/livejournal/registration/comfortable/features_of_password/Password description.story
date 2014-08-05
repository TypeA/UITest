Scenario: Password description

Meta: 
@tags execution:auto,component:Registration,attributes:Comfortable

Given unlogged user on Registration Form
When user enter123 password <password> 
Then user see Password Bubble which contains text <text> and URL <URL>

Examples:
|password|text|URL|
|Test123|Требования к паролю:|http://www.livejournal.com/support/faq/71.html|

