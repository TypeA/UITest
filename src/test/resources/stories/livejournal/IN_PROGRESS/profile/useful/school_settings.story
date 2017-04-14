School settings

Scenario: School privacy

Meta:
@categories profile useful release

Given logged user <user> on Profile page 
When user <user> set school setting <setting>
Then user <user1> can see <user> school


Examples:
|user         |user1          |setting    |
|testautotest |logged         |Yeverybody |
|testautotest |unlogged       |Yeverybody |
|testautotest |friend         |Friends    |
|testautotest |nobody         |Nobody     |


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



