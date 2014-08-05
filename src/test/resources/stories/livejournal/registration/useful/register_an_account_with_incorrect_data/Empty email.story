Scenario: Empty email

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave email field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Email Popup user see message <message> and button Create Account is not active


Examples:
|name|email|password|day|month|year|gender|message|
|test654rnd||Test123|1|4|1990|M|Нужен для подтверждения регистрации и восстановления пароля|
