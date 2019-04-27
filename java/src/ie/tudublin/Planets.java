package ie.tudublin;

import processing.core.PVector;
import processing.core.*;

public class Planets extends Scene
{
    public Planets(UI ui, float x, float y, float size, float color)
    {
        super(ui, x, y, size, color);
    }  

    public void render()
    {
        ui.fill(color,100,100);
        ui.stroke(100);
        ui.strokeWeight(2);
        ui.ellipse(x, y, size, size);

        int moonNum = (int)(color/20);
        float direction = 1;

        for(int j = 1; j <= moonNum+1; j++){

            direction = direction *-1;

            ui.fill(30);
            ui.pushMatrix();
            ui.translate(x, y);
            ui.rotate((float)((direction)*(ui.moon - (direction*50))*0.001*ui.TWO_PI));
            ui.ellipse(size,size,ui.width/(50*j),ui.width/(50*j));
            ui.popMatrix();
            if(direction < 0){
                direction = direction - 0.1f;
            }else{
                direction = direction + 0.1f;
            }
        }

        

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
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(ui.width*3),(float)(ui.width*4),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }
        //for values right of 0 mark
        if(x < ui.width*2){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(0),(float)(ui.width*2),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3),((ui.width/2) - (ui.width/10))+ (ui.width/5));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }
    };

}