Scenario: TOS and Privacy links

Meta: 
@tags execution:auto,component:Registration,attributes:Comfortable

Given unlogged user on Registration Form
When user click TOS Link
Then user in TOS Page
When user click Privacy Link
Then user in Privacy Page
