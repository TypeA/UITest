Scenario: Incorrect age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the age: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>

Examples:
|name|email|password|day|month|year|gender|message|
|test1234rnd|test@test.ru|Test123|1|4|2010|M|Проверка возраста|