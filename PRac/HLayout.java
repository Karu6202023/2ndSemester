import java.awt.*;

public class HLayout extends BLayout
{
	HLayout(LPanel p)
	{
		super(p, H_ALIGN);
	}

	public void add(Component c)
	{	
		panel.add(c);
		fill(5, 0);
	}
}