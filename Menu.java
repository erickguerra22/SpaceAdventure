import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    Puntero puntero = new Puntero();
    private int opcion;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean spacePressed = false;
    private boolean enterPressed = false;
    public Menu()
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
        Jugar jugar = new Jugar();
        addObject(jugar,445,284);
        Opciones opciones = new Opciones();
        addObject(opciones,445,324);
        Salir salir = new Salir();
        addObject(salir,445,364);
        addObject(puntero,345,284);
    }
    
    public void act(){
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
            
        puntero.setLocation(345,284 + opcion*40);
        
        if ((Greenfoot.isKeyDown("Space") && spacePressed == false) || (Greenfoot.isKeyDown("enter") && enterPressed == false)){
            switch(opcion){
                case 0:
                    Greenfoot.setWorld(new Mlendo());
                    break;
                case 2:
                    Greenfoot.stop();
                    break;
            }
        }else if(!Greenfoot.isKeyDown("Space"))
            spacePressed = false;
        else if(!Greenfoot.isKeyDown("enter"))
            enterPressed = false;
    }
}
