import java.awt.*;

public class FLayout extends FlowLayout implements Layout
{
	LPanel panel;
	public static final int CENTER = FlowLayout.CENTER;
	public static final int LEFT = FlowLayout.LEFT;
	public static final int RIGHT = FlowLayout.RIGHT;

	FLayout(LPanel p, int align)
	{
		super(align);

		panel = p;
	}

	public void add(Component c)
	{
		panel.add(c);
	}
}