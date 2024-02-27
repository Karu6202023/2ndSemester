import java.awt.*;
import javax.swing.*;

public class BLayout extends BoxLayout implements Layout {
    LPanel panel;
    public static final int V_ALIGN = BoxLayout.Y_AXIS;
    public static final int H_ALIGN = BoxLayout.X_AXIS;

    BLayout(LPanel p, int axis) {
        super(p, axis);
        panel = p;
    }

    public void fill(int w, int h) {
        //panel.add(Box.createRigidArea(new Dimension(w, h)));
    }

    public void add(Component c) {
    }
}