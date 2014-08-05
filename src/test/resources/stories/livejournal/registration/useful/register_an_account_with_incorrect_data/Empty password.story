Scenario: Empty password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave password field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Password Popup user see message <message> and button Create Account is not active

Examples:
|name|email|password|day|month|year|gender|message|
|test654rnd|test@test.ru||1|4|1990|M|Требования к паролю:|
