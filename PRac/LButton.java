import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LButton extends LPanel
{
	LButton(String s, ActionListener w)
	{
		super();

		putLayout(new FLayout(this, FLayout.CENTER));

		var btn = new JButton(s);
		btn.addActionListener(w);

		addItem(btn);
	}
}