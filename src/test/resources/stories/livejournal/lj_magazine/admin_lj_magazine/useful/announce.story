Scenario: Add new main announce
Meta: 
@categories lj_magazine admin_magazine  admin_announce_magazine useful fdsfdsfdsfdsfds

Given logged user on Main Page and go to Admin Magazine Announce
When create new main announce with image <image>
Then announce with image <image> is displayed on Lj Magazine

Examples:
|image  |
|https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg |

Scenario: Remove main Announcee
Meta: 
@categories lj_magazine admin_magazine  admin_announce_magazine useful 

Given logged user on Main Page and go to Admin Magazine Announce
When remove existing main announce and create new main announce with image <image>
Then previous main announce is dispalyed on Magazine feed
Then new main announce with image <image> is dispalyed in widget

Scenario: incorrect post
Meta:
@categories: lj_magazine admin_magazine  admin_announce_magazine useful 

Given logged user on Main Page and go to Admin Magazine Announce
When enter <incorrect_post> to main announce
Then main post is not changed

Examples:
|incorrect_post     |
|noexist            |
|userpost           |



