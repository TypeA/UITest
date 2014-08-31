Scenario: New Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user add new Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name|password|title|correct_title|
|test|test|new_title|NEW_TITLE|
|test|test||ЛЕНТА|


Scenario: Change Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change Title <title> in Settings and save it
Then the Title is changed on correct title <correct_title>

Examples:
|name|password|title|correct_title|
|test|test|Test|TEST|



Scenario: Set new background color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|BACKGROUND_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|BACKGROUND_COLOR|BY_CODE|dae3c8|0|0|0|



Scenario: Set new foreground color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|FOREGROUND_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|FOREGROUND_COLOR|BY_CODE|dae3c8|0|0|0|



Scenario: Set new sidebar background color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test765765|Mary1992|SIDEBAR_BACKGROUND|BY_POINT|d6c5e0|60|30|30|
|test765765|Mary1992|SIDEBAR_BACKGROUND|BY_CODE|dae3c8|0|0|0|



Scenario: Set new elements background color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|ELEMENTS_BACKGROUND|BY_POINT|d6c5e0|60|30|30|
|test|test|ELEMENTS_BACKGROUND|BY_CODE|dae3c8|0|0|0|



Scenario: Set new elements color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|ELEMENTS_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|ELEMENTS_COLOR|BY_CODE|dae3c8|0|0|0|



Scenario: Set new main text color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|MAIN_TEXT_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|MAIN_TEXT_COLOR|BY_CODE|dae3c8|0|0|0|



Scenario: Set new sidebar text color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|SIDEBAR_TEXT_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|SIDEBAR_TEXT_COLOR|BY_CODE|dae3c8|0|0|0|



Scenario: Set new link color
Meta: 
@categories feed personal test

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> by type <type> (parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>) and save it
Then color <color> is changed by parametrs: code <code>, barY <barY>, colorX <colorX>, colorY <colorY>

Examples:
|name|password|color|type|code|barY|colorX|colorY|
|test|test|LINK_COLOR|BY_POINT|d6c5e0|60|30|30|
|test|test|LINK_COLOR|BY_CODE|dae3c8|0|0|0|




Scenario: Return the current color
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change color <color> (old code <code>) and return current color
Then the color changed to the current code <code>

Examples:
|name|password|color|code|
|test|test|SIDEBAR_BACKGROUND|dae3c8|




Scenario: Background image 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user load Background image <image> and set repeat <repeat> in Settings and save it
Then  Background image is loaded and displayed

Examples:
|name|password|image|repeat|
|test|test|картинка|Horizontal and Vertical|
|test|test|картинка|Horizontal|
|test|test|картинка|Vertical|




Scenario: Text settings 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change text size <size> and font <font> in Settings and save it
Then Text settings is changed

Examples:
|name|password|size|font|
|test|test|TextSize|Verdana|




Scenario: Paging type 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user set Paging type <type>  in Settings and save it
Then Paging type is changed

Examples:
|name|password|type
|test|test|постоянная|
|test|test|постраничная(1 страница)|
|test|test|постраничная(-3 страницы)|


Scenario: Restore default settings 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user click Restore default settings Button in Settings and save it
Then default settings is set

Examples:
|name|password|
|test|test|
