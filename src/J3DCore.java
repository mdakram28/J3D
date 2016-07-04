public class J3DCore{
    Point[] data = new Point[2];
    
    Point self = new Point(0,0,100);
    double Angle_xy = 0.0 ,Angle_yz=0.0, Angle_xz = -0.7853981625;
    double dist = 600;
    int s_width = 1280 , s_height = 800;
    double mxy = s_width/(2*dist) , myz = s_height/(2*dist);
    public void referenciate(plane pl){
        for(int i = 0;i<pl.p.length;i++)
        {
            reference_point(pl.p[i]);
            reference_angle(pl.p[i]);
        }
    }
    public void plot(Point p){
        //System.out.println(p.x+"\t"+p.y+"\t"+p.z);
        double x , y;
        
        if(p.x==0.0)
        {
            if(p.x>0)y = s_height/2;
            else y = -s_height/2;
            
            x = (p.y*y/p.z);
        }
        else
        {
            x = (p.y/p.x)*dist;
            y = (p.z/p.x)*dist;
        }
        
        //System.out.println("plotted : "+ x+"\t"+y);
        
        p.x = (s_width/2)-x;
        p.y = (s_height/2)-y;
        p.z = 0;
        //System.out.println("Screen Coordinates : "+p.x+"\t"+p.y);
    }
    
    public void reference_point(Point p){
        p.x-=self.x;
        p.y-=self.y;
        p.z-=self.z;
    }
    
    public void reference_angle(Point p){
        Point temp = rotate(p.x,p.y,Angle_xy);
        p.x = temp.x;
        p.y = temp.y;
        
        temp = rotate(p.y,p.z,Angle_yz);
        p.y = temp.x;
        p.z = temp.y;
        
        temp = rotate(p.x,p.z,Angle_xz);
        p.x = temp.x;
        p.z = temp.y;
    }
    public Point rotate(double x , double y , double a){
        double angle = Math.atan2(y,x) - a;
        
        double r = Math.sqrt((x*x) + (y*y));
        //System.out.print("angle: "+(angle*180.0/Math.PI)+"\t"+y+ " , " +x+ "\tdist: " + r);
        x = r*Math.cos(angle);
        //System.out.println("\tX: "+x);
        y = r*Math.sin(angle);
        
        return new Point(x,y,0);
    }
}
