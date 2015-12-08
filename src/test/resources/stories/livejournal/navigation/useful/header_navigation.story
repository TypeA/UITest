Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>,region <region>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|name           |region |link           |correct_page                   |page          |
|cyr_test_cyr   |cyr    |LOGO           |MainPageLogged                 |MainPageLogged|
|ncyr_test_ncyr |noncyr |BROWSE         |BrowseMainPageLogged           |MainPageLogged|
|ncyr_test_ncyr |noncyr |RSS            |RssPageLogged                  |MainPageLogged|
|cyr_test_cyr   |cyr    |LJMAGAZINE     |LJMagazinePageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr    |FEED           |FriendsFeedLogged              |MainPageLogged|
|cyr_test_cyr   |cyr    |SHOP           |ShopPageLogged                 |MainPageLogged|
|cyr_test_cyr   |cyr    |NEWENTRY       |UpdateBmlPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr    |JOURNAL        |MyJournalPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr    |PROFILE        |ProfilePage                    |MainPageLogged|
|cyr_test_cyr   |cyr    |STATISTICS     |StatisticsMainPage             |MainPageLogged|
|cyr_test_cyr   |cyr    |ALBUM          |ScrapBookMainPage              |MainPageLogged|
|cyr_test_cyr   |cyr    |VIDEO          |VideoAlbumMainPage             |MainPageLogged|
|cyr_test_cyr   |cyr    |MESSAGES       |InboxMainPage                  |MainPageLogged|
|cyr_test_cyr   |cyr    |SHEDULED       |SheduledEntriesPage            |MainPageLogged|
|cyr_test_cyr   |cyr    |RECENTCOMMENTS |RecentCommentsPage             |MainPageLogged|
|cyr_test_cyr   |cyr    |MNGCOMMUNITIES |ManageCommunitiesPage          |MainPageLogged|
|cyr_test_cyr   |cyr    |SETTINGS       |SettingsMainPage               |MainPageLogged|
|cyr_test_cyr   |cyr    |HELP           |SupportMainPageLogged          |MainPageLogged|
|cyr_test_cyr   |cyr    |LOGOUT         |ServicePageLogged              |MainPageLogged|





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user from region <region> on Main Page
When unlogged user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|region |link           |correct_page            |page            |
|cyr    |LOGO           |MainPageUnlogged        |MainPageUnlogged|
|noncyr |BROWSE         |BrowseMainPageUnlogged  |MainPageUnlogged|
|noncyr |RSS            |RssPageUnlogged         |MainPageUnlogged|
|cyr    |LJMAGAZINE     |LJMagazinePageUnlogged  |MainPageUnlogged|
|cyr    |SHOP           |ShopPageUnlogged        |MainPageUnlogged|
|cyr    |HELP           |SupportMainPageUnlogged |MainPageUnlogged|
|cyr    |REGISTRATION   |CreateAccountPage       |MainPageUnlogged|