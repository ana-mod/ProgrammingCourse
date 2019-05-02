import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Process.*;
import java.io.InputStream;


public class Main extends JFrame implements ActionListener
{
    JFrame fr;
    JPanel header, content;
    JTextArea txtarea;
	JButton bt;
    JTextField ta;
	JLabel lb;

    public Main()
    {
        fr = new JFrame();
        fr.setLayout(new BorderLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Naglowek
        header = new JPanel();
        header.setLayout(new FlowLayout());
        
		lb = new JLabel("Podaj parametry");
        
		ta = new JTextField();
        ta.setColumns(30);
        
        bt = new JButton("Pokaz");
		bt.setBackground(Color.PINK);
		bt.setForeground(Color.YELLOW);
        bt.addActionListener(this);
		
        header.add(lb);
        header.add(ta);
		header.add(bt);

        //Output
        content = new JPanel();
        content.setLayout(new GridLayout(0,1));
        txtarea = new JTextArea();
        content.add(txtarea);
      
        fr.add(header, BorderLayout.NORTH); 
        fr.add(content); 
        fr.setSize(600,500);
        fr.setVisible(true);

    }

	public void actionPerformed(ActionEvent e)
	{
		String output = "";
		try 
		{
			String cmd = "\"C:\\Users\\Ana\\Desktop\\cpp\\WierszTrojkataPascala.exe\" " + ta.getText();
			Process p = Runtime.getRuntime().exec(cmd);

            InputStream in = p.getInputStream();
            int c;
            while((c=in.read())!= -1 ) 
			{
				output = output + (char)c;
                txtarea.setText(output);
			}
		}
		catch (Exception ex) 
		{
			JOptionPane.showMessageDialog(null, "Cos poszlo nie tak");
		}
	}	

    public static void main(String[] args) 
	{
        Main frame = new Main();
    }

}