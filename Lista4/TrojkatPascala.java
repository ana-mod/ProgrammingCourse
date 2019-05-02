package trojkat;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class TrojkatPascala extends JFrame implements ActionListener
{
	JFrame fr;
	JPanel header, content;
	JTextField tf;
	JButton btn;
	JTextArea ta;
	JLabel lb;
	//JScrollPane scrollPane;
	
	public TrojkatPascala ()
	{	
		
		fr = new JFrame();
		fr.setLayout(new BorderLayout());
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Naglowek
		header = new JPanel ();
		header.setLayout(new FlowLayout());	
		
		lb = new JLabel ("Podaj rozmiar trojkata: ");

		tf = new JTextField ();
		tf.setColumns(30);
			
		btn = new JButton("Pokaz");
		btn.setBounds(10,80,100,30);
		btn.setBackground(Color.PINK);
		btn.setForeground(Color.YELLOW);
		btn.addActionListener(this);
		
		header.add(lb);
		header.add(tf);
		header.add(btn);
		
		//Output
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setFont(ta.getFont().deriveFont(9.4f));
		content.add(ta);
		
		//scrollPane = new JScrollPane(ta);
		
		//Okno
		fr.add(header, BorderLayout.NORTH);
		fr.add(content);
		fr.setSize(700,600);
		fr.setVisible(true);
	}
	

	String result () 
	{
		String result = "";

		try
		{
			int n = Integer.parseInt(tf.getText());
			if (n<0 || n>33) result = "Zly numer wiersza";
			else 
			{
				for (int l=0; l<=n; l++)
				{
					WierszTrojkataPascala rzad = new WierszTrojkataPascala(l);
					for (int k=0; k<=l; k++)
					{
						result = result + String.valueOf(rzad.wspolczynnik(k)) + " ";
					}
					result = result + '\n';
				}
			}
		}
	
		catch (NumberFormatException ex)
		{
			result = "To nie jest liczba";
		}

		return result;
	}
	
	public void actionPerformed(ActionEvent e)
	{       
		ta.setText(result());		
		//header.add(scrollPane);
		fr.pack();
	}
	
	
	public static void main (String[] args)
	{
		TrojkatPascala frame = new TrojkatPascala();
	}
}