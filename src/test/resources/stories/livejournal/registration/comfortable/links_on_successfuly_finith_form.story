Scenario: Сhange Email link

Meta: 
@categories registration comfortable
@issue LJSUP-18873

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Сhange Email Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Сhange Email|/changeemail.bml|




Scenario: Validate Email link

Meta: 
@categories registration comfortable
@issue LJSUP-18873

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Validate Email Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Validate Email|/register.bml|



Scenario: Edit Profile link
@issue LJSUP-18873

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Edit Profile Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Edit Profile|/manage/profile|




Scenario: Find Friends link
@issue LJSUP-18873

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Find Friends Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Find Friends|/friends/find|




Scenario: Select Journal Style link
@issue LJSUP-18873

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Select Journal Style Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Select Journal|/customize|



Scenario: Friends Feed link
@issue LJSUP-18873

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Friends Feed Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Friends Feed|/feed|



Scenario: Ratings link
@issue LJSUP-18873

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Ratings Link
Then user in correct page <page> with URL <URL>

Examples:
|name|email|password|day|month|year|gender|page|URL|
|test1234rnd|test@test.ru|Test123|1|4|1990|M|Ratings|/ratings|