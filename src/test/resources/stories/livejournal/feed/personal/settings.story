Scenario: New Title
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user add new Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name           |title      |correct_title    |
|testautotest   |new_title  |NEW_TITLE        |
|testautotest   |           |ENTRIES FEED FOR |


Scenario: Change Title
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name           |password   |title  |correct_title  |
|testautotest   |test       |Test   |TEST           |


Scenario: Cancel changing Title
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change Title <title> in Settings and cancel it
Then the Title is not changed

Examples:
|name           |title |
|testautotest   |RND   |



Scenario: Set new color
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then the color <color> corresponds to correct code <code>

Examples:
|name           |color              |type           |code   |barY   |colorX |colorY |
|testautotest   |BACKGROUND_COLOR   |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |BACKGROUND_COLOR   |BY_CODE        |dae3c8 |0      |0      |0      |
|testautotest   |FOREGROUND_COLOR   |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |FOREGROUND_COLOR   |BY_CODE        |232282 |0      |0      |0      |
|testautotest   |SIDEBAR_BACKGROUND |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |SIDEBAR_BACKGROUND |BY_CODE        |f5e907 |0      |0      |0      |
|testautotest   |ELEMENTS_BACKGROUND|BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |ELEMENTS_BACKGROUND|BY_CODE        |1b4245 |0      |0      |0      |
|testautotest   |ELEMENTS_COLOR     |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |ELEMENTS_COLOR     |BY_CODE        |f797ac |0      |0      |0      |
|testautotest   |BORDERS_COLOR      |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |BORDERS_COLOR      |BY_CODE        |8f0096 |0      |0      |0      |
|testautotest   |MAIN_TEXT_COLOR    |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |MAIN_TEXT_COLOR    |BY_CODE        |8f0096 |0      |0      |0      |
|testautotest   |SIDEBAR_TEXT_COLOR |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |SIDEBAR_TEXT_COLOR |BY_CODE        |030100 |0      |0      |0      |
|testautotest   |LINK_COLOR         |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |LINK_COLOR         |BY_CODE        |7fb816 |0      |0      |0      | 
|testautotest   |ON_HOVER_COLOR     |BY_POINT       |d6c5e0 |60     |30     |30     |
|testautotest   |ON_HOVER_COLOR     |BY_CODE        |66b5ed |0      |0      |0      | 



Scenario: Cansel new color
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change color <color> (old code <code>) and cansel it
Then the color <color> corresponds to correct code <code>

Examples:
|name           |color              |code   |
|testautotest   |BACKGROUND_COLOR   |030100 |
|testautotest   |FOREGROUND_COLOR   |d6c5e0 |
|testautotest   |SIDEBAR_BACKGROUND |e76dfe |
|testautotest   |ELEMENTS_BACKGROUND|f797ac |
|testautotest   |ELEMENTS_COLOR     |f5e907 |
|testautotest   |BORDERS_COLOR      |8f0096 |
|testautotest   |MAIN_TEXT_COLOR    |232282 |
|testautotest   |SIDEBAR_TEXT_COLOR |66b5ed |
|testautotest   |LINK_COLOR         |8f0096 |
|testautotest   |ON_HOVER_COLOR     |1b4245 |


Scenario: Return the current color
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change color <color> (old code <code>) and return current color
Then the color changed to the current code <code>

Examples:
|name           |color              |code   |
|testautotest   |BACKGROUND_COLOR   |030100 |
|testautotest   |FOREGROUND_COLOR   |d6c5e0 |
|testautotest   |SIDEBAR_BACKGROUND |e76dfe |
|testautotest   |ELEMENTS_BACKGROUND|030100 |
|testautotest   |ELEMENTS_COLOR     |f5e907 |
|testautotest   |MAIN_TEXT_COLOR    |232282 |
|testautotest   |SIDEBAR_TEXT_COLOR |66b5ed |
|testautotest   |LINK_COLOR         |8f0096 |
|testautotest   |ON_HOVER_COLOR     |1b4245 |





Scenario: Add background image 
Meta: 
@categories feed personal


Given logged user (name <name>) on Friends Feed
When user load Background image <image> and set repeat <repeat> in Settings and save it
Then  Background image is loaded and displayed

Examples:
|name   |image              |repeat                 |
|test   |РєР°СЂС‚РёРЅРєР°   |Horizontal and Vertical|
|test   |РєР°СЂС‚РёРЅРєР°   |Horizontal             |
|test   |РєР°СЂС‚РёРЅРєР°   |Vertical               |




Scenario: Delete background image 
Meta: 
@categories feed personal


Given logged user (name <name>) with Background image on Friends Feed
When user delete Background image and save it
Then  Background image is deleted

Examples:
|name   |
|test   |





Scenario: Set text settings 
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change text size <size> and font <font> in Settings and save it
Then text settings is changed by size <size> and font <font>

Examples:
|name           |size |font                 |
|testautotest   |10   |ProximaNovaRegular   |
|testautotest   |16   |Verdana              |
|testautotest   |30   |Arial                |
|testautotest   |36   |Helvetica            |



Scenario: Cancel text settings 
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user change text size <new_size> and font <new_font> in Settings and cancel it (old size <size>, old font <font>)
Then text settings is changed by size <size> and font <font>

Examples:
|name           |size |font                 |new_size   |new_font           |
|testautotest   |10   |ProximaNovaRegular   |16         |Arial              |    
|testautotest   |16   |Verdana              |10         |ProximaNovaRegular |
|testautotest   |30   |Arial                |36         |Helvetica          |
|testautotest   |36   |Helvetica            |30         |Verdana            |



Scenario: Set paging type 
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user set Paging type <type> (number <number>)  in Settings and save it
Then Paging type is changed by type <type> (number <number>)

Examples:
|name           |type     |number |
|testautotest   |PAGES    |1      |
|testautotest   |PAGES    |-3     |
|testautotest   |PAGES    |100    |
|testautotest   |PAGES    |0      |
|testautotest   |ENDLESS  |0      |




Scenario: Cancel paging type 
Meta: 
@categories feed personal

Given logged user (name <name>) on Friends Feed
When user set Paging type <new_type> (old type <type>, number <number>) in Settings and cancel it
Then Paging type is changed by type <type> (number <number>)

Examples:
|name           |new_type |type     |number |
|testautotest   |PAGES    |ENDLESS  |10     |
|testautotest   |ENDLESS  |PAGES    |10     |




Scenario: Restore default settings 
Meta: 
@categories feed personal
@issue LJSUP-19537

Given logged user (name <name>) with own settings on Friends Feed
When user click Restore default settings Button and save it
Then default settings are set

Examples:
|name           |
|testautotest   |



Scenario: Save settings after user logged out
Meta: 
@categories feed personal

Given logged user (name <name>) with own settings on Friends Feed
When user logged out and logged in again (name <name>)
Then user's settings are applied

Examples:
|name           |
|testautotest   |