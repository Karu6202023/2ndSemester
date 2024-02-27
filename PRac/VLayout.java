
import java.awt.*;

public class VLayout extends BLayout
{
	VLayout(LPanel p)
	{
		super(p, V_ALIGN);
	}

	public void add(Component c)
	{
		panel.add(c);
		fill(0, 5);
	}
}
