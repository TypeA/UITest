Scenario: Post with subject
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) create new post <post> with subject <subject>
When user go to Friends Feed 
Then new post is on the Friends Feed

Examples:
|name|password|post|subject|
|test|test|PostsGenerate|subject|
|test|test|PostsGenerate||



Scenario: Post with html
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) create new post <post> with list
When user go to Friends Feed
Then post with html is on the Friends Feed

Examples:
|name|password|post|
|test|test|нумерованный список|
|test|test|ненумерованный список|
|test|test|ссылка|
|test|test|пользователь|



Scenario: Post with cut
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) create new post <post> with cut
When user go to Friends Feed
Then post with cut is on the Friends Feed

Examples:
|name|password|post|
|test|test|PostsGenerate|





Scenario: Post with content
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) create new post <post> with content
When user go to Friends Feed 
Then post with content is on the Friends Feed

Examples:
|name|password|post|
|test|test|фото|
|test|test|видео|
|test|test|карта|
|test|test|опрос|
|test|test|соц сети|



Scenario: Post in community
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>)  create new post <post> in community
When user go to Friends Feed 
Then user see that post in community on the Friends Feed

Examples:
|name|password|
|test|test|




Scenario: Jump to tags
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) create new post <post> with tag <tag>
When user click on that tag
Then user see posts with that tag

Examples:
|name|password|post|tag|
|test|test|PostsGenerate|tag|


Scenario: Edit Tags on Entry
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) on Friends Feed
When user click on Change Tag Link and change any tag
Then user see that changes on Friends Feed

Examples:
|name|password|
|test|test|



Scenario: Add comment
Meta: 
@categories feed useful 

Given logged user (name <name>, password <password>) on Friends Feed
When user click on Add Comment Link
Then user can add a comment

Examples:
|name|password|
|test|test|
