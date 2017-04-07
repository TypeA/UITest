Scenario: TOS

Meta: 
@categories TOS

Given TOS on all pages

Examples:
|name           |design       |
|test           |old          |
|test           |new          |


Scenario: All links

Meta: 
@categories links

Given user <name> with design <design> get all links on all pages

Examples:
|name           |design       |
|test           |old          |


