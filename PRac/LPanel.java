import java.awt.*;
import javax.swing.*;

public class LPanel extends JPanel
{
	Layout layout;

	LPanel()
	{
		super();
	}

	LPanel(Layout l)
	{
		super();
		putLayout(l);
	}

	public void putLayout(Layout l)
	{
		layout = l;
		setLayout(layout);

		setBackground(Color.lightGray);
	}

	public void addItem(Component c)
	{
		layout.add(c);
	}

	public Insets getInsets()
	{
		return new Insets(5, 5, 10, 10);
	}
}