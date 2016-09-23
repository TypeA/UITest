Lifecycle:
Before:
Given a step that is executed before each scenario

Scenario: editor can not add source which banned the use of his posts
Meta:
@categories medius admin admin_medius create_post unsuccess banned_source

Given logged editor (name <user>) on Admin Medius Create Post
When editor add source which banned to use of his posts
Then post doest not created
Examples:
|user               |
|test               |





