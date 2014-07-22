Scenario: GetURL debag

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user click TOS Link
Then user in TOS Page
When user click Privacy Link
Then user in Privacy Page
