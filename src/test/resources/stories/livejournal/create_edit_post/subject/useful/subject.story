Scenario: User create new post with subject
Meta: 
@categories create_edit_post subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has correct subject <subject>

Examples:
|name         |subject                                  |
|testautotest |No subject                               |
|testautotest |Всем "привет"!                           |
|testautotest |И вам привет!                            |
|testautotest |Hello world!                             |
|testautotest |Со всякими символами ().,?/@#$%^&*+_=-!;:|



Scenario: User restore post with subject from draft
Meta: 
@categories create_edit_post subject useful draft

Given logged user <name> on Create Post page
When user write new post with subject <subject>
Then user can restore this post with subject <subject> from draft

Examples:
|name         |subject        |
|testautotest |No subject     |
|testautotest |Hello world!   |


Scenario: User edit post with subject
Meta: 
@categories create_edit_post subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then user edit this post with a new subject <newsubject> and see correct subject in post

Examples:
|name         |subject        |newsubject       |
|testautotest |No subject     |Я заголовок      |
|testautotest |Всем "привет"! |No subject       |
|testautotest |И вам привет!  |I AM BREAD       |
|testautotest |Hello world!   |Кто здесь?       |


Scenario: Subject in editing
Meta: 
@categories create_edit_post subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then user edit this post and see correct subject <subject>

Examples:
|name         |subject        |
|testautotest |No subject     |
|testautotest |Всем "привет"! |
|testautotest |И вам привет!  |
|testautotest |Hello world!   |


Scenario: User create new post with long subject
Meta: 
@categories create_edit_post subject useful

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has correct trimmed subject <subject>

Examples:
|name         |subject                                                                                                              |
|testautotest |Это будет слишком большой и длинный заголовок для этого скромного и простого поста который ты читаешь прямо сейчас   |