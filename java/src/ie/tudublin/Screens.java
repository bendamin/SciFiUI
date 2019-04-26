package ie.tudublin;

import processing.core.PApplet;

public class Screens
{
    private float x;
    private float dx = 1;
    private float y;
    private float sizeX;
    private float sizeY;
    UI ui;

    public Screens(UI ui, float x, float y, float sizeX, float sizeY)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

    }
    
    public void render()
    {
        ui.stroke(255);
        ui.fill(0);
        ui.rect(x, y, sizeX, sizeY);
        ui.fill(255);

        

    }

    public void update()
    {
        //bezel
        ui.strokeWeight(ui.width/50);
        ui.stroke(80);
        ui.line(x,y,x+sizeX, y);
        ui.line(x,y+sizeY,x+sizeX, y+sizeY);
        ui.line(x,y,x,y+sizeY);
        ui.line(x+sizeX,y+sizeY,x+sizeX,y);
        ui.strokeWeight(ui.width/100);
    }
}
