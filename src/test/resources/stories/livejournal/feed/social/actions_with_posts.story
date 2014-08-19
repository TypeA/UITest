Scenario: Add to memories
Meta: 
@categories feed social

Given logged user (name <name>, password <password>) create new post <post> 
When user go to Friends Feed add click Add to memories on that post <post>
Then use see Edit privacy level and select parameter <parameter>
Then other users see post <post> charges according to setting

Examples:
|name|password|post|parameter|
|test|test|PostsGenerate|public|
|test|test|PostsGenerate|friends only|
|test|test|PostsGenerate|private|
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!