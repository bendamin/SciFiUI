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
    float compassX = 0;
    float compassY = 90;

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
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height * .75f, 50);
        radar = new Radar(this, 1, width / 2, height / 2, 100);
        midscreen = new Screens(this, (width/2) - (width/10), height - (height/4),width/5, height/5);
        leftscreen = new Screens(this,width/10,  height - (height/4), width/4, height/6);
        rightscreen = new Screens(this, width - ((width/10)+(width/4)),  height - (height/4), width/4, height/6);

        target = new Target(this, width, height);
    }

    Radar radar;

    public void draw()
    {
        noStroke();
        background(0);

        if(scene.size() < 40){
            //Mountain mount = new Mountain(this, random(0,width), (float)(height/2.5), random(height/3, height/5), random(70,150), random(30,80), random(25,70));
            //scene.add(mount);
            
            Planets planet = new Planets(this, random(0,360), random(0, 180), random(height/8, height/20), random(0, 255), random(0,255), random(0,255),compassX, compassY);
            scene.add(planet);
            System.out.println("scene");
        };
        
        i = 0;
        while(i < scene.size()){
            if (dist(scene.get(i).x, 0, compassX, 0) < 90){
                scene.get(i).setCompassX(compassX);
                scene.get(i).render();
            }
            
            i++;
        }


        interior.render();
        
        dash.update();
        dash.render();

        
        //b.render();

        //mc.update();
        //mc.render();

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
        

   
    }

    float getCompassX(){
        return compassX;
    }
}

