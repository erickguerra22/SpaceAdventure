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
    int speed = -3;
    int life = 2;
    //int count = 0;
    public Enemy(){
        getImage().mirrorHorizontally();
    }
    public void act()
    {
        //count++;
        moveAround();
        kill();
        die();
    }
    public void kill(){
        Actor astronauta = getOneIntersectingObject(Astronaut.class);
        if(astronauta!=null){
            ((Mlendo)getWorld()).getPlayer1().loseLife(1);
            astronauta.setLocation(31,34);
        }
    }
    public void die(){
        Actor laser = getOneIntersectingObject(Laser.class);
        if(laser != null){
            getWorld().removeObject(laser);
            if(life >0)
                life--;
            else{
                ((Mlendo)getWorld()).getPlayer1().addPoints(5);
                getWorld().removeObject(this);
            }
        }
    }
    
    public void moveAround(){
        if(!isTouching(Suelo.class)){
            speed = -speed;
            getImage().mirrorHorizontally();
        }
        setLocation(getX() + speed, getY());
    }
}
