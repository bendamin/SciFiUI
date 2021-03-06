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

*To Show Planet Name: Hover Cursor Over Planet*


# How it works
For this assignment, I used Java and processing libraries to create my SciFi user interface. Once launched, *Main.java* is used to call *startUI()* which runs the sketch. The core elements of the sketch are in *UI.java* and additional classes were created as neccessary.

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

*UI.java* has quite a lot of variables, some functional while others are used to reduce the amount of duplicate code and complicated fractions. For example, functional variables such as level, compassX, compassY etc. are crucial to the program, whereas the multiple variables used for the screen dimensions are used reduce the amount of duplicate code when interacting with the screens be it for rendering them or the information on them. Variables are given intuitive names that describe their purpose where posssible.

There are 4 ArrayLists used in UI.java. 3 are of type Scene and store objects relevnt to the scenary such as planets, stars and enemies. The last ArrayList stores strings for the planet names. An ArrayList is beneficial for all of the use cases as their amounts vary each round i.e. more planets every round but less names remaining. Planets are stored in an ArrayList called *scene* and not planets, as the intention is that planets can be swapped out easily for any other scenary orientated object such as mountains, asteroids or anything else.

User input is also handled in the *UI.java* files via the *keyPressed()*, *keyReleased()* and *checkKey()* methods for keyboard input. Possible inputs are numbers for selecting weapons, arrow keys for rotating, and the space bar for firing the selected weapon. The cursor and mouse clicks are also accommodated. The cursor can be used for highlighting a planet and have it's name displayed, while a mouse press will generate a random background color via the *mouseClicked()* method. The cursor control is handled by using the dist method to compare the distance of mouseX and mouseY to the center of each planet. If the distance is less than the radius, then the planet's name will be displayed until the mouse moves or the planet is destroyed.

The *setup()* method sets variables to their relative values based on the screen size and instatiates the needed objects. It also calls the *loadName()* method which loads the planet names from a comma seperated value file called *planets.csv*. It reads each name and adds it to the *planetNames* ArrayList by using Table and storing each row from the text file before adding to the ArrayList.

The *draw()* method is called 60 times a second and as such, contains all neccessary method calls for rendering the UI. For reference, theses are the methods called:

```Java
public void draw()
    {
        noCursor();
        createPlanets();
        createStars();
        createShips();

        colorMode(HSB, 100);
        noStroke();
        background(backgroundColor,100,10);

        drawStars();
        drawScene();
        drawShips();

        blowup();

        drawCursor();

        interior.render();
        
        dash.render();

        midscreen.render();

        leftscreen.render();

        rightscreen.render(); 

        

        roundNum();

        info();
        destroy();
        weaponAnimation();
        screenBezel();

        target.update(sight);
        target.render();

        planetName();

        clock();

        rotating();

        userInput();

        nextRound();
    }
```

Firstly it calls the *createPlanets()*, *createStars()* and *createShips()* methods. These contain while loops which are used to create the needed objects each round and adding them to their respective ArrayLists. During each round, these loops do nothing, as the object don't need to be created until the next round. This cannot be used in *setup* as they need to be called each round. These objects are drawn using the *drawStars()*, *drawScene()* and *drawShips()* methods. These loop through all the objects in their relevant ArrayList and update and render them as neccessary. All size and position variables are set relative to the width and height of the current UI. Below is code demonstrating how for planets, they are added to the ArrayList and then rendered:

```Java
void createPlanets(){
        while(planetsNum < (level * 10)){
            Planets planet = new Planets(this, random(0,width*4), random(0 - (float)(halfWidth), (float)(halfWidth*3)), random(width/20, width/10),random(0,100));
            scene.add(planet);
            planetsNum++;
        }
    }
```

```Java
void drawScene(){
        for(int j = 0; j < scene.size(); j++){
            scene.get(j).render();
        }
    }
```



The *blowup()* method handles the animation for explosions when planets or enemies are destroyed. It checks if the boolean explode is true. It will be true if in the previous *draw()* call, a planet was shot at. If it's true, it will animate the explosion by drawing ellipses and making them bigger each draw until they're big enough. Once large enough, explode is set to false. If explode is false, *explosionColor* is set to the correct color depending on the current weapon system.


The *drawCursor()* method simply draws a hollow rectange around the cursor to show the user where they're pointing currently. After drawing the scenery and cursor, the inside of the ship is rendered. This is downe using the relevant methods. *interior.render()* for example renders the interior window, while *dash.render()* renders the top and bottom dashboard. The various screen methods simply render the screens. The *roundNum()* method is used for displaying the current round to the user and shows the weapons available.

The *info()* method renders the relevant information onto the 3 screens. First, it converts the current X co-ordinate so that it's understandable i.e. makes sure it's between 0 and 360. On the left screen, the ships co-ordinates are displayed. Next, the middle screen's information is displayed. In this case, this means rendering the in game minimap displaying the stars, planets and enemies. This is done via each object's *minimap()* method achieved through the use of the abstract class *Scene* which ensures they all have the minimap method. This method uses the map method to ensure all objects are mapped correctly to the minimap relative to there location and the perspective of the user at that time. This minimap gives a simulated 270 degrees of coverage compared to the 90 degrees for the view throgh the targeting system. A crosshair is then rendered on the minimpap to show the user's position. Finally, the right screen's information is rendered. This includes the number of planets and enemies remaining, which is found by checking the size of their respective ArrayLists.

