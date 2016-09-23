Zip code

Scenario: Usa ZIP code

Meta:
@categories profile comfortable

Given logged user <user> on Profile page
When user change country to United States
Then zip code form is enabled

Example:
|user          |
|testautotest  |
|testautotest  |
|testautotest  |
|testautotest  |
