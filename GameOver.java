import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    Puntero puntero = new Puntero();
    private int opcion;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean spacePressed = false;
    private boolean enterPressed = false;
    GreenfootSound backgroundMusic = new GreenfootSound("GameOver.mp3");
    Score score = SWorld.getScore();

    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 475, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(score, 459, 298);
        Retry retry = new Retry();
        addObject(retry,445,353);
        Back back = new Back();
        addObject(back,445,393);
        Salir salir = new Salir();
        addObject(salir,445,433);
        addObject(puntero,290,353);
    }
    
    public void act(){
        backgroundMusic.playLoop();
        if(Greenfoot.isKeyDown("up")&& upPressed ==false){
            opcion--;
            upPressed = true;
        }else if(!Greenfoot.isKeyDown("up"))
            upPressed = false;
        if(Greenfoot.isKeyDown("down")&& downPressed == false){
            opcion++;
            downPressed = true;
        }else if(!Greenfoot.isKeyDown("down"))
            downPressed = false;
        if(opcion>=3)
            opcion = 0;
        if(opcion<0)
            opcion = 2;
            
        puntero.setLocation(290,353 + opcion*40);
        
        if ((Greenfoot.isKeyDown("Space") && spacePressed == false) || (Greenfoot.isKeyDown("enter") && enterPressed == false)){
            switch(opcion){
                case 0:
                    Greenfoot.setWorld(new Mlendo());
                    backgroundMusic.stop();
                    break;
                case 1:
                    Greenfoot.setWorld(new Menu());
                    backgroundMusic.stop();
                    break;
                case 2:
                    Greenfoot.stop();
                    backgroundMusic.stop();
                    break;
            }
        }else if(!Greenfoot.isKeyDown("Space"))
            spacePressed = false;
        else if(!Greenfoot.isKeyDown("enter"))
            enterPressed = false;
    }
}
