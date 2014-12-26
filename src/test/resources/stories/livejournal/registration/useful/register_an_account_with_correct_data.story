Register an account with correct data

Scenario: User go to registration form 

Meta: 
@categories registration useful blabla

When user on Main Page clicks on Login Menu and clicks Create New Account 
Then user in correct page <page>

Examples:
|page                 |
|CreateAccountPage    |



Scenario: Successfull registration

Meta: 
@categories registration useful

Given unlogged user on Registration Form
When user enter correct data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>


Examples:
|name           |email          |password   |day    |month  |year   |gender |message            |
|test1234rnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |Добро пожаловать   |
|TEST_TESTrnd   |test@test.ru   |Test123234 |today  |today  |today  |M      |Добро пожаловать   |



