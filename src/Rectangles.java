import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Rectangles extends Component {

    private int rectx;//position of obsticle
    private int recty;//position of obstacle

    public Rectangles() {
        rectx = Engine.getFwidth();
        recty = (Engine.getFheight()/2)-20;
        System.out.println(rectx);
    }

    public int getRectx() {
        return rectx;
    }

    public void setRectx(int rectx) {
        rectx = rectx;
    }

    public int getRecty() {
        return recty;
    }

    public void setRecty(int recty) {
        recty = recty;
    }

    public void transrect()
    {
        rectx--;
        if (rectx==5)
        {
            rectx=Engine.getFwidth();
        }
    }

    public void paint (Graphics g)
    {
        int x=rectx;
        int y=recty;
        System.out.println(this.rectx);
        g.drawRect(x,y,20,20);
    }


}
