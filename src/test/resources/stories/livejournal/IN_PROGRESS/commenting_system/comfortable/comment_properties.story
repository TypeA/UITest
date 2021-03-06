Scenario: Answer to comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user open any talk and click on Answer button 
Then the add comment form is opend


Examples:
|name   |password   |style  |
|test   |test       |s1     |
|test   |test       |s2     |


Scenario: Collapse comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user open any comment <comment> and click on Collapse button
Then the comment is collapsed


Examples:
|name   |password   |comment    |style  |
|test   |test       |comment    |s1     |
|test   |test       |comment    |s2     |


Scenario: Deploy comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>)
When user open any comment <comment> and click on Deploy button
Then the comment is deployed


Examples:
|name   |password   |comment    |style  |
|test   |test       |comment    |s1     |
|test   |test       |comment    |s2     |


Scenario: Manage comment

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user open any comment <comment> and click on Manage button
Then user in correct page <page> with URL <URL>


Examples:
|name   |password   |comment    |page           |URL                                                |style  |
|test   |test       |comment    |Manage Comment |http://www.livejournal.com/manage/subscriptions/   |s1     |
|test   |test       |comment    |Manage Comment |http://www.livejournal.com/manage/subscriptions/   |s2     |