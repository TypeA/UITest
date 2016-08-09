Scenario: Scenario: Create new usual category

Meta:
@categories medius admin usual category datest

Given logged editor $user on Admin Medius Categories Page
When editor adds new category with $symbol_in_keyword and $sticker on Categories Page
Then new category is in List of categories on Categories Page

Examples:

|user               |symbol_in_keyword  |sticker    |
|testautotest       |                   |false      |
|testautotest       |_                  |false      |
|testautotest       |6                  |false      |


Scenario: Add new sticker category

Meta:
@categories medius admin sticker category

Given logged editor $user on Admin Medius Categories Page
When editor adds new category with $symbol_in_keyword and $sticker on Categories Page
Then new category is in List of categories on Categories Page

Examples:

|user               |symbol_in_keyword  |sticker    |
|testautotest       |                   |true       |
|testautotest       |_                  |true       |
|testautotest       |6                  |true       |


Scenario: Fail with adding category

Meta:
@categories medius admin failed_adding category

Given logged editor $user on Admin Medius Categories Page
When editor adds new category with $symbol_in_keyword and $sticker on Categories Page
Then editor sees message about error
Then new category is not in List of categories on Categories Page

Examples:

|user               |symbol_in_keyword  |sticker    |
|testautotest       |L                  |false      |
|testautotest       |!                  |false      |
|testautotest       |ж                  |false      |
|testautotest       |Й                  |false      |
|testautotest       |'                  |false      |
|testautotest       |"                  |false      |


