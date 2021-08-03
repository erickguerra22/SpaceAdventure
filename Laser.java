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
        onBorders();
        move(speed);
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void onBorders(){
        if(isAtEdge()==true)
            getWorld().removeObject(this);
    }
}
