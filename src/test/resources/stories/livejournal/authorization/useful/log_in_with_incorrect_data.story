Scenario: Unsuccessfully autorization

Meta: 
@categories authorization useful

Given unlogged user on Login Form
When user enter incorrect data: name <name> and clicks LogIn
Then user is not logged and see message <message>


Examples:
|name           |password   |message                           |
|testrnd        |test       |Такой пользователь не существует  |
|               |123Qwe     |Такой пользователь не существует  |
|testautotest   |testrnd    |Неверный пароль.                  |
|testautotest   |           |Неверный пароль.                  |