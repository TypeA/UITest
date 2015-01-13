Scenario: Links on successfuly finish form

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <link> on successfuly Finish Form
Then user in correct page <page>

Examples:
|name       |email          |password   |day    |month  |year   |gender |link               |page                   |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |СHANGE_EMAIL       |ChangeEmailPage        |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |VALIDATE_EMAIL     |ValidateEmailPage      |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |EDIT_PROFILE       |EditProfilePage        |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |FIND_FRIENDS       |FindFriendsPage        |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |SELECT_JOURNAL     |CustomizeJournalPage   |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |FRIENDS_FEED       |FriendsFeedLogged      |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |1990   |M      |RATINGS            |MainPageLogged         |
|testrnd    |test@test.ru   |Rnds123    |1      |4      |2000   |M      |CREATE_POST_PAGE   |UpdateBmlPageLogged    |


Scenario: Links on unsuccessfuly finish form

Meta: 
@categories registration comfortable

Given new user on Finish Form (data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>)
When user click link <link> on unsuccessfuly Finish Form
Then user in correct page <page>

Examples:
|name          |email          |password   |day    |month  |year   |gender |link               |page                          |
|test134rnd    |test@test.ru   |Rnds123    |1      |4      |2012   |M      |MAIN_PAGE          |MainPageUnlogged              |
|test134rnd    |test@test.ru   |Rnds123    |1      |4      |2012   |M      |UNDERAGE_ACCOUNT   |UnderageAccountPageUnlogged   |

