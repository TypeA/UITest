School settings

Scenario: School privacy

Meta:
@categories profile useful test

Given logged user <user> on Profile page with school setting <setting>
Then user <user1> can see <user> school
Then user <user2> can't see <user> school


Examples:
|user         |user1         |user2       |setting    |
|testautotest |logged        |nobody      |Yeverybody |
|--testautotest |unlogged      |nobody      |Yeverybody |
|--testautotest |friend        |not_friend  |Friends    |
|--testautotest |nobody        |logged      |Nobody     |
|--testautotest |nobody        |unlogged    |Nobody     |


Scenario: Check incorrect school years

Meta:
@categories profile useful

Given logged user <user> on Schools Directory page
When user <user> set start year <year_start> and end year <year_end>
Then user see alert <alert>

Examples:
|user          |year_start |year_end       |setting    |alert      |
|testautotest  |less_min   |rnd_year       |Yeverybody |alert_1    |
|testautotest  |min        |less_min       |Yeverybody |alert_2    |
|testautotest  |rnd_year   |min            |Yeverybody |alert_2    |
|testautotest  |min        |current_more   |Yeverybody |alert_3    |



