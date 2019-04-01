package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    Screens midscreen;
    Screens leftscreen;
    Screens rightscreen;
    Target target;
    Dashboard dash;
    Interior interior;
    boolean sight = false;
    boolean firing = false;
    boolean lazer = false;

    int i = 0;
    int level = 1;
    int m = 0;

    float compassX = 0;
    float compassY = 0;

    public ArrayList<Scene> scene = new ArrayList<Scene>(); 


    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
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
        radar = new Radar(this, 1, width / 2, height / 2, 100);
        midscreen = new Screens(this, (width/2) - (width/10), height - (height/4),width/5, height/5);
        leftscreen = new Screens(this,width/10,  height - (height/4), width/4, height/6);
        rightscreen = new Screens(this, width - ((width/10)+(width/4)),  height - (height/4), width/4, height/6);
        target = new Target(this, width, height);

        while(i < (level * 100)){
            Planets planet = new Planets(this, random(0,width*4), random(0 - height, height*2), 0, random(width/20, width/10),random(0,100), compassX, compassY);
            scene.add(planet);
            i++;
        }
    }

    Radar radar;

    public void draw()
    {
        colorMode(HSB, 100);
        noStroke();
        background(0);

        //let cx = 30;

        //all between 345 and 75 visible

        for(int j = 0; j < scene.size(); j++){
                scene.get(j).render();
        }


        interior.render();
        
        dash.update();
        dash.render();

        midscreen.update();
        midscreen.render();

        leftscreen.update();
        leftscreen.render();

        rightscreen.update();
        rightscreen.render(); 

        radar.update();
        radar.render();

        target.update(sight);
        target.render();

        info();
        beam();

        if(lazer == true){
            fill(96,100,100);
            ellipse(width/2, height/2, m, m);
            if(m > width/12){
                fill(0,0,100);
                lazer = false;
                rect(0,0, width, height);
            }
        }
        m = m + width/80;


        if (checkKey(LEFT))
        {
            for(int j = 0; j < scene.size(); j++){
                scene.get(j).update(5,0);
            }
            compassX = compassX - 5;
            
            System.out.println("Left arrow key pressed");
        }

        if (checkKey(RIGHT))
        {
            for(int j = 0; j < scene.size(); j++){
                scene.get(j).update(-5,0);
            }

            compassX = compassX + 5;


            System.out.println("Right arrow key pressed");
        }

        if (checkKey(UP))
        {
            if(compassY < height){
                for(int j = 0; j < scene.size(); j++){
                    scene.get(j).update(0,5);
                }
                compassY = compassY + 5;
            }

            System.out.println("Up arrow key pressed");
        }

        if (checkKey(DOWN))
        {
            if(compassY > 0 - height){
                for(int j = 0; j < scene.size(); j++){
                    scene.get(j).update(0,-5);
                }
                compassY = compassY - 5;
            }

            System.out.println("Up arrow key pressed");
        }

        if (checkKey(' '))
        {
            if(sight){
                firing = true;
            }
            System.out.println("Space key pressed");
        }
        

   
    }

    public void info(){
        //display co-ords
        fill(0,0,100);
        textAlign(PApplet.CENTER, PApplet.CENTER);

        float cordX = map(compassX, 0, height*4, 0, 360);

        //to allow for multiple rotations, a while loop is used
        while(cordX > 360){
            cordX = cordX - 360;
        }

        while(cordX < 0){
            cordX = 360 + cordX;
        }

        String displayX = Float.toString(cordX);
        String displayY = Float.toString(map(compassY,-height, height, 0, 180));
        text("Current Ship Direction:\nShip is heading: " + displayX + "\nWith an incline of: " + displayY, (width/10) + (width/8), (height - (height/4)) + (height/12));


        //middle screen


        //right screen
        // width - ((width/10)+(width/4)),  height - (height/4), width/4, height/6
        fill(0,0,100);
        textAlign(PApplet.CENTER, PApplet.CENTER);
        text("Targets Remaining:\nPlanets:" + Integer.toString(scene.size()), (width - ((width/10)+(width/4))) + (width/8),height - (height/4)  + (height/12));
    }

    void beam(){
        sight = false;

        

        for(int j = 0; j < scene.size(); j++){
            if (dist(width/2, height/2, scene.get(j).x,scene.get(j).y) < width/12){
                sight = true;
                m = 0;
                lazer = true;
                if(firing == true){
                    scene.remove(j);
                }
            }
        }
        firing = false;
        
    }
}

