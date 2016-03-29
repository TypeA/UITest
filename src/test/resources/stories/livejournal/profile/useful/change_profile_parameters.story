Change profile parameters



Scenario: Change name

Meta: 
@categories profile useful

Given logged user <user> on Edit Profile page
When user enter another name <name> on Edit profile page
Then in Profile user see new name <name>

Examples:
|user          |name       |
|testautotest  |test       |
|testautotest  |rnd_max    |
|testautotest  |rnd_border |


Scenario: Set null to name
Meta:
@categories profile useful test

Given logged user <user> on Edit Profile page
When user enter another name <name> on Edit profile page
Then in Profile user see Sticky Error

Examples:
|user          |name     |
|testautotest  |         |



Scenario: Change gender

Meta: 
@categories profile useful 

Given logged user <user> on Edit Profile page
When user enter another gender <gender> on Edit profile page
Then in Profile user see new gender <gender>

Examples:
|user        |gender     |
|testautotest|Male       |
|testautotest|Female     |




Scenario: Change to correct date of birth

Meta: 
@categories profile useful 

Given logged user <user> on Edit Profile page
When user <user> enter another correct date of birth on Edit profile page
Then in Profile user see new date of birth

Examples:
|user        |
|testautotest|




