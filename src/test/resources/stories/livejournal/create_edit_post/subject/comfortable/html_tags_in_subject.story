Scenario: Subject with correct html tags
Meta: 
@categories create_edit_post subject comfortable

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has correct subject <subject>

Examples:
|name         |subject        |
|testautotest |<b>Тема</b> |
|testautotest |<i>Тема</i> |
|testautotest |<u>Тема</u> |
|testautotest |<s>Тема</s> |
|testautotest |<span style="font-size: 0.7em">Тема</span> |
|testautotest |<span style="color: #ad5e5e;">Тема</span> |
|testautotest |<a href="http://www.yandex.ru/">ссылка</a>|
|testautotest |<lj-like />|
|testautotest |<lj user="maxa" />|
|testautotest |<img src="http://ic.pics.livejournal.com/maxapryg/71384044/504856/504856_900.jpg" alt="shop.jpg" title="shop.jpg">|
|testautotest |<iframe data-link="http://vc.videos.livejournal.com/index/player?player=new&record_id=231160&ad_template_id=4584" data-thumbnail="http://st1.eaglecdn.com/lj/20150320/550c2759a976f_1_360.jpg" frameBorder="0" height="315" src="http://vc.videos.livejournal.com/index/player?player=new&record_id=231160&ad_template_id=4584" width="560"></iframe>|
|testautotest |<lj-cut></lj-cut>|
|testautotest |<lj-spoiler></lj-spoiler>|
|testautotest |<lj-map url="http://maps.yandex.ru/?ll=37.625207%2C55.699252&spn=0.022016%2C0.006677&z=16&l=map" width="425" height="350" />|
|testautotest |<br /><lj-pi>123</lj-pi><br /></lj-pq><br /></lj-poll>|



Scenario: Subject with incorrect html tags
Meta: 
@categories create_edit_post subject1 comfortable

Given logged user <name> on Create Post page
When user create new post with subject <subject>
Then the post in journal has correct subject <subject>

Examples:
|name         |subject        |
