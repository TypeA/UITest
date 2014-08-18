Scenario: Public post
Meta: 
@categories feed privacy

Given logged user (name <name>, password <password>) 
When user create new public post <post>
Then all users see that post

Examples:
|name|password|post|
|test|test|PostsGenerate|



Scenario: Friends post
Meta: 
@categories feed privacy

Given logged user (name <name>, password <password>) 
When user create new friends post <post>
Then nobody but friends see that post

Examples:
|name|password|post|
|test|test|PostsGenerate|


Scenario: Private post
Meta: 
@categories feed privacy

Given logged user (name <name>, password <password>) 
When user create new private post <post>
Then nobody but creator does not see that post

Examples:
|name|password|post|
|test|test|PostsGenerate|


Scenario: Custom post
Meta: 
@categories feed privacy

Given logged user (name <name>, password <password>) 
When user create new custom post <post> for group <group>
Then nobody but group does not see that post

Examples:
|name|password|post|group|
|test|test|PostsGenerate|group|