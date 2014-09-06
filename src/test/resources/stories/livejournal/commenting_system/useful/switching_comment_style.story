Scenario: Set comment style

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>)
When user set commenting system style <style>
Then the commenting system in style <style>

Examples:
|name|password|style|
|test|test|s1|
|test|test|s2|