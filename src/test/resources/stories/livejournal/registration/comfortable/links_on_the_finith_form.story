Scenario: Links on successfuly finish form

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <page> on successfuly Finish Form
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page               |URL                |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Сhange Email       |/changeemail.bml   |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Validate Email     |/register.bml      |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Edit Profile       |/manage/profile    |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Find Friends       |/friends/find      |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Select Journal     |/customize         |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Friends Feed       |/feed              |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Ratings            |livejournal.ru/    |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2000   |M      |Create Post Page   |/update.bml        |


Scenario: Links on unsuccessfuly finish form

Meta: 
@categories registration comfortable test

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <page> on unsuccessfuly Finish Form
Then user in correct page <page> with URL <URL>

Examples:
|name           |email          |password   |day    |month  |year   |gender |page               |URL                |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2012   |M      |Main Page          |livejournal        |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2012   |M      |Underage Account   |/faq/244.html      |

