package ie.tudublin;

import processing.core.PApplet;

public class Target
{
    private float width;
    private float height;
    private float middleX;
    private float middleY;
    private float crosshairX;
    private float crosshairY;
    private float viewfinderX;
    private float viewfinderY;
    private String locked;
    private float finder;

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
        this.crosshairX = (width/80);
        this.crosshairY = (height/80);
        this.locked = "No Target";
        this.finder = 96;

    }
    
    public void render()
    {
        ui.stroke(finder,100,100);
        ui.noFill();
        ui.ellipse(middleX,middleY, width/3, height/3);
        ui.ellipse(middleX, middleY, viewfinderX, viewfinderY);

        ui.line(middleX - (width/5), middleY, middleX + (width/5), middleY);
        ui.line(middleX, middleY - (height/5), middleX, middleY + (height/5));

        ui.rect(middleX - (width/20), height/4, width/10, height/30);
        ui.fill(finder,100,100);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(locked, middleX, (height/4) + (height/60));

        
        ui.fill(255);

    }

    public void update(boolean sight)
    {
        if(sight){
            this.finder = 20;
            this.locked = "Lock On";
        }else{
            this.finder = 96;
            this.locked = "No Target";
        }
    }
}
