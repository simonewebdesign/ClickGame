import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame
{
	private Dimension minSize = new Dimension(200, 200);

	public Frame()
	{
		super("Finestra senza nome");
		setMinimumSize(minSize);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public Frame(String title, int frameWidth, int frameHeight)
	{
		super(title);
		pack();
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public Frame(String title, int frameWidth, int frameHeight, int frameXPos, int frameYPos)
	{
		super(title);
		pack();
		setBounds(frameXPos,frameYPos,frameWidth,frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}