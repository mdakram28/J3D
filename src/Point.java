/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class Point {
    double x , y , z;
    boolean referenciated = false;
    public Point(){
        this(0,0,0);
    }
    
    public Point(double tx  , double ty  , double tz){
        x = tx;
        y = ty;
        z = tz;
    }
    
    public double distance(){
        return Math.sqrt(x*x + y*y + z*z);
    }
}
