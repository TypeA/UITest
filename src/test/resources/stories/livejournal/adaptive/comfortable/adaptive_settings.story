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
@categories adaptive comfortable 

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |false              |false                  |Chameleon      |Adaptive               |
|unlogged           |false              |true                   |Chameleon      |Adaptive               |
|unlogged           |true               |false                  |Chameleon      |Adaptive               |
|autotest_plus_1    |false              |false                  |Chameleon      |Adaptive               |
|autotest_plus_1    |false              |true                   |Chameleon      |Adaptive               |
|autotest_plus_1    |true               |false                  |Chameleon      |Adaptive               |


Scenario: User see Non adaptive theme

Meta: 
@categories adaptive comfortable 

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |true               |true                   |nonAdaptive    |nonAdaptive            |
|autotest_plus_1    |true               |true                   |nonAdaptive    |nonAdaptive            |


Scenario: User see Non adaptive Chameleon theme

Meta: 
@categories adaptive comfortable

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |true               |true                   |Chameleon      |Chameleon              |
|autotest_plus_1    |true               |true                   |Chameleon      |Chameleon              |




Scenario: User see correct theme in his journal

Meta: 
@categories adaptive comfortable

Given random user (paid <paid>,mobile view <mobileView>,style <style>)
When user go to the his journal page
Then user see correct style <correctStyle>

Examples:
|paid               |mobileView             |style          |correctStyle           |
|false              |false                  |Air            |Air                    |
|false              |false                  |nonAdaptive    |Air                    |
|false              |false                  |Chameleon      |Adaptive               |
|false              |true                   |Air            |Air                    |
|false              |true                   |nonAdaptive    |nonAdaptive            |
|false              |true                   |Chameleon      |Chameleon              |
|true               |false                  |Air            |Air                    |
|true               |false                  |nonAdaptive    |Air                    |
|true               |false                  |Chameleon      |Adaptive               |
|true               |true                   |Air            |Air                    |
|true               |true                   |nonAdaptive    |nonAdaptive            |
|true               |true                   |Chameleon      |Chameleon              |