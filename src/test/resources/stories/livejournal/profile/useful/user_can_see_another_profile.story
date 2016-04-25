User can see another profile


Scenario: Birthday privacy

Meta:
@categories profile useful 

Given logged user <user> on Profile page with setting <setting>
Then user <user1> can see another user <user> birthday
Then user <user2> can't see another user <user> birthday

Examples:
|user         |user1         |user2         |setting    |
|testautotest |logged        |nobody        |All        | 
|testautotest |unlogged      |nobody        |All        | 
|testautotest |friend        |not_friend    |Friend     |
|testautotest |logged        |unlogged      |Registered |
|testautotest |nobody        |logged        |Nobody     |
|testautotest |nobody        |unlogged      |Nobody     |



Scenario: Show email

Meta:
@categories profile useful

Given logged Profile page with settings <show> and <display>
Then user <user1> can see email
Them user <user3> can't see email

Example:
|user1          |user2            |show     |display   |
|logged         |                 |true     |everybody |
|unlogged       |                 |true     |everybody |
|logged         |unlogged         |true     |registered|
|friend         |not_friend       |true     |friends   |
|null           |unlogged         |true     |friends   |
|null           |logged           |true     |nobody    |
|null           |unlogged         |true     |nobody    |
|null           |logged           |false    |everybody |
|null           |unlogged         |false    |everybody |
|null           |logged           |false    |registered|
|null           |unlogged         |false    |registered|
|null           |logged           |false    |friends   |
|null           |unlogged         |false    |friends   |
|null           |logged           |false    |nobody    |
|null           |unlogged         |false    |nobody    |




Scenario: Show list of friends

Meta:
@categories profile useful

Given logged Profile page with friend's checkbox <friend>
Then user <user1> can see list of friends
Then user <user2> can't see list of friends

Example:
|user1         |user2    |friend|
|logged        |null     |on    |
|unlogged      |null     |on    |
|null          |logged   |off   |
|null          |unlogged |off   |