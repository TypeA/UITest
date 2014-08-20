Scenario: Select privacy level
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user  click Add to memories on that post <post>
Then user see Edit privacy level and select parameter <parameter>
Then other users see post <post> charges according to setting

Examples:
|name|password|post|parameter|
|test|test|PostsGenerate|public|
|test|test|PostsGenerate|friends only|
|test|test|PostsGenerate|private|


Scenario: Full options
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When click Add to memories on that post <post> and click Full options
Then user in correct page <page> with URL <URL>

Examples:
|name|password|post|page|URL|
|test|test|PostsGenerate|Edit Memorable Entry|memadd.bml|


Scenario: Remove privacy level
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user click Add to memories on that post <post>
Then user see Remove Button and click there
Then privacy level on post <post> is not installed

Examples:
|name|password|post|
|test|test|PostsGenerate|


Scenario: Share
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user click Share on that post <post> and select resource <resource> 
Then user in correct page <resource> with URL <URL>


Examples:
|name|password|post|resource|URL|
|test|test|PostsGenerate|LJ|/update.bml|
|test|test|PostsGenerate|FB|www.facebook.com|
|test|test|PostsGenerate|Twitter|twitter.com|
|test|test|PostsGenerate|Digg|digg.com/|
|test|test|PostsGenerate|Tumblr|www.tumblr.com/|
|test|test|PostsGenerate|Stumbleupon|www.stumbleupon.com/|
|test|test|PostsGenerate|Email a friend|http://api.addthis.com/|


Scenario: Track this
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user click Track this on that post <post>
Then user in correct page <page> with URL <URL>

Examples:
|name|password|post|page|URL|
|test|test|PostsGenerate|Manage Message Settings|/manage/subscriptions/entry.bml|



Scenario: Edit entry
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user click Edit entry on that post <post> and delete post <post>
Then that post <post> is deleted

Examples:
|name|password|post|page|URL|
|test|test|PostsGenerate|Edit Entry|/editjournal.bml|


Scenario: Your post
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with your post <post> on Friends Feed
When user open toolbar on post <post>
Then toolbar contains Buttons <buttons>

Examples:
|name|password|post|buttons|
|test|test|PostsGenerate|4 кнопки|


Scenario: Not your post
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) with not your post <post> on Friends Feed
When user open toolbar on post <post>
Then toolbar contains Buttons <buttons>

Examples:
|name|password|post|buttons|
|test|test|PostsGenerate|2 кнопки|



