Scenario: Logged user create new post with subject
Meta: 
@categories create_edit_post post_subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has correct subject <subject>

Examples:
|name         |subject        |
|testautotest |No subject     |
|testautotest |Всем "привет"! |
|testautotest |И вам привет!  |
|testautotest |Hello world!   |

Scenario: Logged user restore post with subject from draft
Meta: 
@categories create_edit_post post_subject useful draft

Given logged user <name> on Create Post page
When user write new post with subject <subject>
Then user can restore this post with subject <subject> from draft

Examples:
|name         |subject        |
|testautotest |No subject     |
|testautotest |Всем "привет"! |
|testautotest |И вам привет!  |
|testautotest |Hello world!   |

Scenario: Logged user create new post with subject and edit this post
Meta: 
@categories create_edit_post post_subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then user edit this post and see correct subject <subject>

Examples:
|name         |subject        |
|testautotest |No subject     |
|testautotest |Всем "привет"! |
|testautotest |И вам привет!  |
|testautotest |Hello world!   |

Scenario: Logged user create new post with subject and edit this post and save changes
Meta: 
@categories create_edit_post post_subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then user edit this post with a new subject <newsubject> and see correct subject in post

Examples:
|name         |subject        |newsubject       |
|testautotest |No subject     |Я заголовок      |
|testautotest |Всем "привет"! |No subject       |
|testautotest |И вам привет!  |I AM BREAD       |
|testautotest |Hello world!   |Кто здесь?       |