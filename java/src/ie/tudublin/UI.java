package ie.tudublin;

import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

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
    boolean explode = false;
    String weapon = "Lazer";

    int planetsNum = 0;
    int starNum = 0;
    int shipNum = 0;
    int level = 1;
    float ammo = 0;

    float explosionSize = 0;
    float explosionColor = 89;

    float compassX = 0;
    float compassY = 0;
    float angle = 0;
    float moon = 0;
    boolean addAngle;

    float backgroundColor;

    float halfWidth = 0;
    float halfHeight = 0;

    //middlescreen variables
    float midStart = 0;
    float midWidth = 0;
    float midHeight = 0;
    float midTop = 0;

    //leftscreen variables
    float leftStart = 0;
    float leftWidth = 0;
    float leftHeight = 0;
    float leftTop = 0;

    //leftscreen variables
    float rightStart = 0;
    float rightWidth = 0;
    float rightHeight = 0;
    float rightTop = 0;


    public ArrayList<Scene> scene = new ArrayList<Scene>();
    public ArrayList<Scene> stars = new ArrayList<Scene>();
    public ArrayList<Scene> ships = new ArrayList<Scene>();
    
    private ArrayList<String> planetNames = new ArrayList<String>();


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
    }

    public void setup()
    {

        loadName();

        halfWidth = width/2;
        halfHeight = height/2;

        //middlescreen variables
        midStart = (width/2) - (width/10);
        midWidth = width/5;
        midHeight = height/5;
        midTop = height - (height/4);

        //leftscreen variables
        leftStart = width/10;
        leftWidth = width/4;
        leftHeight = height/6;
        leftTop = height - (height/4);

        //leftscreen variables
        rightStart = width - ((width/10)+(width/4));
        rightWidth = width/4;
        rightHeight = height/6;
        rightTop = height - (height/4);


        interior = new Interior(this, width, height);
        dash = new Dashboard(this, width, height);
        midscreen = new Screens(this, midStart, midTop, midWidth, midHeight);
        leftscreen = new Screens(this,leftStart,  leftTop, leftWidth, leftHeight);
        rightscreen = new Screens(this, rightStart, rightTop, rightWidth, rightHeight);
        target = new Target(this, width, height);
    }

    void loadName(){
        Table table = new Table();

        table = loadTable("planets.csv","header");
        
        for(TableRow row : table.rows()){
            String name = row.getString("name");

            planetNames.add(name);
        }
    }

    void planetName(){
        strokeWeight(2);
        stroke(100);
        fill(10);
        rect(width/11,0,width-((width/11)*2),height/20);
        fill(100);
        stroke(100);
        text("Use Your Cursor to Identify Planets",width/2,height/40);

        for(int j = 0; j < scene.size(); j++){
            
            if (dist(mouseX, mouseY, scene.get(j).x,scene.get(j).y) < ((scene.get(j).size)/2)){
                stroke(100);
                fill(10);
                rect(width/11,0,width-((width/11)*2),height/20);
                fill(100);
                stroke(100);
                text("Planet Detected: "+planetNames.get(j),width/2,height/40);
            }
        }
    }

    public void mouseClicked(){
        backgroundColor = random(0,100);
        System.out.println("Background Color changed");
    }

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

    void createPlanets(){
        while(planetsNum < (level * 10)){
            Planets planet = new Planets(this, random(0,width*4), random(0 - (float)(halfWidth), (float)(halfWidth*3)), random(width/20, width/10),random(0,100));
            scene.add(planet);
            planetsNum++;
        }
    }

    void createStars(){
        while(starNum < (200)){
            Stars star = new Stars(this, random(0,width*4), random(0 - (float)(height*3), (float)(height*4)), random(2,10), 100);
            stars.add(star);
            starNum++;
        }
    }

    void createShips(){
        while(shipNum < (level *3)){
            Ships ship = new Ships(this, random(0,width*4), random(0 - (float)(halfWidth), (float)(halfWidth*3)), random(width/15, width/10),random(0,100));
            ships.add(ship);
            shipNum++;
        }
    }

    void drawStars(){
        for(int l = 0; l < stars.size(); l++){
            stars.get(l).render();
        }
    }

    void drawScene(){
        for(int j = 0; j < scene.size(); j++){
            scene.get(j).render();
        }
    }

    void drawShips(){
        for(int j = 0; j < ships.size(); j++){
            ships.get(j).update(0,0);
            ships.get(j).render();
        }
    }

    void drawCursor(){
        noFill();
        rect(mouseX - (width/40),mouseY - (height/40),width/20,height/20);
    }

    void roundNum(){
        textSize(height/20);
        fill(20);
        text("Galaxy Complexity:"+Integer.toString(level), halfWidth-(width/200),(halfHeight)/7);

        fill(90,100,100);
        text("Galaxy Complexity:"+Integer.toString(level), halfWidth,(halfHeight)/7);

        textSize(height/60);
        text("Lazer: 1         Missile: 2         Sentry: 3", halfWidth,(halfHeight)/4);
    }

    void clock(){
        LocalTime hour = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
        fill(0);
        stroke(100);
        strokeWeight(3);
        rect((halfWidth)-width/10, height - (float)(height/3.2), width/5, height/20);

        fill(25,100,80);
        stroke(25,100,80);

        text(hour.toString(),halfWidth,(height - (float)(height/3.2))+(height/40)); 
    }

    void weaponAnimation(){
        if(firing == true){
            if(weapon.equals("Lazer")){
                fill(96,40,100);
                ellipse(width/2, height/2, ammo, ammo);
                ammo = (width/12) + (random((-width/100),(width/100)));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(3,6), random(3,6));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(6,12), random(6,12));
                ellipse(halfWidth + random(-width/20,width/20),halfHeight + random(-height/20,height/20), random(12,15), random(12,15));

            }

            if(weapon.equals("Missile")){
                fill(50);
                ellipse((halfWidth) + (random(-width/150,width/150)), (halfHeight + (random((-width/150),(width/150)))), ammo, ammo);
                ammo = (width/30) + (random((-width/200),(width/200)));
            }

            if(weapon.equals("Sentry")){
                fill(50);
                ellipse((halfWidth) + (random(-width/80,width/80)), (halfHeight + (random((-width/80),(width/80)))), ammo, ammo);
                ammo = (width/100) + (random((-width/150),(width/150)));
            }
            firing = false;
        }
    }

    void blowup(){
        if(explode){
            fill(explosionColor,100,100);
            ellipse(halfWidth, halfHeight, explosionSize, explosionSize);
            explosionSize = explosionSize + width/20;
            explosionColor = (float)(explosionColor + 0.2);

            ellipse(halfWidth + random(-width/3,width/3),halfHeight + random(-height/3,height/3), random(10,15), random(10,15));
            ellipse(halfWidth + random(-width/3,width/3),halfHeight + random(-height/3,height/3), random(15,20), random(15,20));
            ellipse(halfWidth + random(-width/3,width/3),halfHeight + random(-height/3,height/3), random(20,25), random(20,25));

            if(explosionSize > width/2){
                explode = false;
            }
        }else{
            if(weapon.equals("Lazer")){
                explosionColor = 89;
            }

            if(weapon.equals("Missile")){
                explosionColor = 0;
            }

            if(weapon.equals("Sentry")){
                explosionColor = 70;
            }
            
            explosionSize = width/30;
        }

    }

    public void nextRound(){

        if(scene.size() == 0 && ships.size() == 0 && level < 10){
            planetsNum = 0;
            starNum = 0;
            shipNum = 0;
            level = level + 1;
            compassX = 0;
            compassY = 0;
        }
    }

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

        String displayX = Integer.toString((int)cordX);
        String displayY = Integer.toString((int)(map(compassY,-height, height, 0, 180)));
        text("Current Ship Direction:\n\nHorizontal Angle: " + displayX + "°\nWith Incline of: " + displayY + "°\nGalaxy Number:" + level, leftStart + (leftWidth/2), leftTop + (leftHeight/2));


        //middle screen
        for(int j = 0; j < stars.size(); j++){
            stars.get(j).minimap();
        }

        for(int j = 0; j < scene.size(); j++){
            scene.get(j).minimap();
        }

        for(int j = 0; j < ships.size(); j++){
            ships.get(j).minimap();
        }
        
        stroke(92,100,100);
        fill(92,100,100);
        strokeWeight(1);
        ellipse(halfWidth, midTop + (midHeight/2), 10, 10);
        line(halfWidth, midTop, halfWidth, midTop + midHeight);
        line(midStart, midTop + (midHeight/2), midStart + midWidth , midTop + (midHeight/2));


        //right screen
        fill(0,0,100);
        textAlign(PApplet.CENTER, PApplet.CENTER);
        text("Targets Remaining:\nPlanets:" + Integer.toString(scene.size())+"\nEnemies:" + Integer.toString(ships.size()), rightStart + (rightWidth/2),rightTop + (rightHeight/2));
    }

    void destroy(){
        sight = false;

        

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

        for(int j = 0; j < ships.size(); j++){
            if (dist(width/2, height/2, ships.get(j).x,ships.get(j).y) < width/12){
                sight = true;
                if(firing == true){
                    explode = true;
                    ships.remove(j);
                }
            }
        }
        
    }

    public void screenBezel(){
        leftscreen.update();
        midscreen.update();
        rightscreen.update();
    }

    public void userInput(){
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

        if (checkKey(RIGHT))
        {
            for(int j = 0; j < scene.size(); j++){
                scene.get(j).update(-5,0);
            }

            for(int j = 0; j < ships.size(); j++){
                ships.get(j).update(-5,0);
            }

            for(int j = 0; j < stars.size(); j++){
                stars.get(j).update(-5,0);
            }

            compassX = compassX + 5;


            System.out.println("Right arrow key pressed");
        }

        if (checkKey(UP))
        {
            if(compassY < height){
                for(int j = 0; j < scene.size(); j++){
                    scene.get(j).update(0,(height/160));
                }

                for(int j = 0; j < ships.size(); j++){
                    ships.get(j).update(0,(height/160));
                }

                for(int j = 0; j < stars.size(); j++){
                    stars.get(j).update(0,(height/160));
                }
                compassY = compassY + (height/160);
            }

            System.out.println("Up arrow key pressed");
        }

        if (checkKey(DOWN))
        {
            if(compassY > (0 - height)){
                for(int j = 0; j < scene.size(); j++){
                    scene.get(j).update(0,-(height/160));
                }

                for(int j = 0; j < ships.size(); j++){
                    ships.get(j).update(0,-(height/160));
                }

                for(int j = 0; j < stars.size(); j++){
                    stars.get(j).update(0,-(height/160));
                }
                compassY = compassY - (height/160);
            }

            System.out.println("Up arrow key pressed");
        }

        if (checkKey(' '))
        {
            firing = true;
            
            System.out.println("Space key pressed");
        }

        if (checkKey('1'))
        {
            weapon = "Lazer";
        }

        if (checkKey('2'))
        {
            weapon = "Missile";
        }

        if (checkKey('3'))
        {
            weapon = "Sentry";
        }
    }
}

