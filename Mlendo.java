import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mlendo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mlendo extends SWorld
{
    GreenfootSound theme = new GreenfootSound("Mlendo.mp3");
    public Mlendo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 475, 1, 8400, 1);
        setGravity(0.2);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Suelo suelo = new Suelo();
        addObject(suelo,449,450);
        plataforma plataforma = new plataforma();
        addObject(plataforma,1021,287);
        plataforma plataforma2 = new plataforma();
        addObject(plataforma2,1227,287);
        plataforma plataforma3 = new plataforma();
        addObject(plataforma3,1433,287);
        plataforma plataforma4 = new plataforma();
        addObject(plataforma4,1638,287);
        Suelo suelo2 = new Suelo();
        addObject(suelo2,2226,450);
        Dirt dirt = new Dirt();
        addObject(dirt,2877,439);
        Dirt dirt2 = new Dirt();
        addObject(dirt2,3083,439);
        Dirt dirt3 = new Dirt();
        addObject(dirt3,3289,439);
        Dirt dirt4 = new Dirt();
        addObject(dirt4,2877,365);
        Dirt dirt5 = new Dirt();
        addObject(dirt5,3083,365);
        Dirt dirt6 = new Dirt();
        addObject(dirt6,3289,365);
        plataforma plataforma5 = new plataforma();
        addObject(plataforma5,2877,304);
        plataforma plataforma6 = new plataforma();
        addObject(plataforma6,3083,304);
        plataforma plataforma7 = new plataforma();
        addObject(plataforma7,3289,304);
        plataforma plataforma8 = new plataforma();
        addObject(plataforma8,3553,340);
        plataforma plataforma9 = new plataforma();
        addObject(plataforma9,3759,340);
        plataforma plataforma10 = new plataforma();
        addObject(plataforma10,3964,340);
        Suelo suelo3 = new Suelo();
        addObject(suelo3,4657,450);
        Moon moon = new Moon(100,100);
        addObject(moon,50,57, false);
        Diamond diamond = new Diamond();
        addObject(diamond, 400, 400);
        Diamond diamond1 = new Diamond();
        addObject(diamond1,1034, 238);
        Diamond diamond2 = new Diamond();
        addObject(diamond2, 1081, 238);
        Diamond diamond3 = new Diamond();
        addObject(diamond3, 1128, 238);
        Diamond diamond4 = new Diamond();
        addObject(diamond4, 2754, 98);
        Diamond diamond5 = new Diamond();
        addObject(diamond5, 2738, 119);
        Diamond diamond6 = new Diamond();
        addObject(diamond6, 2770, 119);
        Diamond diamond7 = new Diamond();
        addObject(diamond7, 2786, 144);
        Diamond diamond8 = new Diamond();
        addObject(diamond8,2754,144);
        Diamond diamond9 = new Diamond();
        addObject(diamond9, 2722, 144);
        Diamond diamond10 = new Diamond();
        addObject(diamond10, 2738, 165);
        Diamond diamond11 = new Diamond();
        addObject(diamond11, 2770, 165);
        Diamond diamond12 = new Diamond();
        addObject(diamond12, 2754, 190);
        setScore(new Score(), 776, 20, false);
        addObject(new Diamonds(), 717,20,false);
        Diamond diamond0 = new Diamond();
        diamond0.setImage(new GreenfootImage("Diamante.gif"));
        addObject(diamond0, 694,20,false);
        Lifes life1 = new Lifes();
        addObject(life1,830,20, false);
        Lifes life2 = new Lifes();
        addObject(life2,850,20, false);
        Lifes life3 = new Lifes();
        addObject(life3,870,20, false);
        Enemy enemy = new Enemy();
        addObject(enemy,3978,283);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,3322,247);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,1723,230);
        Ship ship = new Ship();
        addObject(ship,5009,57);
        playMusic(theme);
        Portal portal = new Portal();
        addObject(portal,7156,316);
        portal.setLocation(7061,339);
        setMainActor(new Astronaut(), 35, 34, 550, 475);
        removeObject(suelo3);
        plataforma plataforma11 = new plataforma();
        addObject(plataforma11,4401,449);
        Dirt dirt7 = new Dirt();
        addObject(dirt7,4608,438);
        plataforma plataforma12 = new plataforma();
        addObject(plataforma12,4608,376);
        Dirt dirt8 = new Dirt();
        addObject(dirt8,4814,439);
        Dirt dirt9 = new Dirt();
        addObject(dirt9,4814,366);
        plataforma plataforma13 = new plataforma();
        addObject(plataforma13,4814,304);
        plataforma plataforma14 = new plataforma();
        addObject(plataforma14,5020,305);
        Dirt dirt10 = new Dirt();
        addObject(dirt10,5019,367);
        Dirt dirt11 = new Dirt();
        addObject(dirt11,5020,441);
        Dirt dirt12 = new Dirt();
        addObject(dirt12,5225,442);
        plataforma plataforma16 = new plataforma();
        addObject(plataforma16,5431,449);
        plataforma plataforma15 = new plataforma();
        addObject(plataforma15,5225,379);
        Diamond diamond15 = new Diamond();
        addObject(diamond15,4913,83);
        Diamond diamond16 = new Diamond();
        addObject(diamond16,4913,122);
        Diamond diamond17 = new Diamond();
        addObject(diamond17,4913,161);
        Diamond diamond18 = new Diamond();
        addObject(diamond18,4944,123);
        Diamond diamond19 = new Diamond();
        addObject(diamond19,4880,121);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,4923,249);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,4466,393);
        Enemy enemy6 = new Enemy();
        addObject(enemy6,4670,322);
        Enemy enemy7 = new Enemy();
        addObject(enemy7,5160,321);
        Enemy enemy8 = new Enemy();
        addObject(enemy8,5368,387);
        Suelo suelo4 = new Suelo();
        addObject(suelo4,6049,350);
        Diamond diamond20 = new Diamond();
        addObject(diamond20,5654,294);
        Diamond diamond21 = new Diamond();
        addObject(diamond21,5755,294);
        Diamond diamond22 = new Diamond();
        addObject(diamond22,5856,294);
        Diamond diamond23 = new Diamond();
        addObject(diamond23,5957,294);
        Diamond diamond24 = new Diamond();
        addObject(diamond24,6058,294);
        Diamond diamond25 = new Diamond();
        addObject(diamond25,6159,294);
        Diamond diamond26 = new Diamond();
        addObject(diamond26,6260,294);
        Diamond diamond27 = new Diamond();
        addObject(diamond27,6361,294);
        Suelo suelo5 = new Suelo();
        addObject(suelo5,7057,451);
        plataforma plataforma17 = new plataforma();
        addObject(plataforma17,4181,404);
    }
}
