Scenario: Check IP blocking

Meta: 
@tags execution:auto,component:Autorization,attributes:Secure

Given unlogged user on Login Form
When user 5 times enters incorrect data: name <name>, incorrect_password <incorrect_password>
Then user see message <message> and can't enter with correct_password <correct_password>


Examples:
|name|incorrect_password|correct_password|
|test|testrnd|test|