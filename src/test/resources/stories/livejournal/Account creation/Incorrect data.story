########################
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



#########################
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



#########################
Scenario: Incorrect password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the password:
|name|email|password|day|monse|year|
##1. Русские буквы
##2. Меньше шести символов (включая все необходимые)
##3. Больше 30 символов (включая все необходимые)
##4. Нет цифр и знаков
##5. Нет заглавных букв
##6. Нет строчных букв
##7. Используется только три разных символа
Then field Password Field turns red
And then user see message:
|message|
|Пароль должен состоять только из символов, входящих в ASCII. В частности, русские буквы не годятся.|
|Пароль не должен быть меньше 6 символов.|
||
|Пароль, помимо букв алфавита, должен включать в себя не менее 1 цифры или символа.|
|Пароль должен содержать хотя бы одну заглавную букву (A-Z)|
|Пароль должен содержать хотя бы одну прописную букву (a-z)|
|Пароль должен содержать как минимум 4 разных символа.|
And then button Create Account is not active




#########################
Scenario: Incorrect age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data except for the age:
|name|email|password|day|monse|year|
##1. Пользователю меньше 13
And when user clicks Create Account
Then user go to Finish registration form and see message <message>
And then user is not registrsted