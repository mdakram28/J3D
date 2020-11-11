
/**
 *
 * @author Akram
 */
class Shape {
    plane[] pl = {};
    double ox=0.0;
    double oy=0.0;
    double oz=0.0;
    /*
     * 0 : filled_surface
     * 1 : wireframe
     * 2 : transparency
     */
    int type = 0;
    public plane[] getPlanes(){
        return pl;
    }
    
    public plane getPlane(int index){
        return pl[index];
    }
    
    public Point rotate(double x , double y , double a){
        double angle = Math.atan2(y,x) + a;
        
        double r = Math.sqrt((x*x) + (y*y));
        //System.out.print("angle: "+(angle*180.0/Math.PI)+"\t"+y+ " , " +x+ "\tdist: " + r);
        x = r*Math.cos(angle);
        //System.out.println("\tX: "+x);
        y = r*Math.sin(angle);
        
        return new Point(x,y,0);
    }
    public void reference_angle(Point p,double Angle_xy,double Angle_yz){
        
        Point temp = rotate(p.x,p.y,Angle_xy);
        p.x = temp.x;
        p.y = temp.y;
        
        temp = rotate(p.x,p.z,Angle_yz);
        p.x = temp.x;
        p.z = temp.y;
    }
    public void reference_point(Point p,Point self){
        p.x+=self.x;
        p.y+=self.y;
        p.z+=self.z;
    }
    public Point[] plotCircle(Point p1,Point p2,int sides){
        Point[] ret = new Point[sides];
        double Angle_xy = Math.atan((p2.y-p1.y)/(p2.x-p1.x));
        //double Angle_yz = Math.atan((p2.z-p1.z)/(p2.x-p1.x));
        //System.out.println(p2.z+"\t"+p1.z+"\t"+Angle_yz);
        double dist = Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y) + (p2.z-p1.z)*(p2.z-p1.z));
        double ang = 2*Math.PI/sides;
        
        for(int i=0;i<sides;i++)
        {
            ret[i] = new Point();
            ret[i].x = dist*Math.cos(ang*i);
            ret[i].z = dist*Math.sin(ang*i);
            //double dist = ret[i].x*ret[i].x + ret[i].x*ret[i].x;
            Point temp = rotate(ret[i].x,0,Angle_xy);
            ret[i].y = temp.y;
            ret[i].x = temp.x;
            
            reference_point(ret[i],p1);
            
            //System.out.println(Angle_xy+"\t");
            //System.out.println(ret[i].z);
        }
        //System.out.println(ret[0].x);
        return ret;
    }
    
    public void referenciate(Point self){
        for(int i=0;i<pl.length;i++)
        {
            for(int j=0;j<pl[i].p.length;j++)
            {
                if(pl[i].p[j].referenciated)continue;
                pl[i].p[j].x+=self.x;
                pl[i].p[j].y+=self.y;
                pl[i].p[j].z+=self.z;
                pl[i].p[j].referenciated = true;
            }
        }
    }
}
