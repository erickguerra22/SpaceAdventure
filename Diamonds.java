import greenfoot.*;

/**
 * A simple score class.
 */
public class Diamonds extends Actor
{
    int diamonds = 0; // the score field
    
    /**
     * Creates the object and its initial image.
     */
    public Diamonds()
    {
        updateImage();
    }
    
    /**
     * Creates (or re-creates) the image of the object.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage(": "+ (000000+diamonds), 20, Color.WHITE, new Color(15, 0, 0, 0)));
    }
    
    /**
     * Adusts the score by <i>addAmt</i>.
     *
     * @param addAmt: the change in the score (negatives decrease the score)
     */
    public void add()
    {
        diamonds++;
        updateImage();
    }
}