The *destroy()* method is next to be called in each draw call. This method handles removing planet and enemy object when they are shot. It does this by looping through the objects and seeing if they are within range of being shot. If this is true and the user is currently shooting, the object or objects if both in range, will be removed from their respective ArrayLists, and if it is a planet, it's name will be removed from the list of exoplanet names read from planets.csv. Below is an example for how planets are handled:


```Java
for(int j = 0; j < scene.size(); j++){
            if (dist(width/2, height/2, scene.get(j).x,scene.get(j).y) < width/12){
                sight = true;
                if(firing == true){
                    explode = true;
                    scene.remove(j);
                    planetNames.remove(j);
                }
            }
        }
```

The next method to be called in *draw()* is *weaponAnimation()*. It checks if the user is firing by checking the boolean *firing* and if they are, it then check which weapon is selected by checking the contents of the String *weapon*. Depending on the value of *weapon*, the color, size and location will be drawn differently to match the real world look of the selected weapon. Below is an example for if *weapon* is set to "lazer":

```Java
if(firing == true){
            if(weapon.equals("Lazer")){
                fill(96,40,100);
                ellipse(width/2, height/2, ammo, ammo);
                ammo = (width/12) + (random((-width/100),(width/100)));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(3,6), random(3,6));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(6,12), random(6,12));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(12,15), random(12,15));

            }
}
```

The method *screenBezel()* simplies calls the *update()* method of each screen and has them draw their bezel over the screen borders. Then *update()* and *render()* are called for the target. In *update()*, the boolean *sight* is passed which will be true if a planet or enemy is in range. If sight is true, the target finder is set to green and will say 'Lock On'. Else, it will say 'No Target'. The *render()* method then draws the target finder, with the color depending on the outcome of *update()*. The reticle is drawn in the centre, a crosshair in a plus shape is drawn and a box for displaying the target information is drawn above it.

The *planetName()* method draws a screen at the top of the UI and asks the user to use their cursor to indentify planets. When the user hovers the cursor over a planet, it's name is displayed. This is handled by looping through all visible planets and comparing their distance from the current mouse position. If more than one planet is in range of the cursor, it will be the last rendered planet that will have it's name displayed.

The *clock()* method is a simple method used for displaying a real time clock above the middle screen on the dashboard. This is achieved via 

```Java
LocalTime hour = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
```
Then *hour* is converted to a String using *hour.toString()* so that it can be rendered using the text method and thus displaying the user's current time.

Next to be called in *draw()* is *rotating()*. First it checks if the current value of *angle* is too high or low. This value is used for rotating the enemies back and forth. If the value is too low, *addAngle* is set to true and then *angle* will be incremented. Otherwise, the opposite is true. It also increments *moon* by 5 every call. This variable is used for rotating the moons for the given planets both clockwise and anticlockwise.

```Java
public void rotating(){
        if(angle > 120){
            addAngle = false;
        }

        if(angle < -120){
            addAngle = true;
        }


        if(addAngle){
            angle++;
        }else{
            angle--;
        }

        moon = moon + 5;
    } 
```

Next, *userInput()* is called. This handles the user input from the keyboard for directions. Depending on the arrow key pressed, the objects will be have their x and y values adjusted to create the simulation of rotating around the user. The compass variables are also adjusted depending on the arrow key. From the following code snippet for the use case of the user pressing LEFT, it can be seen how each direction only requires slight adjustment to conform to it's needs.

```Java
if (checkKey(LEFT))
        {
            for(int j = 0; j < scene.size(); j++){
                scene.get(j).update(5,0);
            }

            for(int j = 0; j < ships.size(); j++){
                ships.get(j).update(5,0);
            }

            for(int j = 0; j < stars.size(); j++){
                stars.get(j).update(5,0);
            }

            compassX = compassX - 5;
            
            System.out.println("Left arrow key pressed");
        }
```
Although, UP and DOWN have additional checks to prevent the user rotating to far up or down as it would be disorientating. This is done by comparing the current Y value of the compass to the height of the UI. Additionally, this method checks if the user is pressing SPACE and if so, sets the boolean *firing* to true. It also checks for num pad values entered and depending on if it is 1,2, or 3, sets the *weapon* string to the correct value.




# What I am most proud of in the assignment
The elements of this project that I am most proud of are my use of git, the execution of 360 degrees rotation on the X-axis for roating the turret and how I mapped the onscreen objects onto the minimap.

