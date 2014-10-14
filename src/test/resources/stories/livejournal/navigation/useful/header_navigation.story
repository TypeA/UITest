Scenario: Navigation for logged user

Meta: 
@categories navigation useful 

Given logged user (name <name>, password <password>) on Main Page
When user goes from page <page> using link <link>
Then user in correct page <correct_page> with URL <URL>

Examples:
|name |password     |link           |page                                                                       |correct_page                   |URL                      |
|test |test         |LOGO           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Main Page                      |livejournal.ru           |
|test |test         |LJMAGAZINE     |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LJMagazine Page                |/magazine/               |
|test |test         |FEED           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Friends Feed Page              |/feed                    |
|test |test         |FRIENDSGROUP   |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends group Page      |/friends/editgroups.bml  |
|test |test         |MNGGROUP       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Friends Page            |/friends/edit.bml        |
|test |test         |MNGCOMMUNITIES |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Manage Communities Page        |/community/manage.bml    |
|test |test         |BANNEDUSERS    |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Banusers Page                  |/manage/banusers.bml     |





Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user on Main Page
When unlogged user goes from page <page> using link <link>
Then user in correct page <correct_page> with URL <URL>

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
|PRIVACY        |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |Privacyage                     |/legal/privacy-russian-translation.bml    |
|DMCA           |com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged     |DMCA Page                      |/legal/dmca.bml                           |