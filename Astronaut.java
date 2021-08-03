import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Astronaut extends Actor
{
    private double vSpeed;
    private boolean isMoving = false;
    private int lookingTo = 0;
    private boolean isFlying = false;
    private boolean isFalling = true;
    private int skytime = 0;
    private int gravity;
    private boolean spacePressed = false;
    private int lifes = 3;
    private int score = 0;
    private int diamonds = 0;
    private int groundHeight = getImage().getHeight()/2; 
    private int groundWidth = getImage().getWidth()/2;
    GifImage goingFront = new GifImage("Astronauta caminando.gif");
    GifImage goingBack = new GifImage("Astronauta retrosediendo.gif");
    GifImage flying1 = new GifImage("Astronauta volando1.gif");
    GifImage flying2 = new GifImage("Astronauta volando2.gif");
    GifImage flyingFront = new GifImage("Astronauta volando adelante.gif");
    GifImage flyingBack = new GifImage("Astronauta volando atras.gif");
    GifImage fallingFront = new GifImage("Astronauta avanzando en caida.gif");
    GifImage fallingBack = new GifImage("Astronauta retrosediendo en caida.gif");

    public void act()
    {
        setImages();
        fly();
        bounce();
        fall();
        walk();
        shoot();
        die();
    }

    public void shoot(){
        List<Laser> lasers = new ArrayList();
        for(Object obj: getWorld().getObjects(Laser.class)){
            lasers.add((Laser)obj);
        }
        if (lasers.size() < 3){
            Laser laser = new Laser();
            if(lookingTo == 0)
                laser.setSpeed(5);
            else
                laser.setSpeed(-5);
            if(Greenfoot.isKeyDown("space") && spacePressed == false){
                getWorld().addObject(laser, getX(), getY());
                spacePressed = true;
            }else if(!Greenfoot.isKeyDown("space"))
                spacePressed = false;      
        }
    }

    public void fly(){
        gravity = (int)((SWorld)getWorld()).getGravity();
        int elevation = 10 - (gravity*10);
        elevation = (elevation >= 1) ? elevation : 1;
        if(Greenfoot.isKeyDown("up")){
            if(skytime>0){
                setLocation(getX(),getY()-(int)elevation/2);
                vSpeed = 0;
                isFalling = false;
                isMoving = true;
                isFlying = true;
                skytime-=(gravity*20 >= 1) ? gravity*20 : 1 ;
            }else{
                isFalling = true;
                isFlying = false;
            }
        }
    }

    public void walk(){
        if(Greenfoot.isKeyDown("right")){
            move(4);
            isMoving = true;
            lookingTo = 0;
        }else if(Greenfoot.isKeyDown("left")){
            move(-4);
            isMoving = true;
            lookingTo = 1;
        }
    }
    
    public int[] touchingGround(){
        int[] info = new int[2];
        Actor groundBelow = getOneObjectAtOffset(0,groundHeight+5,Suelo.class);
        if ((groundBelow != null) && (isFlying == false)){
            int groundTop = groundBelow.getY() - ((Suelo)groundBelow).getHeight()/2;
            info[0] = 1;
            info[1] = groundTop - groundHeight;
            return info;
        }else{
            info[0] = 0;
            info[1] = getY();
            return info;
        }
    }
    
    public void bounce(){
        Actor groundAbove = getOneObjectAtOffset(0,-groundHeight-5,Suelo.class);
        Actor groundBack = getOneObjectAtOffset(-groundWidth+5,0,Suelo.class);
        Actor groundFront = getOneObjectAtOffset(groundWidth-5,0,Suelo.class);
        if(groundAbove != null){
            int groundBottom = groundAbove.getY() + ((Suelo)groundAbove).getHeight()/2;
            setLocation(getX(), groundBottom + groundHeight);
        }
        if (groundFront!=null){
            int groundRight = ((Suelo)groundFront).getWidth();
            int xPosition = groundFront.getX() - ((groundRight-10) + getImage().getWidth())/2;
            setLocation(xPosition, getY());
        }
        if (groundBack!=null){
            int groundLeft = ((Suelo)groundBack).getWidth();
            int xPosition = groundBack.getX() + ((groundLeft-10) + getImage().getWidth())/2;
            setLocation(xPosition, getY());
        }
    }

    public void fall(){
        if(touchingGround()[0] == 1){
            gravity = (int)((SWorld)getWorld()).getGravity();
            vSpeed = 0;
            isFalling = false;
            skytime = (100-(gravity*100))/2;
            skytime = (skytime >= 50) ? skytime : 50;
            setLocation(getX(), touchingGround()[1]);
        }else{
            vSpeed += ((SWorld)getWorld()).getGravity();
            setLocation(getX(), getY()+(int)vSpeed);
            isFalling = true;
        }
    }
    
    public void die(){
        if(lifes == 0){
            ((SWorld)getWorld()).stopMusic();
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void setImages(){
        if(isMoving == true && lookingTo == 0 && isFlying == true){
            if(Greenfoot.isKeyDown("right"))
                setImage(flyingFront.getCurrentImage());
            else
                setImage(flying1.getCurrentImage());
            isMoving = false;
            isFlying = false;
        }
        else if(isMoving == true && lookingTo == 1 && isFlying == true){
            if(Greenfoot.isKeyDown("left"))
                setImage(flyingBack.getCurrentImage());
            else
                setImage(flying2.getCurrentImage());
            isMoving = false;
            isFlying = false;
        }
        else if(isMoving == true && lookingTo == 0){
            if(isFalling == true)
                setImage(fallingFront.getCurrentImage());
            else
                setImage(goingFront.getCurrentImage());
            isMoving = false;
            isFalling = false;
        }
        else if(isMoving == true && lookingTo == 1){
            if(isFalling == true)
                setImage(fallingBack.getCurrentImage());
            else
                setImage(goingBack.getCurrentImage());
            isMoving = false;
            isFalling = false;
        }
        else if (isMoving == false && lookingTo == 0){
            setImage(new GreenfootImage("Astronauta parado.png"));
        }
        else if(isMoving == false && lookingTo == 1){
            setImage(new GreenfootImage("Astronauta de espalda.png"));
        }
    }
    public void setVSpeed(int vSpeed){
        this.vSpeed = vSpeed;
    }

    public int getScore(){
        return this.score;
    }

    public void addPoints(int points){
        ((Score) getWorld().getObjects(Score.class).get(0)).add(points);
    }
    
    public int getDiamonds(){
        return this.diamonds;    
    }
    
    public void addDiamond(){
        ((Diamonds)getWorld().getObjects(Diamonds.class).get(0)).add();
    }

    public int getLifes(){
        return this.lifes;
    }

    public void addLife(){
        this.lifes++;
    }

    public void loseLife(int damage){
        skytime = 0;
        Lifes life = new Lifes();
        for(Object obj: getWorld().getObjects(Lifes.class)){
            life = (Lifes)obj;
        }
        getWorld().removeObject(life);
        
        this.lifes -= damage;
    }
    
    public int skytime(){
        return this.skytime;
    }
}
