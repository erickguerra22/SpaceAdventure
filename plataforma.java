import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class plataforma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class plataforma extends Suelo
{
    /**
     * Act - do whatever the plataforma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int height;
    private int width;
    public plataforma(int height, int width){
        this.height = height;
        this.width = width;
        getImage().scale(width, height);
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
