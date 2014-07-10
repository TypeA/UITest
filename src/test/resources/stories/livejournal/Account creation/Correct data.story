################################
Scenario: Go to registration form

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user
When user on Main Page clicks on Login Menu 
And when user clicks Create New Account
Then user should be on Registration Form




######################
Scenario: Regictration

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter correct data:
name|email|password|day|monse|year|gender
##1. В имени строчные буквы, цифры, пол задан, в пароле пробел
##2. В имени заглавные буквы, нижний слеш в середине, пол не задан, сегогдня исполняется 13
And when user clicks Create Account
Then user go to Finish registration form and see message <message>
And then user is registrsted