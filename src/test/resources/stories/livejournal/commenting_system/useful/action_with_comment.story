Scenario: Add comment in journal

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user add new comment <comment> in journal
Then the comment is created


Examples:
|name|password|comment|style|
|test|test|comment|s1|
|test|test|comment|s2|


Scenario: Add comment in journal

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user add new comment <comment> in journal
Then the comment is created


Examples:
|name|password|comment|style|
|test|test|comment|s1|
|test|test|comment|s2|



Scenario: Delete comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) with comment <comment> 
When user delete comment <comment>
Then the comment is deleted


Examples:
|name|password|comment|style|
|test|test|comment|s1|
|test|test|comment|s2|


Scenario: Edit comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) with comment <comment> 
When user edit comment <comment>
Then the comment is edited


Examples:
|name|password|comment|style|
|test|test|comment|s1|
|test|test|comment|s2|