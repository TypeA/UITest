Links on successfuly finish form

Scenario: Сhange Email link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Сhange Email Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL                |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Сhange Email   |/changeemail.bml   |




Scenario: Validate Email link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Validate Email Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Validate Email |/register.bml  |



Scenario: Edit Profile link


Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Edit Profile Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Edit Profile   |/manage/profile|




Scenario: Find Friends link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Find Friends Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Find Friends   |/friends/find  |




Scenario: Select Journal Style link


Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Select Journal Style Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL        |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Select Journal |/customize |



Scenario: Friends Feed link


Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Friends Feed Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page           |URL    |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Friends Feed   |/feed  |



Scenario: Ratings link


Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Ratings Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page       |URL            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Ratings    |ivejournal.ru/ |




Scenario: Underage Account link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click Underage Account Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page               |URL                |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2013   |M      |Underage Account   |/faq/244.html      |




Scenario: LJ Anonymously link

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click LJ Anonymously Link
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page |URL                |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2013   |M      |LJ   |livejournal.ru     |



Scenario: First post

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click on Create First Post button
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page               |URL             |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2000   |M      |Create Post Page   |/update.bml     |