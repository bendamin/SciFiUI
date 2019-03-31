package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Planets extends Scene
{
    public Planets(UI ui, float x, float y, float peak, float red, float green, float blue, float compassX, float compassY)
    {
        super(ui,  x,  y,  peak, red,  green, blue,compassX, compassY);
    }  

    public void render()
    {
        float temp = compassX;
        if(x - temp < 0){
            //on the left
            temp = (ui.width/90)*(x*-1);

        }else{
            temp = (ui.width/90)*(x);
        }

        ui.fill((int)red, (int)green, (int)blue);
        ui.ellipse(temp,(float)((ui.height/180)*y),peak,peak);
    }

    public void update()
    {
        
    }

}