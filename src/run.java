
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.*;


public class run extends JFrame implements AWTEventListener {
    JSlider x_val = new JSlider() , y_val = new JSlider() , z_val = new JSlider() , a_val = new JSlider();
    final J3DView j3d = new J3DView(this);
    public static void main(String[] args){
        run f = new run();
    }
    
    public run(){
        //System.out.println("hellooooooooo****************************************************************************************");
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        DrawPanel panel = j3d.getPanel();
        
        Point p1 = new Point(-100,-100,0);
        Point p2 = new Point(-100,100,0);
        Point p3 = new Point(100,100,0);
        Point p4 = new Point(100,-100,0);

        Point[] points1 = {p1,p2,p3,p4};
        Shape[] sh = {new planeShape(points1)};
        
        panel.add(x_val);
        panel.add(y_val);
        panel.add(z_val);
        panel.add(a_val);
        
//        j3d.add(sh[0]);
//        j3d.add(new Cuboid(25,25,25,0,0,0));
//        j3d.add(new Cuboid(25,25,25,50,0,0));
//        j3d.add(new Cuboid(25,25,25,100,0,0));
//        j3d.add(new Cuboid(25,25,25,150,0,0));
//        j3d.add(new Cuboid(25,25,25,25,25,0));
//        j3d.add(new Cuboid(25,25,25,75,25,0));
//        j3d.add(new Cuboid(25,25,25,125,25,0));
//        j3d.add(new Cuboid(25,25,25,50,0,0));
//        j3d.add(new Cuboid(25,25,25,50,50,0));
//        j3d.add(new Cuboid(25,25,25,100,50,0));
//        j3d.add(new Cuboid(25,25,25,150,50,0));
//        j3d.add(new Cuboid(25,25,25,25,75,0));
//        j3d.add(new Cuboid(25,25,25,75,75,0));
//        j3d.add(new Cuboid(25,25,25,125,75,0));
        //j3d.convertShapes();
        
//        j3d.add(new Pyramid(100,100,200,200,-100,100));
//        
//        j3d.add(new Cylinder(150,150,0,150,150,-100,25,50));
//        j3d.add(new Cylinder(250,150,0,250,150,-100,25,50));
//        j3d.add(new Cylinder(350,150,0,350,150,-100,25,50));
//        j3d.add(new Cylinder(450,150,0,450,150,-100,25,50));
//        j3d.add(new Cylinder(550,150,0,550,150,-100,25,50));
//        
//        j3d.add(new Cylinder(150,50,0,150,50,-100,25,50));
//        j3d.add(new Cylinder(250,50,0,250,50,-100,25,50));
//        j3d.add(new Cylinder(350,50,0,350,50,-100,25,50));
//        j3d.add(new Cylinder(450,50,0,450,50,-100,25,50));
//        j3d.add(new Cylinder(550,50,0,550,50,-100,25,50));
//        
//        j3d.add(new Cylinder(150,-50,0,150,-50,-100,25,50));
//        j3d.add(new Cylinder(250,-50,0,250,-50,-100,25,50));
//        j3d.add(new Cylinder(350,-50,0,350,-50,-100,25,50));
//        j3d.add(new Cylinder(450,-50,0,450,-50,-100,25,50));
//        j3d.add(new Cylinder(550,-50,0,550,-50,-100,25,50));
//        
        j3d.add(new Cuboid(200,200,10,0,0,0));
        j3d.add(new Cuboid(160,160,10,20,20,10));
        j3d.add(new Cuboid(120,120,10,40,40,20));
        j3d.add(new Cuboid(80,80,10,60,60,30));
        j3d.add(new Cylinder(65,65,40,65,65,100,5,10));
        j3d.add(new Cylinder(135,65,40,135,65,100,5,10));
        j3d.add(new Cylinder(65,135,40,65,135,100,5,10));
        j3d.add(new Cylinder(135,135,40,135,135,100,5,10));
        j3d.add(new Cuboid(80,80,10,60,60,100));
        j3d.add(new Cuboid(10,10,10,95,95,40));
        j3d.add(new Cuboid(10,10,10,95,95,50));
        j3d.add(new Cuboid(10,10,10,95,95,60));
        j3d.add(new Pyramid(95,95,105,105,70,10));
        
//        j3d.add(new Sphere(0,0,-100,50,50));
//        j3d.add(new Sphere(100,0,-100,50,50));
//        j3d.add(new Sphere(200,0,-100,50,50));
//        j3d.add(new Sphere(300,0,-100,50,50));
//        j3d.add(new Sphere(0,100,-100,50,50));
//        j3d.add(new Sphere(100,100,-100,50,50));
//        j3d.add(new Sphere(200,100,-100,50,50));
//        j3d.add(new Sphere(300,100,-100,50,50));
//        j3d.add(new Sphere(0,-100,-100,50,50));
//        j3d.add(new Sphere(100,-100,-100,50,50));
//        j3d.add(new Sphere(200,-100,-100,50,50));
//        j3d.add(new Sphere(300,-100,-100,50,50));
//        j3d.add(new Cuboid(10,10,100,0,0,0));
//        j3d.add(new Sphere(5,5,110,10,10));
//        j3d.add(new Sphere(0,150,0,25,20));
//        j3d.add(new Donut(100,100,0,100,150,0,30,50,20));
        //j3d.add(new Donut(-100,-100,0,-100,-150,0,30,50,20));
//        j3d.add(new House(100,100,0));
//        j3d.add(new House(100,-150,0));
//        j3d.add(new House(300,100,0));
//        j3d.add(new House(300,-150,0));
//        j3d.add(new Panel(-100,-100,500,100,0));
//       
        j3d.convertShapes();
        j3d.refresh();
        //System.exit(0);
        this.getToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK);
        
            x_val.addChangeListener(new ChangeListener(){
              public void stateChanged(ChangeEvent ce){
                  j3d.core.self.x = x_val.getValue()-50;
                  j3d.refresh();
                }
            });
            y_val.addChangeListener(new ChangeListener(){
              public void stateChanged(ChangeEvent ce){
                  j3d.core.self.y = y_val.getValue()-50;
                  j3d.refresh();
                }
            });
            z_val.addChangeListener(new ChangeListener(){
              public void stateChanged(ChangeEvent ce){
                  j3d.core.self.z = z_val.getValue()-50;
                  j3d.refresh();
                }
            });
            a_val.addChangeListener(new ChangeListener(){
              public void stateChanged(ChangeEvent ce){
                  j3d.core.Angle_xy = a_val.getValue()*0.02;
                  j3d.refresh();
                }
            });
            
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        if(event instanceof KeyEvent){
            KeyEvent key = (KeyEvent)event;
            int keyCode = key.getKeyCode();
            
            if(key.getID()==KeyEvent.KEY_PRESSED){
                switch( keyCode ) { 
                    case KeyEvent.VK_UP:
                        j3d.forward(2);
                        break;
                    case KeyEvent.VK_DOWN:
                        j3d.backward(2);
                        break;
                    case KeyEvent.VK_LEFT:
                        j3d.core.Angle_xy+=0.03;
                        break;
                    case KeyEvent.VK_RIGHT :
                        j3d.core.Angle_xy-=0.03;
                        break;
                    case KeyEvent.VK_W :
                        j3d.core.Angle_xz+=0.03;
                        break;
                    case KeyEvent.VK_S :
                        System.out.println("hi");
                        j3d.core.Angle_xz-=0.03;
                        break;
                }
            }
            else if(key.getID()==KeyEvent.KEY_RELEASED){
            }
            j3d.refresh();
            key.consume();
        }
    }
}
