# SciFi UI Project

Name: Ben Cox

Student Number: C17325641

# Description of the assignment

The task for this assignment was to create a SciFi User Interface similar to what is found in movies and other media.

This assignment is written in Java code and uses processing libraries to enable visualizations. 

The design of my assignment is based off of the a Scifi UI found while researching for this project:

![An image](images/influence.jpg)

While the final project is vastly different, it was from this image that I started the design process. I incorporated the multiscreen layout and used a similar targetting system.

# Instructions
While the purpose of the assignment was to create a SciFi UI, due to the interactive elements of this UI, it plays as a space shooter. Using the arrow keys to control the user's targeting and weapons system, you can travel between galaxies and destroy enemy ships and planets.

Each successive galaxy will have more enemies and planets to defeat. Rounds change automatically once all targets are destroyed.

Your ship offers three selectable weapons - lazers, missiles and sentry gun. Each weapon is powerful enough to destroy your target, but all have their own unique animation. These can be selected using the number keys.

Your turret has the ability to pan 360 degrees in the X-axis and 180 degrees in the Y-axis. This is to replicate the control of a top mounted turret on a spaceship.

The cursor controls an addition targeting option, but is only used for identifying plantes. Simply hover the cursor via a mouse or trackpad over any planet to find it's name. The names are sourced from the names of all know exoplanets and can be found here:
[Exoplanet Names](https://en.wikipedia.org/wiki/List_of_exoplanets_(full))
## User Controls:

| Control Turret | Toggle |
|-----------|-----------|
|Look Up | Up Arrow on Keyboard |
|Look Down | Down Arrow on Keyboard |
|Look Left | Left Arrow on Keyboard |
|Look Right | Right Arrow on Keyboard |

| Weapon | Toggle |
|-----------|-----------|
|Lazer | Number 1 on Keyboard |
|Missiles | Number 2 on Keyboard |
|Sentry Gun | Number 3 on Keyboard |

*To Fire Weapons: Space Bar*


# How it works
For this assignment, I used Java and processing libraries to create my SciFi user interface. Once launched, Main.java is used to calls startUI which runs the sketch. The core elements of the sketch are in UI.java and additional classes were created as neccessary.

Libraries used:
-java.time is used for get the current time and displaying on a clock
-java.util is used for ArrayLists for storing planet names and scenary objects

Several classes were created for this project and can be summarized as follows:

| Class | Purpose |
|-----------|-----------|
|Dashboard | Used for drawing the dashboard on top and bottom of the screen |
|Interior | Used for drawing the interior window |
|Scene | An abstract class used for various scenary classes. It handles basic parameters and has update,render and minimap method |
|Planets | Extends the Scene class. This is used for drawing the generated planets each round and displays them on the minimap also. The update function is used for when the turret is rotating |
|Screens | Used for rendering the multiple screens in the cockpit and their bezels |
|Ships | Extends the Scene class. This is used for drawing the generated enemy ships each round and displays them on the minimap also. The update function is used for when the turret is rotating |
|Stars | Extends the Scene class. This is used for drawing the generated stars each round for scenary and displays them on the minimap also. The update function is used for when the turret is rotating |
|Target | Used for drawing the turrets large target, reticle and target/weapon information. The update method is used to check if a target is in range of the crosshairs |

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

