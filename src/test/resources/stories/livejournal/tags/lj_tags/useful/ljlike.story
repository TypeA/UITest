Scenario: User can make new post with lj-like tag
Meta: 
@categories tags lj_tags useful likes

Given logged user <name> on Create Post page
When user create post with lj-like <likes> tag
Then the post is in journal and contains lj-like <likes> buttons

Examples:
|name         |likes                                                                                    |
|testautotest |default;                                                                                 |
|testautotest |facebook;                                                                                |
|testautotest |repost;twitter;livejournal;                                                              |   
|testautotest |repost;facebook;twitter;vkontakte;google;surfingbird;odnoklassniki;tumblr;livejournal;   |