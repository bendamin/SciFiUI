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
    float z;
    float size;
    float color;
    float compassX;
    float compassY;
    boolean visible;

    public Scene(UI ui, float x, float y, float z, float size, float color, float compassX, float compassY)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.color = color;
        this.visible = false;
        this.compassX = compassX;
        this.compassY = compassY;
    }

    public abstract void update(float x, float y);

    public abstract void render();

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
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
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

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the compassX
     */
    public float getCompassX() {
        return compassX;
    }

    /**
     * @param compassX the compassX to set
     */
    public void setCompassX(float compassX) {
        this.compassX = compassX;
    }

    /**
     * @return the compassY
     */
    public float getCompassY() {
        return compassY;
    }

    /**
     * @param compassY the compassY to set
     */
    public void setCompassY(float compassY) {
        this.compassY = compassY;
    }
    
}