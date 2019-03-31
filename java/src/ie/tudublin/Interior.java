package ie.tudublin;

import processing.core.PApplet;

public class Interior
{
    private float x;
    private float dx = 1;
    private float y;
    private float sizeX;
    private float sizeY;
    UI ui;

    public Interior(UI ui,float sizeX, float sizeY)
    {
        this.ui = ui;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

    }
    
    public void render()
    {

        ui.fill(0,0,255,40);
        ui.rect(0, 0, sizeX, sizeY);

        /*
        ui.stroke(255);
        ui.fill(0);
        ui.rect(x, y, sizeX, sizeY);
        ui.fill(255);
        // Static field
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text("Screen", x + (sizeX/2), y + (sizeY/2)); */

    }

    public void update()
    {
        //x += dx;
        //if ((x > ui.width - radius) || (x < radius))
        //{
        //    dx *= -1;
        //}
    }
}
