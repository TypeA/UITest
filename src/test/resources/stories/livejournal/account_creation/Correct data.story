Scenario: Go to registration form

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

When user on Main Page clicks on Login Menu 
When user clicks Create New Account
Then user should be on Registration Form




Scenario: Registration

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data: <name>,<email>,<password>,<day>,<monse>,<year>,<gender>
When user clicks Create Account
Then user go to Finish Registration Form and see message <message>
Then user is registreted and create First Post

Examples:
|name|email|password|day|monse|year|gender|message|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Добро пожаловать|
|TEST_TEST|test@test.ru|Test123|1|2|1990||Добро пожаловать|


