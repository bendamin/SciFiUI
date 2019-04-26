package ie.tudublin;

import processing.core.PApplet;

public class Target
{
    private float width;
    private float height;
    private float middleX;
    private float middleY;
    private float viewfinderX;
    private float viewfinderY;
    private String locked;
    private float finder;
    private String weapon;

    UI ui;

    public Target(UI ui, float width,float height)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
        this.middleX = width/2;
        this.middleY = height/2;
        this.viewfinderX = width/12;
        this.viewfinderY = height/12;
        this.locked = "No Target";
        this.finder = 96;
        this.weapon = ui.weapon;

    }
    
    public void render()
    {
        ui.stroke(finder,100,100);
        ui.noFill();
        //reticle
        ui.ellipse(middleX,middleY, width/3, height/3);
        ui.ellipse(middleX, middleY, viewfinderX, viewfinderY);

        //crosshair
        ui.line(middleX - (width/5), middleY, middleX + (width/5), middleY);
        ui.line(middleX, middleY - (height/5), middleX, middleY + (height/5));

        //target box and text
        ui.rect(middleX - (width/20), height/5, width/10, height/15);
        ui.fill(finder,100,100);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(weapon + "\n"+locked, middleX, (height/5) + (height/30));

        
        ui.fill(255);

    }

    public void update(boolean sight)
    {
        //check if target locked
        if(sight){
            this.finder = 20;
            this.locked = "Lock On";
        }else{
            this.finder = 96;
            this.locked = "No Target";
        }

        this.weapon = ui.weapon;
    }
}
