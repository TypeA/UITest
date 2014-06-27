Narrative:
As a user
I want to authorize

Scenario: Authorization
Meta: 
@tags execution:Automated
When I on page <page> submit authorization form with correct login test and password test
Then I should be authorized

Examples:
|page|
|com.livejournal.uitests.pages.service_pages.login_page.LoginPage|