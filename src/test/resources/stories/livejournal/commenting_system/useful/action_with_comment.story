Scenario: Add comment in journal

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user add new comment <comment> in journal
Then the comment is created


Examples:
|name|password|comment|
|test|test|comment|


Scenario: Add comment in journal

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user add new comment <comment> in journal
Then the comment is created


Examples:
|name|password|comment|
|test|test|comment|



Scenario: Delete comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) with comment <comment> 
When user delete comment <comment>
Then the comment is deleted


Examples:
|name|password|comment|
|test|test|comment|


Scenario: Edit comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) with comment <comment> 
When user edit comment <comment>
Then the comment is edited


Examples:
|name|password|comment|
|test|test|comment|