For enabling a full 360 degrees of rotation, certain ideas were incorporated. By default the user has a simulated 90 degrees of vision through the window. Once loaded, all planets between the x values 0 and *width* are visible. This requires little work to implement. But as soon as the user presses LEFT, problems would arrise. Similarly, if the user pressed RIGHT until they had passed all planets, they would continue indefinitely and never see any more planets. To avoid this, first we need to look at how the system responds to the arrow keys.

```Java
if (checkKey(LEFT))
        {
            for(int j = 0; j < scene.size(); j++){
                scene.get(j).update(5,0);
            }

            for(int j = 0; j < ships.size(); j++){
                ships.get(j).update(5,0);
            }

            for(int j = 0; j < stars.size(); j++){
                stars.get(j).update(5,0);
            }

            compassX = compassX - 5;
            
            System.out.println("Left arrow key pressed");
        }
```

As you can see, the parameters 5 and 0 are passed to each scenary object's *update()* method. Once passed, this how they are handled:

```Java
public void update(float offsetX, float offsetY)
    {
        x = x + offsetX;

        if(x > ui.width*4){
            x = 0;
        }

        if(x < 0){
            x = ui.width*4;
        }

        y = y + offsetY;

    }
```

here you can see how the illusion of rotation is achieved. Since the user's simulated field of view is 90 degrees, the total width of a rectange that would be able to wrap around 360 degrees is *width* multiplied by 4. As such, if a value exceeds this, is position must have gone past the 360 degree mark and such is back at 0 degrees and thus, its x value is set to 0. The opposite is done when an x value becomes less than 0. It is set to *width* by 4 as it is now 360 degrees away when turning clockwise. This enables the user to rotate left or right as much as they wish.

The harder element of the code though was enabling this to be visible on the minimap with a much wider field of view. While I knew from the start this would require the use of the *map()* method, I did not expect it be as challenging and rewarding as it was. At first I was rendering the objects on the minimap using the *map()* method inside the relevant render methods used and entering values directly in. This presented extremely long and complicated lines of code and made debugging difficult when errors occured. As such, I first calculated the mapped value for the X and Y co-ordinate and then used them to draw the minimap after. This also improved readability greatly. This is the end result in the case of the planets, but is very similar to the other objects with the exception of the stars extending further off the screen to stop the UI from looking cut off, whereas planets and enemies had to be reachable with the target:

```Java
public void minimap(){
        ui.fill(color,100,100);
        ui.noStroke();

        //for values left of 0 mark
        if(x > ui.width*3){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(ui.width*3),(float)(ui.width*4),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }
        //for values right of 0 mark
        if(x < ui.width*2){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(0),(float)(ui.width*2),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3),((ui.width/2) - (ui.width/10))+ (ui.width/5));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }
    }
```

The reason for the two if statements is that objects with an extremely big x value would actually be on the left of the minimap if the users target was to be the center of the minimap. As such, the first if statment deals with planets, enemies and stars to the left of the user's position by 90 degrees but that can't currently be seen. The other if statement handles the remaining 180 degrees. This creates a field of view of 270 degrees - 135 degrees left and right of the center of the user's screen.

Smaller elements of the project that I am proud of are the inclusion of push/pop matrix, rotaion and translation. I had little experience with these before starting this project and so ensured I included them somewhere. I used these concepts to create generated moons for each planet and have the amount, size and direction of rotation vary from planet to planet. This is the code used:

```Java
	int moonNum = (int)(color/20);
        float direction = 1;

        for(int j = 1; j <= moonNum+1; j++){

            direction = direction *-1;

            ui.fill(30);
            ui.pushMatrix();
            ui.translate(x, y);
            ui.rotate((float)((direction)*(ui.moon - (direction*50))*0.001*ui.TWO_PI));
            ui.ellipse(size,size,ui.width/(50*j),ui.width/(50*j));
            ui.popMatrix();
            if(direction < 0){
                direction = direction - 0.1f;
            }else{
                direction = direction + 0.1f;
            }
        }
```

The first part of this sets the number of moons per planet. This is calculated depending on the color of the given planet. The variable *direction* is set to 1. It is used for changing whether the moon rotates clockwise or anti-clockwise. *pushMatrix()* is used so other screen elements aren't also rotated/translated after. The UI is translates to the planet's center point and then rotated around it. The moon is then drawn and *popMatrix()* is called. The absolute value of direction increases at the end of each pass of the loop So that every second moon does not simply overlap. The size of the moon is *ui.width/(50*j)* so that the size is reduced for each additional moon on the planet. I also used these techniques but very differently when handling the back and forth rotation of the enemy ships. 

Regarding git, while I had an account for many years, lacked proficient skills in using git which made it little use to me. Through this project and module, I have learned to commit, branch, fork, set remotes and much more. I made a very large amount of commits over the course of this project, but it also has enabled me to start using git for other projects such as Android apps that I make as a hobby. While this is not entirely relevant to the SciFi UI, it has been incredibly helpful for my abilty to code and collaborate with friends on other projects.

# SciFi Demo

[![YouTube](http://img.youtube.com/vi/VJkd6LCrGvI/0.jpg)](https://www.youtube.com/watch?v=VJkd6LCrGvI)
