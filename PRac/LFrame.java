import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class LFrame extends JFrame implements ActionListener
{
	LPanel content;

	abstract void event(String e);

	public void actionPerformed(ActionEvent e)
	{
		event(e.getActionCommand());
	}

	LFrame(String title)
	{
		super(title);

		content = new LPanel();
		add(content);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void putLayout(Layout layout)
	{
		content.putLayout(layout);
	}

	public void display()
	{
		pack();
		toFront();
		requestFocus();
		setVisible(true);
	}

	public void fork()
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void close()
	{
		setVisible(false);
		dispose();
	}

	public void addItem(Component c)
	{
		content.addItem(c);
	}
}