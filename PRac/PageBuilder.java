import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PageBuilder
{
	public static void createHeader(String s, LPanel p)
	{
		var label = new FLabel(s, FLabel.CENTER);
		label.putFont(new Font("Arial", Font.BOLD, 18));
		p.addItem(label);
	}

	public static void createSubtitle(String s, LPanel p)
	{
		var label = new FLabel("your one stop digital store", FLabel.CENTER);
		label.putFont(new Font("Arial", Font.ITALIC, 14));
		p.addItem(label);
	}

	public static void createFooter(String s, LPanel p)
	{
		var label = new FLabel("DigiBay (c) 2024", FLabel.CENTER);
		label.putFont(new Font("Arial", Font.ITALIC, 12));
		p.addItem(label);
	}

	public static void createNavMenu(ActionListener w, LPanel p, String... args)
	{
		var menu = new NavMenu(w);
		menu.putLayout(new HLayout(menu));
		for (String s : args)
			menu.addBtn(s);
		p.addItem(menu);
	}
}