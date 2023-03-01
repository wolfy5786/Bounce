import java.awt.*;
import java.util.*;
public class SphereRotate extends Component {
    private int spherex;//x position of sphere
    private int spherey;// y position of sphere
    private int asscend = 0;// flag for sphere to go up
    private int desend = 0; //flag for sphere to go down
    static SphereRotate s;


    public SphereRotate(int spherex, int spherey) {
        this.spherex = spherex;
        this.spherey = spherey;
    }

    public void jumpupdate() {
        for(int i=0;i<=20;i++) {

            if (spherey == 30) {
                desend = 1;
                asscend = 0;
            }
            if (spherey == 20) {
                desend = 0;
            }
            if (asscend == 1) {
                spherey++;
            } else if (desend == 1) {
                spherey--;
            }
        }
    }


    public int getSpherex() {
        return spherex;
    }

    public int getSpherey() {
        return spherey;
    }

    public void paint(Graphics g) {

        g.fillOval(spherex, spherey, 20, 20);
    }

}