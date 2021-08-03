import greenfoot.*;

/**
 * A simple score class.
 */
public class Score extends Actor
{
    int score = 0; // the score field
    
    /**
     * Creates the object and its initial image.
     */
    public Score()
    {
        updateImage();
    }
    
    /**
     * Creates (or re-creates) the image of the object.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage("Score: "+ (000000+score), 20, Color.WHITE, new Color(15, 0, 0, 0)));
    }
    
    /**
     * Adusts the score by <i>addAmt</i>.
     *
     * @param addAmt: the change in the score (negatives decrease the score)
     */
    public void add(int addAmt)
    {
        score+=addAmt;
        updateImage();
    }
}