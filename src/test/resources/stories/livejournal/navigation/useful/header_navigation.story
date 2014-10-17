Scenario: Navigation for logged user

Meta: 
@categories navigation useful

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user on correct page <correct_page> with URL <URL>

Examples:
|name |password     |link           |page                                                                       |correct_page                   |URL                                        |
|test |test         |LOGO           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Main Page                      |livejournal.ru                             |
|test |test         |LJMAGAZINE     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LJMagazine Page                |/magazine/                                 |
|test |test         |FEED           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Friends Feed Page              |/feed                                      |
|test |test         |FRIENDSGROUP   |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends group Page      |/friends/editgroups.bml                    |
|test |test         |MNGGROUP       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends Page            |/friends/edit.bml                          |
|test |test         |MNGCOMMUNITIES |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Communities Page        |/community/manage.bml                      |
|test |test         |BANNEDUSERS    |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Banusers Page                  |/manage/banusers.bml                       |
|test |test         |SHOP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Shop Page                      |/shop                                      |
|test |test         |PAID           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Paid Account Page              |/shop/paidaccount.bml                      |
|test |test         |PROMO          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Promo Page                     |/shop/selfpromo.bml                        |
|test |test         |HISTORY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Order History Page             |/shop/history.bml                          |
|test |test         |TOKENS         |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Tokens Page                    |/shop/tokens.bml                           |
|test |test         |HELP           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Help Main Page                 |/support                                   |
|test |test         |ABOUT          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |About Main Page                |/about                                     |
|test |test         |FAQ            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |FAQ Page                       |/support/faq/                              |
|test |test         |TOS            |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |TOS Page                       |/legal/tos-russian-translation.bml         |
|test |test         |PRIVACY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Privacy Page                   |/legal/privacy-russian-translation.bml     |
|test |test         |DMCA           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |DMCA Page                      |/legal/dmca.bml                            |
|test |test         |JOURNAL        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Journal Page                |test.                                      |
|test |test         |PROFILE        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Profile Page                |/profile                                   |
|test |test         |NEWENTRYINMENU |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |New Entry Page                 |/update.bml                                |
|test |test         |EDITPROFILE    |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Edit Profile Page              |/manage/profile/                           |
|test |test         |MANAGEUSERPICS |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Edit Userpics Page             |/editpics.bml                              |
|test |test         |MESSAGESINMENU |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Inbox Page                     |/inbox/                                    |
|test |test         |SHEDULED       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Sheduled Entries Page          |/manage/scheduled_posts.bml                |
|test |test         |RECENTCOMMENTS |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Recent Comments Page           |/tools/recent_comments.bml                 |
|test |test         |ALBUM          |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |My Albums Page                 |/pics/catalog                              |
|test |test         |STATISTICS     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Statics Page                   |/statistics/                               |
|test |test         |TAGS           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Tags Page                      |/account/settings/tags/                    |
|test |test         |MEMORIES       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Memories Page                  |/tools/memories.bml                        |
|test |test         |JOURNALSTYLE   |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Jornal Style Page              |/customize/                                |
|test |test         |SETTINGS       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Settings Page                  |/manage/settings/                          |
|test |test         |LOGOUT         |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LogOut                         |livejournal.ru                             |



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

