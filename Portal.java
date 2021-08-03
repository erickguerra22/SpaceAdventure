import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage image = new GifImage("Portal.gif");
    int vSpeed = -4;
    int xSpeed = 2;
    boolean finish = false;
    
    public void act()
    {
        finish();
    }
    
    public void finish(){
        Actor astronauta = getOneIntersectingObject(Astronaut.class);
        if(astronauta!=null){
            getWorld().removeObject(astronauta);
            finish = true;
        }
        if(finish){
            setImage(image.getCurrentImage());
            if(!isAtEdge()){
                setLocation(getX()+xSpeed, getY()+vSpeed);
            }else{
                setImage(new GreenfootImage("Portal.gif"));
                ((SWorld)getWorld()).stopMusic();
                Greenfoot.setWorld(new Finish());
            }
        }
    }
    
    
}
