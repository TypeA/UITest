Scenario: Successfully autorization

Meta: 
@categories registration_and_authorization useful release

Given unlogged user on Login Form
When user enter correct data: name <name> and clicks LogIn
Then user logged in


Examples:
|name           |
|testautotest   |

