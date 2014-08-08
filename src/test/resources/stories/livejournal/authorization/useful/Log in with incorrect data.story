Scenario: Unsuccessfully autorization

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user enter incorrect data: name <name>, password <password> and clicks LogIn
Then user is not logged and see message <message>


Examples:
|name|password|message|
|test|testrnd|Неверный пароль.|
|test||Неверный пароль.|
|testrnd|test|Такой пользователь не существует. Хотите ли вы создать аккаунт с этим именем?|
||123Qwe|Такой пользователь не существует. Хотите ли вы создать аккаунт с этим именем?|