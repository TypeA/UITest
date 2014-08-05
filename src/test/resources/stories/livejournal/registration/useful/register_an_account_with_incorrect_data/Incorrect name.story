Scenario: Incorrect name

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then button Create Account is not active and user see message <message> on popup

Examples:
|name|email|password|day|month|year|gender|message|
|лоргшнеrnd|test@test.ru|Test123|1|4|1990|M|Имя пользователя содержит недопустимые символы|
|t.es,t1234rnd|test@test.ru|Test123|1|4|1990|M|Имя пользователя содержит недопустимые символы|
|te st1234rnd|test@test.ru|Test123|1|4|1990|M|Имя пользователя содержит недопустимые символы|
|_test1234rnd|test@test.ru|Test123|1|4|1990|M|Имя пользователя содержит недопустимые символы|
|test1234rnd_|test@test.ru|Test123|1|4|1990|M|Имя пользователя содержит недопустимые символы|
|teNOSst1234rnd|test@test.ru|Test123|1|4|1990|M||