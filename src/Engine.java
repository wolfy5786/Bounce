import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Engine extends Canvas implements Runnable, KeyListener, WindowListener {
    final private static int fwidth=500;// frame width
    final private static int fheight=500;// frame height
    Rectangles rect;
    SphereRotate sphere;
    long stscore, enscore, score;

    public Engine() {
        rect = new Rectangles();
        sphere = new SphereRotate(fwidth/20,(fheight/2)-20);
    }

    public static void main (String args[]) throws InterruptedException {

        Engine engm = new Engine();
        Thread tpaint = new Thread(engm);
        tpaint.start();

    }

    public static int getFwidth() {
        return fwidth;
    }

    public static int getFheight() {
        return fheight;
    }

    public void paint (Graphics g)
    {

        g.drawLine(0, fheight / 2, fwidth, fheight / 2);
        rect.paint(g);
        sphere.paint(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed (KeyEvent e) {
        System.out.println(e);
        sphere.jumpupdate();
        sphere.setAsscend(1);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    @Override
    public void run() {

            JFrame f = new JFrame();
            f.setSize(fwidth, fheight);
            f.setTitle("Bounce");
            f.setBackground(Color.WHITE);
            f.add(this);

            f.setVisible(true);
            f.addKeyListener(this);
            f.addWindowListener(this);
            this.stscore=System.currentTimeMillis();
            new Thread(){
                @Override
                public void run() {
                    for(long g=0;;)
                    {
                        enscore=System.currentTimeMillis();
                        score=(enscore-stscore)/1000;
                        g = (score /10);
                        if(g<0)
                        {
                            g=-g;
                        }
                        if (g==20)
                        {
                            g=19;
                        }
                        rect.transrect();
                        sphere.jumpupdate();
                        Engine.this.repaint();
                        try {
                            Thread.sleep(20-g);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }.start();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        enscore=System.currentTimeMillis();
        this.score=(enscore-stscore)/1000;
        System.out.println(score);
        System.exit(0);

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
