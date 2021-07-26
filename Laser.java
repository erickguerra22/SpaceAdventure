import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    private int speed;
    public void act()
    {
        move(speed);
        onBorders();
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void onBorders(){
        if(getX() == 0 || getX() == getWorld().getWidth()-1)
            getWorld().removeObject(this);
    }
}
