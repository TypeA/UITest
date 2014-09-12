Register an account with correct data


Scenario: Go to registration form

Meta: 
@categories registration useful

When user on Main Page clicks on Login Menu and clicks Create New Account 
Then user in correct page <page> with URL <URL>

Examples:
|page                   |URL        |
|Create Account Page    |/create    |



Scenario: Successfull registration

Meta: 
@categories registration useful test

Given unlogged user on Registration Form
When user enter correct data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message> and create First Post


Examples:
|name           |email          |password   |day    |month  |year   |gender |message            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Добро пожаловать   |
|TEST_TESTrnd   |test@test.ru   |Test123234 |today  |today  |today  |M      |Добро пожаловать   |



