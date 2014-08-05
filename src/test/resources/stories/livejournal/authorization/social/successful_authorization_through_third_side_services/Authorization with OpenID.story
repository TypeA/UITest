Scenario: Authorization with OpenID 

Meta: 
@tags execution:auto,component:Authorization,attributes:Social

Given unlogged user on Autorization Form
When user autorizated through OpenID with correct data: OpenID_URL <OpenID_URL> 
Then user should be in LJ through OpenID

Examples:
|OpenID_URL|