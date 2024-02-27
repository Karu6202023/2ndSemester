import java.awt.*;
import javax.swing.*;

public class Settings extends LFrame
{
	Settings()
	{
		super("Settings Page");

		putLayout(new VLayout(content));

		PageBuilder.createHeader("DigiBay - Settings", content);

		fillBtn("Account", "Pocket", "History", "Wallet", "Preferences", "Close");

		PageBuilder.createFooter("DigiBay (c) 2024", content);

		display();
	}

	void fillBtn(String... args)
	{
		var menu = new NavMenu(this);
		menu.putLayout(new VLayout(menu));

		for (String s : args)
			menu.addBtn(s);

		addItem(menu);
	}

	void event(String e)
	{
		switch (e)
		{
			case "Account":
				new Cookies();
				break;
		}
	}
}