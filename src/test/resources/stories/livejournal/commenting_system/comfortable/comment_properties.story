Scenario: Answer to comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user open any talk and click on Answer button
Then the add comment form is opend


Examples:
|name|password|
|test|test|


Scenario: Collapse comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user open any comment <comment> and click on Collapse button
Then the comment is collapsed


Examples:
|name|password|comment|
|test|test|comment|


Scenario: Manage comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>) 
When user open any comment <comment> and click on Manage button
Then user in correct page <page> with URL <URL>


Examples:
|name|password|comment|page|URL|
|test|test|comment|Manage Comment|http://www.livejournal.com/manage/subscriptions/|