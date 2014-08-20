Scenario: Title
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change Title in Settings and save it
Then Title is changed

Examples:
|name|password|
|test|test|


Scenario: Background color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Background color in Settings and save it
Then  Background color is changed

Examples:
|name|password|
|test|test|


Scenario: Background image 
Meta: 
@categories feed personal test1

Given logged user (name <name>, password <password>) on Friends Feed
When user load Background image <image> and set repeat <repeat> in Settings and save it
Then  Background image is loaded and displayed

Examples:
|name|password|image|repeat|
|test|test|картинка|Horizontal and Vertical|
|test|test|картинка|Horizontal|
|test|test|картинка|Vertical|


Scenario: Foreground color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Foreground color in Settings and save it
Then  Foreground color is changed

Examples:
|name|password|
|test|test|


Scenario: Sidebar dackground 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Sidebar dackground in Settings and save it
Then Sidebar dackground is changed

Examples:
|name|password|
|test|test|


Scenario: Elements dackground 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Elements dackground in Settings and save it
Then Elements dackground is changed

Examples:
|name|password|
|test|test|



Scenario: Border color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Border color in Settings and save it
Then Border color is changed

Examples:
|name|password|
|test|test|



Scenario: Text settings 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change text size <size> and font <font> in Settings and save it
Then Text settings is changed

Examples:
|name|password|size|font|
|test|test|TextSize|Verdana|


Scenario: Main text color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Main text color in Settings and save it
Then Main text color is changed

Examples:
|name|password|
|test|test|



Scenario: Sidebar text color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Sidebar text color in Settings and save it
Then Sidebar text color is changed

Examples:
|name|password|
|test|test|



Scenario: Link color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Link color in Settings and save it
Then Link color is changed

Examples:
|name|password|
|test|test|


Scenario: On hover color 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  On hover color in Settings and save it
Then On hover color is changed

Examples:
|name|password|
|test|test|



Scenario: Visited link 
Meta: 
@categories feed personal

Given logged user (name <name>, password <password>) on Friends Feed
When user change  Visited link in Settings and save it
Then Visited link is changed

Examples:
|name|password|
|test|test|



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
