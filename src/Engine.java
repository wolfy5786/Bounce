import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class Engine extends Canvas implements Runnable, KeyListener {
    final private static int fwidth=500;// frame width
    final private static int fheight=500;// frame height
    Rectangles rect;
    SphereRotate sphere;

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
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.addKeyListener(this);
            new Thread(){
                @Override
                public void run() {
                    for(;;)
                    {

                        rect.transrect();
                        Engine.this.repaint();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }.start();
    }

}
