import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class ILabel extends JLabel
{
	ILabel(String path, int w, int h)
	{
		super();

		try
		{
			var src = new File(path);
			var img = ImageIO.read(src);
			var scaledImage = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			var icon = new ImageIcon(scaledImage);
			setIcon(icon);
		}
		catch (IOException e)
		{
			setText("Img Alt");
			e.printStackTrace();
		}
	}
}