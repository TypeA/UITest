Register an account with incorrect data



Scenario: Incorrect name

Meta: 
@categories registration useful 
@issue LJSUP-19397

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name           |email          |password   |day    |month  |year   |gender |message                                            |
|лоргшнеrnd     |test@test.ru   |Test123    |1      |4      |1990   |M      |Имя пользователя содержит недопустимые символы     |
|t.es,t1234rnd  |test@test.ru   |Test123    |1      |4      |1990   |M      |Имя пользователя содержит недопустимые символы     |
|te st1234rnd   |test@test.ru   |Test123    |1      |4      |1990   |M      |Имя пользователя содержит недопустимые символы     |
|_test1234rnd   |test@test.ru   |Test123    |1      |4      |1990   |M      |Извините, но это имя пользователя зарезервировано  |
|test1234rnd_   |test@test.ru   |Test123    |1      |4      |1990   |M      |Извините, но это имя пользователя зарезервировано  |
|teNOSst1234rnd |test@test.ru   |Test123    |1      |4      |1990   |M      |                                                   |





Scenario: Incorrect email

Meta: 
@categories registration useful
@issue LJSUP-19397

Given unlogged user on Registration Form
When user enter correct data except for the email: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active


Examples:
|name           |email              |password   |day    |month  |year   |gender |message                                        |
|test1234rnd    |te"st@test.ru      |Test123    |1      |4      |1990   |M      |Ваш адрес email содержит недопустимые символы  |
|test1234rnd    |tes,t@test.ru      |Test123    |1      |4      |1990   |M      |Ваш адрес email содержит недопустимые символы  |
|test1234rnd    |te st@test.ru      |Test123    |1      |4      |1990   |M      |Ваш адрес email содержит недопустимые символы  |
|test1234rnd    |testtest.ru        |Test123    |1      |4      |1990   |M      |Вы указали неверный адрес email                |
|test1234rnd    |test@@test.ru      |Test123    |1      |4      |1990   |M      |Вы указали неверный адрес email                |
|test1234rnd    |tesNOSt@test.ru    |Test123    |1      |4      |1990   |M      |                                               |
|test1234rnd    |test@test.r'u      |Test123    |1      |4      |1990   |M      |Неверный домен адреса email                    |
|test1234rnd    |test@test.r()u     |Test123    |1      |4      |1990   |M      |Неверный домен адреса email                    |



Scenario: Incorrect password

Meta: 
@categories registration useful
@issue LJSUP-19183
@issue LJSUP-19397

Given unlogged user on Registration Form
When user enter correct data except for the password: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active


Examples:
|name           |email          |password       |day    |month  |year   |gender |message                                                                                                |
|test1234rnd    |test@test.ru   |1QqytNOS       |1      |4      |1990   |M      |                                                                                                       |
|test1234rnd    |test@test.ru   |rRtTyYiI       |1      |4      |1990   |M      |Пароль, помимо букв алфавита, должен включать в себя не менее 1 цифры или символа.                     |
|test1234rnd    |test@test.ru   |ytrytr123      |1      |4      |1990   |M      |Пароль должен содержать хотя бы одну заглавную букву (A-Z)                                             |
|test1234rnd    |test@test.ru   |RTYFGH123      |1      |4      |1990   |M      |Пароль должен содержать хотя бы одну прописную букву (a-z)                                             |
|test1234rnd    |test@test.ru   |Rr1Rr1Rr1Rr1   |1      |4      |1990   |M      |Пароль должен содержать как минимум 4 разных символа.                                                  |
|test1234rnd    |test@test.ru   |1Qqk           |1      |4      |1990   |M      |Пароль не должен быть меньше 6 символов.                                                               |
|test1234rnd    |test@test.ru   |Ешка123        |1      |4      |1990   |M      |Пароль должен состоять только из символов, входящих в ASCII. В частности, русские буквы не годятся.    |
|test1234R      |test@test.ru   |test1234R      |1      |4      |1990   |M      |Ваш пароль не должен основываться на вашем имени пользователя.                                         |




Scenario: Incorrect age


Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data except for the age: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>

Examples:
|name           |email          |password   |day    |month  |year   |gender |message            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2010   |M      |Age Verification   |


Scenario: Empty name

Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name   |email          |password   |day    |month  |year   |gender |message                                                                                                |
|       |test@test.ru   |Test123    |1      |4      |1990   |M      |Используйте строчные латинские буквы a-z, цифры 0-9 и знак подчёркивания _ (не в начале и не в конце). |






Scenario: Empty email

Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data except for the email: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active


Examples:
|name           |email  |password   |day    |month  |year   |gender |message                                                        |
|test654rnd     |       |Test123    |1      |4      |1990   |M      |Нужен для подтверждения регистрации и восстановления пароля    |





Scenario: Empty password

Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data except for the password: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name       |email          |password   |day    |month  |year   |gender |message                |
|test654rnd |test@test.ru   |           |1      |4      |1990   |M      |Требования к паролю:   |




Scenario: Empty age


Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data leave one age field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name       |email          |password   |day    |month  |year   |gender |message                                                                                                |
|test654rnd |test@test.ru   |Test123    |-1     |4      |1990   |M      |Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц    |
|test654rnd |test@test.ru   |Test123    |1      |-1     |1990   |M      |Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц    |
|test654rnd |test@test.ru   |Test123    |1      |4      |-1     |M      |Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц    |


