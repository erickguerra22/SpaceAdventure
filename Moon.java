import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moon extends Actor
{
    /**
     * Act - do whatever the Moon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int height;
    private int width;
    public Moon(int height, int width){
        this.height = height;
        this.width = width;
        getImage().scale(width, height);
    }
    public void act()
    {
    }
}
