Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page>

Examples:
|name       |password     |link           |correct_page                   |page          |
|test765765 |test         |LOGO           |MainPageLogged                 |MainPageLogged|
|test765765 |test         |LJMAGAZINE     |LJMagazinePageLogged           |MainPageLogged|
|test765765 |test         |FEED           |FriendsFeedLogged              |MainPageLogged|
|test765765 |test         |MNGGROUP       |ManageGroupsPage               |MainPageLogged|
|test765765 |test         |MNGFRIENDS     |ManageFriendsPage              |MainPageLogged|
|test765765 |test         |MNGCOMMUNITIES |ManageCommunitiesPage          |MainPageLogged|
|test765765 |test         |BANNEDUSERS    |BannedUsersPage                |MainPageLogged|
|test765765 |test         |SHOP           |ShopPageLogged                 |MainPageLogged|
|test765765 |test         |PAID           |PaidAccountPageLogged          |MainPageLogged|
|test765765 |test         |PROMO          |PromoPageLogged                |MainPageLogged|
|test765765 |test         |HISTORY        |OrderHistoryLoggedPage         |MainPageLogged|
|test765765 |test         |TOKENS         |TokensPageLogged               |MainPageLogged|
|test765765 |test         |HELP           |SupportMainPageLogged          |MainPageLogged|
|test765765 |test         |ABOUT          |AboutMainPageLogged            |MainPageLogged|
|test765765 |test         |FAQ            |FaqMainPageLogged              |MainPageLogged|
|test765765 |test         |TOS            |TosRusPageLogged               |MainPageLogged|
|test765765 |test         |PRIVACY        |PrivacyRusPageLogged           |MainPageLogged|
|test765765 |test         |DMCA           |DMCAPageLogged                 |MainPageLogged|
|test765765 |test         |JOURNAL        |MyJournalPage                  |MainPageLogged|
|test765765 |test         |PROFILE        |ProfilePage                    |MainPageLogged|
|test765765 |test         |NEWENTRYINMENU |UpdateBmlPageLogged            |MainPageLogged|
|test765765 |test         |EDITPROFILE    |EditProfilePage                |MainPageLogged|
|test765765 |test         |MANAGEUSERPICS |EditPicsPage                   |MainPageLogged|
|test765765 |test         |MESSAGESINMENU |InboxMainPage                  |MainPageLogged|
|test765765 |test         |SHEDULED       |SheduledEntriesPage            |MainPageLogged|
|test765765 |test         |RECENTCOMMENTS |RecentCommentsPage             |MainPageLogged|
|test765765 |test         |ALBUM          |ScrapBookMainPage              |MainPageLogged|
|test765765 |test         |STATISTICS     |StatisticsMainPage             |MainPageLogged|
|test765765 |test         |TAGS           |TagsPage                       |MainPageLogged|
|test765765 |test         |MEMORIES       |MemoriesPage                   |MainPageLogged|
|test765765 |test         |JOURNALSTYLE   |CustomizeJournalPage           |MainPageLogged|
|test765765 |test         |SETTINGS       |SettingsMainPage               |MainPageLogged|
|test765765 |test         |LOGOUT         |ServicePageLogged              |MainPageLogged|





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

