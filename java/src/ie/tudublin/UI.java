package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Screens midscreen;
    Screens leftscreen;
    Screens rightscreen;
    Target target;
    Dashboard dash;
    Interior interior;

    int i = 0;

    public ArrayList<Scene> scene = new ArrayList<Scene>(); 


    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        //colorMode(HSB);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(P3D); 
    }

    public void setup()
    {
        interior = new Interior(this, width, height);
        dash = new Dashboard(this, width, height);
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, width / 2, height / 2, 100);
        midscreen = new Screens(this, (width/2) - (width/10), height - (height/4),width/5, height/5);
        leftscreen = new Screens(this,width/10,  height - (height/4), width/4, height/6);
        rightscreen = new Screens(this, width - ((width/10)+(width/4)),  height - (height/4), width/4, height/6);

        target = new Target(this, width, height);
    }

    Radar radar;

    public void draw()
    {
        background(255);

        interior.render();
        
        dash.update();
        dash.render();

        
        b.render();

        mc.update();
        mc.render();

        midscreen.update();
        midscreen.render();

        leftscreen.update();
        leftscreen.render();

        rightscreen.update();
        rightscreen.render();

        radar.update();
        radar.render();

        target.update();
        target.render();



        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }

        if(scene.size() < 5){
            Mountain mount = new Mountain(this, width, height/2, random(0,height/3), 150, 80, 40);
            scene.add(mount);
            System.out.println("scene");
        };

        while(i < scene.size()){
            scene.get(i).render();
            i++;
        }
    }
}

