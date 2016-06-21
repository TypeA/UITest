Scenario: User can create new entry with spoiler
Meta: 
@categories create_edit_post lj_tags useful release

Given logged user <name> on Create Post page
When user use spoiler <spoiler> and put some text in it
Then the post is in journal and contains spoiler with some information in it

Examples:
|name         |spoiler       |
|cyr_test_cyr |DEFAULT       |


Scenario: User can create new entry with custom title in spoiler
Meta: 
@categories create_edit_post lj_tags useful release

Given logged user <name> on Create Post page
When user use spoiler <spoiler> and put some text in it
Then the post is in journal and contains spoiler with custom title <spoiler>

Examples:
|name         |spoiler       |
|cyr_test_cyr |ололо         |

Scenario: Spoiler works on feed
Meta: 
@categories create_edit_post lj_tags useful release

Given logged user <name> on Create Post page
When user use spoiler <spoiler> and put some text in it
Then the post is on feed and contains spoiler with some information in it

Examples:
|name         |spoiler       |
|cyr_test_cyr |DEFAULT       |


Scenario: Spoiler with custom text on feed
Meta: 
@categories create_edit_post lj_tags useful release

Given logged user <name> on Create Post page
When user use spoiler <spoiler> and put some text in it
Then the post is on feed and contains spoiler with custom title <spoiler>

Examples:
|name         |spoiler       |
|cyr_test_cyr |ололо         |