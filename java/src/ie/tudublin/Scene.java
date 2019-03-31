package ie.tudublin;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.*;

public abstract class Scene
{
    protected PVector pos;
    protected float peak;
    protected float speed;
    protected float x;
    protected float y;
    protected float compassX;
    protected float compassY;
    protected float red;
    protected float green;
    protected float blue;
    UI ui;

    public Scene(UI ui, float x, float y, float peak, float red, float green, float blue, float compassX, float compassY)
    {
        this.ui = ui;
        this.peak = peak;
        this.x = x;
        this.y = y;
        this.red = red;
        this.green = green;
        this.blue = blue;
        pos = new PVector(x, y); 
        this.compassX = compassX;
        this.compassY = compassY;
    }

    public abstract void update();

    public abstract void render();

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the peak
     */
    public float getPeak() {
        return peak;
    }

    /**
     * @param peak the peak to set
     */
    public void setPeak(float peak) {
        this.peak = peak;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
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
     * @return the red
     */
    public float getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * @return the green
     */
    public float getGreen() {
        return green;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * @return the blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

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
     * @param red the red to set
     */
    public void setRed(float red) {
        this.red = red;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(float green) {
        this.green = green;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(float blue) {
        this.blue = blue;
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