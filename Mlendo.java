import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mlendo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mlendo extends SWorld
{
    Astronaut player1 = new Astronaut();
    public Mlendo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 475, 1, 4000, 1);
        setMainActor(player1, 31, 34, 550, 475);
        addObject(new Suelo(), 0, 451);
        addObject(new Suelo(), 650, 451);
        setGravity(0.5);
        //getBackground().setColor(new Color(173, 214, 172));
        setBackground(new GreenfootImage("Menu_screen.png"));
        //getBackground().fill();
        prepare();
    }

    public Astronaut getPlayer1(){
        return this.player1;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        plataforma plataforma0 = new plataforma(475, 5);
        addObject(plataforma0, 0, 225);
        plataforma plataforma1 = new plataforma(475, 5);
        addObject(plataforma1, 3996, 146);
        plataforma plataforma = new plataforma(100, 200);
        addObject(plataforma,1170,442);
        plataforma plataforma2 = new plataforma(50, 1000);
        addObject(plataforma2,1838,305);
        Enemy enemy = new Enemy();
        addObject(enemy,2318,261);
        Suelo suelo = new Suelo();
        addObject(suelo,2448,450);
        Suelo suelo2 = new Suelo();
        addObject(suelo2,3092,450);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,3399,407);
        plataforma plataforma3 = new plataforma(300, 500);
        addObject(plataforma3,3806,405);
    }
}
