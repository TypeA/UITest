Scenario: add video from album
Meta:
@categories video_from_album useful

Given logged user <name> on Create Post page
When add video from album (user, $name)
Then post contains video from album (user <name>)

Examples:
|name     |
|test     |