Scenario: Empty age

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form1
When user enter correct data leave one age field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Age Popup user see message <message> and button Create Account is not active

Examples:
|name|email|password|day|month|year|gender|message|
|test654rnd|test@test.ru|Test123|-1|4|1990|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|
|test654rnd|test@test.ru|Test123|1|-1|1990|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|
|test654rnd|test@test.ru|Test123|1|4|-1|M|Мы обязаны спрашивать вашу дату рождения по закону. По умолчанию будут показаны только день и месяц|


