Links on the account creation page

Scenario: TOS link

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user click TOS Link
Then user in correct page <page> with URL <URL>

Examples:
|page       |URL                            |
|TOS Page   |/tos-russian-translation.bml   |



Scenario: Privacy link

Meta: 
@categories registration comfortable

Given unlogged user on Registration Form
When user click Privacy Link
Then user in correct page <page> with URL <URL>

Examples:
|page           |URL                                |
|Privacy Page   |/privacy-russian-translation.bml   |
