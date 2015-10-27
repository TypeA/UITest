Scenario: Add category
Meta: 
@categories lj_magazine admin_magazine  admin_categories_magazine useful 

Given logged user on Main Page and go to Admin Magazine Categories
When create new <usual_category> category
Then categories exist in <usual_category> widget

Examples:
|usual_category     |
|true               |
|false              |  


        
Scenario: edit categories
Meta:
@categories lj_magazine admin_magazine  admin_categories_magazine useful gdfgsfgdfgsdgh

Given logged user on Main Page and go to Admin Magazine Categories
When edit <usual_category> category and set option special category <special_category> and new name <new_name>
Then <special_category> category is changed

Examples:
|usual_category   |special_category     |new_name   |
|true             |false                |true       |
|false            |true                 |false      |
|true             |true                 |true       |

Scenario: delete categories
Meta:
@categories lj_magazine admin_magazine  admin_categories_magazine useful

Given logged user on Main Page and go to Admin Magazine Categories
When delete <usual_category> category
Then <usual_category> category is deleted

Examples:
|usual_category   |
|true             |
|false            |