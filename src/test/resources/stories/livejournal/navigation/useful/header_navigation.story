Scenario: Navigation for logged user

Meta: 
@categories navigation useful test

Given logged user (name <name>, password <password>) on Main Page
When user goes to page <page> using link <link>
Then user in correct page <correct_page> with URL <URL>

Examples:
|name |password     |link       |page                                                                       |correct_page   |URL                |
|test |test         |LOGO       |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |Main Page      |livejournal.ru     |
|test |test         |LJMAGAZINE |com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged      |LJMagazine Page|/magazine/         |


Scenario: Navigation for unlogged user

Meta: 
@categories navigation useful

Given unlogged user on Main Page
When user goes to page <page> using link <link>
Then user in correct page <page> with URL <URL>