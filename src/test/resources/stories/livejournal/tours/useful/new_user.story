Scenario: Friends Feed tour
Meta: 
@categories feed comfortable

Given user (name <name>, password <password>), that can see Friends Feed Tour
When user go to Friends Feed
Then users see Friends Feed Tour, all buttons work

Examples:
|name   |password   |
|test   |test       |


Scenario: Welcome to LiveJournal
Meta: 
@categories feed comfortable

Given new user (name <name>, password <password>) 
When user go to Friends Feed
Then users see post <post> with block <block>
Then user ckick link <link> and go to page by URL <URL>

Examples:
|name   |password   |post                   |block                              |link                                       |URL
|test   |test       |Welcome to LiveJournal |Настройте свой журнал              |настройте                                  |/customize                         |
|test   |test       |Welcome to LiveJournal |Настройте свой журнал              |придумайте оригинальный текст для ссылок   |customize/options.bml?group=text   |
|test   |test       |Welcome to LiveJournal |Настройте свой журнал              |Картинки пользователя                      |/editpics.bml                      |
|test   |test       |Welcome to LiveJournal |Настройте свой журнал              |Узнайте больше                             |/support/faq/cat/userpics.html     |
|test   |test       |Welcome to LiveJournal |Настройте свой журнал              |Заполните профиль своего журнала           |/manage/profile/                   |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |ленте                                      |/support/faq/219.html              |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |узнайте                                    |/friends/find.bml                  |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |топ популярных записей                     |/                                  |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |Журнал ЖЖ                                  |/magazine/                         |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |одноклассников или однокурсников           |/schools/                          |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |ленте                                      |/feed                              |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |Сообщества                                 |/support/faq/77.html               |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |популярны в ЖЖ                             |/ratings/community/authority/      |
|test   |test       |Welcome to LiveJournal |Ищите новых друзей                 |вступите                                   |/support/faq/101.html              |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |страницу «Новая запись»                    |/update.bml                        |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |на главной странице                        |/                                  |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |Узнайте больше                             |/support/faq/222.html              |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |кат                                        |/support/faq/75.html               |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |метки                                      |/support/faq/226.html              |
|test   |test       |Welcome to LiveJournal |Пишите в свой журнал               |Узнайте больше                             |/support/faq/24.html               |
|test   |test       |Welcome to LiveJournal |Будьте в курсе последних событий   |подписаться на уведомления                 |/manage/settings/?cat=notifications|
|test   |test       |Welcome to LiveJournal |Будьте в курсе последних событий   |центр сообщений                            |/inbox                             |
|test   |test       |Welcome to LiveJournal |Будьте в курсе последних событий   |Узнайте больше                             |/support/faq/272.html              |
|test   |test       |Welcome to LiveJournal |Будьте в курсе последних событий   |Справке ЖЖ                                 |/support/faq                       |
|test   |test       |Welcome to LiveJournal |Будьте в курсе последних событий   |Школа ЖЖ                                   |/profile?list=friends              |