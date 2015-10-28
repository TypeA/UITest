Scenario: Edit main announce
Meta: 
@categories lj_magazine admin_magazine  admin_announce_magazine useful fdsfdsfdsfdsfds

Given logged user on Admin Magazine Announce
When edit announce with image <image>
Then announce with image <image> is displayed on Lj Magazine

Examples:
|image  |
|https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg |

Scenario: Create new announce
Meta: 
@categories lj_magazine admin_magazine  admin_announce_magazine useful 

Given logged user on Admin Magazine Announce
When create new announce with image <image>
Then previous announce is dispalyed on Magazine feed
Then new announce with image <image> is dispalyed in widget

Scenario: incorrect post
Meta:
@categories: lj_magazine admin_magazine  admin_announce_magazine useful 

Given logged user on Admin Magazine Announce
When enter <incorrect_post> to announce
Then announce is not changed

Examples:
|incorrect_post     |
|noexist            |
|userpost           |



