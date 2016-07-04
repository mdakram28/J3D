
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class Donut extends Shape{
    public Donut(double x1 , double y1, double z1 ,double x2 , double y2, double z2 , double r , int sides , int c_sides){
        double Angle_xy = Math.atan2((y2-y1),(x2-x1));
        double Angle_yz = Math.atan2((z2-z1),(x2-x1));
        Point self = new Point(x1,y1,z1);
        
        double len = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1));
        double l = len+r;
        //System.out.println((Angle_xy*180/Math.PI) + "\t" + (Angle_yz*180/Math.PI));
        
        pl = new plane[sides*c_sides];
        Point poi[][] = new Point[sides][c_sides];
        double ang = 2*Math.PI/sides;
        
        for(int i=0;i<sides;i++)
        {
            double angle = ang*i;
            //Point p1 = new Point(len*Math.cos(Angle_xy),len*Math.sin(Angle_xy),len*Math.sin(Angle_yz));
            //Point p2 = new Point(l*Math.cos(Angle_xy),l*Math.sin(Angle_xy),l*Math.sin(Angle_yz));
            Point p1 = new Point(len*Math.cos(angle),len*Math.sin(angle),0);
            Point p2 = new Point(l*Math.cos(angle),l*Math.sin(angle),0);
            
            
            //System.out.println(i+"\t"+p1.x+"\t"+p1.y+"\t"+(angle*180/Math.PI) +"\t"+ (len*Math.cos(angle)) +"\t"+ (len*Math.sin(angle)));
            //reference_angle(p1,Angle_xy,Angle_yz);
            //reference_angle(p2,Angle_xy,Angle_yz);
            reference_point(p1,self);
            reference_point(p2,self);
            
            poi[i] = plotCircle(p1, p2, c_sides);
            //System.out.println((int)(angle*180/Math.PI)+"\t"+poi[i][0].x+"\t");
        }
        int i,j,c=0;
        for(i=0;i<sides-1;i++)
        {
            Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            
            for(j=0;j<c_sides-1;j++)
            {
                Point[] temp = new Point[4];
                temp[0] = poi[i][j];
                temp[1] = poi[i][j+1];
                temp[2] = poi[i+1][j+1];
                temp[3] = poi[i+1][j];
                pl[c] = new plane(temp,col);
                //System.out.println(pl[c].p[0].x);
                c++;
            }
                Point[] temp = new Point[4];
                temp[0] = poi[i][j];
                temp[1] = poi[i][0];
                temp[2] = poi[i+1][0];
                temp[3] = poi[i+1][j];
                pl[c] = new plane(temp,col);
                c++;
        }
        
            Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            for(j=0;j<c_sides-1;j++)
            {
                Point[] temp = new Point[4];
                temp[0] = poi[i][j];
                temp[1] = poi[i][j+1];
                temp[2] = poi[0][j+1];
                temp[3] = poi[0][j];
                pl[c] = new plane(temp,col);
                c++;
            }
                Point[] temp = new Point[4];
                temp[0] = poi[i][j];
                temp[1] = poi[i][0];
                temp[2] = poi[0][0];
                temp[3] = poi[0][j];
                pl[c] = new plane(temp,col);
                //System.out.println(c);
                
    }
    
}
