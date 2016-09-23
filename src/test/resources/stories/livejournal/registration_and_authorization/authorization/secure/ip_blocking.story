Scenario: IP blocking, when you spent login attempts

Meta: 
@categories registration_and_authorization secure

Given unlogged user on Login Form
When user 3 times enters incorrect data: name <name>, incorrect_password <incorrect_password>
Then user see message <message> and can not enter with correct data: name <name>


Examples:
|name           |incorrect_password |message                                                                                                        |
|testipblock    |testrnd            |Ваш адрес IP временно заблокирован, поскольку количество неудачных попыток входа превысило разумные пределы    |
