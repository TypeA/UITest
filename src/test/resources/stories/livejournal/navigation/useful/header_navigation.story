Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page> with URL <URL>

Examples:
|name       |password     |link           |page                                                                       |correct_page                   |URL                                        |
|test765765 |test         |LOGO           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Main Page                      |livejournal.ru                             |
|test765765 |test         |LJMAGAZINE     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LJMagazine Page                |/magazine/                                 |
|test765765 |test         |FEED           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Friends Feed Page              |/feed                                      |
|test765765 |test         |FRIENDSGROUP   |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends group Page      |/friends/editgroups.bml                    |
|test765765 |test         |MNGGROUP       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends Page            |/friends/edit.bml                          |
|test765765 |test         |MNGCOMMUNITIES |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Communities Page        |/community/manage.bml                      |
|test765765 |test         |BANNEDUSERS    |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Banusers Page                  |/manage/banusers.bml                       |
|test765765 |test         |SHOP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Shop Page                      |/shop                                      |
|test765765 |test         |PAID           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Paid Account Page              |/shop/paidaccount.bml                      |
|test765765 |test         |PROMO          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Promo Page                     |/shop/selfpromo.bml                        |
|test765765 |test         |HISTORY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Order History Page             |/shop/history.bml                          |
|test765765 |test         |TOKENS         |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Tokens Page                    |/shop/tokens.bml                           |
|test765765 |test         |HELP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Help Main Page                 |/support                                   |
|test765765 |test         |ABOUT          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |About Main Page                |/about                                     |
|test765765 |test         |FAQ            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |FAQ Page                       |/support/faq/                              |
|test765765 |test         |TOS            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |TOS Page                       |/legal/tos-russian-translation.bml         |
|test765765 |test         |PRIVACY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Privacy Page                   |/legal/privacy-russian-translation.bml     |
|test765765 |test         |DMCA           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |DMCA Page                      |/legal/dmca.bml                            |
|test765765 |test         |JOURNAL        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Journal Page                |test.                                      |
|test765765 |test         |PROFILE        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Profile Page                |/profile                                   |
|test765765 |test         |NEWENTRYINMENU |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |New Entry Page                 |/update.bml                                |
|test765765 |test         |EDITPROFILE    |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Edit Profile Page              |/manage/profile/                           |
|test765765 |test         |MANAGEUSERPICS |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Edit Userpics Page             |/editpics.bml                              |
|test765765 |test         |MESSAGESINMENU |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Inbox Page                     |/inbox/                                    |
|test765765 |test         |SHEDULED       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Sheduled Entries Page          |/manage/scheduled_posts.bml                |
|test765765 |test         |RECENTCOMMENTS |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Recent Comments Page           |/tools/recent_comments.bml                 |
|test765765 |test         |ALBUM          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Albums Page                 |/pics/catalog                              |
|test765765 |test         |STATISTICS     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Statics Page                   |/statistics/                               |
|test765765 |test         |TAGS           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Tags Page                      |/account/settings/tags/                    |
|test765765 |test         |MEMORIES       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Memories Page                  |/tools/memories.bml                        |
|test765765 |test         |JOURNALSTYLE   |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Jornal Style Page              |/customize/                                |
|test765765 |test         |SETTINGS       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Settings Page                  |/manage/settings/                          |
|test765765 |test         |LOGOUT         |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LogOut                         |livejournal.ru                             |



Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user on Main Page
When unlogged user goes from page <page> using link <link>
Then user on correct page <correct_page> with URL <URL>

Examples:
|link           |page                                                                        |correct_page                   |URL                                       |
|LOGO           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Main Page                      |livejournal.ru                            |
|LJMAGAZINE     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |LJMagazine Page                |/magazine/                                |
|SHOP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Shop Page                      |/shop                                     |
|PAID           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Paid Account Page              |/shop/paidaccount.bml                     |
|PROMO          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Promo Page                     |/shop/selfpromo.bml                       |
|TOKENS         |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Login Page                     |/login.bml                                |
|HELP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Help Main Page                 |/support                                  |
|ABOUT          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |About Main Page                |/about                                    |
|FAQ            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |FAQ Page                       |/support/faq/                             |
|TOS            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |TOS Page                       |/legal/tos-russian-translation.bml        |
|PRIVACY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Privacy Page                   |/legal/privacy-russian-translation.bml    |
|DMCA           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |DMCA Page                      |/legal/dmca.bml                           |                    |livejournal.ru                            |

