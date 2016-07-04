
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class Cylinder extends Shape{
    public Cylinder(double x1 , double y1, double z1 , double x2 , double y2 , double z2 , double r , int sides){
        double Angle_xy = Math.atan2((y2-y1),(x2-x1));
        double Angle_yz = Math.atan2((z2-z1),(x2-x1));
        Point self = new Point(x1,y1,z1);
        double len = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1));
        System.out.println((Angle_xy*180/Math.PI) + "\t" + (Angle_yz*180/Math.PI));
        
        pl = new plane[sides];
        Point end1[] = new Point[sides];
        Point end2[] = new Point[sides];
        Point poi[] = new Point[sides*2];
        double ang = 2*Math.PI/sides;
        
        for(int i=0;i<sides;i++)
        {
            poi[i*2] = new Point();
            poi[i*2+1] = new Point();
            
            poi[i*2].x = 0;
            poi[i*2+1].x = len;
            poi[i*2].y = r*Math.cos(ang*i);
            poi[i*2].z = r*Math.sin(ang*i);
            poi[i*2+1].y = poi[i*2].y;
            poi[i*2+1].z = poi[i*2].z;
            
            reference_angle(poi[i*2],Angle_xy,Angle_yz);
            reference_point(poi[i*2],self);
            reference_angle(poi[i*2+1],Angle_xy,Angle_yz);
            reference_point(poi[i*2+1],self);
        }
        int i;
        for(i=0;i<sides-1;i++)
        {
            
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            Point[] p = new Point[4];
            p[0] = poi[i*2];
            p[1] = poi[i*2+1];
            p[2] = poi[i*2+3];
            p[3] = poi[i*2+2];
            pl[i] = new plane(p,col);
            
        }
        Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        
            Point[] p = new Point[4];
            p[0] = poi[i*2];
            p[1] = poi[i*2+1];
            p[2] = poi[1];
            p[3] = poi[0];
            pl[i] = new plane(p,col);
            
        
    }
    
}
