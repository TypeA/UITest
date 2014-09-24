Scenario: Navigation for logged user

Meta: 
@categories navigation useful test

Given logged user (name <name>, password <password>) on Main Page
When user goes to page <page> using link <link>
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
When user goes to page <page> using link <link>
Then user in correct page <page> with URL <URL>