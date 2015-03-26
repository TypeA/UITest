Scenario: Logged user create new post with correct lj-user tag
Meta: 
@categories create_edit_post lj_tags comfortable

Given logged user <name> on Create Post page
When user enter correct username <ljuser> in ljuser bubble and create new post
Then the post is in journal and contains correct username <ljuser>

Examples:
|name         |ljuser       |
|testautotest |test         |
|testautotest |test001      |

Scenario: Logged user create new post with uncorrect lj-user tag
Meta: 
@categories create_edit_post lj_tags comfortable

Given logged user <name> on Create Post page
When user enter incorrect username <ljuser> in ljuser bubble and try to post new entry
Then user see an error in header

Examples:
|name         |ljuser       |
|testautotest |тест         |
|testautotest |!            |
|testautotest |=@4          |
|testautotest |%1тест       |
|testautotest |tеst         |
|testautotest |test/3       |
|testautotest |test=test    |