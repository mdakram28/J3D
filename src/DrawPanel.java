
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akram
 */

class DrawPanel extends JPanel{
    plane[] pos = {};
    public void update(plane[] p){
    pos = p;
    repaint();
}
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //g2d.setColor(Color.red);
        int l =(pos.length);
        for(int i = 0;i<l;i++)
        {
            //System.out.println(pos[i*2].x+"\t"+pos[i*2].y+"\t"+pos[i*2+1].x+"\t"+pos[i*2+1].y);
            for(int j=1;j<pos[i].p.length-1;j++)
            {
                int[] x = {(int)pos[i].p[0].x,(int)pos[i].p[j].x,(int)pos[i].p[j+1].x};
                int[] y = {(int)pos[i].p[0].y,(int)pos[i].p[j].y,(int)pos[i].p[j+1].y};

                //if(col==null)g2d.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
                g2d.setColor(pos[i].col);
                g2d.fillPolygon(x,y,3);
                g2d.setColor(Color.BLACK);
                g2d.drawLine(x[0], y[0], x[1], y[1]);
                g2d.drawLine(x[0], y[0], x[2], y[2]);
                g2d.drawLine(x[2], y[2], x[1], y[1]);
            }
            //printPoints(pos[i]);
        }
    }
    
    public void printPoints(plane pla){
        for(int i=0;i<pla.p.length;i++)
        {
            System.out.println("Point "+i+" : "+pla.p[i].x+"\t"+pla.p[i].y+"\t"+pla.p[i].z);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}