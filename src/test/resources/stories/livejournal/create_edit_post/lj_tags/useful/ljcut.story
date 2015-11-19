Scenario: User can create new entry with lj-cut
Meta: 
@categories create_edit_post lj_tags useful testcut

Given logged user <name> on Create Post page
When user use lj-cut <ljcut> and put some text in it
Then the post is in journal and contains lj-cut with some information in it

Examples:
|name         |ljcut       |
|testautotest |DEFAULT     |