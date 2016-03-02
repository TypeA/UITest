Change profile parameters



Scenario: Change name

Meta: 
@categories profile useful test

Given logged user <user> on Edit Profile page
When user enter another name <name> on Edit profile page
Then in Profile user see new name <name>

Examples:
|user          |name       |
|testautotest  |test       |
|--testautotest|           |
|--testautotest|rnd_max    |




Scenario: Change gender

Meta: 
@categories profile useful 

Given logged user <user> on Edit Profile page
When user enter another gender <gender> on Edit profile page
Then in Profile user see new gender <gender>

Examples:
|user        |gender     |
|testautotest|male       |
|testautotest|female     |




Scenario: Change date of birth

Meta: 
@categories profile useful 

Given logged user <user> on Edit Profile page
When user enter another day <day> month <month> year <year> on Edit profile page
Then in Profile user see new date of birth <day>.<month>.<year>

Examples:
|user        |day    |month     |year    |
|testautotest|rnd_day|rnd_mnth  |rnd_year| проверить валидацию




