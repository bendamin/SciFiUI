package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Mountain extends Scene
{
    public Mountain(UI ui, float x, float y, float peak, float red, float green, float blue)
    {
        super(ui,  x,  y,  peak, red,  green, blue);
    }  

    public void render()
    {
        ui.fill((int)red, (int)green, (int)blue);
        ui.triangle(x, y - (y/5), x + x, y - (y/5), x + (x/2), peak);
    }

    public void update()
    {
        
    }

}