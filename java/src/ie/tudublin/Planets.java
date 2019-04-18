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

    public void minimap(float compassX,float compassY){
        ui.fill(color,100,100);
        ui.noStroke();

        /*if(ui.map(x+((ui.width/2)*3),0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) > ((ui.width/2) - (ui.width/10)) && ui.map(x+((ui.width/2)*3)+((ui.width/2)*3),0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)) <(ui.width/2) - (ui.width/10) + (ui.width/5)){
            if(ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) >  ui.height - (ui.height/4) && ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5) < ui.height - (ui.height/4) + ui.height/5){
                ui.ellipse(ui.map(x+((ui.width/2)*3),0,ui.width*4,(ui.width/2) - (ui.width/10),(ui.width/2) - (ui.width/10) + (ui.width/5)), ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5), size/10, size/10);
            }
        }*/

        /*if(ui.dist(x,0,ui.width/2,0) < ui.width*2 || ui.dist(x,0,360,0) > ){
            if(ui.dist(0,y,0,ui.height/2) < ui.height){
                ui.ellipse(ui.map(x,(float)(ui.width*-1.5),(float)(ui.width*2.5),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ (ui.width/5)),ui.map(y,0 - (float)(ui.height/2), (float)(ui.height*3/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + (ui.height/5)),size/10,size/10);
            }
        }*/

        //for values left of 0 mark
        if(x > ui.width*3){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(ui.width*3),(float)(ui.width*4),(ui.width/2) - (ui.width/10),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }

        if(x < ui.width*2){
            float mappedY = ui.map(y,-ui.height - (float)(ui.height/2), (float)(ui.height*5/2),ui.height - (ui.height/4), ui.height - (ui.height/4) + ui.height/5);
            float mappedX = ui.map(x,(float)(0),(float)(ui.width*2),((ui.width/2) - (ui.width/10))+ ((ui.width/5)/3),((ui.width/2) - (ui.width/10))+ (ui.width/5));
            ui.ellipse(mappedX, mappedY, size/10, size/10);
        }

       
        

    };

}