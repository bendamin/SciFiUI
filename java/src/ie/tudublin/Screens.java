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
        // Static field
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text("Screen", x + (sizeX/2), y + (sizeY/2));

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
