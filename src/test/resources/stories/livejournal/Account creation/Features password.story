###########################
Scenario: Displays password

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter password <password>
Then the password is hidden
When user clicks Mapping Button
Then the password is displayed



###########################
Scenario: Password description

Meta: 
@tags execution:auto,component:Registration,attributes:Useful

Given unlogged user on Registration Form
When user enter password <password>