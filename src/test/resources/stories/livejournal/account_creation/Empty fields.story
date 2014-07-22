
Scenario: Empty name

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave name field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Name Popup user see message <message> and button Create Account is not active

Examples:
|name|email|password|day|month|year|gender|message|
||test@test.ru|Test123|1|4|1990|M|Используйте строчные латинские буквы a-z, цифры 0-9 и знак подчёркивания _ (не в начале и не в конце).|






Scenario: Empty email

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave email field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Email Popup user see message <message> and button Create Account is not active


Examples:
|name|email|password|day|month|year|gender|message|
|test654rnd||Test123|1|4|1990|M|Нужен для подтверждения регистрации и восстановления пароля|





Scenario: Empty password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave password field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Password Popup user see message <message> and button Create Account is not active

Examples:
|name|email|password|day|month|year|gender|message|
|test654rnd|test@test.ru||1|4|1990|M|Требования к паролю:|




Scenario: Empty age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave one age field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Age Popup user see message <message> and button Create Account is not active

|name|email|password|day|month|year|gender|message|
|test654rnd|test@test.ru|Test123|-1|4|1990|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|
|test654rnd|test@test.ru|Test123|1|-1|1990|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|
|test654rnd|test@test.ru|Test123|1|4|-1|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|


