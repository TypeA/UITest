Scenario: Create new category

Meta:
@categories medius admin category adding gg

Given logged editor <user> on Admin Medius Categories Page
When editor adds new category with <keyword_with> and <sticker> and <limit_10> on Categories Page
Then category is in List of categories on Categories Page

Examples:

|user               |keyword_with  |sticker   |limit_10   |
|testautotest       |text          |true      |=10        |
|testautotest       |_             |false     |>10        |
|testautotest       |number        |true      |<10        |

Scenario: Fail with adding category

Meta:
@categories medius admin category failed_adding gg

Given logged editor <user> on Admin Medius Categories Page
When editor adds new category with <keyword_with> and <sticker> and <limit_10> on Categories Page
Then editor sees message about error and category is not in List of categories on Categories Page

Examples:

|user               |keyword_with  |sticker   |limit_10   |
|testautotest       |upper_text    |true      |>10        |
|testautotest       |punctuation   |false     |<10        |
|testautotest       |russian_text  |false     |=10        |

Scenario: Delete category

Meta:
@categories medius admin category removing

Given logged editor <user> on Admin Medius Categories Page
When editor delete any category with <symbol_in_keyword>
Then category is not in List of categories on Categories Page

Examples:

|user           |symbol_in_keyword  |
|testautotest   |we                 |

Scenario: Edit name and genitive of category

Meta:
@categories medius admin category edit

Given logged editor <user> on Admin Medius Categories Page
When editor change name and genitive of any category with <symbol_in_keyword>
Then category is in List of categories on Categories Page

Examples:

|user           |symbol_in_keyword  |
|testautotest   |6                  |

Scenario: Change position of category in top

Meta:
@categories medius admin category changing_position

Given logged editor <user> on Admin Medius Categories Page
When editor change <position> of any category
Then category changed its position

Examples:

|user           |position   |
|testautotest   |up         |
|testautotest   |down       |