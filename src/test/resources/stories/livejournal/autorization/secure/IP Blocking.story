Scenario: Check IP blocking

Meta: 
@tags execution:auto,component:Autorization,attributes:Secure

Given unlogged user on Login Form
When user 4 times enters incorrect data: name <name>, incorrect_password <incorrect_password>
Then user see message <message> and can't enter with correct data: name <name>, correct_password <correct_password>


Examples:
|name|incorrect_password|correct_password|message|
|test|testrnd|test|Ваш адрес IP временно заблокирован, поскольку количество неудачных попыток входа превысило разумные пределы|