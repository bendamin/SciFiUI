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

    public void minimap(){
        ui.fill(color,100,100);
        ui.noStroke();

        //for values left of 0 mark
        if(x > ui.width*3){
            float mappedY = ui.map(y,-ui.height*3, (float)(ui.height*4),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(ui.width*3),(float)(ui.width*4),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3));
            ui.fill(100);
            if(mappedY > ui.height - (ui.height/4) && mappedY < (ui.height - (ui.height/4) + ui.height/5) ){
                ui.ellipse(mappedX, mappedY, 2, 2);
            }
        }
        //for values right of 0 mark
        if(x < ui.width*2){
            float mappedY = ui.map(y,-ui.height*3, (float)(ui.height*4),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(0),(float)(ui.width*2),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3),((ui.width/2) - (ui.width/10))+ (ui.width/5));
            ui.fill(100);
            if(mappedY > ui.height - (ui.height/4) && mappedY < (ui.height - (ui.height/4) + ui.height/5) ){
                ui.ellipse(mappedX, mappedY, 2, 2);
            }
        }

    };

}