Scenario: Empty name

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data leave name field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Name Popup user see message <message> and button Create Account is not active

Examples:
|name|email|password|day|month|year|gender|message|
||test@test.ru|Test123|1|4|1990|M|Используйте строчные латинские буквы a-z, цифры 0-9 и знак подчёркивания _ (не в начале и не в конце).|
