
import java.awt.Color;


/**
 *
 * @author Akram
 */
public class Cuboid extends Shape{
    public Cuboid(double dx,double dy,double dz,double cx,double cy,double cz){
        super();
        pl = new plane[6];
        
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        //Color col = Color.red;
        Point[] v = {
            new Point(cx,cy,cz) ,
            new Point(cx,cy,cz+dz) ,
            new Point(cx,cy+dy,cz+dz) ,
            new Point(cx,cy+dy,cz) ,
            new Point(cx+dx,cy,cz) ,
            new Point(cx+dx,cy,cz+dz) ,
            new Point(cx+dx,cy+dy,cz+dz) ,
            new Point(cx+dx,cy+dy,cz) ,
        };
        Point[] pl1 = {v[0],v[1],v[2],v[3]};
        Point[] pl2 = {v[0],v[1],v[5],v[4]};
        Point[] pl3 = {v[1],v[2],v[6],v[5]};
        Point[] pl4 = {v[2],v[6],v[7],v[3]};
        Point[] pl5 = {v[0],v[3],v[7],v[4]};
        Point[] pl6 = {v[4],v[5],v[6],v[7]};
        pl[0] = new plane(pl1,col);
        pl[1] = new plane(pl2,col);
        pl[2] = new plane(pl3,col);
        pl[3] = new plane(pl4,col);
        pl[4] = new plane(pl5,col);
        pl[5] = new plane(pl6,col);
    }
}
