Scenario: Post with correct lj-user tag
Meta: 
@categories create_edit_post lj_tags useful

Given logged user <name> on Create Post page
When user enter correct username <ljuser> in ljuser bubble and create new post
Then the post is in journal and contains correct username <ljuser>

Examples:
|name         |ljuser       |
|testautotest |test         |
|testautotest |TEST         |
|testautotest |Test         |
|testautotest |tesT         |

Scenario: Post with uncorrect lj-user tag
Meta: 
@categories create_edit_post lj_tags useful

Given logged user <name> on Create Post page
When user enter incorrect username <ljuser> in ljuser bubble and try to post new entry
Then user see an error in header

Examples:
|name         |ljuser       |
|testautotest |тест         |
|testautotest |! =@4 /3     |
|testautotest |tеst         |
