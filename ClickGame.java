public class ClickGame
{
	private int click;
	private int decimi;
	private int secondi;	
	
	public ClickGame(int durata)
	{
		click = 0;
		decimi = 0;
		secondi = durata;
	}
	
	public void addClick(){ click++; }
	
	public void remDecimal()
	{
		if (decimi > 0 && secondi >= 0)
		{ 
			decimi--;
		}
		else if (decimi <= 0 && secondi > 0)
		{
			secondi--;
			decimi = 9;
		}
	}
	
	public int getClick(){ return click; }
	public int getDecimals(){ return decimi; }
	public int getSeconds(){ return secondi; }
}