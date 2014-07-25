Scenario: From the Main Page by Login Button

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Main Page
When user clicks on the Login Button in the Header
Then user see Autorization Form




Scenario: From the Main Page by Tokens

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user on Main Page
When user clicks on the Tokens in the Header
Then user in Autorization Page





Scenario: From the Magazine by Tokens

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user in Magazine
When user clicks on the Tokens Link
Then user in Autorization Page




Scenario: From the Magazine by Rename Account

Meta: 
@tags execution:auto,component:Autorization,attributes:Useful

Given unlogged user in Magazine
When user clicks on the Rename Account Link
Then user in Autorization Page
