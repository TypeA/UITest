Scenario: Сhange Email link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Сhange Email Link
Then user in Сhange Email Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|




Scenario: Validate Email link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Validate Email Link
Then user in Validate Email Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|



Scenario: Edit Profile link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Edit Profile Link
Then user in Edit Profile Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|




Scenario: Find Friends link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Find Friends Link
Then user in Find Friends Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|




Scenario: Select Journal Style link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Select Journal Style Link
Then user in Select Journal Style Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|



Scenario: Friends Feed link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Friends Feed Link
Then user in Friends Feed Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|



Scenario: Ratings link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Ratings Link
Then user in Ratings Page

Examples:
|name|email|password|day|month|year|gender|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|