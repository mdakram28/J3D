
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class J3DView extends JFrame{
    DrawPanel panel = new DrawPanel();
    Color[] col;
    
    plane[] p = {};
    ArrayList<Shape> sh = new ArrayList<Shape>();
    J3DCore core = new J3DCore();
    PlaneViewer pv = new PlaneViewer();
    
    public void add(Shape sha){
        sh.add(sha);
    }
    public void refresh2(){
        plane[] temp = copy(p);
        
        for(int i=0;i<temp.length;i++)
        {
             core.referenciate(temp[i]);
        }
        
    }
    public void refresh(){
        plane[] temp = copy(p);
        //panel.printPoints(temp[0]);
        for(int i=0;i<temp.length;i++)
        {
             core.referenciate(temp[i]);
             validate(temp[i]);
        }
        //panel.printPoints(temp[0]);
        //temp = removeExtraPlanes(temp);
         //pv.update(copy(temp));
        //panel.printPoints(temp[0]);
        //temp = removeExtraPlanes(temp);
         pv.update(copy(temp));
        temp = arrangePlanes(temp);
        //panel.printPoints(temp[0]);
        
         for(int i=0;i<temp.length;i++)
         {
             //panel.printPoints(temp[i]);
             plotPlane(temp[i]);
         }
        //panel.printPoints(temp[0]);
         update(temp);
         
    }
    public plane[] copy(plane[] temp){
        plane[] tempo = new plane[temp.length];
        
        for(int i=0;i<tempo.length;i++)
        {
            Point[] poi = new Point[temp[i].p.length];
            for(int j=0;j<temp[i].p.length;j++)
            {
                Point po = temp[i].p[j];
                poi[j] = new Point(po.x,po.y,po.z);
            }
            tempo[i] = new plane(poi,temp[i].col);
        }
        
        return tempo;
    }
    public plane[] removeExtraPlanes(plane[] temp){
        ArrayList<plane> al = new ArrayList<plane>();
        for(int j=0;j<temp.length;j++)
        {
            boolean out = true;
            for(int i=0;i<temp[j].p.length;i++)
            {
                if(isIn(temp[j].p[i])==2)
                {
                    out = false;
                    break;
                }
            }
            
            if(!out)al.add(temp[j]);
        }
        temp = new plane[al.size()];
        for(int i=0;i<al.size();i++)
        {
            temp[i] = al.get(i);
        }
        return temp;
    }
    public int isIn(Point p){
        int ret=0;
        double m1 = p.y/p.x,m2 = p.z/p.x;
        if(m1>core.mxy)
        {
            ret = 1;
            if(p.x<0)
            {
                ret=-3;
            }
        }
        else if(m1<-core.mxy)
        {
            ret = -1;
            if(p.x<0)
            {
                ret=3;
            }
        }
        else if(p.x<0)
        {
            ret = 2;
        }
        return ret;
    }
    public plane[] arrangePlanes (plane[] pla){
        
        for(int i=0;i<pla.length-1;i++)
        {
                try{    
            double largest = pla[i].p[0].x;
            for(int j=i;j<pla.length;j++)
            {
                double y=0;
                int av;
                for(av=0;av<pla[j].p.length;av++)
                {
                    y += pla[j].p[av].distance();
                }
                y = y/av;
                
                    if(y>largest)
                    {   
                     largest = y;
                    plane temp = pla[i];
                    pla[i] = pla[j];
                    pla[j] = temp;
                    //System.out.println(i+" : "+j+" : "+y);
                }
                }
            }
                catch(Exception e){}
        }
        return pla;
    }
    public void convertShapes(){
        ArrayList<plane> al = new ArrayList<plane>();
        for(int i=0;i<sh.size();i++)
        {
            
             //System.out.println("converting shape : "+i);
             Shape sha = (Shape)sh.get(i);
             al.addAll(Arrays.asList(sha.pl));
        }
        
        p = toArrayPlane(al);
    }
    
    public plane[] toArrayPlane(ArrayList<plane> al){
        int l = al.size();
        plane[] temp = new plane[l];
        for(int i=0;i<l;i++)
        {
            temp[i] = al.get(i);
        }
        return temp;
    }
    public J3DView(JFrame frame){
        
        frame.add(panel);
        
    }
    public DrawPanel getPanel(){
        return panel;
    }
    public void validate(plane coord){
        ArrayList<Point> temp = new ArrayList<Point>();
        int i;
        for(i=0;i<coord.p.length-1;i++)
        {
            if(coord.p[i].x>=0)temp.add(coord.p[i]);
            if((coord.p[i].x>=0 && coord.p[i+1].x<0) || (coord.p[i+1].x>=0 && coord.p[i].x<0))
            {
                Point cut = getIntersection(coord.p[i],coord.p[i+1]);
                temp.add(cut);
            }
        }
            if(coord.p[i].x>=0)temp.add(coord.p[i]);
            if((coord.p[i].x>=0 && coord.p[0].x<0) || (coord.p[0].x>=0 && coord.p[i].x<0))
            {
                Point cut = getIntersection(coord.p[i],coord.p[0]);
                temp.add(cut);
                //System.exit(0);
            }
        coord.p = toArrayPoint(temp);
    }
    
    public void validate2(plane coord){
        ArrayList<Point> temp = new ArrayList<Point>();
        int i;
        for(i=0;i<coord.p.length-1;i++)
        {
            Point p1 = coord.p[i] , p2 = coord.p[i+1];
            processIntersections(p1,p2,temp);
        }
            Point p1 = coord.p[i] , p2 = coord.p[0];
            processIntersections(p1,p2,temp);
        coord.p = toArrayPoint(temp);
        System.out.println("******************************************");
        //panel.printPoints(coord);
    }
    public void processIntersections(Point p1,Point p2,ArrayList<Point> temp){
        int in1 = isIn(p1) , in2 = isIn(p2);
        System.out.println(in1);
            if(in1==in2){
                if(in1==0)
                {
                    temp.add(p1);
                }
            }
            else
            {
                if(in1 == 1)
                {
                    if(in2==0)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,1));
                    }
                    else if(in2==-1)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,1));
                        temp.add(getViewIntersectionXY(p1,p2,-1));
                    }
                    else if(in2==-3)
                    {
                        Point tp = getViewIntersectionXY(p1,p2,1);
                        if(tp.x>0)
                        {
                            temp.add(tp);
                            temp.add(getViewIntersectionXY(p1,p2,-1));
                        }
                    }
                }
                else if(in1 == 0)
                {
                    temp.add(p1);
                    if(in2 == 1)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,1));
                    }
                    else if(in2==-1)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,-1));
                    }
                    else if(in2==3)
                    {
                        
                        temp.add(getViewIntersectionXY(p1,p2,1));
                    }
                    else if(in2==2)
                    {
                        Point tp = getViewIntersectionXY(p1,p2,1);
                        if(tp.x<0)
                        {
                            tp = getViewIntersectionXY(p1,p2,-1);
                        }
                            temp.add(tp);
                    }
                    else if(in2==-3)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,-1));
                    }
                }
                else if(in1 == -1)
                {
                    if(in2==1)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,-1));
                        temp.add(getViewIntersectionXY(p1,p2,1));
                    }
                    else if(in2==0)
                    {
                        temp.add(getViewIntersectionXY(p1,p2,-1));
                    }
                    else if(in2==3)
                    {
                        Point tp = getViewIntersectionXY(p1,p2,-1);
                        if(tp.x>0)
                        {
                            temp.add(tp);
                            temp.add(getViewIntersectionXY(p1,p2,1));
                        }
                    }
                }
            }
    }
    public Point[] toArrayPoint(ArrayList<Point> al){
        int l = al.size();
        Point[] temp = new Point[l];
        for(int i=0;i<l;i++)
        {
            temp[i] = al.get(i);
        }
        return temp;
    }
    
    public Point getIntersection(Point p1 , Point p2){
        double x=0.0;
        double y = p1.y - (p2.y-p1.y)*p1.x/(p2.x-p1.x);
        double z = p1.z - (p2.z-p1.z)*p1.x/(p2.x-p1.x);
        return new Point(x,y,z);
    }
    public Point getViewIntersectionXY(Point p1,Point p2,int x){
        Point ret = new Point();
        
        double r = (core.s_width*x)/(2.0*core.dist);
        
        double m1 = (p2.y-p1.y)/(p2.x-p1.x);
        
        
        ret.x = (p1.y-p1.x*m1)/(r-m1);
        ret.y = ret.x*r;
        ret.z = ((p2.z-p1.z)*(ret.x-p1.x)/(p2.x-p1.x))+p1.z;
        
        return ret;
    }
    public void plotPlane(plane pl){
        
        for(int i=0;i<pl.p.length;i++)
        {
            core.plot(pl.p[i]);
        }
    }
    
    public void update(plane[] po){
        panel.update(po);
    }
    
    public void forward(double dist){
        core.self.x+=dist*Math.cos(core.Angle_xy);
        core.self.y+=dist*Math.sin(core.Angle_xy);
    }
    
    public void backward(double dist){
        core.self.x-=dist*Math.cos(core.Angle_xy);
        core.self.y-=dist*Math.sin(core.Angle_xy);
    }
}


