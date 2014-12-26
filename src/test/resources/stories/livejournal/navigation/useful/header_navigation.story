Scenario: Navigation for logged user

Meta: 
@categories navigation useful testrun

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|name           |password       |link           |correct_page                   |page          |
|cyr_test_cyr   |cyr_test_cyr   |LOGO           |MainPageLogged                 |MainPageLogged|
|ncyr_test_ncyr |ncyr_test_ncyr |BROWSE         |BrowseMainPageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |LJMAGAZINE     |LJMagazinePageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |FEED           |FriendsFeedLogged              |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MNGGROUP       |ManageGroupsPage               |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MNGFRIENDS     |ManageFriendsPage              |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MNGCOMMUNITIES |ManageCommunitiesPage          |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |BANNEDUSERS    |BannedUsersPage                |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |SHOP           |ShopPageLogged                 |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |PAID           |PaidAccountPageLogged          |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |PROMO          |PromoPageLogged                |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |HISTORY        |OrderHistoryLoggedPage         |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |TOKENS         |TokensPageLogged               |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |HELP           |SupportMainPageLogged          |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |ABOUT          |AboutMainPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |FAQ            |FaqMainPageLogged              |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |TOS            |TosRusPageLogged               |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |PRIVACY        |PrivacyRusPageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |DMCA           |DMCAPageLogged                 |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |JOURNAL        |MyJournalPage                  |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |PROFILE        |ProfilePage                    |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |NEWENTRYINMENU |UpdateBmlPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |EDITPROFILE    |EditProfilePage                |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MANAGEUSERPICS |EditPicsPage                   |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MESSAGESINMENU |InboxMainPage                  |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |SHEDULED       |SheduledEntriesPage            |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |RECENTCOMMENTS |RecentCommentsPage             |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |ALBUM          |ScrapBookMainPage              |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |STATISTICS     |StatisticsMainPage             |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |TAGS           |TagsPage                       |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |MEMORIES       |MemoriesPage                   |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |JOURNALSTYLE   |CustomizeJournalPage           |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |SETTINGS       |SettingsMainPage               |MainPageLogged|
|cyr_test_cyr   |cyr_test_cyr   |LOGOUT         |ServicePageLogged              |MainPageLogged|





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful testrun

Given unlogged user from region <region> on Main Page
When unlogged user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|link           |region |correct_page            |page            |
|LOGO           |cyr    |MainPageUnlogged        |MainPageUnlogged|
|BROWSE         |noncyr |BrowseMainPageUnlogged  |MainPageUnlogged|
|LJMAGAZINE     |cyr    |LJMagazinePageUnlogged  |MainPageUnlogged|
|SHOP           |cyr    |ShopPageUnlogged        |MainPageUnlogged|
|PAID           |cyr    |PaidAccountPageUnlogged |MainPageUnlogged|
|PROMO          |cyr    |PromoPageUnlogged       |MainPageUnlogged|
|TOKENS         |cyr    |LoginPageUnlogged       |MainPageUnlogged|
|HELP           |cyr    |SupportMainPageUnlogged |MainPageUnlogged|
|ABOUT          |cyr    |AboutMainPageUnlogged   |MainPageUnlogged|
|FAQ            |cyr    |FaqMainPageUnlogged     |MainPageUnlogged|
|TOS            |cyr    |TosRusPageUnlogged      |MainPageUnlogged|
|PRIVACY        |cyr    |PrivacyRusPageUnlogged  |MainPageUnlogged|
|DMCA           |cyr    |DMCAPageUnlogged        |MainPageUnlogged|

