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
        ui.fill(60, 70, 45, 40);
        ui.rect(0, 0, sizeX, sizeY);
    }

    public void update()
    {

    }
}
