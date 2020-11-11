
import java.awt.Color;


/**
 *
 * @author Akram
 */
public class Panel extends Shape{
    public Panel(double x1,double y1,double x2,double y2,double z){
        super();
        Point[] poin = {
            new Point(x1,y1,z),
            new Point(x1,y2,z),
            new Point(x2,y2,z),
            new Point(x2,y1,z),
        };
        plane pla = new plane(poin);
        pl = new plane[1];
        pl[0] = pla;
        
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        //Color col = Color.red;
        
    }
}
