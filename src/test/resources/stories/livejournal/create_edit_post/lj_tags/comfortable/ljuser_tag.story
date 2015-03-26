Scenario: Logged user create new post with lj-user tag
Meta: 
@categories create_edit_post lj_tags comfortable

Given logged user <name> on Create Post page
When user enter username <ljuser> in ljuser bubble and create new post
Then the post is in journal and contains correct username <ljuser>

Examples:
|name         |ljuser       |
|testautotest |test         |
|testautotest |test001      |