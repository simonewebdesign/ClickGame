/******************
 *	ClickGame v1.7
 *	Developed by Simone Vittori - www.simonewebdesign.it
 *	Last Update: 16/06/2011
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter; // classe che implementa l'interfaccia MouseListener
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener; // interfaccia
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AvviaGioco
{
	public static void main(String[] args) throws NumberFormatException
	{
		//debug
		//long startTime = 0;
		Frame frame = new Frame("ClickGame!", 160,160);		
		int secondiDiGioco = 0;
		try
		{
			while (secondiDiGioco < 5 || secondiDiGioco > 30 )
			{
				secondiDiGioco = Integer.parseInt(JOptionPane.showInputDialog("Scegli la durata del gioco in secondi (min: 5  max: 30)"));	
			}
		}
		catch  (NumberFormatException e)
		{
			//JOptionPane.showMessageDialog("Devi inserire un numero!");
			//System.out.println("Devi inserire un numero!");
			// e.printStackTrace();
             JOptionPane.showMessageDialog(
                 frame,
                 "Devi inserire un numero!",
                 "Dati errati",
                 JOptionPane.WARNING_MESSAGE);
		}
		
		final ClickGame game = new ClickGame(secondiDiGioco);
		
	 	final JButton button = new JButton("CLICCA QUI");
	//	button.setBounds(200, 200, 300, 180); non funge
		final JLabel tempo = new JLabel(String.format("%02d.%d", secondiDiGioco, 0));
		tempo.setFont(new Font("SansSerif", Font.BOLD, 30));
	//	tempo.setHorizontalAlignment(JLabel.CENTER);
		
		final JLabel punteggio = new JLabel();
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(tempo);
		panel.add(punteggio);
		frame.add(panel);

	//	final Timer timer = new Timer(10, null);
	//	timer.addActionListener(new ActionListener() {
	//	    public void actionPerformed(ActionEvent evt) {
	//	        (as in the question, except that you can refer to timer here)
	//	    }
	//	});

		final GameTimer timer = new GameTimer(null);
		timer.addActionListener(new ActionListener()
		{
			// azioni da svolgere
			public void actionPerformed(ActionEvent event)
			{
				//conto alla rovescia
				game.remDecimal();

				//aggiornamento JLabel tempo
				String s = String.format("%02d.%d", game.getSeconds(), game.getDecimals());			
				// System.out.println("Debug timer: "+ s);
				tempo.setText(s);
				
				if (game.getSeconds() <= 0 && game.getDecimals() <= 0)
				{
					timer.stoppaTimer();
				//	System.out.println("\nTEMPO SCADUTO!\n");
				//	System.out.println("Punteggio: " + game.getClick());
					button.setText("TEMPO SCADUTO!");
					punteggio.setText("Hai totalizzato " + game.getClick() + " click");					
				}
			}
		});
		
		class ImplementazioneMouseListener extends MouseAdapter
		{			
			public void mousePressed(MouseEvent event) // CHEAT: questo metodo funziona per ogni pulsante del mouse!
			{
				if (timer.statoTimer() == false)
				{
					timer.avviaTimer();
				//	System.out.println("IL GIOCO È INIZIATO!\nClicca più veloce che puoi!");
				}
				if (timer.isRunning())
				{
					game.addClick();
				}
			//	System.out.println(game.getClick());
			}
		} //end ImplementazioneMouseListener
		// creo il ricevitore
		MouseAdapter mListener = new ImplementazioneMouseListener();
		// e l'associo al button
		button.addMouseListener(mListener);
		
		frame.setResizable(false);
		frame.setVisible(true);
	} // end main()
} // end AvviaGioco