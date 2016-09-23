Register an account with correct data

Scenario: Successfull registration

Meta: 
@categories registration_and_authorization useful release

Given unlogged user on Registration Form
When user enter correct data: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user in correct page <page>


Examples:
|name       |email          |password   |day    |month  |year   |gender |page                |
|testrnd    |test@test.ru   |Test123    |1      |4      |1990   |M      |MyJournalPageLogged |
|TEST_rnd   |test@test.ru   |Test123234 |today  |today  |today  |M      |MyJournalPageLogged |



