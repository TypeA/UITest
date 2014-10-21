Scenario: Links on successfuly finish form

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <link> on successfuly Finish Form
Then user in correct page <page>

Examples:
|name           |email          |password   |day    |month  |year   |gender |link               |page                   |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |СHANGE_EMAIL       |ChangeEmailPage        |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |VALIDATE_EMAIL     |ValidateEmailPage      |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |EDIT_PROFILE       |EditProfilePage        |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |FIND_FRIENDS       |FindFriendsPage        |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |SELECT_JOURNAL     |CustomizeJournalPage   |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |FRIENDS_FEED       |FriendsFeedLogged      |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |RATINGS            |MainPageLogged         |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2000   |M      |CREATE_POST_PAGE   |UpdateBmlPageLogged    |


Scenario: Links on unsuccessfuly finish form

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <link> on unsuccessfuly Finish Form
Then user in correct page <page>

Examples:
|name           |email          |password   |day    |month  |year   |gender |link               |page                          |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2012   |M      |MAIN_PAGE          |MainPageUnlogged              |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |2012   |M      |UNDERAGE_ACCOUNT   |UnderageAccountPageUnlogged   |

