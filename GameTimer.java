import javax.swing.Timer;
import java.awt.event.ActionListener; // interface

public class GameTimer extends Timer
{
	private boolean avviato;
		
	public GameTimer(ActionListener listener)
	{
		super(100, listener); //Timer(int delay, ActionListener listener) - Creates a Timer and initializes both the initial delay and between-event delay to delay milliseconds.	
		avviato = false;
	}
	
	public void avviaTimer()
	{ 
		start();
		avviato = true;
	}	
	public void stoppaTimer()
	{
		stop();
		// avviato = false;
	}	
	public boolean statoTimer(){ return avviato; }
}