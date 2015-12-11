Scenario: add video by url
Meta:
@categories create_edit_post video_from_album useful

Given logged user <name> on Create Post page
When add video from album
Then post contains video from album

Examples:
|name     |
|test     |