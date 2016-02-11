Scenario: Create post with style
Meta: 
@categories create_post html_tags useful 

Given logged user <name> on Create Post page
When user create new post with style <tag> and save post
Then post with style <tag> is displayed correctly

Examples:
|name         |tag       |
|testautotest |b         |      
|testautotest |i         |
|testautotest |u         |


Scenario: Create post with font
Meta: 
@categories create_post html_tags useful

Given logged user <name> on Create Post page
When user create new post with font <font_text> and save post
Then post with font <font_text> is displayed correctly

Examples:
|name         |font_text     |
|testautotest |tiny          |
|testautotest |small         |
|testautotest |normal        |
|testautotest |large         |
|testautotest |huge          |

Scenario: Create post with color
Meta: 
@categories create_post html_tags useful 

Given logged user <name> on Create Post page
When user create new post with color <color_text> and save post
Then post with color <color_text> is displayed correctly

Examples:
|name         |color_text     |
|testautotest |e03d3d         |
|testautotest |64b30b         |
|testautotest |de0d48         |

Scenario: Create post with custom text 
Meta: 
@categories create_post html_tags useful

Given logged user <name> on Create Post page
When user create new post with color <color_text> style_1 <tag_1> style_2 <tag_2> and save post
Then post with color <color_text> and styles <tag_1> <tag_2> is displayed correctly

Examples:
|name         |tag_1   |tag_2   |color_text     |
|testautotest |b       |u       |e03d3d         |
|testautotest |i       |b       |64b30b         |

Scenario: Create post with link
Meta: 
@categories create_post html_tags useful html_tags_link
 
Given logged user <name> on Create Post page
When user create new post with link <link> and add property open in new window <newWindow>
Then post with link <link> is displayed and open in newWindow <newWindow>

Examples:
|name         |link         |newWindow   |
|testautotest |rambler.co   |false       |
|testautotest |google.com   |true        |

Scenario: Create post with custom link 
Meta: 
@categories create_post html_tags useful html_tags_link

Given logged user <name> on Create Post page
When user create new post with link <link> and style <tag>
Then post with link <link> and with style <tag> is displayed

Examples:
|name         |link         |tag      |
|testautotest |rambler.co   |b        |
|testautotest |google.com   |u        |
|testautotest |google.com   |i        |

