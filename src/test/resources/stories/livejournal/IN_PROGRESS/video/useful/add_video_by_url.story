Scenario: add video by url
Meta:
@categories create_edit_post video_by_url useful dsgfdsgdfretretretre

Given logged user <name> on Create Post page
When add video by url <video_url>
Then post contains video by url <video_url>

Examples:
|name     |video_url                                    |
|test     |http://youtube.com/watch?v=-LMebrVm-uU       |