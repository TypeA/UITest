Scenario: User can create new entry with lj-cut
Meta: 
@categories create_edit_post lj_tags useful 

Given logged user <name> on Create Post page
When user use lj-cut <ljcut> and put some text in it
Then the post is in journal and contains lj-cut with some information in it

Examples:
|name         |ljcut       |
|testautotest |DEFAULT     |


Scenario: User can create new entry with custom title in lj-cut
Meta: 
@categories create_edit_post lj_tags useful 

Given logged user <name> on Create Post page
When user use lj-cut <ljcut> and put some text in it
Then the post is in journal and contains lj-cut with custom title <ljcut>

Examples:
|name         |ljcut       |
|testautotest |ололо       |


Scenario: LJ-cut works on feed
Meta: 
@categories create_edit_post lj_tags useful

Given logged user <name> on Create Post page
When user use lj-cut <ljcut> and put some text in it
Then the post is on feed and contains lj-cut with some information in it

Examples:
|name         |ljcut       |
|testautotest |DEFAULT     |


Scenario: Custom LJ-cut text on feed
Meta: 
@categories create_edit_post lj_tags useful

Given logged user <name> on Create Post page
When user use lj-cut <ljcut> and put some text in it
Then the post is on feed and contains lj-cut with custom title <ljcut>

Examples:
|name         |ljcut       |
|testautotest |ололо       |