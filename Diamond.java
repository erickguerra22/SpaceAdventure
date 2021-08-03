import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Actor
{
    /**
     * Act - do whatever the Diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage image = new GifImage("Diamante.gif");
    public void act()
    {
        setImage(image.getCurrentImage());
        atrapado();
    }
    
    public void atrapado(){
        Actor astronauta = getOneIntersectingObject(Astronaut.class);
        if(astronauta!=null){
            ((SWorld)getWorld()).getCurrentPlayer().addDiamond();
            ((SWorld)getWorld()).getCurrentPlayer().addPoints(50);
            getWorld().removeObject(this);
        }
    }
}
