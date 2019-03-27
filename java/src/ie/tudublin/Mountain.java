package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Mountain extends Scene
{
    public Mountain(UI ui, float x, float y, float peak, int red, int green, int blue)
    {
        super(ui,  x,  y,  peak, red,  green,blue);
    }  

    public void render()
    {
        System.out.println("it worked");
    }

    public void update()
    {
        
    }

}