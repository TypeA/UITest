Scenario: Leave comment

Meta: 
@tags execution:manual,component:Commenting

Given logged user
When user on post page <page> clicks on Post a new comment
And when user submits Comment field
And when user clicks Add a comment
Then user should see his comment have been posted


Scenario: Reply to comment

Meta: 
@tags execution:manual,component:Commenting

Given logged user
When user on post page <page> clicks on Reply
And when user submits Comment field
And when user clicks Add a comment
Then user should see his comment have been replyed to original comment

