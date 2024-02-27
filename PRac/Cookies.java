import java.awt.*;
import javax.swing.*;

public class Cookies extends LFrame
{
	Cookies()
	{
		super("Account Control Page");

		putLayout(new VLayout(content));

		PageBuilder.createHeader("DigiBay - Account Center", content);

		PageBuilder.createNavMenu(this, content, "Login", "Register");

		PageBuilder.createFooter("DigiBay (c) 2024", content);

		display();	
	}

	void event(String e)
	{
	}
}