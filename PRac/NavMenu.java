import java.awt.event.*;
import javax.swing.*;

public class NavMenu extends LPanel
{
	ActionListener window;

	NavMenu(ActionListener w)
	{
		super();

		window = w;
	}

	public void addBtn(String s)
	{
		addItem(new LButton(s, window));
	}
}
