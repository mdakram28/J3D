/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class JoinShapes extends Shape {
    
    public JoinShapes(Shape[] shapes){
        int l =0;
        for(int i=0;i<shapes.length;i++)
        {
            l+=shapes[i].pl.length;
        }
        
        pl = new plane[l];
        int c=0;
        for(int i=0;i<shapes.length;i++)
        {
            for(int j=0;j<shapes[i].pl.length;j++)
            {
                pl[c] = shapes[i].pl[j];
                c++;
            }
        }
    }
}
