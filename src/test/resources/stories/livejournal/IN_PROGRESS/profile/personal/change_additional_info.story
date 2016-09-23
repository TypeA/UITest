Change additional info


Scenario: Change interests

Meta: 
@categories profile personal

Given logged user <user> on Profile page
When user enter another interest <interest> on Edit profile page
Then in Profile user see new interests <interest>

Examples:
|user        |interest    |
|testautotest|rnd_text    |
|testautotest|rnd_big_text|



Scenario: Change "about" info

Meta: 
@categories profile personal

Given logged user <user> on Profile page
When user enter another ??about info with HTML and text??
Then in Profile user see new about info <about>

Examples:
|user        |about       |
|testautotest|rnd_text    |
|testautotest|rnd_big_text|




Scenario: Change "web page" info

Meta: 
@categories profile personal

Given logged user <user> on Profile page
When user enter another link <link> with name of the link <name>
Then in Profile user see new name <name>
Then after user click on name, new link <link> works

Examples:
|user        |link       |name       |
|testautotest|rnd_link   |rnd_name   |





Scenario: Change Location

Meta: 
@categories profile personal

Given logged user <user> on Profile page
When user enter another location 
Then in Profile user see new location

Examples:
|user        |
|testautotest| 




Scenario: Detect location

Meta: 
@categories profile personal

Given logged user <user> on Profile page
When user click on detect button
Then autodection works

Examples:
|user        |
|testautotest| 



Scenario: Change email in contacts

Meta:
@categories profile personal

Given logged user <user> on Profile page
When user change email to <email>
Then in profile user see new <email>

Example:
|user          |email               |
|testautotest  |проверить валидацию |


Scenario: Change social info

Meta:
@categories profile personal

Given logged user <user> on Profile page
When user change social info 
Then in profile user see new social info 


Examples:
|user         |
|testautotest |




Scenario: Change additional contact info 

Meta:
@categories profile personal

Given logged user <user> on Profile page
When user change additional contact info that contains web page links
Then user see new  links


Examples:
|user          |
|testautotest  |


