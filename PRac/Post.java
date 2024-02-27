import java.awt.*;
import javax.swing.*;

public class Post extends LFrame
{
	Post()
	{
		super("Post Page");

		putLayout(new VLayout(content));

		PageBuilder.createHeader("DigiBay - New Post", content);

		var titleField = new JTextField(20);
		labelItem("Item Name", titleField);

		var imageUrl = new JTextField(20);
		labelItem("Image URL", imageUrl);

		var priceField = new JTextField(5);
		labelItem("Price ($)", priceField);

		var descField = new JTextArea(10, 20);
		labelItem("Description", descField);

		PageBuilder.createNavMenu(this, content, "Cancel", "Publish");

		PageBuilder.createFooter("DigiBay (c) 2024", content);

		display();
	}

	void labelItem(String s, Component c)
	{
		var label = new FLabel(s);
		var group = new LPanel();
		group.putLayout(new VLayout(group));
		group.addItem(label);
		group.addItem(c);
		addItem(group);
	}

	void event(String e)
	{
	}
}