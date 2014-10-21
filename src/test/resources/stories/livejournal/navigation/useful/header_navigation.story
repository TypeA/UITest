Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <page>

Examples:
|name       |password     |link           |page                         |
|test765765 |test         |LOGO           |MainPageLogged                 |
|test765765 |test         |LJMAGAZINE     |LJMagazinePageLogged           |
|test765765 |test         |FEED           |FriendsFeedLogged              |
|test765765 |test         |MNGGROUP       |ManageGroupsPage               |
|test765765 |test         |MNGFRIENDS     |ManageFriendsPage              |
|test765765 |test         |MNGCOMMUNITIES |ManageCommunitiesPage          |
|test765765 |test         |BANNEDUSERS    |BannedUsersPage                |
|test765765 |test         |SHOP           |ShopPageLogged                 |
|test765765 |test         |PAID           |PaidAccountPageLogged          |
|test765765 |test         |PROMO          |PromoPageLogged                |
|test765765 |test         |HISTORY        |OrderHistoryLoggedPage         |
|test765765 |test         |TOKENS         |TokensPageLogged               |
|test765765 |test         |HELP           |SupportMainPageLogged          |
|test765765 |test         |ABOUT          |AboutMainPageLogged            |
|test765765 |test         |FAQ            |FaqMainPageLogged              |
|test765765 |test         |TOS            |TosRusPageLogged               |
|test765765 |test         |PRIVACY        |PrivacyRusPageLogged           |
|test765765 |test         |DMCA           |DMCAPageLogged                 |
|test765765 |test         |JOURNAL        |MyJournalPage                  |
|test765765 |test         |PROFILE        |ProfilePage                    |
|test765765 |test         |NEWENTRYINMENU |UpdateBmlPageLogged            |
|test765765 |test         |EDITPROFILE    |EditProfilePage                |
|test765765 |test         |MANAGEUSERPICS |EditPicsPage                   |
|test765765 |test         |MESSAGESINMENU |InboxMainPage                  |
|test765765 |test         |SHEDULED       |SheduledEntriesPage            |
|test765765 |test         |RECENTCOMMENTS |RecentCommentsPage             |
|test765765 |test         |ALBUM          |ScrapBookMainPage              |
|test765765 |test         |STATISTICS     |StatisticsMainPage             |
|test765765 |test         |TAGS           |TagsPage                       |
|test765765 |test         |MEMORIES       |MemoriesPage                   |
|test765765 |test         |JOURNALSTYLE   |CustomizeJournalPage           |
|test765765 |test         |SETTINGS       |SettingsMainPage               |
|test765765 |test         |LOGOUT         |ServicePageLogged              | 





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user on Main Page
When unlogged user goes from page <page> using link <link>
Then user on correct page <page>

Examples:
|link           |page                    |
|LOGO           |MainPageUnlogged        |
|LJMAGAZINE     |LJMagazinePageUnlogged  |
|SHOP           |ShopPageUnlogged        |
|PAID           |PaidAccountPageUnlogged |
|PROMO          |PromoPageUnlogged       |
|TOKENS         |LoginPageUnlogged       |
|HELP           |SupportMainPageUnlogged |
|ABOUT          |AboutMainPageUnlogged   |
|FAQ            |FaqMainPageUnlogged     |
|TOS            |TosRusPageUnlogged      |
|PRIVACY        |PrivacyRusPageUnlogged  |
|DMCA           |DMCAPageUnlogged        |             

