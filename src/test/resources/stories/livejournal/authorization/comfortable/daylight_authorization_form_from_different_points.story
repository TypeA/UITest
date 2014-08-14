Scenario: From Main Page by Login Button

Meta: 
@categories authorization comfortable

Given unlogged user on Main Page
When user clicks on the Login Button in the Header
Then user see Autorization Form




Scenario: From Main Page by Tokens

Meta: 
@categories authorization comfortable

Given unlogged user on Main Page
When user clicks on the Tokens in the Header
Then user in correct page <page> with URL <URL>

Examples:
|page|URL|
|Authorization Page|/login.bml|




Scenario: From Shop by Tokens

Meta: 
@categories authorization comfortable

Given unlogged user in Shop
When user clicks on the Tokens Link
Then user in correct page <page> with URL <URL>

Examples:
|page|URL|
|Authorization Page|/login.bml|




Scenario: From Shop by Rename Account

Meta: 
@categories authorization comfortable

Given unlogged user in Shop
When user clicks on the Rename Account Link
Then user in correct page <page> with URL <URL>

Examples:
|page|URL|
|Authorization Page|/login.bml|
