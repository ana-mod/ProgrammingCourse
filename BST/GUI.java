import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
  JLabel output;
  JLabel header;
  JButton insert;
  JButton search;
  JButton delete;
  JButton draw;
  JTextField input;
  Socket socket = null;
  PrintWriter out = null;
  BufferedReader in = null;
  public String action = "";
  public String type = "";
  
  GUI() {
    setFont(new Font(Font.SANS_SERIF,Font.PLAIN,40));
    header = new JLabel("Podaj element");
    input = new JTextField(20);

    output = new JLabel();
    output.setBackground(Color.white);
    
    insert = new JButton("insert");
    insert.setSize(100,30);
	insert.setBackground(Color.PINK);
	insert.setForeground(Color.YELLOW);
	search = new JButton("search");
	search.setSize(100,30);
	search.setBackground(Color.PINK);
	search.setForeground(Color.YELLOW);
    delete = new JButton("delete");
	delete.setSize(100,30);
	delete.setBackground(Color.PINK);
	delete.setForeground(Color.YELLOW);
	draw = new JButton("draw");
	draw.setSize(100,30);
	draw.setBackground(Color.PINK);
	draw.setForeground(Color.YELLOW);
    insert.addActionListener(this);
    search.addActionListener(this);
    delete.addActionListener(this);
    draw.addActionListener(this);

    setLayout(new FlowLayout());
    output.setLayout(new GridLayout(3,5));
    add(header, BorderLayout.NORTH);
    add(input);
    add(output);
    add(insert);
    add(search);
    add(delete);
    add(draw);
    add(createMenuBar());
  }

  public void actionPerformed(ActionEvent event) {
    
	  
	  if(event.getSource() == insert) {
    	out.println("insert");
    	out.println(input.getText());
      try {
        output.setText(in.readLine());
      }
      catch (IOException e) {
        System.out.println("Read failed"); System.exit(1);
      }
      input.setText("");
      input.requestFocus();
    }
   
	  
	  
	  else if (event.getSource()==delete) {
    	out.println("delete");
        out.println(input.getText());
        try {
          output.setText(in.readLine());
        }
        catch (IOException e) {
          System.out.println("Read failed"); System.exit(1);
        }
        input.setText("");
        input.requestFocus();
    }
    
    else if (event.getSource()==search) {
    	out.println("search");
        out.println(input.getText());
        try {
          output.setText(in.readLine());
        }
        catch (IOException e) {
          System.out.println("Read failed"); System.exit(1);
        }
        input.setText("");
        input.requestFocus();
    }
    
    else if (event.getSource()==draw) {
    	out.println("draw");
        out.println(input.getText());

        try {
          output.setText(in.readLine());
        }
        catch (IOException e) {
          System.out.println("Read failed"); System.exit(1);
        }
        input.setText("");
        input.requestFocus();
    }
    
    else {
    	type = event.getActionCommand().toString();
    	out.println(type);
    }
    	
  }

  public void listenSocket(){
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
    GUI frame = new GUI();
    frame.addWindowListener( new WindowAdapter() {
                               public void windowClosing(WindowEvent e) {
                                 System.exit(0);
                               }
                             } );
  //  frame.pack();
    frame.setSize(600,300);
    frame.setVisible(true);
    frame.listenSocket();
  }
}
