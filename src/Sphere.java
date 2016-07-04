
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class Sphere extends Shape{
    public Sphere(double x , double y, double z , double r , int sides){
        //double Angle_xy = Math.atan2((y2-y1),(x2-x1));
        //double Angle_yz = Math.atan2((z2-z1),(x2-x1));
        Point self = new Point(x,y,z);
        //double len = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) + (z2-z1)*(z2-z1));
        //System.out.println((Angle_xy*180/Math.PI) + "\t" + (Angle_yz*180/Math.PI));
        
        pl = new plane[sides*sides];
        Point poi[][] = new Point[sides][sides];
        double ang = 2*Math.PI/sides;
        
        for(int i=0;i<sides;i++)
        {
            double Angle_xy = ang*i;
            for(int j=0;j<sides;j++)
            {
                double Angle_yz = ang*j;
                Point temp = new Point(r,0,0);
                reference_angle(temp,Angle_xy,Angle_yz);
                reference_point(temp,self);
                poi[i][j] = temp;
            }
        }
        int i,j,c=0;
        for(i=0;i<sides-1;i++)
        {
            Color col = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            
            for(j=0;j<sides-1;j++)
            {
                Point[] temp = new Point[4];
                temp[0] = poi[i][j];
                temp[1] = poi[i][j+1];
                temp[2] = poi[i+1][j+1];
                temp[3] = poi[i+1][j];
                pl[c] = new plane(temp,col);
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
            for(j=0;j<sides-1;j++)
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
                System.out.println(c);
                
    }
    
}
