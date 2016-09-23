Virtual gifts story


Scenario: Virtual gifts

Meta:
@categories profile comfortable

Given logged user <user> on Profile page that is paid <paid>
When user change receipt <receipt> of virtual gifts
Then user see <receipt> on his Profile page
Then checkbox <checker> works correctly

Example:
|user          |checker          |receipt     |paid         |
|testautotest  |disabled         |enable_all  |false        |
|testautotest  |disabled         |friends     |false        |
|testautotest  |disabled         |anonymous   |false        |
|testautotest  |disabled         |disable_all |false        |
|test          |enabled          |enable_all  |true         |
|test          |enabled          |friends     |true         |
|test          |enabled          |anonymous   |true         |
|test          |enabled          |disable_all |true         |


