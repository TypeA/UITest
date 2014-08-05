Scenario: Successfully registration

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message> and create First Post


Examples:
|name|email|password|day|month|year|gender|message|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Добро пожаловать|
|TEST_TESTrnd|test@test.ru|Test123|today|today|today|U|Добро пожаловать|



