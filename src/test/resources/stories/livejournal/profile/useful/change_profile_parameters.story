Change profile parameters


Scenario: Change name

Meta: 
@categories profile useful

Given logged user <user> on Edit Profile page
When user enter another name <name> on Edit profile page
Then in Profile user see new correct name

Examples:
|user          |name       |
|testautotest  |rnd        |
|testautotest  |rnd_max    |



Scenario: Delete profile name
Meta:
@categories profile useful

Given logged user <user> on Edit Profile page
When user enter another name <name> on Edit profile page
Then in Profile user see Error

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
|user         |gender             |
|testautotest |Male               |
|testautotest |Female             |
|testautotest |Unspecified/Other  |




Scenario: Change to correct date of birth

Meta: 
@categories profile useful

Given logged user <user> on Edit Profile page
When user <user> enter another correct date of birth on Edit profile page
Then in Profile user see new date of birth

Examples:
|user        |
|testautotest|




