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
|cyr_test_cyr   |cyr    |LJMAGAZINE     |LJMagazinePageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr    |FEED           |FriendsFeedLogged              |MainPageLogged|
|cyr_test_cyr   |cyr    |MNGGROUP       |ManageGroupsPage               |MainPageLogged|
|cyr_test_cyr   |cyr    |MNGFRIENDS     |ManageFriendsPage              |MainPageLogged|
|cyr_test_cyr   |cyr    |MNGCOMMUNITIES |ManageCommunitiesPage          |MainPageLogged|
|cyr_test_cyr   |cyr    |BANNEDUSERS    |BannedUsersPage                |MainPageLogged|
|cyr_test_cyr   |cyr    |SHOP           |ShopPageLogged                 |MainPageLogged|
|cyr_test_cyr   |cyr    |PAID           |PaidAccountPageLogged          |MainPageLogged|
|cyr_test_cyr   |cyr    |PROMO          |PromoPageLogged                |MainPageLogged|
|cyr_test_cyr   |cyr    |HISTORY        |OrderHistoryLoggedPage         |MainPageLogged|
|cyr_test_cyr   |cyr    |TOKENS         |TokensPageLogged               |MainPageLogged|
|cyr_test_cyr   |cyr    |HELP           |SupportMainPageLogged          |MainPageLogged|
|cyr_test_cyr   |cyr    |ABOUT          |AboutMainPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr    |FAQ            |FaqMainPageLogged              |MainPageLogged|
|cyr_test_cyr   |cyr    |TOS            |TosRusPageLogged               |MainPageLogged|
|cyr_test_cyr   |cyr    |PRIVACY        |PrivacyRusPageLogged           |MainPageLogged|
|cyr_test_cyr   |cyr    |DMCA           |DMCAPageLogged                 |MainPageLogged|
|cyr_test_cyr   |cyr    |JOURNAL        |MyJournalPage                  |MainPageLogged|
|cyr_test_cyr   |cyr    |PROFILE        |ProfilePage                    |MainPageLogged|
|cyr_test_cyr   |cyr    |NEWENTRYINMENU |UpdateBmlPageLogged            |MainPageLogged|
|cyr_test_cyr   |cyr    |EDITPROFILE    |EditProfilePage                |MainPageLogged|
|cyr_test_cyr   |cyr    |MANAGEUSERPICS |EditPicsPage                   |MainPageLogged|
|cyr_test_cyr   |cyr    |MESSAGESINMENU |InboxMainPage                  |MainPageLogged|
|cyr_test_cyr   |cyr    |SHEDULED       |SheduledEntriesPage            |MainPageLogged|
|cyr_test_cyr   |cyr    |RECENTCOMMENTS |RecentCommentsPage             |MainPageLogged|
|cyr_test_cyr   |cyr    |ALBUM          |ScrapBookMainPage              |MainPageLogged|
|cyr_test_cyr   |cyr    |STATISTICS     |StatisticsMainPage             |MainPageLogged|
|cyr_test_cyr   |cyr    |TAGS           |TagsPage                       |MainPageLogged|
|cyr_test_cyr   |cyr    |MEMORIES       |MemoriesPage                   |MainPageLogged|
|cyr_test_cyr   |cyr    |JOURNALSTYLE   |CustomizeJournalPage           |MainPageLogged|
|cyr_test_cyr   |cyr    |SETTINGS       |SettingsMainPage               |MainPageLogged|
|cyr_test_cyr   |cyr    |LOGOUT         |ServicePageLogged              |MainPageLogged|





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

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
|REGISTRATION   |cyr    |CreateAccountPage       |MainPageUnlogged|