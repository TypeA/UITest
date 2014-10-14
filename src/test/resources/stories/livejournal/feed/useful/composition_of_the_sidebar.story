Scenario: Links in widget
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) with widget <widget> in sidebar on Friends Feed
When user click link <link> on the widget <widget>
Then user in correct page <page> with URL <URL>


Examples:
|name   |password   |widget             |link               |page                       |URL                                    |
|test   |test       |Comments           |Allcomments        |Manage Comments            |/tools/recent_comments.bml             |
|test   |test       |Comments           |Allcomments        |Manage Comments            |/tools/recent_comments.bml             |
|test   |test       |Interesting link   |Edit Links List    |Customize Journal Style    |/customize/options.bml?group=linkslist |
|test   |test       |Facebook feed      |Login to Facebook  |Facebook                   |www.facebook.com/                      |
|test   |test       |Instagram feed     |Login to Instagram |Instagram                  |instagram.com/                         |
|test   |test       |Twitter feed       |Login to Twitter   |Twitter                    |api.twitter.com/                       |