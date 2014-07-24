Scenario: Unsuccessfully autorization

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Login Form
When user enter incorrect data: name <name>, password <password> and clicks LogIn
Then user not logged in and see message <message>


Examples:
|name|password|message|
|maxapryg|rndMary1992|Неверный пароль.|
|maxaprygrndtest|Mary1992|Такой пользователь не существует. Хотите ли вы создать аккаунт с этим именем?|