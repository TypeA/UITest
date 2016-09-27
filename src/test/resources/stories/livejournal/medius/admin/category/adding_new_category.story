Scenario: Create new category

Meta:
@categories medius admin adding category

Given logged editor <user> on Admin Medius Categories Page
When editor adds new category with <symbol_in_keyword> and <sticker> and <figures> on Categories Page
Then new category is in List of categories on Categories Page

Examples:

|user               |symbol_in_keyword  |sticker    |figures    |
|testautotest       |                   |false      |4          |
|testautotest       |_                  |false      |5          |
|testautotest       |6                  |false      |6          |

|testautotest       |                   |true       |4          |
|testautotest       |_                  |true       |3          |
|testautotest       |6                  |true       |2          |


Scenario: Fail with adding category

Meta:
@categories medius admin failed_adding category

Given logged editor <user> on Admin Medius Categories Page
When editor adds new category with <symbol_in_keyword> and <sticker> and <figures> on Categories Page
Then editor sees message about error
Then category is not in List of categories on Categories Page

Examples:

|user               |symbol_in_keyword  |sticker    |figures    |
|testautotest       |L                  |false      |4          |
|--testautotest       |!                  |false      |5          |
|--testautotest       |ж                  |false      |4          |
|--testautotest       |Й                  |false      |6          |
|--testautotest       |'                  |false      |3          |
|--testautotest       |F                  |true       |2          |
|--testautotest       |?                  |true       |4          |
|--testautotest       |й                  |true       |3          |
|--testautotest       |Ы                  |true       |4          |
|--testautotest       |'                  |true       |3          |
|--testautotest       |"                  |true       |2          |
|testautotest       |                   |true       |6          |

Scenario: Delete category

Meta:
@categories medius admin removing category

Given logged editor <user> on Admin Medius Categories Page
When editor delete any category
Then category is not in List of categories on Categories Page

Examples:

|user           |
|testautotest   |

Scenario: Edit name and genitive of category

Meta:
@categories medius admin edit category

Given logged editor <user> on Admin Medius Categories Page
When editor change name and genitive of any category
Then category's name and genitive changed

Examples:

|user           |
|testautotest   |
|testautotest   |

Scenario: Change position of category in top

Meta:
@categories medius admin changing_position category

Given logged editor <user> on Admin Medius Categories Page
When editor change <position> of any category
Then category changed its position

Examples:

|user           |position   |
|testautotest   |up         |
|testautotest   |down       |