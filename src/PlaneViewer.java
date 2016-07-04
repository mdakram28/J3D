
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */
public class PlaneViewer extends JFrame {
    static plane[] pl = {};
    PlanePanel pp = new PlanePanel();
    
    public PlaneViewer()
    {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        add(pp);
    }
    
    public void update(plane[] pla){
        pl = pla;
        pp.repaint();
    }
    
}


class PlanePanel extends JPanel{
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.red);
        g2d.drawLine(512,0,512,800);
        g2d.drawLine(0, 400, 1024, 400);
        g2d.setColor(Color.BLACK);
        int j;
        for(int i=0;i<PlaneViewer.pl.length;i++)
        {
            for(j=0;j<PlaneViewer.pl[i].p.length-1;j++)
            {
                Point p1 = PlaneViewer.pl[i].p[j];
                Point p2 = PlaneViewer.pl[i].p[j+1];
                
                g2d.drawLine((int)p1.x+512, (int)p1.y+400, (int)p2.x+512, (int)p2.y+400);
                g2d.drawString("0", (int)p1.x+512, (int)p1.y+400);
                
            }
        }
    }
}