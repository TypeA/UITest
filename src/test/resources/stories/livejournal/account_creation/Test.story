
Scenario: Incorrect password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the password: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then button Create Account is not active and user see message <message> on popup


Examples:
|name|email|password|day|month|year|gender|message|
|test1234rnd|test@test.ru|1Qqyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy|1|4|1990|M||
|test1234rnd|test@test.ru|rRtTyYiI|1|4|1990|M|Пароль, помимо букв алфавита, должен включать в себя не менее 1 цифры или символа.|
|test1234rnd|test@test.ru|ytrytr123|1|4|1990|M|Пароль должен содержать хотя бы одну заглавную букву (A-Z)|
|test1234rnd|test@test.ru|RTYFGH123|1|4|1990|M|Пароль должен содержать хотя бы одну прописную букву (a-z)|
|test1234rnd|test@test.ru|Rr1Rr1Rr1Rr1|1|4|1990|M|Пароль должен содержать как минимум 4 разных символа.|
|test1234rnd|test@test.ru|1Qqk|1|4|1990|M|Пароль не должен быть меньше 6 символов.|
|test1234rnd|test@test.ru|Ешка123|1|4|1990|M|Пароль должен состоять только из символов, входящих в ASCII. В частности, русские буквы не годятся.|
|test1234R|test@test.ru|test1234R|1|4|1990|M|Ваш пароль не должен основываться на вашем имени пользователя.|


