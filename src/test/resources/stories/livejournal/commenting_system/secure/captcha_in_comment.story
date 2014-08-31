Scenario: Nobody show captcha

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Nobody show captcha
Then all user sees captcha when adding a comment <comment>


Examples:
|name|password|comment|
|test|test|comment|



Scenario: Anonyms show captcha

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Anonyms show captcha
Then anonyms user sees captcha when adding a comment <comment>


Examples:
|name|password|comment|
|test|test|comment|


Scenario: All are not from your friends show captcha

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting All are not from your friends show captcha
Then all are not from your friends sees captcha when adding a comment <comment>


Examples:
|name|password|comment|
|test|test|comment|



Scenario: All users show captcha

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting All users show captcha
Then all users

Examples:
|name|password|comment|
|test|test|comment|