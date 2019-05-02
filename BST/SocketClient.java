/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SocketClient extends JFrame implements ActionListener{
	
	JFrame fr;
	JButton insert; JButton delete; JButton search; JButton draw;
	JPanel header, content;
	JTextField tf;
	JTextArea ta;
	JLabel lb;
	
	public String type;
	public String action;
	
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	
	public SocketClient(){
		fr = new JFrame();
		fr.setLayout(new BorderLayout());
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Naglowek
		header = new JPanel ();
		header.setLayout(new FlowLayout());	
				
		lb = new JLabel ("Wpisz liczbê: ");

		tf = new JTextField ();
		tf.setColumns(10);
					
		insert = new JButton("Insert");
		insert.setBounds(10,80,100,30);
		insert.setBackground(Color.PINK);
		insert.setForeground(Color.YELLOW);
		insert.addActionListener(this);
				
		delete = new JButton("Delete");
		delete.setBounds(10,120,100,30);
		delete.setBackground(Color.PINK);
		delete.setForeground(Color.YELLOW);
		delete.addActionListener(this);
		
		search = new JButton("Search");
		search.setBounds(10,160,100,30);
		search.setBackground(Color.PINK);
		search.setForeground(Color.YELLOW);
		search.addActionListener(this);
		
		draw = new JButton("Draw");
		draw.setBounds(10,200,100,30);
		draw.setBackground(Color.PINK);
		draw.setForeground(Color.YELLOW);
		draw.addActionListener(this);
		
		header.add(lb);
		header.add(tf);
		header.add(insert);
		header.add(delete);
		header.add(search);
		header.add(draw);
		header.add(createMenuBar());
			
		//Output
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setFont(ta.getFont().deriveFont(9.4f));
		content.add(ta);
					
		//Okno
		fr.add(header, BorderLayout.NORTH);
		fr.add(content);
		fr.setSize(700,600);
		fr.setVisible(true);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==insert)
		{
			action = "insert";
			
		      try {
		          lb.setText(in.readLine());
		        }
		        catch (IOException ex) {
		          System.out.println("Read failed"); System.exit(1);
		        }
		        tf.setText("");
		        tf.requestFocus();
		      
		}
		else if (e.getSource()==delete)
		{
			action = "delete";
		}
		else if (e.getSource()==search)
		{
			action = "search";
		}
		else if (e.getSource()==draw)
		{
			action = "draw";
		}
		else
		{
			type = e.getActionCommand().toString(); // which type was chosen
		}
		
		
		
	}
	
	public void listenSocket() {
	    try {
	        socket = new Socket("localhost", 4444);
	        out = new PrintWriter(socket.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      }
	      catch (UnknownHostException e) {
	         System.out.println("Unknown host: localhost"); System.exit(1);
	       }
	       catch  (IOException e) {
	       System.out.println("No I/O"); System.exit(1);
	       }
	}
	
	
	
	private JMenuBar createMenuBar(){
		
		JMenuBar menuBar;
		JMenu menu;
		JRadioButtonMenuItem rbMenuItem;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Choose the type");
		//menu.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menu);
		
		ButtonGroup group = new ButtonGroup();
		
		rbMenuItem = new JRadioButtonMenuItem("Integer");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_I);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Double");
		rbMenuItem.setMnemonic(KeyEvent.VK_D);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("String");
		rbMenuItem.setMnemonic(KeyEvent.VK_S);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		return menuBar;
	}
	
	public static void main(String[] args){
		SocketClient frame = new SocketClient();
		frame.listenSocket();
	}
}
*/