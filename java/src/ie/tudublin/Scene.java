package ie.tudublin;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.*;

public abstract class Scene
{

    UI ui;
    float x;
    float y;
    float size;
    float color;

    public Scene(UI ui, float x, float y, float size, float color)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;;
    }

    public abstract void update(float x, float y);

    public abstract void render();

    public abstract void minimap(float compassX, float compassY);

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the color
     */
    public float getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(float color) {
        this.color = color;
    }
    
}