Scenario: Incorrect name

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the name:
|name|email|password|day|monse|year|
##1. Русские буквы
##2. Знаки препинания
##3. Пробел
##4. Нижний слеш в начале
##5. Нижний слеш в конце
##6. Ограничение по длинне
Then field Name Field turns red
And then user see message:
|message|
|Имя пользователя содержит недопустимые символы|
|Имя пользователя содержит недопустимые символы|
|Имя пользователя содержит недопустимые символы|
|НЕПРАВИЛЬНО!!!!|
|НЕПРАВИЛЬНО!!!!|
||
And then button Create Account is not active




Scenario: Incorrect email

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the email:
|name|email|password|day|monse|year|
##1. Двойные ковычки в логине
##2. Знаки препинания в логине
##3. Пробел в логине
##4. Нет собаки
##5. Две собаки
##6. Ограничение по длинне
##7. Одинарные ковычки в домене
##8. Скобки в домене
Then field Email Field  turns red
And then user see message:
|message|
|Ваш адрес email содержит недопустимые символы|
|Ваш адрес email содержит недопустимые символы|
|Ваш адрес email содержит недопустимые символы|
|Вы указали неверный адрес email. Адрес email выглядит так: username@some.domain|
|Вы указали неверный адрес email. Адрес email выглядит так: username@some.domain|
||
|Неверный домен адреса email|
|Неверный домен адреса email|
And then button Create Account is not active




Scenario: Incorrect password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the password: <name>,<email>,<password>,<day>,<monse>,<year>,<gender>
Then user see message <message> on popup
Then button Create Account is not active

Examples:
|name|email|password|day|monse|year|gender|message|
|test1234rnd|test@test.ru|Ешка123|1|4|1990|M|Пароль должен состоять только из символов, входящих в ASCII. В частности, русские буквы не годятся.|
|test1234rnd|test@test.ru|1Qqk|1|4|1990|M|Пароль не должен быть меньше 6 символов.|
|test1234rnd|test@test.ru|1Qqyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy|1|4|1990|M||
|test1234rnd|test@test.ru|rRtTyYiI|1|4|1990|M|Пароль, помимо букв алфавита, должен включать в себя не менее 1 цифры или символа.|
|test1234rnd|test@test.ru|ytrytr123|1|4|1990|M|Пароль должен содержать хотя бы одну заглавную букву (A-Z)|
|test1234rnd|test@test.ru|RTYFGH123|1|4|1990|M|Пароль должен содержать хотя бы одну прописную букву (a-z)|
|test1234rnd|test@test.ru|Rr1Rr1Rr1Rr1|1|4|1990|M|Пароль должен содержать как минимум 4 разных символа.|



Scenario: Incorrect age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the age: <name>,<email>,<password>,<day>,<monse>,<year>,<gender>
When user clicks Create Account
Then user go to Finish Registration Form and see message <message>

Examples:
|name|email|password|day|monse|year|gender|message|
|test1234rnd|test@test.ru|Test123|1|4|2010|M|Проверка возраста|
