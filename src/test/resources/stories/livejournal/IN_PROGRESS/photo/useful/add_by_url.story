Scenario: add photo by url with different size
Meta:
@categories photo by_url useful

Given logged user <name> on Create Post page
When add photo by url <photo_url> with size <size> and with link <link>
Then post contains photo by url <photo_url> and size <size> and link <link>

Examples:
|name   |photo_url       |link      |size      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |                                 |100      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |www.livejournal.com/magazine     |300      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |www.afisha.ru                    |600      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |                                 |800      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |                                 |900      |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |www.livejournal.com              |1000     |
|test   |https://cloud.githubusercontent.com/assets/10027473/10514681/e23d4fca-7357-11e5-9ca8-01bc714a74e2.jpg  |                                 |Original |



