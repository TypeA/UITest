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






Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful test

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

