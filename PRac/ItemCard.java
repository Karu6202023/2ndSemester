import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemCard extends LPanel
{
	ActionListener window;

	ItemCard(Component icon, ActionListener w)
	{
		super();

		putLayout(new HLayout(this));

		var c1 = column();
		c1.addItem(icon);

		var c2 = column();
		label(c2, "Item Name", FLabel.LEFT, new Font("Arial", Font.BOLD, 16));
		label(c2, "Item Description", FLabel.LEFT, new Font("Arial", Font.ITALIC, 14));
		label(c2, "$0.00", FLabel.RIGHT, new Font("Monospaced", Font.BOLD, 14));

		var c3 = column();
		var optMenu = new NavMenu(w);
		optMenu.putLayout(new VLayout(optMenu));
		optMenu.addBtn("Add to pocket");
		optMenu.addBtn("Buy");
		c3.addItem(optMenu);
	}

	public void label(LPanel panel, String s, int align, Font f)
	{
		var l = new FLabel(s, align);
		l.putFont(f);
		panel.addItem(l);
	}

	LPanel column()
	{
		var panel = new LPanel();
		panel.putLayout(new VLayout(panel));
		addItem(panel);
		return panel;
	}
}