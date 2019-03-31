package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Planets extends Scene
{
    public Planets(UI ui, float x, float y, float z, float size, float color, float compassX, float compassY)
    {
        super(ui, x, y, z, size, color, compassX, compassY);
    }  

    public void render()
    {
        ui.fill(color,100,100);
        ui.ellipse(x, y, size, size);
    }

    public void update(float offsetX, float offsetY)
    {
        x = x + offsetX;

        if(x > ui.width*4){
            x = 0;
        }

        if(x < 0){
            x = ui.width*4;
        }

        y = y + offsetY;

    }

}