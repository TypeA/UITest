Scenario: Navigation for logged user

Meta: 
@categories navigation useful release

Given logged user (name <name>,region <region>) on Main Page
When user goes from page using link <link>
Then user on correct page <correct_page>

Examples:
|name           |region |link           |correct_page                   |
|cyr_test_cyr   |cyr    |LOGO           |MainPageLogged                 |
|ncyr_test_ncyr |noncyr |BROWSE         |BrowseMainPageLogged           |
|ncyr_test_ncyr |noncyr |RSS            |RssPageLogged                  |
|cyr_test_cyr   |cyr    |FEED           |FriendsFeedLogged              |
|cyr_test_cyr   |cyr    |SHOP           |ShopPageLogged                 |
|cyr_test_cyr   |cyr    |NEWENTRY       |UpdateBmlPageLogged            |
|cyr_test_cyr   |cyr    |JOURNAL        |MyJournalPageLogged            |
|cyr_test_cyr   |cyr    |PROFILE        |ProfilePageLogged              |
|cyr_test_cyr   |cyr    |STATISTICS     |StatisticsMainPage             |
|cyr_test_cyr   |cyr    |ALBUM          |ScrapBookMainPage              |
|cyr_test_cyr   |cyr    |VIDEO          |VideoAlbumMainPage             |
|cyr_test_cyr   |cyr    |MESSAGES       |InboxMainPage                  |
|cyr_test_cyr   |cyr    |SHEDULED       |SheduledEntriesPage            |
|cyr_test_cyr   |cyr    |RECENTCOMMENTS |RecentCommentsPage             |
|cyr_test_cyr   |cyr    |MNGCOMMUNITIES |ManageCommunitiesPage          |
|cyr_test_cyr   |cyr    |SETTINGS       |SettingsMainPage               |
|cyr_test_cyr   |cyr    |HELP           |SupportMainPageLogged          |
|cyr_test_cyr   |cyr    |LOGOUT         |ServicePageLogged              |





Scenario: Navigation for unlogged user 

Meta: 
@categories navigation useful release

Given unlogged user from region <region> on Main Page
When unlogged user goes from page using link <link>
Then user on correct page <correct_page>

Examples:
|region |link           |correct_page            |
|cyr    |LOGO           |MainPageUnlogged        |
|noncyr |BROWSE         |BrowseMainPageUnlogged  |
|noncyr |RSS            |RssPageUnlogged         |
|cyr    |SHOP           |ShopPageUnlogged        |
|cyr    |HELP           |SupportMainPageUnlogged |
|cyr    |REGISTRATION   |CreateAccountPage       |



Scenario: Navigation for logged user on journal pages

Meta: 
@categories navigation useful release

Given logged user (name <name>,region <region>) on Main Page
When logged user on journal page with syle <syle> use link <link>
Then user on correct page <correct_page>

Examples:
|name           |region |link           |correct_page                   |syle               |
|cyr_test_cyr   |cyr    |LOGO           |MainPageLogged                 |AIR                |
|ncyr_test_ncyr |noncyr |BROWSE         |BrowseMainPageLogged           |CHAMELEON          |
|ncyr_test_ncyr |noncyr |RSS            |RssPageLogged                  |EXPRESSIVE         |
|cyr_test_cyr   |cyr    |FEED           |FriendsFeedLogged              |SMOOTH SAILING     |
|cyr_test_cyr   |cyr    |SHOP           |ShopPageLogged                 |TRANQUILITY        |
|cyr_test_cyr   |cyr    |NEWENTRY       |UpdateBmlPageLogged            |BLOGGISH           |
|cyr_test_cyr   |cyr    |JOURNAL        |MyJournalPageLogged            |FLEXIBLE SQUARES   |
|cyr_test_cyr   |cyr    |PROFILE        |ProfilePageLogged              |AIR                |
|cyr_test_cyr   |cyr    |STATISTICS     |StatisticsMainPage             |CHAMELEON          |
|cyr_test_cyr   |cyr    |ALBUM          |ScrapBookMainPage              |EXPRESSIVE         |
|cyr_test_cyr   |cyr    |VIDEO          |VideoAlbumMainPage             |MINIMALISM         |
|cyr_test_cyr   |cyr    |MESSAGES       |InboxMainPage                  |SMOOTH SAILING     |
|cyr_test_cyr   |cyr    |SHEDULED       |SheduledEntriesPage            |TRANQUILITY        |
|cyr_test_cyr   |cyr    |RECENTCOMMENTS |RecentCommentsPage             |BLOGGISH           |
|cyr_test_cyr   |cyr    |MNGCOMMUNITIES |ManageCommunitiesPage          |FLEXIBLE SQUARES   |
|cyr_test_cyr   |cyr    |SETTINGS       |SettingsMainPage               |AIR                |
|cyr_test_cyr   |cyr    |HELP           |SupportMainPageLogged          |CHAMELEON          |
|cyr_test_cyr   |cyr    |LOGOUT         |ServicePageLogged              |EXPRESSIVE         |





Scenario: Navigation for unlogged user on journal pages

Meta: 
@categories navigation useful release

Given unlogged user from region <region> on Main Page
When unlogged user on journal page with syle <syle> use link <link>
Then user on correct page <correct_page>

Examples:
|region |link           |correct_page            |syle               |
|cyr    |LOGO           |MainPageUnlogged        |AIR                |
|noncyr |BROWSE         |BrowseMainPageUnlogged  |CHAMELEON          |
|noncyr |RSS            |RssPageUnlogged         |EXPRESSIVE         |
|cyr    |SHOP           |ShopPageUnlogged        |SMOOTH SAILING     |
|cyr    |HELP           |SupportMainPageUnlogged |TRANQUILITY        |
|cyr    |REGISTRATION   |CreateAccountPage       |BLOGGISH           |
