Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|name         |password     |link           |correct_page                   |page          |
|testautotest |test         |LOGO           |MainPageLogged                 |MainPageLogged|
|testautotest |test         |LJMAGAZINE     |LJMagazinePageLogged           |MainPageLogged|
|testautotest |test         |FEED           |FriendsFeedLogged              |MainPageLogged|
|testautotest |test         |MNGGROUP       |ManageGroupsPage               |MainPageLogged|
|testautotest |test         |MNGFRIENDS     |ManageFriendsPage              |MainPageLogged|
|testautotest |test         |MNGCOMMUNITIES |ManageCommunitiesPage          |MainPageLogged|
|testautotest |test         |BANNEDUSERS    |BannedUsersPage                |MainPageLogged|
|testautotest |test         |SHOP           |ShopPageLogged                 |MainPageLogged|
|testautotest |test         |PAID           |PaidAccountPageLogged          |MainPageLogged|
|testautotest |test         |PROMO          |PromoPageLogged                |MainPageLogged|
|testautotest |test         |HISTORY        |OrderHistoryLoggedPage         |MainPageLogged|
|testautotest |test         |TOKENS         |TokensPageLogged               |MainPageLogged|
|testautotest |test         |HELP           |SupportMainPageLogged          |MainPageLogged|
|testautotest |test         |ABOUT          |AboutMainPageLogged            |MainPageLogged|
|testautotest |test         |FAQ            |FaqMainPageLogged              |MainPageLogged|
|testautotest |test         |TOS            |TosRusPageLogged               |MainPageLogged|
|testautotest |test         |PRIVACY        |PrivacyRusPageLogged           |MainPageLogged|
|testautotest |test         |DMCA           |DMCAPageLogged                 |MainPageLogged|
|testautotest |test         |JOURNAL        |MyJournalPage                  |MainPageLogged|
|testautotest |test         |PROFILE        |ProfilePage                    |MainPageLogged|
|testautotest |test         |NEWENTRYINMENU |UpdateBmlPageLogged            |MainPageLogged|
|testautotest |test         |EDITPROFILE    |EditProfilePage                |MainPageLogged|
|testautotest |test         |MANAGEUSERPICS |EditPicsPage                   |MainPageLogged|
|testautotest |test         |MESSAGESINMENU |InboxMainPage                  |MainPageLogged|
|testautotest |test         |SHEDULED       |SheduledEntriesPage            |MainPageLogged|
|testautotest |test         |RECENTCOMMENTS |RecentCommentsPage             |MainPageLogged|
|testautotest |test         |ALBUM          |ScrapBookMainPage              |MainPageLogged|
|testautotest |test         |STATISTICS     |StatisticsMainPage             |MainPageLogged|
|testautotest |test         |TAGS           |TagsPage                       |MainPageLogged|
|testautotest |test         |MEMORIES       |MemoriesPage                   |MainPageLogged|
|testautotest |test         |JOURNALSTYLE   |CustomizeJournalPage           |MainPageLogged|
|testautotest |test         |SETTINGS       |SettingsMainPage               |MainPageLogged|
|testautotest |test         |LOGOUT         |ServicePageLogged              |MainPageLogged|





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user on Main Page
When unlogged user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|link           |correct_page            |page            |
|LOGO           |MainPageUnlogged        |MainPageUnlogged|
|LJMAGAZINE     |LJMagazinePageUnlogged  |MainPageUnlogged|
|SHOP           |ShopPageUnlogged        |MainPageUnlogged|
|PAID           |PaidAccountPageUnlogged |MainPageUnlogged|
|PROMO          |PromoPageUnlogged       |MainPageUnlogged|
|TOKENS         |LoginPageUnlogged       |MainPageUnlogged|
|HELP           |SupportMainPageUnlogged |MainPageUnlogged|
|ABOUT          |AboutMainPageUnlogged   |MainPageUnlogged|
|FAQ            |FaqMainPageUnlogged     |MainPageUnlogged|
|TOS            |TosRusPageUnlogged      |MainPageUnlogged|
|PRIVACY        |PrivacyRusPageUnlogged  |MainPageUnlogged|
|DMCA           |DMCAPageUnlogged        |MainPageUnlogged|

