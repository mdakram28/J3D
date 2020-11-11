
import java.awt.Color;


/**
 *
 * @author Akram
 */
public class planeShape extends Shape{
    public planeShape(Point[] poin){
        super();
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        
        plane pla = new plane(poin,col);
        pl = new plane[1];
        pl[0] = pla;
        
        //Color col = Color.red;
        
    }
}
