Scenario: User see Air theme

Meta: 
@categories adaptive comfortable 

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |false              |false                  |Air            |Air                    |
|unlogged           |false              |false                  |nonAdaptive    |Air                    |
|unlogged           |false              |true                   |Air            |Air                    |
|unlogged           |false              |true                   |nonAdaptive    |Air                    |
|unlogged           |true               |false                  |Air            |Air                    |
|unlogged           |true               |false                  |nonAdaptive    |Air                    |
|unlogged           |true               |true                   |Air            |Air                    |
|autotest_plus_1    |false              |false                  |Air            |Air                    |
|autotest_plus_1    |false              |false                  |nonAdaptive    |Air                    |
|autotest_plus_1    |false              |true                   |Air            |Air                    |
|autotest_plus_1    |false              |true                   |nonAdaptive    |Air                    |
|autotest_plus_1    |true               |false                  |Air            |Air                    |
|autotest_plus_1    |true               |false                  |nonAdaptive    |Air                    |
|autotest_plus_1    |true               |true                   |Air            |Air                    |


Scenario: User see Adaptive Chameleon theme

Meta: 
@categories adaptive1 comfortable 

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |false              |false                  |Chameleon      |Adaptive               |
|unlogged           |true               |false                  |Chameleon      |Adaptive               |
|autotest_plus_1    |false              |false                  |Chameleon      |Adaptive               |
|autotest_plus_1    |true               |false                  |Chameleon      |Adaptive               |