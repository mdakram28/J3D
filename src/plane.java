
import java.awt.Color;

public class plane implements Cloneable {
    Point[] p;
    Color col;
    public plane(Point[] po){
        p=po;
    }
    public plane(Point[] po,Color colo){
        p=po;
        col = colo;
    }
    public plane(){this(new Point[0]);}
    
    public void add(Point po,int add){
        Point[] temp = new Point[p.length+1];
        boolean ahead = false;
        for(int i = 0;i<temp.length;i++)
        {
            if(i==add)
            {
                ahead = true;
                temp[i] = po;
            }
            if(ahead)
            {
                temp[i+1] = p[i];
            }
            else
            {
                temp[i] = p[i];
            }
        }
        p=temp;
    }
    public void add(Point po){
        add(po,p.length);
    }
    
    public Point[] get(){
        return p;
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            System.exit(0);
            throw new Error("Something impossible just happened");
        }
    }
}
