Scenario: Fail with creating new usual category

Meta:
@categories medius admin usual unsuccessful_adding category

Given logged editor <user> on Admin Medius Categories Page
When editor add new incorrect category with <incorrect_symbol_in_keyword> on Categories Page
Then editor sees message about error
Then new incorrect category is not in List of categories on Categories Page

Examples:

|user           |incorrect_symbol_in_keyword    |
|testautotest   |"                              |
|testautotest   |'                              |
|testautotest   |%                              |
|testautotest   |Я                              |
|testautotest   |ю                              |
|testautotest   |L                              |
