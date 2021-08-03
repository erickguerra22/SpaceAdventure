import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int groundHeight = getImage().getHeight()/2; 
    private int groundWidth = getImage().getWidth()/2;
    int speed = -3;
    int life = 2;
    GifImage image = new GifImage("Alien.gif");
    public Enemy(){
        getImage().mirrorHorizontally();
    }
    public void act()
    {
        setImage(image.getCurrentImage());
        moveAround();
        bounce();
        kill();
        die();
    }
    public void kill(){
        Actor astronauta = getOneIntersectingObject(Astronaut.class);
        if(astronauta!=null){
            astronauta.setLocation(31,34);
            ((SWorld)getWorld()).getCurrentPlayer().loseLife(1);
        }
    }
    public void die(){
        Actor laser = getOneIntersectingObject(Laser.class);
        if(laser != null){
            getWorld().removeObject(laser);
            if(life >0)
                life--;
            else{
                ((SWorld)getWorld()).getCurrentPlayer().addPoints(100);
                getWorld().removeObject(this);
            }
        }
    }
    
    public boolean touchingGround(){
        Actor groundBelow = getOneObjectAtOffset(0,groundHeight+20,Suelo.class);
        if (groundBelow != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void bounce(){
        Actor groundBack = getOneObjectAtOffset(-groundWidth+5,0,Suelo.class);
        Actor groundFront = getOneObjectAtOffset(groundWidth-5,0,Suelo.class);
        if (groundFront!=null){
            speed = -speed;
        }
        if (groundBack!=null){
            speed = -speed;
        }
    }
    
    public void moveAround(){
        if(touchingGround() == false){
            speed = -speed;
        }
        setLocation(getX() + speed, getY());
    }
}
