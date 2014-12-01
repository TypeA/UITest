Scenario: Links in widget for new user
Meta: 
@categories feed personal test1

Given new user (name <name>, password <password>) with widget <widget> in sidebar on Friends Feed
When user click link <link> on the widget <widget>
Then user in correct page <page>


Examples:
|name      |password   |widget             |link               |page                       |URL                                    |
|new-test  |test       |Instagram feed     |Login to Instagram |Instagram                  |instagram.com/                         |
|new-test  |test       |Twitter feed       |Login to Twitter   |Twitter                    |api.twitter.com/                       |