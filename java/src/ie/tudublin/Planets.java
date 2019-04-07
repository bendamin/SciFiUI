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

    public void minimap(){
        ui.fill(color,100,100);
        ui.noStroke();

        if(ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) > ((ui.width/2) - (ui.width/10)) && ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) <(ui.width/2) - (ui.width/10) + (ui.width/5)){
            if(ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) >  ui.height - (ui.height/4) && ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) < ui.height - (ui.height/4) + ui.height/5){
                ui.ellipse(ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)), ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5), size/10, size/10);
            }
        }
        

    };

}