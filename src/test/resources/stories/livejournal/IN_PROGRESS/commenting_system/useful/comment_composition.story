Scenario: Comment with image

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>)
When user create new comment <comment> with image <image>
Then the comment is created


Examples:
|name |password |comment |image |style |
|test |test     |comment |image |s1    |
|test |test     |comment |image |s2    |


Scenario: Comment with video

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>)
When user create new comment <comment> with video <video>
Then the comment is created


Examples:
|name |password |comment |video |style |
|test |test     |comment |video |s1    |
|test |test     |comment |video |s2    |

Scenario: Comment with link

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user create new comment <comment> with link <link> 
Then the comment is created


Examples:
|name |password |comment |link |style |
|test |test     |comment |link |s1    |
|test |test     |comment |link |s2    |



Scenario: Comment with user name

Meta: 
@categories commenting system useful

Given logged user (name <name>, password <password>, style <style>) 
When user create new comment <comment> with user name <user_name>
Then the comment is created


Examples:
|name |password |comment |user_name |style |
|test |test     |comment |user_name |s1    |
|test |test     |comment |user_name |s2    |