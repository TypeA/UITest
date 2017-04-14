Scenario: User see Air theme

Meta: 
@categories adaptive adaptive_and_navigation 

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
|test002            |false              |false                  |Air            |Air                    |
|test002            |false              |false                  |nonAdaptive    |Air                    |
|test002            |false              |true                   |Air            |Air                    |
|test002            |false              |true                   |nonAdaptive    |Air                    |
|test002            |true               |false                  |Air            |Air                    |
|test002            |true               |false                  |nonAdaptive    |Air                    |
|test002            |true               |true                   |Air            |Air                    |


Scenario: User see Adaptive Chameleon theme

Meta: 
@categories adaptive adaptive_and_navigation

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |false              |false                  |Chameleon      |Adaptive               |
|unlogged           |false              |true                   |Chameleon      |Adaptive               |
|unlogged           |true               |false                  |Chameleon      |Adaptive               |
|test002            |false              |false                  |Chameleon      |Adaptive               |
|test002            |false              |true                   |Chameleon      |Adaptive               |
|test002            |true               |false                  |Chameleon      |Adaptive               |


Scenario: User see Non adaptive theme

Meta: 
@categories adaptive adaptive_and_navigation

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |true               |true                   |nonAdaptive    |nonAdaptive            |
|test002            |true               |true                   |nonAdaptive    |nonAdaptive            |


Scenario: User see Non adaptive Chameleon theme

Meta: 
@categories adaptive adaptive_and_navigation

Given user <user>
When user go to the journal (paid <paid>,mobile view <mobileView>,style <style>) page
Then user see correct style <correctStyle>

Examples:
|user               |paid               |mobileView             |style          |correctStyle           |
|unlogged           |true               |true                   |Chameleon      |Chameleon              |
|test002            |true               |true                   |Chameleon      |Chameleon              |




Scenario: User see correct theme in his journal

Meta: 
@categories adaptive adaptive_and_navigation release

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


Scenario: User see correct theme in random journal with option 'in my style' part1

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |false                  |Air            |false              |false                  |Air            |Air                    |
|true               |false                  |Air            |false              |false                  |nonAdaptive    |Air                    |
|true               |false                  |Air            |false              |false                  |Chameleon      |Air                    |
|true               |false                  |Air            |false              |true                   |Air            |Air                    |
|true               |false                  |Air            |false              |true                   |nonAdaptive    |Air                    |
|true               |false                  |Air            |false              |true                   |Chameleon      |Air                    |
|true               |false                  |Air            |true               |false                  |Air            |Air                    |
|true               |false                  |Air            |true               |false                  |nonAdaptive    |Air                    |
|true               |false                  |Air            |true               |false                  |Chameleon      |Air                    |
|true               |false                  |Air            |true               |true                   |Air            |Air                    |
|true               |false                  |Air            |true               |true                   |nonAdaptive    |Air                    |
|true               |false                  |Air            |true               |true                   |Chameleon      |Air                    |




Scenario: User see correct theme in random journal with option 'in my style' part2

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |false                  |nonAdaptive    |false              |false                  |Air            |Air                    |
|true               |false                  |nonAdaptive    |false              |false                  |nonAdaptive    |Air                    |
|true               |false                  |nonAdaptive    |false              |false                  |Chameleon      |Air                    |
|true               |false                  |nonAdaptive    |false              |true                   |Air            |Air                    |
|true               |false                  |nonAdaptive    |false              |true                   |nonAdaptive    |Air                    |
|true               |false                  |nonAdaptive    |false              |true                   |Chameleon      |Air                    |
|true               |false                  |nonAdaptive    |true               |false                  |Air            |Air                    |
|true               |false                  |nonAdaptive    |true               |false                  |nonAdaptive    |Air                    |
|true               |false                  |nonAdaptive    |true               |false                  |Chameleon      |Air                    |
|true               |false                  |nonAdaptive    |true               |true                   |Air            |Air                    |
|true               |false                  |nonAdaptive    |true               |true                   |nonAdaptive    |Air                    |
|true               |false                  |nonAdaptive    |true               |true                   |Chameleon      |Air                    |






