
import java.awt.Color;


/**
 *
 * @author Akram
 */
public class Pyramid extends Shape{
    public Pyramid(double x1,double y1,double x2,double y2,double z,double h){
        Point[] p = {
            new Point(x1,y1,z),
            new Point(x1,y2,z),
            new Point(x2,y2,z),
            new Point(x2,y1,z),
            new Point((x2+x1)/2,(y2+y1)/2,h+z)
        };
        Point[] p1 = {p[0],p[1],p[2],p[3]};
        Point[] p2 = {p[0],p[1],p[4]};
        Point[] p3 = {p[1],p[2],p[4]};
        Point[] p4 = {p[2],p[3],p[4]};
        Point[] p5 = {p[3],p[0],p[4]};
        
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        pl = new plane[5];
        pl[0] = new plane(p1,col);
        pl[1] = new plane(p2,col);
        pl[2] = new plane(p3,col);
        pl[3] = new plane(p4,col);
        pl[4] = new plane(p5,col);
        
        //Color col = Color.red;
        
    }
}
