Scenario: add photo to post from album 
Meta:
@categories photo from_album useful

Given logged user <name> on Create Post page
When create post with photo from album with link <link> and with size <size> (user, <name>)
Then post contains photo with link <link> and size <size> (user, <name>)

Examples:
|name      |link     |size       |
|test      |false    |           |
|test      |true     |           |
|test      |false    |100        |
|test      |false    |300        |
|test      |true     |600        |
|test      |false    |800        |
|test      |true     |900        |
|test      |false    |1000       |
|test      |true     |Original   |