Scenario: User see correct theme in random journal with option 'in my style' part3

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |false                  |Chameleon      |false              |false                  |Air            |Adaptive               |
|true               |false                  |Chameleon      |false              |false                  |nonAdaptive    |Adaptive               |
|true               |false                  |Chameleon      |false              |false                  |Chameleon      |Adaptive               |
|true               |false                  |Chameleon      |false              |true                   |Air            |Adaptive               |
|true               |false                  |Chameleon      |false              |true                   |nonAdaptive    |Adaptive               |
|true               |false                  |Chameleon      |false              |true                   |Chameleon      |Adaptive               |
|true               |false                  |Chameleon      |true               |false                  |Air            |Adaptive               |
|true               |false                  |Chameleon      |true               |false                  |nonAdaptive    |Adaptive               |
|true               |false                  |Chameleon      |true               |false                  |Chameleon      |Adaptive               |
|true               |false                  |Chameleon      |true               |true                   |Air            |Adaptive               |
|true               |false                  |Chameleon      |true               |true                   |nonAdaptive    |Adaptive               |
|true               |false                  |Chameleon      |true               |true                   |Chameleon      |Adaptive               |





Scenario: User see correct theme in random journal with option 'in my style' part4

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |true                   |Air            |false              |false                  |Air            |Air                    |
|true               |true                   |Air            |false              |false                  |nonAdaptive    |Air                    |
|true               |true                   |Air            |false              |false                  |Chameleon      |Air                    |
|true               |true                   |Air            |false              |true                   |Air            |Air                    |
|true               |true                   |Air            |false              |true                   |nonAdaptive    |Air                    |
|true               |true                   |Air            |false              |true                   |Chameleon      |Air                    |
|true               |true                   |Air            |true               |false                  |Air            |Air                    |
|true               |true                   |Air            |true               |false                  |nonAdaptive    |Air                    |
|true               |true                   |Air            |true               |false                  |Chameleon      |Air                    |
|true               |true                   |Air            |true               |true                   |Air            |Air                    |
|true               |true                   |Air            |true               |true                   |nonAdaptive    |Air                    |
|true               |true                   |Air            |true               |true                   |Chameleon      |Air                    |





Scenario: User see correct theme in random journal with option 'in my style' part5

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |true                   |nonAdaptive    |false              |false                  |Air            |nonAdaptive            |
|true               |true                   |nonAdaptive    |false              |false                  |Chameleon      |nonAdaptive            |
|true               |true                   |nonAdaptive    |false              |false                  |nonAdaptive    |nonAdaptive            |
|true               |true                   |nonAdaptive    |false              |true                   |Air            |nonAdaptive            |
|true               |true                   |nonAdaptive    |false              |true                   |nonAdaptive    |nonAdaptive            |
|true               |true                   |nonAdaptive    |false              |true                   |Chameleon      |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |false                  |Air            |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |false                  |nonAdaptive    |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |false                  |Chameleon      |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |true                   |Air            |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |true                   |nonAdaptive    |nonAdaptive            |
|true               |true                   |nonAdaptive    |true               |true                   |Chameleon      |nonAdaptive            |






Scenario: User see correct theme in random journal with option 'in my style' part6

Meta: 
@categories adaptive adaptive_and_navigation release

Given random user (paid <paid>,mobile view <mobileView>,style <style>) with option in my style
When user go to the random journal (paid <paid1>,mobile view <mobileView1>,style <style1>) page
Then random user see correct style <correctStyle> in random journal

Examples:
|paid               |mobileView             |style          |paid1              |mobileView1            |style1         |correctStyle           |
|true               |true                   |Chameleon      |false              |false                  |Air            |Chameleon              |
|true               |true                   |Chameleon      |false              |false                  |nonAdaptive    |Chameleon              |
|true               |true                   |Chameleon      |false              |false                  |Chameleon      |Chameleon              |
|true               |true                   |Chameleon      |false              |true                   |Air            |Chameleon              |
|true               |true                   |Chameleon      |false              |true                   |nonAdaptive    |Chameleon              |
|true               |true                   |Chameleon      |false              |true                   |Chameleon      |Chameleon              |
|true               |true                   |Chameleon      |true               |false                  |Air            |Chameleon              |
|true               |true                   |Chameleon      |true               |false                  |nonAdaptive    |Chameleon              |
|true               |true                   |Chameleon      |true               |false                  |Chameleon      |Chameleon              |
|true               |true                   |Chameleon      |true               |true                   |Air            |Chameleon              |
|true               |true                   |Chameleon      |true               |true                   |nonAdaptive    |Chameleon              |
|true               |true                   |Chameleon      |true               |true                   |Chameleon      |Chameleon              |


Scenario: User with Adaptive Chameleon see correct theme in journal with option 'in my style'

Meta: 
@categories adaptive adaptive_and_navigation

Given user <user> with option in my style
When user go to the random journal <journal> page
Then user see correct style <correctStyle> in journal