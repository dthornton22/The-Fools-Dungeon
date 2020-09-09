# The Project for CS 321 (Imported from Canvas)

## The Project
* We will build a suite of software components to be used in building something of interest.
* You and your team will need to define what the "something of interest" is. I will give you the specification of the components that will be in your project. You will be able to use these components to build different things. You might want to build a science analysis notebook, a game, an interactive storyteller, a social simulation, a data analyzer, a graphics catalog, or something else. Think creatively but be practical the semester is not a long period of time!

## Overview

### What are the components?
There will be five basic components (in addition to the model for your "something of interest")
1. Graphical user interface
2. Text formatting and processing (html or other)
3. Graphics sampled or constructive with manipulation or animation (could be all four)
4. Storage and retrieval of information (flat file, database, XML, or all of these).
5. Editing and configuring the software product

#### Major Construct: MVC
* The project must clearly demonstrate the ideas of the Model-View-Control pattern/paradigm.

#### Graphical User Interface (GUI)
* No matter what you decide to build, you must provide a GUI. A good variety of widgets are available, and you can customize these. http://docs.oracle.com/javase/tutorial/uiswing. The underlying software engineering principle will be the model-view-control pattern. There is a lot to do here; you will need to think through the user interaction. Use cases and CRC cards will help.

#### Text Formatting and Processing
But what about that processing part? This will vary by project. For example, you might want to search your documents for key words or phrases and then display them or you might want to make substitution when the text is displayed. Or you might want to assemble data into a formatted text document. We will need to investigate this.
* You might want to check Apache Commons in general, but more specifically for this part of the project Commons Text might be helpful. https://commons.apache.org/proper/commons‐text
* If your interest is text processing, you might try http://www.gutenberg.org for source material.

#### Graphics sampled or constructive with manipulation or animation
What goes better with nice looking text than some nice graphics?
* Sampled graphics are images that are like those taken by a camera.
* Constructed graphics are images built from primitive graphic shapes.
* Manipulating graphics is changing them in some way (colors, size, contrast, and so on)
* Animation is graphics manipulation over time.

There is a good deal to learn about graphics. A lot will depend on your project. We will keep things at the 2D level but there is still a great deal you can do: build a display of a social network, visualize scientific data, page through a collection of pictures, bend on picture into another, move a commentator avatar across a road map, and more.
* https://docs.oracle.com/javase/tutorial/2d
* There are many graphics and animation libraries available for Java. A bit of Googling will get you to these.
* There are many graphics repositories and there is always your phone.

#### Storage and retrieval of information
Well if there is going to be text, images, and other project data it would be good to be able to easily store and retrieve these. How is this done? These items will be stored in files but how will we keep track of the files, find the right one, and even find the right item in a file?
* Flat files can be fine for things like sampled graphics, but more is often needed. If you are looking at some structured document or file, there are several readily available XML libraries in the Java distribution.
* Databases and XML files are good for structured data. You might look at H2 or Derby. There are many others
   1. H2: https://www.h2database.com/html/main.html
   2. Derby: https://db.apache.org/derby
* We will need to build an appropriate component

So where are we going to put the files? Can the user produce new files? Should these be added to files that are already there? What if the user wants to change the color scheme? What if the user wants to use a different natural language?
* And property files are handy for configuration! https://docs.oracle.com/javase/tutorial/essential/environment/properties.html


### Semester Project
#### 1. *View*
1. Animations
2. Widgets
   1. Text
   2. Images
#### 2. *Controller*
1. Collection
2. Modification
   1. View
   2. Model
#### 3. *Model*
1. State
2. Transforms
#### 4. *Utilities*
1. Text
   1. Composed
   2. Formatted
2. Graphics
   1. Constructed
   2. Sampled
3. Data Persistence
   1. Preferences
   2. Configuration
   3. Data
      1. Managed database
      2. File
         1. Unstructured
         2. Structured
         
FreeMind is handy: http://freemind.sourceforge.net/wiki/index.php/Main_Page

VUE is cool: http://vue.tufts.edu/
