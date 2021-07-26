import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class SWorld extends World
{
    private double gravity;
    private int scrollingWidth, scrollingHeight; // dimensions of scrolling area
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; // limits for main actor within world coordinates
    private int scrolledX, scrolledY; // horizontal and vertical scrolled amounts
    private int scrollType; // indicates scrolling directions (0=none, 1=horizontal, 2=vertical, 3=both)
    Actor mainActor = null; // the actor that always stays visible
    private List<Actor>genActors = new ArrayList(); // lists all generic scrolling actor objects
    private GreenfootImage background = null;
    
    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh, int scrollType)
    {
        super(wide,high, cellSize, false);
        this.scrollType = scrollType;
        scrollingWidth = (scrollType == 1 || scrollType == 3) ? scrollWide : wide;
        scrollingHeight = (scrollType == 2 || scrollType == 3) ? scrollHigh : high;
    }
    
    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollType)
    {
        this(wide, high, cellSize, scrollWide, high, scrollType);
    }
    
    public void setMainActor(Actor main, int x, int y, int xRange, int yRange)
    {
        super.addObject(main, x, y);
        mainActor = main;
        actorMinX = getWidth()-xRange;
        actorMaxX = xRange;
        actorMinY = (getHeight()-yRange) + mainActor.getImage().getHeight()/2;
        actorMaxY = yRange;
    }
    
    private void scrollObjects()
    {
        if (mainActor==null)
            return;
        if (mainActor.getX() < actorMinX && scrolledX > 0){
            mainActor.setLocation(actorMinX, mainActor.getY());   
            for(Object obj : genActors)
                ((Actor)obj).setLocation(((Actor)obj).getX()+3, ((Actor)obj).getY());
            scrolledX -= 4;
        }
        if (mainActor.getX() > actorMaxX && scrolledX < scrollingWidth){
            mainActor.setLocation(actorMaxX, mainActor.getY());   
            for(Object obj : genActors)
                ((Actor)obj).setLocation(((Actor)obj).getX()-3, ((Actor)obj).getY());
            scrolledX+=4;
        }   
        if(mainActor.getY()<actorMinY)
            mainActor.setLocation(mainActor.getX(), actorMinY);
        if(mainActor.getY()>actorMaxY){
            mainActor.setLocation(mainActor.getX()-300,34);
            ((Astronaut)mainActor).loseLife(1);
        }
    }
    
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        super.addObject(obj, xLoc, yLoc);
        if (scroller) genActors.add(obj);
    }
    
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }
    
    public void removeObject(Actor obj)
    {
        if (obj == null) return;
        if (obj.equals(mainActor)) mainActor = null;
        else genActors.remove(obj);
        super.removeObject(obj);
    }
    
    public void removeObjects(List<Actor>objs)
    {
        for (Actor obj : objs) removeObject(obj);
    }
  
    public void act()
    {
        scrollObjects();
        //scrollBackground();
    }
    
    /**
     * Scrolls the background image.
     */
    /*private void scrollBackground()
    {
        if (background == null) return;
        int w = getWidth(), h = getHeight(), c = getCellSize();
        int bw = background.getWidth(), bh = background.getHeight();
        getBackground().drawImage(background, (w*c-bw)/2-scrolledX*c, (h*c-bh)/2-scrolledY*c);
    }*/
    
    public int getScrolledX()
    {
        return scrolledX;
    }
    
    public int getScrollingWidth()
    {
        return scrollingWidth;
    }
    
    public int getScrollingHeight()
    {
        return scrollingHeight;
    }
    
    public double getGravity(){
        return this.gravity;
    }
    
    public void setGravity(double gravity){
        this.gravity = gravity;
    }
}