Scenario: Create new sticker category

Meta:
@categories medius admin sticker category

Given logged editor <user> on Admin Medius Categories Page
When editor adds new sticker category with <symbol_in_keyword> on Categories Page
Then new sticker category is in List of categories on Categories Page

Examples:

|user           |symbol_in_keyword|
|testautotest   |                 |
|testautotest   |_                |
|testautotest   |6                |