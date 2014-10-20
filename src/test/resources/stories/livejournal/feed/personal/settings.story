Scenario: New Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user add new Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name   |password   |title      |correct_title   |
|test   |test       |new_title  |NEW_TITLE       |
|test   |test       |           |ЛЕНТА           |


Scenario: Change Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name   |password   |title  |correct_title  |
|test   |test       |Test   |TEST           |


Scenario: Cancel changing Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change Title <title> in Settings and cancel it
Then the Title is not changed

Examples:
|name   |password   |title |
|test   |test       |RND   |



Scenario: Set new color
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then the color <color> corresponds to correct code <code>

Examples:
|name   |password   |color              |type           |code   |barY   |colorX |colorY |
|test   |test       |BACKGROUND_COLOR   |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |BACKGROUND_COLOR   |BY_CODE        |dae3c8 |0      |0      |0      |
|test   |test       |FOREGROUND_COLOR   |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |FOREGROUND_COLOR   |BY_CODE        |232282 |0      |0      |0      |
|test   |test       |SIDEBAR_BACKGROUND |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |SIDEBAR_BACKGROUND |BY_CODE        |f5e907 |0      |0      |0      |
|test   |test       |ELEMENTS_BACKGROUND|BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |ELEMENTS_BACKGROUND|BY_CODE        |1b4245 |0      |0      |0      |
|test   |test       |ELEMENTS_COLOR     |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |ELEMENTS_COLOR     |BY_CODE        |f797ac |0      |0      |0      |
|test   |test       |MAIN_TEXT_COLOR    |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |MAIN_TEXT_COLOR    |BY_CODE        |8f0096 |0      |0      |0      |
|test   |test       |SIDEBAR_TEXT_COLOR |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |SIDEBAR_TEXT_COLOR |BY_CODE        |030100 |0      |0      |0      |
|test   |test       |LINK_COLOR         |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |LINK_COLOR         |BY_CODE        |7fb816 |0      |0      |0      | 
|test   |test       |ON_HOVER_COLOR     |BY_POINT       |d6c5e0 |60     |30     |30     |
|test   |test       |ON_HOVER_COLOR     |BY_CODE        |66b5ed |0      |0      |0      |





Scenario: Cansel new color
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> (old code <code>) and cansel it
Then the color <color> corresponds to correct code <code>

Examples:
|name   |password   |color              |code   |
|test   |test       |BACKGROUND_COLOR   |030100 |
|test   |test       |FOREGROUND_COLOR   |d6c5e0 |
|test   |test       |SIDEBAR_BACKGROUND |e76dfe |
|test   |test       |ELEMENTS_BACKGROUND|f797ac |
|test   |test       |ELEMENTS_COLOR     |f5e907 |
|test   |test       |MAIN_TEXT_COLOR    |232282 |
|test   |test       |SIDEBAR_TEXT_COLOR |66b5ed |
|test   |test       |LINK_COLOR         |8f0096 |
|test   |test       |ON_HOVER_COLOR     |1b4245 |




Scenario: Return the current color
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> (old code <code>) and return current color
Then the color changed to the current code <code>

Examples:
|name   |password   |color              |code   |
|test   |test       |BACKGROUND_COLOR   |030100 |
|test   |test       |FOREGROUND_COLOR   |d6c5e0 |
|test   |test       |SIDEBAR_BACKGROUND |e76dfe |
|test   |test       |ELEMENTS_BACKGROUND|030100 |
|test   |test       |ELEMENTS_COLOR     |f5e907 |
|test   |test       |MAIN_TEXT_COLOR    |232282 |
|test   |test       |SIDEBAR_TEXT_COLOR |66b5ed |
|test   |test       |LINK_COLOR         |8f0096 |
|test   |test       |ON_HOVER_COLOR     |1b4245 |





Scenario: Add background image 
Meta: 
@categories feed personal


Given logged user (name <name>, password <password>) on Friends Feed 1
When user load Background image <image> and set repeat <repeat> in Settings and save it
Then  Background image is loaded and displayed

Examples:
|name   |password   |image      |repeat                 |
|test   |test       |РєР°СЂС‚РёРЅРєР°   |Horizontal and Vertical|
|test   |test       |РєР°СЂС‚РёРЅРєР°   |Horizontal             |
|test   |test       |РєР°СЂС‚РёРЅРєР°   |Vertical               |




Scenario: Delete background image 
Meta: 
@categories feed personal


Given logged user (name <name>, password <password>) with Background image on Friends Feed
When user delete Background image and save it
Then  Background image is deleted

Examples:
|name   |password   |
|test   |test       |





Scenario: Set text settings 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change text size <size> and font <font> in Settings and save it
Then text settings is changed by size <size> and font <font>

Examples:
|name   |password   |size |font                 |
|test   |test       |10   |ProximaNovaRegular   |
|test   |test       |16   |Verdana              |
|test   |test       |30   |Arial                |
|test   |test       |36   |Helvetica            |



Scenario: Cancel text settings 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change text size <new_size> and font <new_font> in Settings and cancel it (old size <size>, old font <font>)
Then text settings is changed by size <size> and font <font>

Examples:
|name   |password   |size |font                 |new_size   |new_font           |
|test   |test       |10   |ProximaNovaRegular   |16         |Arial              |    
|test   |test       |16   |Verdana              |10         |ProximaNovaRegular |
|test   |test       |30   |Arial                |36         |Helvetica          |
|test   |test       |36   |Helvetica            |30         |Verdana            |



Scenario: Set paging type 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user set Paging type <type> (number <number>)  in Settings and save it
Then Paging type is changed by type <type> (number <number>)

Examples:
|name   |password  |type     |number |
|test   |test      |PAGES    |1      |
|test   |test      |PAGES    |-3     |
|test   |test      |PAGES    |100    |
|test   |test      |PAGES    |0      |
|test   |test      |ENDLESS  |0      |




Scenario: Cancel paging type 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user set Paging type <new_type> (old type <type>, number <number>) in Settings and cancel it
Then Paging type is changed by type <type> (number <number>)

Examples:
|name   |password   |new_type |type     |number |
|test   |test       |PAGES    |ENDLESS  |10     |
|test   |test       |ENDLESS  |PAGES    |10     |




Scenario: Restore default settings 
Meta: 
@categories feed personal
@issue LJSUP-19537

Given logged user (name <name>, password <password>) with own settings on Friends Feed
When user click Restore default settings Button and save it
Then default settings are set

Examples:
|name   |password   |
|test   |test       |

