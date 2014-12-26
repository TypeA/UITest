Scenario: Search for user

Meta: 
@categories navigation useful

Given user from region <region> on Main Page
When user search text <text> using search in header
Then user on search page with text <text> in URL