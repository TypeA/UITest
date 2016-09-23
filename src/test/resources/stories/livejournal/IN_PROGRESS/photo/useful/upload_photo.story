Scenario: upload photo to post with different privacy
Meta: 
@categories create_edit_post photo privacy dsf132313123131

Given logged user <name> on Create Post page
When upload photo to post with privacy <privacy>
Then post contains photo with privacy <privacy>

Examples:
|name    |privacy     |
|test    |Public      |
|test    |Friends     |
|test    |Custom      |
|test    |Private     |


Scenario: upload photo to post with different size
Meta:
@categories create_edit_post photo size

Given logged user <name> on Create Post page
When upload photo to post with <size>
Then post contains photo with <size>

Examples:
|name    |size        |
|test    |100         |
|test    |300         |
|test    |600         |
|test    |800         |
|test    |900         |
|test    |1000        |
|test    |original    |

Scenario: upload photo to new album
Meta:
@categories create_edit_post photo

Given logged user <name> on Create Post page
When upload photo to post to new album
Then post contains photo
Then album is displayed on Photo album page

Examples:
|name    |
|test    |

Scenario: upload photo to post with link to fullsize
Meta:
@categories create_edit_post photo

Given logged user <name> on Create Post page
When upload photo to post with link  to fullsize
Then post contains photo with link to fullsize

Examples:
|user   |
|test   |
