Scenario: Subject with correct html tags
Meta: 
@categories create_edit_post subject comfortable release

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has subject <subject> with correct tag

Examples:
|name         |subject     |
|testautotest |<b>РўРµРјР°</b> |
|testautotest |<i>РўРµРјР°</i> |
|testautotest |<u>РўРµРјР°</u> |
|testautotest |<s>РўРµРјР°</s> |



Scenario: Subject with cropped html tags
Meta: 
@categories create_edit_post subject comfortable release

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has subject <subject> with cropped tag 

Examples:
|name         |subject                                                  |
|testautotest |<span style="font-size: 0.7em">РўРµРјР° СЂР°Р·РјРµСЂ С€СЂРёС„С‚Р°</span> |
|testautotest |<span style="color: #ad5e5e;">РўРµРјР° С†РІРµС‚РЅР°СЏ</span>        |
|testautotest |<a href="http://www.yandex.ru/">РЎСЃС‹Р»РєР°</a>               |



Scenario: Subject with incorrect html tags
Meta: 
@categories create_edit_post subject comfortable release

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has cultivated subject <cultivated_subject>

Examples:
|name         |subject                                                                                                                                                                                                                                                                                                                                              |cultivated_subject                                                                                     |
|testautotest |<lj-like />                                                                                                                                                                                                                                                                                                                                          |[lj-like in invalid context]                                                                           |
|testautotest |<img src="http://ic.pics.livejournal.com/maxapryg/71384044/504856/504856_900.jpg" alt="shop.jpg" title="shop.jpg">                                                                                                                                                                                                                                   |<img src="http://ic.pics.livejournal.com/maxapryg/71384044/504856/504856_900.jpg" alt="shop.jpg" tit   |
|testautotest |<iframe data-link="http://vc.videos.livejournal.com/index/player?player=new&record_id=231160&ad_template_id=4584" data-thumbnail="http://st1.eaglecdn.com/lj/20150320/550c2759a976f_1_360.jpg" frameBorder="0" height="315" src="http://vc.videos.livejournal.com/index/player?player=new&record_id=231160&ad_template_id=4584" width="560"></iframe>|<iframe data-link="http://vc.videos.livejournal.com/index/player?player=new&record_id=231160&ad_temp   |
|testautotest |<lj-spoiler title="!!!"></lj-spoiler>                                                                                                                                                                                                                                                                                                                |[!!!]                                                                                                  |
|testautotest |<lj-map url="http://maps.yandex.ru/?ll=37.625207%2C55.699252&spn=0.022016%2C0.006677&z=16&l=map" width="425" height="350" />                                                                                                                                                                                                                         |<lj-map url="http://maps.yandex.ru/?ll=37.625207%2C55.699252&spn=0.022016%2C0.006677&z=16&l=map" wid   |
|testautotest |<lj-cut>123</lj-cut>                                                                                                                                                                                                                                                                                                                                 |123                                                                                                    |
|testautotest |<lj-poll name="New" whovote="all" whoview="all"><br /><lj-pq type="radio">Who?<br /><lj-pi>I</lj-pi><br /><lj-pi>You</lj-pi><br /></lj-pq><br /></lj-poll>                                                                                                                                                                                           |Who?I                                                                                                  |
|testautotest |<lj user='test'/>                                                                                                                                                                                                                                                                                                                                    |test                                                                                                   |