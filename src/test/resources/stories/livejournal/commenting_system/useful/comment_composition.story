Scenario: Comment with image

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>)
When user create new comment <comment> with image <image>
Then the comment is created


Examples:
|name|password|comment|image|
|test|test|comment|image|


Scenario: Comment with video

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>)
When user create new comment <comment> with video <video>
Then the comment is created


Examples:
|name|password|comment|video|
|test|test|comment|video|

Scenario: Comment with link

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user create new comment <comment> with link <link> 
Then the comment is created


Examples:
|name|password|comment|link|
|test|test|comment|link|


Scenario: Comment with user name

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user create new comment <comment> with user name <user_name>
Then the comment is created


Examples:
|name|password|comment|user_name|
|test|test|comment|user_name|