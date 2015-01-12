Register an account with correct data

Scenario: Successfull registration

Meta: 
@categories registration useful test
@issue LJSUP-19944

Given unlogged user on Registration Form
When user enter correct data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>


Examples:
|name           |email          |password   |day    |month  |year   |gender |message            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Добро пожаловать   |
|TEST_TESTrnd   |test@test.ru   |Test123234 |today  |today  |today  |M      |Добро пожаловать   |



