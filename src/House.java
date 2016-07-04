
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class House extends Shape {
    public House(double x , double y , double z){
        
        Color col1 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        Color col2 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        pl = new plane[8];
        Point[] p = new Point[10];
        p[0] = new Point(0,0,0);
        p[1] = new Point(0,50,0);
        p[2] = new Point(0,50,50);
        p[3] = new Point(0,0,50);
        p[4] = new Point(100,0,0);
        p[5] = new Point(100,50,0);
        p[6] = new Point(100,50,50);
        p[7] = new Point(100,0,50);
        p[8] = new Point(0,25,75);
        p[9] = new Point(100,25,75);
        
        Point[] p1 = {p[0],p[1],p[2],p[3]};
        Point[] p2 = {p[0],p[3],p[7],p[4]};
        Point[] p3 = {p[4],p[5],p[6],p[7]};
        Point[] p4 = {p[1],p[2],p[6],p[5]};
        Point[] p5 = {p[3],p[7],p[9],p[8]};
        Point[] p6 = {p[2],p[8],p[9],p[6]};
        Point[] p7 = {p[2],p[3],p[8]};
        Point[] p8 = {p[6],p[7],p[9]};
        
        
        pl[0] = new plane(p1,col1);
        pl[1] = new plane(p2,col1);
        pl[2] = new plane(p3,col1);
        pl[3] = new plane(p4,col1);
        
        pl[4] = new plane(p5,col2);
        pl[5] = new plane(p6,col2);
        pl[6] = new plane(p7,col2);
        pl[7] = new plane(p8,col2);
        
        Point self = new Point(x,y,z);
        referenciate(self);
        
//        poi[0] = new Point(0,0,);
//        poi[1] = new Point(120,-20,55);
//        poi[2] = new Point(120,25,125);
//        poi[3] = new Point(-20,25,125);
//        poi[4] = new Point(-20,70,55);
//        poi[5] = new Point(120,70,55);
//        Point po1[] = {poi[0],poi[1],poi[2],poi[3]};
//        Point po2[] = {poi[2],poi[3],poi[4],poi[5]};
//        plane top1 = new plane(po1);
//        plane top2 = new plane(po2);
//        pl = new plane[8];
//        pl[0] = cb.pl[0];
//        pl[1] = cb.pl[1];
//        pl[2] = cb.pl[2];
//        pl[3] = cb.pl[3];
//        pl[4] = cb.pl[4];
//        pl[5] = cb.pl[5];
//        pl[6] = top1;
//        pl[7] = top2;
//        
        //referenciate(new Point(x,y,z));
    }
}
