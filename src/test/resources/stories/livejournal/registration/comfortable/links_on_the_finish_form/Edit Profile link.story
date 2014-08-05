Scenario: Edit Profile link

Meta: 
@tags execution:auto,component:Registration,attributes:Comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Edit Profile Link
Then user in Edit Profile Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|