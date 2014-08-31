Scenario: Not to hide comments

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Not to hide comments
Then the all comment <comment> is not hided


Examples:
|name|password|comment|
|test|test|comment|



Scenario: Hide anonymous comments

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Hide anonymous comments
Then the anonymous comment <comment> is hided


Examples:
|name|password|comment|
|test|test|comment|



Scenario: Hide all comments are not from your friends

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Hide all comments are not from your friends
Then the comment <comment> are not from your friends is hided


Examples:
|name|password|comment|
|test|test|comment|



Scenario: Hide all comments

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When set setting Hide all comments 
Then all comments <comment> is hided


Examples:
|name|password|comment|
|test|test|comment|