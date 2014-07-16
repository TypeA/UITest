
Scenario: Empty name

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data whith empty name:
|name|email|password|day|month|year|
Then user see bubble Name Bubble In Registration Page
And then in Name Bubble In Registration Page user see message <Используйте строчные латинские буквы a-z, цифры 0-9 и знак подчёркивания _ (не в начале и не в конце).>
And then button Create Account is not active




Scenario: Empty email

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data whith empty email:
|name|email|password|day|month|year|
Then user see bubble Email Bubble In Registration Page
And then in Email Bubble In Registration Page user see message <Нужен для подтверждения регистрации и восстановления пароля>
And then button Create Account is not active




Scenario: Empty password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data whith empty password:
|name|email|password|day|month|year|
Then user see bubble Password Bubble In Registration Page
And then in Password Bubble In Registration Page user see message <Требования к паролю:>
And then button Create Account is not active




Scenario: Empty age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data whith empty age:
|name|email|password|day|month|year|
##1. Не заполнен день
##2. Не заполнен месяц
##3. Не заполнен год
And then button Create Account is not active