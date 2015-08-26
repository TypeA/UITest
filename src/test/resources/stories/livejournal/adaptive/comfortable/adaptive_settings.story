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



Scenario: Logged paid user see correct style

Meta: 
@categories adaptive comfortable

Given logged user <user> on journal <journal> page
Then user see correct style <style> in journal <journal> page

Examples:
|user              |journal            |style          |
|autotest_paid_2   |autotest-paid-1    |AIR            |
|autotest_paid_2   |autotest-paid-2    |Librarian      |
|autotest_paid_2   |autotest-plus-1    |AIR            |
|autotest_paid_2   |autotest-plus-2    |AIR            |
|autotest_paid_2   |autotest-paid-1    |AIR            |
|autotest_paid_2   |autotest-paid-2    |Librarian      |
|autotest_paid_2   |autotest-plus-2    |AIR            |
|autotest_paid_2   |autotest-plus-2    |AIR            |
