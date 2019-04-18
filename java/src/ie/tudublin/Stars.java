package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Stars extends Scene
{
    public Stars(UI ui, float x, float y, float size, float color)
    {
        super(ui, x, y, size, color);
    }  

    public void render()
    {
        ui.fill(color);
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

    public void minimap(float compassX, float compassY){
        ui.fill(color,100,100);
        ui.noStroke();

        if(ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) > ((ui.width/2) - (ui.width/10)) && ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) <(ui.width/2) - (ui.width/10) + (ui.width/5)){
            if(ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) >  ui.height - (ui.height/4) && ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) < ui.height - (ui.height/4) + ui.height/5){
                ui.ellipse(ui.map(x,0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)), ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5), size/10, size/10);
            }
        }
        

    };

}