package ie.tudublin;

import processing.core.PApplet;

public class Dashboard
{
    private float width;
    private float height;
    private float sizeX;
    private float sizeY;
    UI ui;

    public Dashboard(UI ui, float width,float height)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
        this.sizeX = width/10;

    }
    
    public void render()
    {
        ui.noStroke();
        ui.fill(50);

        //bottom section
        ui.rect(width/10,height -((height/3) - (height/20)) , width - (width/5), height/3);
        ui.triangle(width/10, height - ((height/3) - (height/20)), width/10, height, 0 - (width/3), height);
        ui.triangle(width - (width/10), height -((height/3) - (height/20)),width - (width/10), height, width + (width/3), height);

        //top section
        ui.rect(width/10,0, width - (width/5), height/7);
        ui.triangle(width/10, height/7, width/10, 0, 0 - (width/3), 0);
        ui.triangle(width - (width/10), height/7,width - (width/10), 0, width + (width/3), 0);

        
        ui.fill(255);

    }

    public void update()
    {

    }
}
