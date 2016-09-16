Register an account with incorrect data



Scenario: Register an account with incorrect name

Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name           |email          |password   |day    |month  |year   |gender |message                                  |
|лоргшне333     |test@test.ru   |Pass123    |1      |4      |1990   |M      |Username contains invalid characters     |
|t.es,t1234rnd  |test@test.ru   |Pass123    |1      |4      |1990   |M      |Username contains invalid characters     |
|te st1234rnd   |test@test.ru   |Pass123    |1      |4      |1990   |M      |Username contains invalid characters     |
|te(st1234rnd   |test@test.ru   |Pass123    |1      |4      |1990   |M      |Username contains invalid characters     |
|_test1234rnd   |test@test.ru   |Pass123    |1      |4      |1990   |M      |Sorry, that is a reserved username.      |
|test1234_      |test@test.ru   |Pass123    |1      |4      |1990   |M      |Sorry, that is a reserved username.      |



Scenario: Register an account with long name

Meta: 
@categories registration useful release testmaxa

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then there is <symbols> symbols in name field

Examples:
|name           |email          |password   |day    |month  |year   |gender |symbols|
|teNOSst1234rnd |test@test.ru   |Pass123    |1      |4      |1990   |M      |15     |



Scenario: Register an account with incorrect email

Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data except for the email: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name           |email              |password   |day    |month  |year   |gender |message                                                      |
|test1234rnd    |te"st@test.ru      |Pass123    |1      |4      |1990   |M      |You have invalid characters in your email address username.  |
|test1234rnd    |tes,t@test.ru      |Pass123    |1      |4      |1990   |M      |You have invalid characters in your email address username.  |
|test1234rnd    |te st@test.ru      |Pass123    |1      |4      |1990   |M      |You have invalid characters in your email address username.  |
|test1234rnd    |testtest.ru        |Pass123    |1      |4      |1990   |M      |You did not give a valid email address.                      |
|test1234rnd    |test@@test.ru      |Pass123    |1      |4      |1990   |M      |You did not give a valid email address.                      |
|test1234rnd    |test@test.r'u      |Pass123    |1      |4      |1990   |M      |Your email address domain is invalid.                        |
|test1234rnd    |test@test.r()u     |Pass123    |1      |4      |1990   |M      |Your email address domain is invalid.                        |



Scenario: Register an account with incorrect password

Meta: 
@categories registration useful release
@issue LJSUP-21440

Given unlogged user on Registration Form
When user enter correct data except for the password: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active


Examples:
|name           |email          |password       |day    |month  |year   |gender |message                                                     |
|test1234rnd    |test@test.ru   |1QqytNOS       |1      |4      |1990   |M      |Password may not exceed 30 characters                       |
|test1234rnd    |test@test.ru   |rRtTyYiI       |1      |4      |1990   |M      |Your password must contain at least one number or symbol    |
|test1234rnd    |test@test.ru   |ytrytr123      |1      |4      |1990   |M      |The password should contain at least one upper case letter  |
|test1234rnd    |test@test.ru   |RTYFGH123      |1      |4      |1990   |M      |The password should contain at least one lower case letter  |
|test1234rnd    |test@test.ru   |Rr1Rr1Rr1Rr1   |1      |4      |1990   |M      |Your password must have at least four different characters. |
|test1234rnd    |test@test.ru   |1Qqk           |1      |4      |1990   |M      |Your password must be at least six characters long.         |
|test1234rnd    |test@test.ru   |Ешка123        |1      |4      |1990   |M      |Your password can only be comprised of ASCII characters.    |
|test1234R      |test@test.ru   |test1234R      |1      |4      |1990   |M      |Your password cannot be based on your username.             |




Scenario: Register an account with incorrect age

Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data except for the age: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender> and clicks Create Account
Then user go to Finish Registration Form and see message <message>

Examples:
|name           |email          |password   |day    |month  |year   |gender |message            |
|test1234rnd    |test@test.ru   |Pass123    |1      |4      |2010   |M      |Age Verification   |




Scenario: Register an account with empty name

Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data except for the name: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name   |email          |password   |day    |month  |year   |gender |message                                          |
|       |test@test.ru   |Pass123    |1      |4      |1990   |M      |Use latin letters a..z, digits 0..9 and single _ |






Scenario: Register an account with empty email

Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data except for the email: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active


Examples:
|name           |email  |password   |day    |month  |year   |gender |message                                   |
|test654rnd     |       |Pass123    |1      |4      |1990   |M      |For verification and password recovery    |





Scenario: Register an account with empty password

Meta: 
@categories registration useful release
@issue LJSUP-21440

Given unlogged user on Registration Form
When user enter correct data except for the password: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name       |email          |password   |day    |month  |year   |gender |message                |
|test654rnd |test@test.ru   |           |1      |4      |1990   |M      |Password requirements  |




Scenario: Register an account with empty age


Meta: 
@categories registration useful release

Given unlogged user on Registration Form
When user enter correct data leave one age field empty: name <name>, email <email>, password <password>, day <day>, month <month>, year <year>, gender <gender>
Then in Popup user see message $message and button Create Account is not active

Examples:
|name       |email          |password   |day    |month  |year   |gender |message                                                         |                                       |
|test654rnd |test@test.ru   |Pass123    |-1     |4      |1990   |M      |Required by law. Only month and day are displayed by default.   |
|test654rnd |test@test.ru   |Pass123    |1      |-1     |1990   |M      |Required by law. Only month and day are displayed by default.   |
|test654rnd |test@test.ru   |Pass123    |1      |4      |-1     |M      |Required by law. Only month and day are displayed by default.   |


