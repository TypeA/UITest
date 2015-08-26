Scenario: Unlogged user see correct style

Meta: 
@categories adaptive comfortable

Given unlogged user on journal <journal> page
Then user see correct style <style> in journal <journal> page

Examples:
|journal            |style          |
|autotest-paid-1    |AIR            |
|autotest-paid-2    |Librarian      |
|autotest-plus-1    |AIR            |
|autotest-plus-2    |AIR            |



Scenario: Logged user see correct style

Meta: 
@categories adaptive comfortable testt

Given logged user <user> on journal <journal> page
Then user see correct style <style> in journal <journal> page

Examples:
|user              |journal            |style          |сценарий                                                        |
|autotest_paid_1   |autotest_paid_1    |AIR            |платник с выключенным custom свой журанл                        |
|autotest_paid_1   |autotest_paid_2    |Librarian      |платник с выключенным custom платника с включенным custom       |
|autotest_paid_1   |autotest_plus_1    |AIR            |платник с выключенным custom бесплатника с выключенным custom   |
|autotest_paid_1   |autotest_plus_2    |AIR            |платник с выключенным custom бесплатника с включенным custom    |
|autotest_paid_2   |autotest_paid_1    |AIR            |платник с включенным custom платника с выключенным custom       |
|autotest_paid_2   |autotest_paid_2    |Librarian      |платник с включенным custom свой журнал                         |
|autotest_paid_2   |autotest_plus_1    |AIR            |платник с включенным custom бесплатника с выключенным custom    |
|autotest_paid_2   |autotest_plus_2    |AIR            |платник с включенным custom бесплатника с включенным custom     |
|autotest_plus_1   |autotest_paid_1    |AIR            |бесплатник с выключенным custom платника с выключенным custom   |
|autotest_plus_1   |autotest_paid_2    |Librarian      |бесплатник с выключенным custom платника с включенным custom    |
|autotest_plus_1   |autotest_plus_1    |AIR            |бесплатник с выключенным custom свой журнал                     |
|autotest_plus_1   |autotest_plus_2    |AIR            |бесплатник с выключенным custom бесплатника с включенным custom |
|autotest_plus_2   |autotest_paid_1    |AIR            |бесплатник с включенным custom платника с выключенным custom    |
|autotest_plus_2   |autotest_paid_2    |Librarian      |бесплатник с включенным custom платника с включенным custom     |
|autotest_plus_2   |autotest_plus_1    |AIR            |бесплатник с включенным custom бесплатника с выключенным custom |
|autotest_plus_2   |autotest_plus_2    |Light_Clouds   |бесплатник с включенным custom свой журнал                      |
