Scenario: IP blocking, when you spent login attempts

Meta: 
@categories registration_and_authorization secure testmaxa

Given unlogged user on Login Form
When user <user> 3 times enters incorrect password
Then user <user> see message <message> and can not login with correct data


Examples:
|user           |message                                                                                                        |
|testipblock    |Ваш адрес IP временно заблокирован    |
