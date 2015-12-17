Scenario: User can make new post with lj-like tag
Meta: 
@categories create_edit_post lj_tags useful

Given logged user <name> on Create Post page
When user create post with lj-like tag
Then the post is in journal and contains lj-like buttons

Examples:
|name         |
|testautotest |