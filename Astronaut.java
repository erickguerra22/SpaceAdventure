import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Astronaut extends Actor
{
    private double vSpeed;
    private boolean isMoving = false;
    private int lookingTo = 0;
    private boolean isFlying = false;
    private boolean isFalling = true;
    private int skytime = 0;
    private boolean spacePressed = false;
    private int lifes = 3;
    private int score = 0;
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

    public void fly(){
        if(Greenfoot.isKeyDown("up")){
            if(skytime>0){
                setLocation(getX(),getY()-3);
                vSpeed = 0;
                isFalling = false;
                isMoving = true;
                isFlying = true;
                skytime--;
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
            vSpeed = 0;
            isFalling = false;
            skytime = (int)(((SWorld)getWorld()).getGravity() * 100);
            setLocation(getX(), touchingGround()[1]);
        }else{
            vSpeed += ((SWorld)getWorld()).getGravity();
            setLocation(getX(), getY()+(int)vSpeed);
            isFalling = true;
        }
    }
    
    public void die(){
        if(lifes == 0){
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

    public int getScore(){
        return this.score;
    }

    public void addPoints(int points){
        this.score += points;
    }

    public int getLifes(){
        return this.lifes;
    }

    public void addLife(){
        this.lifes++;
    }

    public void loseLife(int damage){
        skytime = 0;
        this.lifes -= damage;
    }
    
    public int skytime(){
        return this.skytime;
    }
}
