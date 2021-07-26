import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class suelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo extends Actor
{
    /**
     * Act - do whatever the suelo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int height;
    private int width;
    
    public Suelo(){
        this.height = getImage().getHeight();
        this.width = getImage().getWidth();
    }
    public void act()
    {
        // Add your action code here.
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getWidth(){
        return this.width;
    }
}
