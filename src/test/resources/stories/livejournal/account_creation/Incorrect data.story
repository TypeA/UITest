

Scenario: Incorrect email

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the email: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then button Create Account is not active and user see message <message> on popup


Examples:
|name|email|password|day|month|year|gender|message|
|test1234rnd|te"st@test.ru|Test123|1|4|1990|M|Ваш адрес email содержит недопустимые символы|
|test1234rnd|tes,t@test.ru|Test123|1|4|1990|M||Ваш адрес email содержит недопустимые символы|
|test1234rnd|te st@test.ru|Test123|1|4|1990|M|Ваш адрес email содержит недопустимые символы|
|test1234rnd|testtest.ru|Test123|1|4|1990|M|Вы указали неверный адрес email|
|test1234rnd|test@@test.ru|Test123|1|4|1990|M|Вы указали неверный адрес email|
|test1234rnd|tes222222222t@test.ru|Test123|1|4|1990|M||
|test1234rnd|test@test.r'u|Test123|1|4|1990|M|Неверный домен адреса email|
|test1234rnd|test@test.r()u|Test123|1|4|1990|M|Неверный домен адреса email|
|test12341rnd|te"st@test.ru|Test123|1|4|1990|M|Ваш адрес email содержит недопустимые символы|
|test12341rnd|tes,t@test.ru|Test123|1|4|1990|M||Ваш адрес email содержит недопустимые символы|
|test12341rnd|te st@test.ru|Test123|1|4|1990|M|Ваш адрес email содержит недопустимые символы|
|test12341rnd|testtest.ru|Test123|1|4|1990|M|Вы указали неверный адрес email|
|test12341rnd|test@@test.ru|Test123|1|4|1990|M|Вы указали неверный адрес email|
|test12341rnd|tes2222222t@test.ru|Test123|1|4|1990|M||
|test12341rnd|test@test.r'u|Test123|1|4|1990|M|Неверный домен адреса email|
|test12341rnd|test@test.r()u|Test123|1|4|1990|M|Неверный домен адреса email|
|test12342rnd|test@@test.ru|Test123|1|4|1990|M|Вы указали неверный адрес email|
|test12342rnd|tes2222222222t@test.ru|Test123|1|4|1990|M||
|test12342rnd|test@test.r'u|Test123|1|4|1990|M|Неверный домен адреса email|
|test12342rnd|test@test.r()u|Test123|1|4|1990|M|Неверный домен адреса email|




Scenario: Incorrect age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the age: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>

Examples:
|name|email|password|day|month|year|gender|message|
|test1234rnd|test@test.ru|Test123|1|4|2010|M|Проверка возраста|
