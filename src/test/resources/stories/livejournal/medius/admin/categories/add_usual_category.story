Scenario: Create new usual category

Meta:
@categories medius admin usual category

Given logged editor <user> on Admin Medius Categories Page
When editor add new category with <symbol_in_keyword> on Categories Page
Then new category is in List of categories on Categories Page

Examples:

|user           |symbol_in_keyword|
|testautotest   |                 |
|testautotest   |_                |
|testautotest   |6                |