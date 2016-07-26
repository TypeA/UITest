Scenario: content update.bml
Meta:
@categories medius admin admin_medius create_post content_admin_medius_create

Given logged user (name <user>) on Admin Medius Create Post
Then admin can not change date and privacy settings
Examples:
|user               |
|test               |


Scenario: Create post without sources
Meta: 
@categories medius admin admin_medius create_post create_post_medius_without_authors 

Given logged user (name <user>) on Admin Medius Create Post
When create post without source in random category
Then post is created with author lj_media and editor <user>

Examples:
|user               |
|test               |

Scenario: Create post with sources
Meta:
@categories medius admin admin_medius create_post_medius @with_authors


Given logged user (name <user>) on Admin Medius Create Post
When create post with source in random category
Then post is created with authors and editor <user>

Examples:
|user               |
|test               |

Scenario: Create interesting post
Meta:
@categories medius admin admin_medius create_post_medius medius_interesting

Given logged user (name <name>) on Admin Medius Create Post
When create interesting post in random category
Then interesting post is created editor <user>

Examples:
|user               |
|test               |

Scenario: Create main post
Meta:
@categories medius admin admin_medius create_post_medius main

Given logged user (name <name>) on Admin Medius Create Post
When create main post in random category
Then main post is created witn editor <user>

Examples:
|user               |
|test               |





