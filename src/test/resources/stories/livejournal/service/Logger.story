Scenario: Logger for unlogged user
Meta:
@categories service logger

Given unlogged user on page <page> with url <url>
Then user get logs from dev console

Examples:
|page                                       |url                                                                        |
|Main Page                                  |http://www.livejournal.com                                                 |
|Medius category                            |http://www.livejournal.com/media/puteshestviya/                            |
|Medius post                                |http://www.livejournal.com/media/2595815.html                              |
|Medius repost                              |http://pine-and-apple.livejournal.com/97579.html?media                     |
|Ratings                                    |http://www.livejournal.com/ratings                                         |
|Ratings category                           |http://www.livejournal.com/ratings/category/visual                         |
|Ratings users                              |http://www.livejournal.com/ratings/users                                   |
|Ratings communities                        |http://www.livejournal.com/ratings/community                               |
|Browse                                     |http://www.livejournal.com/browse                                          |
|Rss                                        |http://www.livejournal.com/syn                                             |
|Shop                                       |http://www.livejournal.com/shop                                            |
|Help                                       |http://www.livejournal.com/support                                         |
|Support submit                             |https://www.livejournal.com/support/submit                                 |
|About                                      |http://www.livejournal.com/about/                                          |
|TOS                                        |http://www.livejournal.com/legal/tos-ru.bml                                |
|Betatest                                   |http://www.livejournal.com/betatest.bml                                    |
|Update.bml                                 |http://www.livejournal.com/update.bml                                      |
|Create account                             |https://www.livejournal.com/create                                         |
|Login page                                 |http://www.livejournal.com/login.bml                                       |
|User profile page                          |http://tema.livejournal.com/profile                                        |
|User feed                                  |http://100.livejournal.com/feed                                            |
|User feed only journals                    |http://100.livejournal.com/feed/journals/                                  |
|User photos                                |http://tema.livejournal.com/photo                                          |
|User photo album                           |http://tema.livejournal.com/photo/album/475                                |
|User photo                                 |http://tema.livejournal.com/photo/album/475/?mode=view&id=1688697&page=1   |
|User videos                                |http://long-name.livejournal.com/video/                                    |
|User video album                           |http://long-name.livejournal.com/video/album/3153                          |
|User video                                 |http://long-name.livejournal.com/video/album/3153/?mode=view&id=19335      |
|User calendar                              |http://test0002.livejournal.com/calendar                                   |
|User tags                                  |http://test0002.livejournal.com/tag/                                       |
|User post                                  |http://test0002.livejournal.com/20904.html                                 |
|Settings page                              |http://www.livejournal.com/manage/settings/                                |
