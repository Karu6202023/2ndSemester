import java.awt.*;
import javax.swing.*;

public abstract interface Layout extends LayoutManager
{
	public abstract void add(Component c);
}