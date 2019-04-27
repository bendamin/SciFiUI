package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Ships extends Scene
{
    public Ships(UI ui, float x, float y, float size, float color)
    {
        super(ui, x, y, size, color);
    }  

    public void render()
    {
        ui.fill(color,100,100);
        ui.stroke(100);
        ui.strokeWeight(2);

        ui.pushMatrix();
        ui.rotate(ui.radians(1));
        ui.ellipse(x,y,size*2,size);
        ui.ellipse(x - size , y, size/2, size/2);
        ui.ellipse(x + size , y, size/2, size/2);
        ui.popMatrix();

    }

    public void update(float offsetX, float offsetY)
    {
        x = x + offsetX;

        if(color > 45){
            x = x - (ui.width/200);
        }else{
            x = x + (ui.width/200);
        }

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

        //for values left of 0 mark
        if(x > ui.width*3){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(ui.width*3),(float)(ui.width*4),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3));
            ui.ellipse(mappedX, mappedY, size/5, size/10);
            ui.ellipse(mappedX - (size/10), mappedY, size/15, size/15);
            ui.ellipse(mappedX + (size/10), mappedY, size/15, size/15);
        }
        //for values right of 0 mark
        if(x < ui.width*2){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(0),(float)(ui.width*2),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3),((ui.width/2) - (ui.width/10))+ (ui.width/5));
            ui.ellipse(mappedX, mappedY, size/5, size/10);
            ui.ellipse(mappedX - (size/10), mappedY, size/15, size/15);
            ui.ellipse(mappedX + (size/10), mappedY, size/15, size/15);
        }
    };

}