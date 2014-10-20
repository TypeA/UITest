Scenario: Unsuccessfully autorization

Meta: 
@categories authorization useful

Given unlogged user on Login Form
When user enter incorrect data: name <name>, password <password> and clicks LogIn
Then user is not logged and see message <message>


Examples:
|name           |password   |message                                                                        |
|test765765     |testrnd    |Неверный пароль.                                                               |
|test765765     |           |Неверный пароль.                                                               |
|testrnd        |test       |Такой пользователь не существует. Хотите ли вы создать аккаунт с этим именем?  |
|               |123Qwe     |Такой пользователь не существует. Хотите ли вы создать аккаунт с этим именем?  |